package JALON010725;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MAINMENU {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        ArrayList<LocalDateTime> appointmentDates = new ArrayList<>();

        boolean keepRunning = true;
        String userName = "Admin";
        String password = "Mulhouse68";
        boolean validLogin = false;

        AppointmentForm appointmentForm = new AppointmentForm(appointmentDates); // conseil de ChatGPT parc eque j'étais bloqué, d'après ce que je comprend sur le fonctionnement de cette opération, je transmet à MAINMENU toutes le sinformations que j'ai dans AppointmentForm, en créant une instance ici je peux me servir de toutes les fonctionnalités qui se trouvent dans AppintmentForm

        while (!validLogin) {
            System.out.println("====== Bienvenue dans DOCTOR WHEN, l'outil de prise de rendez-vous médicaux. ======\n");
            System.out.println("Merci de bien vouloir vous identifier\n");
            System.out.println("Veuillez entrer votre identifiant");
            String enterUserName = clavier.nextLine();
            System.out.println("Veuillez entrer votre mot de passe");
            String enterPassword = clavier.nextLine();

            validLogin = Login.ValidLogin(userName, password, enterUserName, enterPassword); //j'appele la méthode Login
            if (!validLogin) {
                System.out.println("Identifiant ou mot de passe incorrect. Veuillez réessayer.");
            }
        }

        while (keepRunning) { //la méthode se trouve dans ContinueLoop, elle me permet de réafficher le menu jusqu'à ce qu'on tape 5 dna sle terminal qui correspond à la commande sortir 
            System.out.println("\n====== Menu Principal ======\n");
            System.out.println("Veuillez choisir une action :\n");
            System.out.println("(1) Ajouter un rendez-vous");
            System.out.println("(2) Annuler un rendez-vous");
            System.out.println("(3) Décaler un rendez-vous");
            System.out.println("(4) Filtrer les rendez-vous");
            System.out.println("(5) Quitter");

            int menu = 0;
            try {
                menu = Integer.parseInt(clavier.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez saisir un nombre.");
                continue;
            }
//ici je fais appel aux méthodes dans les autres fichiers
            switch (menu) {
                case 1:
                    System.out.println("\n--- Ajouter un rendez-vous ---");
                    appointmentForm.takeClientAppointment(clavier);
                    break;
                case 2:
                    System.out.println("\n--- Annuler un rendez-vous ---");
                    CancelAppointment.cancelAppointments(clavier, appointmentDates);
                    break;
                case 3:
                System.out.println("\n--- Décaler un rendez-vous ---");
                String[] clientInfo = ChangeAppointment.getClientInfo(clavier);
                ChangeAppointment.changeAppointments(clavier, appointmentDates, clientInfo[0], clientInfo[1], clientInfo[2]);
                break;

                case 4:
                    System.out.println("\n--- Filtrer les rendez-vous ---");
                    FilterAppointments.findClient(clavier, appointmentForm);
                    break;
                case 5:
                    System.out.println("\n--- Quitter ---");
                    keepRunning = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Entrée invalide. Veuillez choisir une option entre 1 et 5.");
                    break;
            }
        }

        clavier.close();
    }

    
}

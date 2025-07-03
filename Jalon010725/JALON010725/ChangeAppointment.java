package JALON010725;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeAppointment {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static String[] getClientInfo(Scanner clavier) { //une méthode suggérée par ChatGPT parce que quand j'ai voulu générer un nouveau code si on change la date de rendez-vous ça marchait pas, en fait c'est un mini formulaire et ça fontionne comme un tableau où à chaque fois quand on répond à une question on remplit une case dans le tabelau
        String[] info = new String[3];
        System.out.print("Prénom du client : ");
        info[0] = clavier.nextLine();

        System.out.print("Nom du client : ");
        info[1] = clavier.nextLine();

        System.out.print("Motif du rendez-vous : ");
        info[2] = clavier.nextLine();

        return info;
    }

    public static void changeAppointments(Scanner clavier, ArrayList<LocalDateTime> appointmentDates, String firstName, String lastName, String motif)
 {
//la même procnipe que pour anuler un rdv sauf qu'une fois le rdv annulé on demande de renseigner une nouvelle date 
       System.out.println("Merci d'indiquer la date du rendez-vous à déplacer (dd-MM-yyyy HH:mm) :");
        String toRemove = clavier.nextLine();
        LocalDateTime removeAppointment;

        System.out.println("Merci d'indiquer la date du nouveau rendez-vous (dd-MM-yyyy HH:mm) :");
        String toReplace = clavier.nextLine();
        LocalDateTime replaceAppointment;

        try {
            removeAppointment = LocalDateTime.parse(toRemove, formatter);
            replaceAppointment = LocalDateTime.parse(toReplace, formatter);
        } catch (Exception e) {
            System.out.println("Format invalide. Veuillez réessayer.");
            return;
        }

        int index = appointmentDates.indexOf(removeAppointment);

        if (index != -1) {
            appointmentDates.set(index, replaceAppointment); //on remplace la ligne à laquelle correspond la date qu'on donne
            String clientReference = CreateClientReference.generateClientReference(firstName, lastName, replaceAppointment, motif);
            System.out.println("Rendez-vous remplacé avec succès.\n" + clientReference);
            
        } else {
            System.out.println("Aucun rendez-vous trouvé à cette date.");
        }
    }
}


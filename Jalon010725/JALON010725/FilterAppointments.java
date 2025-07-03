package JALON010725;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FilterAppointments {

    static String euro = "\u20ac"; //ça marche pas...

    public static void findClient(Scanner clavier, AppointmentForm form) {

        System.out.println("Entrez les 6 premiers caractères de la référence client :");
        String ReferenceSearch = clavier.nextLine().trim();

        boolean found = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//en fait là c'est simple - on va mettre dans le terminal la reference qu'on cherche et ensuite on va chercher dans clientReferences et il faut que la référence commence par l'information qu'on a mis dans le terminal
        for (int i = 0; i < form.clientReferences.size(); i++) {
            if (form.clientReferences.get(i).startsWith(ReferenceSearch)) {
                found = true;

                System.out.println("\n--- Rendez-vous trouvé ---");
                System.out.println("Référence client : " + form.clientReferences.get(i));
                System.out.println("Nom : " + form.lastNames.get(i));
                System.out.println("Prénom : " + form.firstNames.get(i));
                System.out.println("Âge : " + form.patientAges.get(i));
                System.out.println("Téléphone : " + form.telephones.get(i));
                System.out.println("Email : " + form.emailAddresses.get(i));
                System.out.println("Numéro de sécurité sociale : " + form.socialSecurityNs.get(i));
                System.out.println("Motif : " + form.appointmentCodes.get(i));
                System.out.println("Prix final : " + form.finalPrices.get(i) + euro);
                System.out.println("Date du rendez-vous : " + form.appointmentDates.get(i).format(formatter));
            }
        }

        if (!found) {
            System.out.println("Aucun rendez-vous trouvé.");
        }
    }
}

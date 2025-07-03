package JALON010725;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CancelAppointment {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static void cancelAppointments(Scanner clavier, ArrayList<LocalDateTime> appointmentDates) {
//ici c'est simple - on donne la date et l'heure du rdv qu'on veut annuler et s'il se trouve dans le tableau appointmentDates on l'enleve
        System.out.println("Merci d'indiquer la date du rendez-vous à annuler (dd-MM-yyyy HH:mm) :");
        String toRemove = clavier.nextLine();
        LocalDateTime removeAppointment;

        try {
            removeAppointment = LocalDateTime.parse(toRemove, formatter);
        } catch (Exception e) {
            System.out.println("Format invalide. Veuillez réessayer.");
            return;
        }

        if (appointmentDates.contains(removeAppointment)) {
            appointmentDates.remove(removeAppointment);
            System.out.println("Rendez-vous annulé avec succès.");
        } else {
            System.out.println("Aucun rendez-vous trouvé à cette date.");
        }
    }
}

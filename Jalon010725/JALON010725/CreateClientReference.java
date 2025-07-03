package JALON010725;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class CreateClientReference {
    //cette méthode sert à créer une référence cleint - on prend les caractéres de la place  càd la première place dans un tableau, ensuite la date du rendez-vous fourmat yyyymmddhhmm et le code qui correspond au motif du rendez-vosu et cela nous fait la référence 
        public static String generateClientReference(String firstName, String lastName, LocalDateTime appointmentDate, String appointmentCode){
        char firstInitial = Character.toUpperCase(firstName.charAt(0));
        char lastInitial = Character.toUpperCase(lastName.charAt(0));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedDate = appointmentDate.format(formatter);

        String clientReference = firstInitial + "" + lastInitial + "" + formattedDate + "" + appointmentCode;

        return clientReference;
    }
}
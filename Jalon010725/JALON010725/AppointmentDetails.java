package JALON010725;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AppointmentDetails {

    //je ne savais pas comment faire pour exclure les jours fériés du coup j'ai fait un tableau avec des exceptions
    public static final Set<LocalDate> alsaceHolidays = Set.of(
        LocalDate.of(2025, 1, 1),
        LocalDate.of(2025, 4, 18),
        LocalDate.of(2025, 4, 21),
        LocalDate.of(2025, 5, 1),
        LocalDate.of(2025, 5, 8),
        LocalDate.of(2025, 5, 29),
        LocalDate.of(2025, 6, 9),
        LocalDate.of(2025, 7, 14),
        LocalDate.of(2025, 8, 15),
        LocalDate.of(2025, 11, 1),
        LocalDate.of(2025, 11, 11),
        LocalDate.of(2025, 12, 25),
        LocalDate.of(2025, 12, 26)
    );

    public static final int APPOINTMENT_DURATION_HOURS = 1; //chaque rdv dure 1h

    public boolean isTimeAvailable(LocalDateTime newStart, List<LocalDateTime> appointmentDates) {
        LocalDateTime newEnd = newStart.plusHours(APPOINTMENT_DURATION_HOURS); //calcule le temps entre le début et la fin de la consultation
        LocalDateTime now = LocalDateTime.now();

        if (newStart.isBefore(now)) { //si on choisit une date antérieure ça marchera pas 
            System.out.println("Créneau à une date antérieure, merci de choisir un autre créneau.");
            return false;
        }

        for (LocalDateTime existingStart : appointmentDates) {
            LocalDateTime existingEnd = existingStart.plusHours(APPOINTMENT_DURATION_HOURS);

            if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) { //si on essaye de réserver un créneau qi est avant la fin d'un créneau déjà pris ou après le début d'un rdv déjà existant ça nous bloque
                System.out.println("Créneau déjà pris, merci de choisir un autre créneau.");
                return false;
            }
        }

        return true;
    }

    public LocalDateTime requestAppointmentDate(Scanner scanner, DateTimeFormatter formatter, List<LocalDateTime> appointmentDates) {
        LocalDateTime appointmentDate = null;

        while (appointmentDate == null) { //tant qu'on ne donne pas de valeur à appointmentDate la boucle va reccomencer
            System.out.println("Entrez la date du rendez-vous au format jj-MM-aaaa HH:mm (ex: 03-07-2025 14:00) :");
            String input = scanner.nextLine();

            try {
                LocalDateTime proposedDate = LocalDateTime.parse(input, formatter);
                DayOfWeek day = proposedDate.getDayOfWeek();
                int hour = proposedDate.getHour();
                int minute = proposedDate.getMinute();
                LocalDate proposedLocalDate = proposedDate.toLocalDate();

                if (alsaceHolidays.contains(proposedLocalDate)) { //j'appele la méthode qui nous permet d'exclure les jours fériés en Alsace
                    System.out.println("Vous avez sélectionné un jour férié. Merci de choisir une autre date.");
                    continue;
                }

                if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) { //il faut que la dte du rdv ne soit ni samedi ni dimanche (les médecins ont aussi le droit de se reposer)
                    System.out.println("Les rendez-vous sont uniquement possibles du lundi au vendredi.");
                    continue;
                }

                boolean validHour = (hour >= 8 && hour < 12) || (hour >= 14 && hour < 17);//il faut que le rdv soit pendant les plgaes horaires 8-12 et 14-17
                if (!validHour) {
                    System.out.println("Les rendez-vous sont possibles uniquement entre 8h-12h et 14h-17h.");
                    continue;
                }

                if (minute != 0) { //le commentaire en dessous explique la logique
                    System.out.println("Les rendez-vous doivent commencer à l'heure pile (ex : 08:00, 09:00).");
                    continue;
                }

                if (!isTimeAvailable(proposedDate, appointmentDates)) { //la méthode que j'ai créée pour vois si la date qu'on demande n'est pas dans la liste des créneaux déjà pris
                    continue;
                }

                appointmentDate = proposedDate; //si la date qu'on veut passe par la méthode, càd elle est disponible, elle est rajoutée à la liste des dates de rrdv

            } catch (Exception e) {
                System.out.println("Format invalide. Veuillez saisir la date au format jj-MM-aaaa HH:mm :");
            }
        }

        return appointmentDate;
    }

}

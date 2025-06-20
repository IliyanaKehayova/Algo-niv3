
package Fonctions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DateFormatter;

public class methodes1 {


public static void heroes(ArrayList<String> justiceleague) {
        for (String hero : justiceleague) {
            System.out.println(hero);
        }
    }

public static String supprimer(ArrayList<String> justiceleague, String removehero) {
        for (int i = 0; i < justiceleague.size(); i++) {
            if (justiceleague.get(i).equalsIgnoreCase(removehero)) {
                justiceleague.remove(i);
                return removehero + " has been removed from the Justice League.\n";
            }
        }
        return "This super hero is not part of the Justice League.\n";
    }


public static boolean questionYesNo(String question) { 

        while (true) {
            
            System.out.print(question);
            List<String> positive = List.of("o", "oui", "y", "yes", "t", "true");
            List<String> negative = List.of("n", "non", "no", "f", "false");

            try {
                String response = sc.nextLine().trim().toLowerCase();

                if (positive.contains(response)) {
                    return true;  
                } else if (negative.contains(response)) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("\nRépondez par un des choix proposés.");
            }
        }         
    }


public static String dateformatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}

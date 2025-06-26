
package Fonctions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


public static boolean questionYesNo(String response) { 

        while (true) {
            
            String question;
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


public static double calculpourcentage(Double chiffre, Double pourcentage){
    double result = chiffre * pourcentage/100;
    return result; 

}

public static String banque(int pret, int salaire, String cdi, int apport, String propriete) {
    String decision;
    if (cdi.equals("OUI") && salaire >= 3000 && apport > pret * 25 / 100) {
        decision = "Vous êtes éligible pour ce prêt";
    } else if (propriete.equals("OUI")) {
        decision = "Vous êtes éligible pour ce prêt";
    } else {
        decision = "Vous n'êtes pas éligible pour ce prêt";
    }
    return decision;
}


public static boolean continuer(String reponse) {
    if (reponse.equalsIgnoreCase("oui")) {
        return true;
    } else if (reponse.equalsIgnoreCase("non")) {
        return false;
    } else {
        System.out.println("Merci de répondre par oui ou non.");
        return false; // 
    }
}


public static double calculateFinalPrice(double price, boolean sale, LocalDate storageDate, LocalDateTime now) {
    if (sale) {
        return price * 0.6;
    }

    long months = ChronoUnit.MONTHS.between(storageDate.withDayOfMonth(1), now.withDayOfMonth(1));
    if (months > 4) {
        return price * 0.9;
    }

    return price;
}
        

public static boolean removearticle(String reponse) {
    if (reponse.equalsIgnoreCase("oui")) {
        return true;
    } else if (reponse.equalsIgnoreCase("non")) {
        return false;
    } else {
        System.out.println("Merci de répondre par oui ou non.");
        return false;
    }
                                                    }

public static double reductionage(int age, int vol){
        int reductionage;
        if (age<18)
        {reductionage=vol*20/100;}
        else if(age>60)
        {reductionage=vol*40/100;}
        else{reductionage=0;};
        return reductionage;

}


public static double reductionplace(int vol, int places){
        int reducplace;
        if(places>60)
        {reducplace=vol*20/100;}
        else if(places<20)
        {reducplace=vol*20/100;}
        else{reducplace=0;};
        return reducplace; 
                                                        }



public static double reducbusiness(String classe, int vol){
        int reducbusiness;
        if(classe.equals("OUI")){reducbusiness=vol*20/100;}
        else{reducbusiness=0;};
        return reducbusiness;
                                                          }


public static int truefalse(String answer, int i) {
    if ((i == 1 || i == 2 || i == 5) && answer.equalsIgnoreCase("vrai")) {
        return 1;
    } else if ((i == 3 || i == 4) && answer.equalsIgnoreCase("faux")) {
        return 1;
    } else {
        return 0;
    }
}

}

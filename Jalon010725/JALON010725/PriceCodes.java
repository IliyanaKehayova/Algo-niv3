package JALON010725;
import java.util.HashMap;
import java.util.Scanner;

public class PriceCodes {

    String euro = "\u20ac";

    public static void main(String[] args) {
        
    

        HashMap<String, Double> fees = new HashMap<>();
        fees.put("BS", 120.0);
        fees.put("CD", 200.0);
        fees.put("VC", 0.0);
        fees.put("CM", 100.0);
        fees.put("GN", 70.0);
        fees.put("SM", 60.0);

      
        askAndShowPrice(fees);
    }

  
        public static void askAndShowPrice(HashMap<String, Double> fees) {
        Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez le code du service (ex: CD): ");
        String feeChoice = clavier.nextLine().trim().toUpperCase();

        Double Price = fees.get(feeChoice); // on affecte la valeur Price au monant qu'on a trouvé dans la Hashmap fees

        if (Price != null) {
            String euro = "\u20ac"; //ça marche pas, c'est censé être le code qui nous donne le signe euro 
            System.out.println("Le prix pour '" + feeChoice + "' est : " + Price + euro);
        } else {
            System.out.println("Code inconnu.");
        }

        clavier.close();
    }
}
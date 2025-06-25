/*Bonjour les Avengers,

Nous sommes le site ecommerce ElectroDepot, nous aurions besoin d’un programme qui nous permettrait de gérer notre stock de produit, l’afficher sous forme de liste avec :

•	N°id du produit : Qui se crée automatiquement en incrémentation
•	Nom du produit : Ville / Pays
•	Type de produit : TV/Electro-ménager/Micro-Informatique/Audio/ 
•	Date de stockage du produit : Date de création du produit, (si la date dépasse 4 mois, alors on applique une réduction de 10%, mais attention ça ne veut pas dire qu’il est soldé)
•	Solde : Si le produit est soldé alors il aura une réduction de 40% de son prix (Les soldes ne sont pas cumulatifs avec les réductions précédemment évoqués)
•	Prix : Le prix de base du produit

On veut gérer cette liste en ajoutant ou supprimant nos produits. On peut aussi rechercher un produit en fonction de son ID

 */
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Fonctions.methodes1;

public class jalonblanc24062025 {

    public static void main(String[] args) {
        Scanner stock = new Scanner(System.in);

        boolean continueprogram = true;
        boolean remove = true;
        String country;
        String type;
        String storage;
        boolean sale = false;
        double price = 0;
        int id = 1;
        LocalDate storageDate = null;

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> countries = new ArrayList<>();
        ArrayList<String> types = new ArrayList<>();
        ArrayList<LocalDate> storages = new ArrayList<>();
        ArrayList<Boolean> sales = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();

        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);

        System.out.println("Bonjour et bienvenue sur la plateforme de gestion de stock d'Electrodepot.");
        System.out.println("Afin d'enregistrer un produit, merci de bien vouloir remplir le formulaire suivant : ");

        do {

            try {
                System.out.println("Veuillez entrer le nom de la ville d'origine du produit. (Ville/PAYS)");
                country = stock.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Format invalide.");
                return;
            }

            try {
                System.out.println("Type de produit : TV/Electro-ménager/Micro-Informatique/Audio");
                type = stock.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Format invalide.");
                return;
            }

            try {
                System.out.println("Quelle est la date de stockage du produit ? (dd-MM-yyyy)");
                storage = stock.nextLine();
                storageDate = LocalDate.parse(storage, formatter);
            } catch (Exception e) {
                System.out.println("Format invalide, merci de renseigner la date (dd-MM-yyyy)");
                continue;
            }

            try {
                System.out.println("Est-ce que le produit est soldé ? (oui/non)");
                String soldResponse = stock.nextLine().trim().toLowerCase();
                if (soldResponse.equals("oui")) {
                    sale = true;
                } else if (soldResponse.equals("non")) {
                    sale = false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (Exception e) {
                System.out.println("Format invalide, merci de répondre par oui ou non.");
                continue;
            }

            try {
                System.out.println("Veuillez entrer le prix de base du produit :");
                price = Double.parseDouble(stock.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Format invalide.");
                continue;
            }

            numbers.add(id++);
            countries.add(country);
            types.add(type);
            storages.add(storageDate);
            sales.add(sale);
            prices.add(price);

            System.out.println("Souhaitez-vous enregistrer un autre article ? (oui/non)");
            continueprogram = methodes1.continuer(stock.nextLine());

        } while (continueprogram);

    
        do {
            try {
                System.out.println("Souhaitez-vous retirer un article ? (oui/non)");
                remove = methodes1.removearticle(stock.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Merci de répondre par oui ou non.");
                continue;
            }

            if (remove) {
                try {
                    System.out.println("Entrez l'id du produit à retirer : ");
                    int idToRemove = Integer.parseInt(stock.nextLine());

                    int indexToRemove = numbers.indexOf(idToRemove);
                    if (indexToRemove != -1) {
                        numbers.remove(indexToRemove);
                        countries.remove(indexToRemove);
                        types.remove(indexToRemove);
                        storages.remove(indexToRemove);
                        sales.remove(indexToRemove);
                        prices.remove(indexToRemove);
                        System.out.println("Produit retiré.");
                    } else {
                        System.out.println("ID non trouvé.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Format d'ID invalide.");
                }
            }
        } while (remove);

       
        System.out.println("\n---------- Liste des produits enregistrés ----------");

        for (int i = 0; i < numbers.size(); i++) {
            double finalPrice = methodes1.calculateFinalPrice(prices.get(i), sales.get(i), storages.get(i), now);

            System.out.println("Id produit : " + numbers.get(i));
            System.out.println("Ville/PAYS : " + countries.get(i));
            System.out.println("Type du produit : " + types.get(i));
            System.out.println("Date de stockage : " + storages.get(i));
            System.out.println("Produit soldé : " + (sales.get(i) ? "Oui" : "Non"));
            System.out.println("Prix du produit : " + f.format(finalPrice) + " euros");
            System.out.println("-------------------------------");
        }

        stock.close();
    }
}
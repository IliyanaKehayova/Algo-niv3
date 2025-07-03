/* A l’aide des ArrayList, des méthodes, des conditions et des boucles, vous allez me créer un algorithme pour me faire un inventaire de produit alimentaire sous-forme de liste. 
Les produits alimentaires ont chacun un type :

TypeAliment [] = {« Viande », « Légume », « Féculant », « Fruit », « Laitage », « Poisson », « Dessert », « Pâtisserie », « Boulangerie »}
Chaque Aliment possède :
-	Nom (String)
-	Type d’Aliment ( String [] Type)
-	Date de fabrication (Date)
-	Date de péremption (Date)
-	Prix de base (Double ou Float)
-	Si il est consommable (Boolean ou String)

A noter, le prix diminue si la date d’aujourd’hui est proche de 3 jours avant la date de péremption. 
Si la date de péremption est dépassée alors le produit n’est pas consommable.
Il faudrait qu’on est la possibilité d’afficher la liste de tous les produits, pouvoir ajouter ou supprimer, mais aussi chercher un produit dans la liste via son nom.
Résultat attendu :
(0) Nom : Spaghetti Panzini
Type : Féculant | Date de fabrication : 24/06/2025 | Date de péremption : 27/06/2025 | Consommable (Périme bientôt !!!)
Prix : 0.90€ (Après réduction de 20%)

(1) Nom : Riz Uncle Ben’s
Type : Féculant | Date de fabrication : 24/06/2025 | Date de péremption : 30/06/2025 | Consommable
Prix : 1.30€ (Après réduction de 20%)

(2) Nom : Saucisse de Francfort
Type : Viande| Date de fabrication : 23/06/2025 | Date de péremption : 23/06/2025 | Périmée
Prix : Aucun (Article périmé)

Voulez-vous ? (A) Ajouter un nouvel article | (B) Supprimer un article | (Y) Chercher un article | (X) Quitter
X
Merci au revoir !
*/


package Fonctions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class methodesdwwm {

    public static void foodtype() {
        System.out.println("(1). Viande");
        System.out.println("(2). Légume");
        System.out.println("(3). Féculent");
        System.out.println("(4). Fruit");
        System.out.println("(5). Laitage");
        System.out.println("(6). Poisson");
        System.out.println("(7). Dessert");
        System.out.println("(8). Pâtisserie");
        System.out.println("(9). Boulangerie");
    }

    public static void mainmenu() {
        System.out.println("(A) Ajouter un nouvel article");
        System.out.println("(B) Supprimer un article");
        System.out.println("(Y) Chercher un article");
        System.out.println("(L) Afficher la liste des articles");
        System.out.println("(X) Quitter");
    }

    public static String addName(ArrayList<String> names, String productname, Scanner clavier) {
        System.out.print("Nom du produit : ");
        productname = clavier.nextLine();
        System.out.println("Nom du produit choisi : " + productname);
        names.add(productname);
        return productname;
    }

public static String addType(ArrayList<String> types, String producttype, Scanner clavier) {
    choixType: while (true) { // labeled loop
        System.out.print("Type du produit : ");
        foodtype(); // Shows the list

        String choix = clavier.nextLine().trim().toLowerCase();

        switch (choix) {
            case "1":
            case "viande":
                producttype = "Viande";
                break choixType;
            case "2":
            case "légume":
            case "legume":
                producttype = "Légume";
                break choixType;
            case "3":
            case "féculant":
            case "feculant":
                producttype = "Féculant";
                break choixType;
            case "4":
            case "fruit":
                producttype = "Fruit";
                break choixType;
            case "5":
            case "laitage":
                producttype = "Laitage";
                break choixType;
            case "6":
            case "poisson":
                producttype = "Poisson";
                break choixType;
            case "7":
            case "dessert":
                producttype = "Dessert";
                break choixType;
            case "8":
            case "pâtisserie":
            case "patisserie":
                producttype = "Pâtisserie";
                break choixType;
            case "9":
            case "boulangerie":
                producttype = "Boulangerie";
                break choixType;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.\n");
                continue choixType; // restart the loop
        }
    }

    System.out.println("Type du produit choisi : " + producttype);
    types.add(producttype);
    return producttype;
}


    public static String addProductDate(ArrayList<LocalDate> fabricationdates, String productfabricationdate, Scanner clavier) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                System.out.print("Date de fabrication (DD/MM/YYYY) : ");
                productfabricationdate = clavier.nextLine();
                LocalDate date = LocalDate.parse(productfabricationdate, formatter);
                System.out.println("Date de fabrication choisie : " + productfabricationdate);
                fabricationdates.add(date);
                return productfabricationdate;
            } catch (DateTimeParseException e) {
                System.out.println("Format invalide. Réessayez.");
            }
        }
    }

    public static LocalDate addExpiryDate(ArrayList<LocalDate> expirydates, String expirydate, Scanner clavier) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                System.out.print("Date de péremption (DD/MM/YYYY) : ");
                expirydate = clavier.nextLine();
                LocalDate date = LocalDate.parse(expirydate, formatter);
                System.out.println("Date de péremption choisie : " + date);
                expirydates.add(date);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Format invalide. Réessayez.");
            }
        }
    }

    public static double addProductPrice(ArrayList<Double> prices, double price, Scanner clavier) {
        while (true) {
            try {
                System.out.print("Prix du produit : ");
                price = clavier.nextDouble();
                clavier.nextLine(); // consume leftover newline
                System.out.println("Prix du produit choisi : " + price + " €");
                prices.add(price);
                return price;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                clavier.nextLine(); // Clear the invalid input
            }
        }
    }

    public static double pricereduction(double price, LocalDate expirydate) {
        LocalDate reductionDate = LocalDate.now().plusDays(3);
        if (reductionDate.isAfter(expirydate)) {
            price = price - price * 0.20;
        }
        return price;
    }

    public static String yesnoexpired(LocalDate today, LocalDate expirydate) {
        if (today.isAfter(expirydate)) {
            return "Produit périmé";
        } else if (today.plusDays(3).isAfter(expirydate)) {
            return "Consommable (Périme bientôt !!!)";
        } else {
            return "Consommable";
        }
    }

    public static void showAllProducts(
        ArrayList<String> names,
        ArrayList<String> types,
        ArrayList<LocalDate> fabricationdates,
        ArrayList<LocalDate> expirydates,
        ArrayList<Double> prices
    ) {
        if (names.isEmpty()) {
            System.out.println("Aucun produit enregistré.");
            return;
        }

        System.out.println("\n===== Liste des Produits =====");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Produit #" + (i + 1));
            System.out.println("Nom : " + names.get(i));
            System.out.println("Type : " + types.get(i));
            System.out.println("Date de fabrication : " + fabricationdates.get(i));
            System.out.println("Date de péremption : " + expirydates.get(i));
            System.out.println("Prix : " + prices.get(i) + " €");
            System.out.println("-----------------------------");
        }
    }



public static void ajouterProduit(
    ArrayList<String> name,
    ArrayList<String> type,
    ArrayList<LocalDate> fabricationdates,
    ArrayList<LocalDate> expirydates,
    ArrayList<Double> prices,
    Scanner clavier
) {
    System.out.println("\nAjout d'un nouveau produit");

    addName(name, "", clavier);
    addType(type, "", clavier);
    addProductDate(fabricationdates, "", clavier);
    addExpiryDate(expirydates, "", clavier);
    addProductPrice(prices, 0, clavier);
}






    
}

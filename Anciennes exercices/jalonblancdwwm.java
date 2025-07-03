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

A noter, le prix diminue si la date d’aujourd’hui est proche de 3 jours avant la date de péremption. Si la date de péremption est dépassée alors le produit n’est pas consommable.
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
 * 
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Fonctions.methodesdwwm;

public class jalonblancdwwm {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        ArrayList<LocalDate> fabricationdates = new ArrayList<>();
        ArrayList<LocalDate> expirydates = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        boolean continuer = true;

        while (continuer) {
            System.out.println();
            System.out.println("===== MENU PRINCIPAL =====");
            methodesdwwm.mainmenu();
            System.out.print("Votre choix : ");
            String choice = clavier.nextLine().toUpperCase();

            switch (choice) {
                case "A":            
                    methodesdwwm.ajouterProduit(name, type, fabricationdates, expirydates, prices, clavier);
                    break;

                case "B":
                    System.out.println("Suppression d'un produit (non implémenté pour le moment).");
                    break;

                case "Y":
                    System.out.println("Recherche d'un produit (non implémentée pour le moment).");
                    break;

                case "X":
                    System.out.println("Fermeture du programme...");
                    continuer = false;
                    break;

                case "L":
                    methodesdwwm.showAllProducts(name, type, fabricationdates, expirydates, prices);
                    break;

                default:
                    System.out.println("Option invalide, veuillez réessayer.");
                    break;
            }
        }

        clavier.close();
    }
}
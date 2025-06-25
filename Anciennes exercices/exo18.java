/* EXO18 : Avec PRINT & SCANNER : 
 * 
 * 
 * Vous souvenez de l'exercice d'algèbre de Boole de la banque ? Une banque vous accorde un prêt immobilier 
 * si vous répondez aux critères suivants :
 * 
 * condition 1 : Avoir un CDI avec un salaire de plus 3000€
 * 
 * condition 2 : Avoir un apport de 25% de la somme demandé
 * 
 * condition 3 (Si la condition 1 n'est pas rempli ) : Avoir une autre propriété 
 * valant minimum 75% du prêt demandé
 * 
 * 
 *  *  * **********************AFFICHAGE ATTENDU ****************:
 * 
    * Quel est le montant de votre prêt ?
 * 
 * 150000
 * 
 * Quel est montant de votre salaire mensuel brut ?
 * 
 * 4000
 * 
 * Êtes-vous en CDI ?
 * 
 * TRUE
 * 
 * Combien avez-vous d'appord ?
 * 
 * 1500
 * 
 * Vous ne pouvez pas hélas obtenir de prêt !

 * 
*/
import Fonctions.methodes1;
import java.util.Scanner;
public class exo18 {
    public static void main(String[] args){

    

        Scanner clavier = new Scanner(System.in);

        System.out.println("Quel est le montant de votre prêt ?");
        int pret = clavier.nextInt();

        System.out.println("Quel est le montant de votre salaire mensuel brut ?");
        int salaire = clavier.nextInt();
        clavier.nextLine();

        System.out.println("Etes-vous en CDI ? OUI/NON");
        String cdi = clavier.nextLine();

        System.out.println("Combien avez-vous d'apport ?");
        int apport = clavier.nextInt();
        clavier.nextLine();

        System.out.println("Avez-vous une propriete valant minimum 75% du prêt demandé ? OUI/NON");
        String propriete = clavier.nextLine();


        String decision = methodes1.banque(pret, salaire, cdi, apport, propriete);
        System.out.println(decision);

        clavier.close();
}}
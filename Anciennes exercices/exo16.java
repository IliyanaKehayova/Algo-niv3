/* EXO16 : Avec PRINT & SCANNER : 
 * 
 * 
 * Me faire un algo qui change le prix d'un vol selon les paramètres suivants :
 * 
 * Réduction de 20% si le passager est mineur
 * 
 * Réduction de 40% si le passager est senior de plus 60 ans
 * 
 * Réduction de 20% si il y a plus de 60 places disponibles
 * 
 * Augmentation de 20% si il y a moins de 20 places disponibles
 * 
 * Augmentation de 20% si le passager a choisit la classe business 
 * 
 * -----Vous définisserez vous même le prix initial du vol, le nombre de place disponible, l'âge du voyageur
 * 
 * Si le voyageur a choisi une classe business
 * 
 * 
 *  * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Quel est l'âge de votre passager ?
 * 
 * 15
 * 
 * Le passager veut-il une classe business (oui/non) ?
 * 
 * oui
 * 
 * Le prix du vol :
 * 
 * 1200
 * 
 * Nombre de places disponibles :
 * 
 * 50
 * 
 * Le prix du vol est de 1200 euros
 * 
 * 
*/

import java.util.Scanner;
import Fonctions.methodes1; 

public class exo16 {
    public static void main(String[] args){

    
    int vol=600;
    int places=40;


        Scanner clavier = new Scanner(System.in);
    
        System.out.println("Quel est l'age de votre passager ?");
        int age = clavier.nextInt();
        clavier.nextLine();
    
        System.out.println("Le passager veut-il une classe business ? OUI/NON");
        String classe = clavier.nextLine();

        System.out.println("Le prix du vol : "+vol);
    
        System.out.println("\nNombre de places disponibles : "+places);
        System.out.println("\nLe prix du vol est de "+vol+"\n");
        
        double reductionage = methodes1.reductionage(age, vol);
        double reducplace = methodes1.reductionplace(vol, places);
        double reducbusiness = methodes1.reducbusiness(classe, vol);
        

        System.out.println("Le prix de votre billet est de "+(vol-reductionage-reducplace+reducbusiness));
        
        clavier.close();
}}
package JALON010725;
import java.util.Scanner;


public class ContinueLoop{


public static boolean keepRunning() { //j'ai crée une methode pour qu'une boucle continue à tourner, utilisée dans le main
        Scanner clavier = new Scanner(System.in); 
        System.out.println("Souhaitez-vous effectuer une autre action ? (oui/non)");

        String KeepGoing = clavier.nextLine().trim().toLowerCase();

        if (KeepGoing.equals("oui") || KeepGoing.equals("yes") || KeepGoing.equals("y")){
            return true;
        }else {return false;}
    }
   

}





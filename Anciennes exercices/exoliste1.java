
import java.util.ArrayList;
import java.util.Scanner;
import Developpement.Fonctions.supprimerliste;

public class exoliste1 {
    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        ArrayList<String> justiceleague = new ArrayList<>();

        justiceleague.add("Batman");
        justiceleague.add("Superman");
        justiceleague.add("Wonder Woman");
        justiceleague.add("Green Lantern");
        justiceleague.add("The Flash");
        justiceleague.add("The Martian");

        System.out.println("These are the members of the Justice League:");
        supprimerliste.heroes(justiceleague);

        System.out.println("\nLex Luthor, which member of the Justice League would you like to erase?");
        String removehero = clavier.nextLine();

        // Capture the message returned by supprimer
        String result = supprimerliste.supprimer(justiceleague, removehero);

        // Print that message (which may say removed or not found)
        System.out.println(result);

        System.out.println("These are the remaining members:\n");
        supprimerliste.heroes(justiceleague);

        clavier.close();
    }
}
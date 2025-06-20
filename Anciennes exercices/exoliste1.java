import java.util.ArrayList;
import java.util.Scanner;
import Fonctions.methodes1;

public class ExoListe1 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        ArrayList<String> justiceleague = new ArrayList<>();
        justiceleague.add("Batman");
        justiceleague.add("Superman");
        justiceleague.add("Wonder Woman");
        justiceleague.add("Green Lantern");
        justiceleague.add("The Flash");
        justiceleague.add("The Martian");

        while (justiceleague.size()>0){

        System.out.println("These are the members of the Justice League: \n"); //
        methodes1.heroes(justiceleague);

        System.out.println("\nLex Luthor, which member would you like to erase?");
        String removehero = clavier.nextLine();

        String result = methodes1.supprimer(justiceleague, removehero);
        System.out.println(result);
}
        while (justiceleague.size()>0){

        System.out.println("\nThese are the remaining members:\n");
        methodes1.heroes(justiceleague);
        System.out.println("\n");
        }

        System.out.println("Lex Luthor, you have defeated all the members of the Justice League.");

        clavier.close();
    }
}
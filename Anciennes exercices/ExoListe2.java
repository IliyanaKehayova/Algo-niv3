import java.util.ArrayList;
import java.util.Scanner;

public class ExoListe2 {
   
    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        ArrayList<String> langage = new ArrayList<>();

        langage.add("C#");
        langage.add("Java");
        langage.add("C++");
        langage.add("Python");
        langage.add("HTML");
        


        for (String lala : langage) {
            System.out.println(lala);
        }

        langage.add(0, "CSS");

        System.out.println("\n");

        for (String lala : langage) {
        System.out.println(lala);
        }

        System.out.println("\n");
        
        System.out.println();
        


clavier.close();
    }

    }
    



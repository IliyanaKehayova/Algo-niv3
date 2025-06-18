/* EXO2 : A l'aide de Scanner et Print, me faire afficher le résultat d'une soustraction (types entiers) et vérifier si elle est inférieur à 0    
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * a = 2
 * b = 3
 * 
 * resultat = a - b
 * 
 * resultat = -1
 * 
 * resutat est inférieur à 0
 
 */
import java.util.Scanner;

public class exo2 {

    public static int calcul(int a, int b) {
        return a - b;
    }

    public static String supinf(int soustraction) {
        if (soustraction < 10) {
            return "Le résultat est inférieur à 10.";
        } else if (soustraction == 10) {
            return "Le résultat est exactement 10.";
        } else {
            return "Le résultat est supérieur à 10.";
        }
    }

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        System.out.println("La valeur de a :");
        int a = clavier.nextInt();

        System.out.println("La valeur de b :");
        int b = clavier.nextInt();

        int soustraction = calcul(a, b);
        System.out.println("a - b = " + soustraction);

        String message = supinf(soustraction);
        System.out.println(message);

        clavier.close();
    }
}

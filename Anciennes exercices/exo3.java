/* EXO3 : A l'aide de Scanner et Print, me faire afficher le résultat d'une addition (types entiers) et vérifier si elle est pair ou impaire     
 * **********************AFFICHAGE ATTENDU ****************:
 * a = 2
 * b = 3
 * 
 * resultat = a + b
 * resultat = 5
 * 
 * resultat est impaire
*/
import java.util.Scanner;
public class exo3{

        public static int calcul(int a, int b){
            int addition = a+b;
            return addition;
        }

        public static boolean isDivisibleBy2(int total) {
        return total % 2 == 0;
    }

        public static void main(String[] args) {
            Scanner clavier=new Scanner(System.in);
        int a;
        int b;
        

        System.out.println("Donnez une valeur de a.");
        a=clavier.nextInt();

        System.out.println("Donnez une valeur de b.");
        b=clavier.nextInt();

        int total = calcul(a, b);
        System.out.println("Sum: " + total);

        if (isDivisibleBy2(total)) {
            System.out.println("The sum is divisible by 2.");
        } else {
            System.out.println("The sum is not divisible by 2.");
        }
        clavier.close();
   } 
} 

       
      
        
 
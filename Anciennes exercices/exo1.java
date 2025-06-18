/* EXO1 : A l'aide de Scanner et Print, me faire afficher le résultat d'une addition de deux entiers        
 * 
 * 
* **********************AFFICHAGE ATTENDU ****************:
 * 
 * a = 2
 * b = 3
 * 
 * resultat = a + b
 * 
 * resulat vaut 5
 * 
 * 
 * 
*/
import java.util.Scanner;

public class exo1{


    public static int calcul (int a, int b){
        int result = a + b;
        return result;
                                    }
    public static void main(String[] args){
        
       
        
        Scanner clavier = new Scanner(System.in);

        System.out.println("La valeur de a");
        int a = clavier.nextInt();
        System.out.println("La valeur de b");
        int b = clavier.nextInt();


        int result = calcul (a, b);
        
        System.out.println("a+b="+result);


        clavier.close();
    }

}
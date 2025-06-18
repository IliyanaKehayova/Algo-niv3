/* EXO4 : A l'aide de Scanner et Print, tester si une valeur(type entier) est divisible par 2   

 * **********************AFFICHAGE ATTENDU ****************:
 * a = 14
 * a est bien divisible par 2
*/
import java.util.Scanner;
public class exo4{

public static boolean even(int a){
    return a%2==0;
}


    public static void main(String[] args){
    int a;
    
    Scanner clavier = new Scanner(System.in);

    System.out.println("La valeur de a");
    a = clavier.nextInt(); 

  if (even(a)){ System.out.println(a+" est divisible par 2");}
  else{System.out.println(a+" n'est pas divisible par 2");};


  clavier.close();
    
    
    

}}
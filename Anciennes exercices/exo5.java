/* EXO5 : A l'aide de Scanner et Print, créer une équation  A multiplié par B et divisé par C (tous types entiers), 
récupérer le résultat et vérifier si elle inférieure ou supérieure à 10
 * **********************AFFICHAGE ATTENDU ****************:
 * equation = (EQUATION)
 * equation = 15
 * equation est superieure
 * 
*/
import java.util.Scanner;
public class exo5{


public static double SuperieurA10(double a, double b, double c){
    return (a*b)/c;
    
}

    public static void main(String[] args){

        Scanner clavier = new Scanner(System.in);

        System.out.println("La valeur de a est ");
        double a = clavier.nextDouble();
        System.out.println("La valeur de b est ");
        double b = clavier.nextDouble();
        System.out.println("La valeur de c est ");
        double c = clavier.nextDouble();
        
        double equation = SuperieurA10(a,b,c);

        System.out.println("Le résultat est "+equation);

        if(equation>10){System.out.println("L'equation est superieure a 10.");}
        else{System.out.println("L'equation est inferieure a 10.");}


        clavier.close();

    }}
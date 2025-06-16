import java.util.InputMismatchException;
import java.util.Scanner;

/* A l'aide de boucle, tableau, exception et fonction. Me faire un tableau contenant 5 noms de ville (Vous pouvez choisir vos propres villes), créer une méthode pour afficher les villes du tableau numéroté par ligne et autre une méthode pour choisir une ville selon 

la position de sa cellule du tableau et puis affichera un message de bienvenue dans la langue de la ville choisie.:

Bonjour, quelle ville voulez-vous visiter ?

0 - Paris 
1 - Londres
2 - Madrid
3 - Lisbonne
4 - Berlin

0
Bienvenue à Paris !

Voulez-vous visiter une autre ville ? (O/N)
O

1
Welcome to London !

Voulez-vous visiter une autre ville ? (O/N)
O

2
Bienvenido a Madrid !
Voulez-vous visiter une autre ville ? (O/N)
O


3
Bem-vindo a Lisboa !
Voulez-vous visiter une autre ville ? (O/N)
O

4
Willkommen in Berlin !
Voulez-vous visiter une autre ville ? (O/N)
O


5
Désolé, cette ville n'est pas sur la liste !
Voulez-vous visiter une autre ville ? (O/N)
O

Votre voyage est terminé :) !

*/


public class exofonction4versioneudes {

    // Si la réponse est N la valeur que ça retourne est FAUX, si la réponse est O la valeur que ça retourne est VRAI. 
    // Si ni O ni N est renseigné la valeur renvoyée est FAUX avec un message qu'il faut réécrire sa réponse.
    public static boolean decision(String response){

        if(response.toUpperCase().equals("N")){

            return false;

        }else if(response.toUpperCase().equals("O")){

            return true;

        }else{

            System.err.print("Veuillez renseigner une valeur O(Oui) ou N(Non)");

                    return false;
        }
    }

    //Si la longueur du tableau est supérieure à 0, le résultat affiché sera le numéro de la ligne + la ligne corréspondante 
    // Sinon cela veut dire que la liste est vide
    public static String ListeTableau(String[]tab){

        String result="";

        if(tab.length!=0){

        for(int i=0;i<tab.length;i++){

            result+= i+"-"+tab[i]+"\n";

        }

        }else{

            result="\nLa liste de villes est vide\n";
        }

        return result;

    }

    public static void main(String[] args) {


        boolean stop = false; //Valeur qui si VRAI met fin à la boucle
        Scanner clavier = new Scanner(System.in);
        int choice=0; // Valeur qui indique le choix de boucle
        String response;

        String [] villes = {"Paris","Londres","Madrid","Lisbonne","Berlin"};
        String [] messages = {"Bienvenu à Paris","Welcome in London","Bienvenido a Madrid","Bem-vindo a Lisboa","Willkommen in Berlin"};

        System.out.println("Bonjour, quelle ville voulez-vous visiter ?:");

         while(!stop){

            System.out.println(ListeTableau(villes));
            choose(choice,messages,clavier); //Sélectionne le numéro associée à la ville et le message corréspondant en piochant dans la classe clavier. 
            System.out.print("Voulez-vous visiter une autre ville (O/N):");
            clavier.nextLine();
            response = clavier.nextLine();

            stop = continueTravel(response,clavier); // Cette méthode va chercher la valeur booleene dans continueTravel qui sera associée avec reponse.

        }

        System.out.print("Votre voyage est terminé :) !");

                            clavier.close();

    }

    public static void choose(int choice,String[]tab,Scanner clavier){ //choose contient la liste des messages de bienvenue


           boolean repeat=true;

           int count=0;
        
           while(repeat){ //Tant que la boucle se répete parce que repeat est VRAI

           try {
           System.out.print("Numéro de la ville :");
           if(count>=1){
           clavier.nextLine();
           }
             choice = clavier.nextInt();
             repeat=false; //Si la réponse donné n'est pas un nombre la boucle va se répeter, on met donc repeat = false pour que la boucle ne se répete pas. 
             count++;

                
            } catch (Exception e) {
                
             System.out.println("Veuillez entrer un nombre");
             count++; //on met ++ pour que la question se répete

            }

        }
            System.out.println(ValeurTableau(tab, choice));
    }


    public static boolean continueTravel(String response,Scanner clavier) { // de base la boucle doit se répeter et dois sortir uniquement si on tape N 
    //la valeur decision est de base FAUX si qui veut dire qu'on va sortir de la boucle seulement si on met decision = TRUE

        boolean decision=false;
        boolean repeat=false;

        while(!repeat){

           if (response.equalsIgnoreCase("N")) { // si on tape N ça renvoie une valeur VRAI, la boucle va donc ne pas se répeter

                decision=true;
                repeat=true;

            } else if (response.equalsIgnoreCase("O")) { // si on tape O ça renvoie une valeur FAUX, la boucle va donc se répeter 

                decision=false;
                repeat=true; 

            }else{

                System.out.print("Veuillez tapez soit O(Oui) ou N(Non):"); // Si on tape ni N ni O ça nous renvoie une valeur FAUX automatiquement et nous demande de retaper 
                response = clavier.nextLine();
                decision=false;
                repeat=false;

            }

        }

            return decision;
        
    }

    public static String ValeurTableau(String[]tab, int i){ //la methode ValeurTableau contient le String asoccié au message de bienvue et ne nombre auquel il corréspond
        
        
        if(i<tab.length){

            return tab[i]; //tant que la longueur du tableau est supérieure à i (qui represente le numéro de la ligne) ça nous retourne le message de bienvenue correspondant 

        }else{

            return "Cette ville n'est pas sur la liste"; //si le numéro i est supérieur à la taille du tableau, par exemple on a 4 entrée et on tape 9, ça nous affiche ce message 

        }

    }

}

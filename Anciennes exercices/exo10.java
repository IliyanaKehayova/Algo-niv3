/* EXO10 : Créer un quizz de 5 questions, chaque question à deux réponses au choix VRAI OU FAUX, à chaque fois que vous répondez juste à une question 
vous gagnez un point
 * 
 * Après avoir répondu à vos 5 questions, vous avez le résultat final sur 5.
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Question 1 : 
 * 
 * 
*/
import java.util.Scanner;
import Fonctions.methodes1;

public class exo10 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int score = 0;
        String answer;

        for (int i = 1; i <= 5; i++) {
            String question;

            switch (i) {
                case 1:
                    question = "Paris est la capitale de la France ? VRAI/FAUX";
                    break;
                case 2:
                    question = "Il y a 7 continents sur notre planete ? VRAI/FAUX";
                    break;
                case 3:
                    question = "L'Allemagne est le pays le plus peuple au monde ? VRAI/FAUX";
                    break;
                case 4:
                    question = "La ville de Tokyo se trouve en Europe ? VRAI/FAUX";
                    break;
                case 5:
                    question = "Le Dalai Lama vient de Tibet ? VRAI/FAUX";
                    break;
                default:
                    question = "Aucune question.";
                    break;
            }

            System.out.println("Question " + i + ": " + question);
            answer = clavier.nextLine();
            score += methodes1.truefalse(answer, i);
        }

        System.out.println("\nVous avez obtenu " + score + " point(s) sur 5.");

        clavier.close();
    }
}
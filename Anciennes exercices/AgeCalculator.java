import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your date of birth (dd-MM-yyyy): ");
        String input = scanner.nextLine();

     
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
         
            LocalDate birthDate = LocalDate.parse(input, formatter); // java va piocher dans input scanner next Line, donc un String
            //d'où le besoin de faire un parsing qui permettra de chercher la date dans la chaine de caractères et la convertir dans le format formatter

         
            LocalDate today = LocalDate.now(); // local date now nous donne la date d'aujourd'hui

       
            Period age = Period.between(birthDate, today);

          
            System.out.println("You are " + age.getYears() + " years old."); // get years nous permet d'obtenir le resultat de la ligne précédente 

            long daysOld = ChronoUnit.DAYS.between(birthDate, today);
            System.out.println("You are " + daysOld + " days old.");

        } catch (Exception e) {
            System.out.println("Invalid date format! Please use dd-MM-yyyy (e.g. 18-06-2000).");
        }

        scanner.close();
    }
}
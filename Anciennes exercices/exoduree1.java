import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class exoduree1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your date of birth (dd-MM-yyyy): ");
        String input = scanner.nextLine();

     
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
         
            LocalDate birthDate = LocalDate.parse(input, formatter); 

         
            LocalDate firstdate = LocalDate.parse("22-02-2025", formatter);


            long daysOld = ChronoUnit.DAYS.between(birthDate, firstdate);
            System.out.println("You were " + daysOld + " days old when we started dating.");

        } catch (Exception e) {
            System.out.println("Invalid date format! Please use dd-MM-yyyy (e.g. 18-06-2000).");
        }

        scanner.close();
    }
}
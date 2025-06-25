import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class exoduree1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a moment in history (dd-MM-yyyy): ");
        String input1 = scanner.nextLine();

        System.out.print("Enter a different moment in history (dd-MM-yyyy): ");
        String input2 = scanner.nextLine();

     
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
         
            LocalDate history1 = LocalDate.parse(input1, formatter); 

            LocalDate history2 = LocalDate.parse(input2, formatter); 
            

            long daysbetween = ChronoUnit.DAYS.between(history1, history2);
            System.out.println(daysbetween + " have passed between "+history1+" and "+history2);

        } catch (Exception e) {
            System.out.println("Invalid date format! Please use dd-MM-yyyy (e.g. 18-06-2000).");
        }

        scanner.close();
    }
}
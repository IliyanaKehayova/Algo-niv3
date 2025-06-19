import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; 

public class exotime1 {
    

    public static void main(String [] args){

Scanner clavier = new Scanner(System.in);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

LocalTime now = LocalTime.now();
String nowString = now.toString(); 
LocalTime parsed = LocalTime.parse(nowString); 

System.out.println("Local Time : "+now);
System.out.println("Parsed Time : "+parsed.format(formatter));




clavier.close();
    }
}

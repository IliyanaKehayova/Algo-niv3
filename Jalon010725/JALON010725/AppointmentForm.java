package JALON010725;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class AppointmentForm {

    String euro = "\u20ac";


    //toutes mes listes, j'adore les arraylist
    ArrayList<String> lastNames = new ArrayList<>();
    ArrayList<String> firstNames = new ArrayList<>();
    ArrayList<Integer> patientAges = new ArrayList<>();
    ArrayList<String> socialSecurityNs = new ArrayList<>();
    ArrayList<String> telephones = new ArrayList<>();
    ArrayList<String> emailAddresses = new ArrayList<>();
    ArrayList<String> appointmentCodes = new ArrayList<>();
    ArrayList<Double> finalPrices = new ArrayList<>();
    ArrayList<String> clientReferences = new ArrayList<>();

    ArrayList<LocalDateTime> appointmentDates;

    public final AppointmentDetails CheckIfSlotIsAvailable = new AppointmentDetails(); //Une nouvelle technique que j'ai trouvé (ChatGPT, always in our hearts), je créé une nouvelle instance qui me permet de ne pas juste par appel à une methode mai d'utiliser toutes les informations qu'il y a dans le fichier AppointmentDetails

    public final HashMap<String, Double> fees = loadFees();

    public AppointmentForm(List<LocalDateTime> appointmentDates) {
        this.appointmentDates = (ArrayList<LocalDateTime>) appointmentDates;
    }

    public static HashMap<String, Double> loadFees() { //une nouvelle fonction que j'ai trouvée - me permet d'associer une clé (exCD) à une valeur - ici le prix
        HashMap<String, Double> fees = new HashMap<>();
        fees.put("BS", 120.0);
        fees.put("CD", 200.0);
        fees.put("VC", 0.0);
        fees.put("CM", 100.0);
        fees.put("GN", 70.0);
        fees.put("SM", 60.0);
        return fees;
    }

    public static double InsuranceCoverage(int PatientAge, double Price) { //ici c'est simple - soit on a une price en charge de 60%, soit 80% pour les mineurs et les vieux
        if (PatientAge < 18 || PatientAge > 60) {
            return Price * 0.2;
        } else {
            return Price * 0.4;
        }
    }

    public void takeClientAppointment(Scanner clavier) { //le formulaire que j'ai mis dans le main menu qui me permet d'enregistrer un rendez-vous
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    System.out.println("Nom du patient :");
    String lastName = clavier.nextLine();

    System.out.println("Prénom du patient :");
    String firstName = clavier.nextLine();
    //la boucle while oblige l'utilisateur de remplir les champs
    int age = 0;
    while (age <= 0) {
        System.out.println("Âge du patient :");
        try {
            age = Integer.parseInt(clavier.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide pour l'âge.");
        }
    }

    long ssn = 0; //pour pouvoir mettre 13 chiffres
    while (ssn <= 0) {
        System.out.println("Numéro de sécurité sociale :");
        try {
            ssn = Long.parseLong(clavier.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Merci de saisir uniquement des chiffres pour le numéro de sécurité sociale.");
        }
    }

    long phone = 0; //pareil que pour le numéro de sécurité sociale
    while (phone <= 0) {
        System.out.println("Téléphone :");
        try {
            phone = Long.parseLong(clavier.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Merci de saisir uniquement des chiffres pour le numéro de téléphone.");
        }
    }

    System.out.println("Adresse mail :");
    String email = clavier.nextLine();

    System.out.println("Motif du rendez-vous (ex: CD) :");
    System.out.println("Codes disponibles : " + fees.keySet()); //on fait appel à la méthode contenant le montant des soins

    String motif; //ici motif correspond à la clé qu'on trouve dans la hashmap fees
    while (true) {
        motif = clavier.nextLine().toUpperCase();
        if (fees.containsKey(motif)) break;
        System.out.println("Code invalide, veuillez réessayer.");
    }

    double basePrice = fees.get(motif); //le prix correspondant au "motif" avant la remise
    double finalPrice = InsuranceCoverage(age, basePrice); //après la remise, on fait appel à la méthode qui nous permet de calculer la prise en charfe de l'assurance

    LocalDateTime appointmentDate = CheckIfSlotIsAvailable.requestAppointmentDate(clavier, formatter, appointmentDates); //nous permet de vérifier si après avoir rempli le formulaire, le créneau demandé est libre, CheckIfSlotIsAvailable prend tout c equ'il y a dans la methode requestappointmentdate 

    String clientReference = CreateClientReference.generateClientReference(firstName, lastName, appointmentDate, motif); // on utilise la methode generateClientReference pour créer un string correspondant à tout ce qu'on a mis dedans 

    //ici on prend les infos qu'on a renseignées dans le terminal et on les dispatche dans les différents tableaux correspondant 
    clientReferences.add(clientReference);
    lastNames.add(lastName);
    firstNames.add(firstName);
    patientAges.add(age);
    socialSecurityNs.add(String.valueOf(ssn));
    telephones.add(String.valueOf(phone));    
    emailAddresses.add(email);
    appointmentCodes.add(motif);
    finalPrices.add(finalPrice);
    appointmentDates.add(appointmentDate);

    //ici on affiche ce qu'on a mis comme info dans le formulaire 
    System.out.println("\nRendez-vous pris avec succès !\n");
    System.out.println("Nom : " + lastName);
    System.out.println("Prénom : " + firstName);
    System.out.println("Âge : " + age);
    System.out.println("Numéro SS : " + ssn);
    System.out.println("Téléphone : +33" + phone);
    System.out.println("Email : " + email);
    System.out.println("Motif : " + motif + " | Prix final : " + finalPrice + euro);
    System.out.println("Rendez-vous : " + appointmentDate.format(formatter));
    System.out.println("Référence client : " + clientReference);
}


    
}

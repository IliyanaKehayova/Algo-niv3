package JALON010725;
public class Login {


    public static boolean ValidLogin(String correctUserName, String correctPassword, String enteredUserName, String enteredPassword) {
//là c'est simple - si le code qu'on rentre dans le terminal correspond à l'identifiant et le mot de passe enregistrés on se connecte
        if (correctUserName.equals(enteredUserName) && correctPassword.equals(enteredPassword)) {
            return true;
        } else {
            return false;
            
        }
            
        }
    }

import java.util.ArrayList;
import java.util.Scanner;


public class calorieIntakeTracker {


    public static void main(String[] args) {

        // loaded user data

        fileController controller = new fileController();
        ArrayList<String> data = controller.readFile("src/main/resources/userDetails.csv");
        ArrayList<String[]> formattedData = controller.formatFileData(data);

        // log user into application OR sign user up.

        Scanner scanner = new Scanner(System.in);
        inputValidator validator = new inputValidator();
        accountManagement manager = new accountManagement();
        String choice;
        do {
            System.out.println("Log in (0) / Sign up (1) \nEnter (0/1): ");
            choice = scanner.nextLine();
        }
        while (!validator.validateStringInput(choice, new String[]{"0", "1"}));
        switch(Integer.parseInt(choice)) {
            case 0:
                System.out.println("log in");
                boolean result;
                do{
                     result = manager.login();
                     if (!result){
                         System.out.println("invalid login details.");
                     }
                }while(!result);
                System.out.println("Logged in:");
                break;
            case 1:
                System.out.println("Sign up");
                do {
                    result = manager.signUp();
                }
                while (!result);

        }

    }




}

import java.util.ArrayList;
import java.util.Scanner;

public class accountManagement {

    public boolean signUp(){
        Scanner scanner = new Scanner(System.in);
        fileController controller = new fileController();
        //Username, Password, Name, Age, Gender, Weight, Height, Activity level

        System.out.println("Username: ");
        String username = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Age: ");
        String age = scanner.nextLine();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Gender (Male/Female): ");
        String gender = scanner.nextLine();

        System.out.println("Weight (kg): ");
        String weight = scanner.nextLine();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Height (M): ");
        boolean height = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Are you active? : ");
        boolean active = Boolean.parseBoolean(scanner.nextLine());

        return controller.writeToFile("src/main/resources/userDetails.csv", username + "," + password + "," + name + "," + age + "," + gender + "," + weight + "," + height + "," + active);

    }

    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        fileController controller = new fileController();
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        ArrayList<String> data = controller.readFile("src/main/resources/userDetails.csv");

        ArrayList<String[]> formattedData = controller.formatFileData(data);

        for (String[] user: formattedData){
            if (user[0].equals(username) && user[1].equals(password)){return true;}
        }

        return false;

    }

}

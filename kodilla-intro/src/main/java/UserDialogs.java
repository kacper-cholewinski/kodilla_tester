import java.util.Scanner;
public class UserDialogs {

    public static String getValue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your chosen color's first letter:");
            String colorFirstLetter = scanner.nextLine().trim();
            if (colorFirstLetter.length() == 1) {
                return colorFirstLetter;
            }
            System.out.println("Your input should consist of exactly one letter. Try again.");
        }
    }
}
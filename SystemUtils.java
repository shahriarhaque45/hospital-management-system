import java.util.Scanner;

public class SystemUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void pause() {
        System.out.print("\n                    Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                    Type 0 to go back: ");
        }
    }
    
    public static void clearScreen() {
        System.out.print("\n\n");
    }
}
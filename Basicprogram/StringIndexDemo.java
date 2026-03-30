import java.util.Scanner;

public class StringIndexDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.next();
        handleException(userInput);

        scanner.close();
    }
    public static void generateException(String text) {
        System.out.println("\n--- Attempting to access an invalid index ---")
        char invalidChar = text.charAt(text.length()); 
        System.out.println("This will not print: " + invalidChar);
    }
    public static void handleException(String text) {
        System.out.println("\n--- Demonstrating Try-Catch for Index Error ---");
        try {
            int badIndex = text.length() + 5;
            System.out.println("Trying to access index: " + badIndex);
            char character = text.charAt(badIndex);
            System.out.println("Character found: " + character);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: You tried to reach an index that doesn't exist!");
            System.out.println("Error Message: " + e.getMessage());
        } finally {
            System.out.println("Process complete.");
        }
    }
}
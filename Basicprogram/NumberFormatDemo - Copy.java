import java.util.Scanner;

public class NumberFormatDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some text (try entering letters instead of numbers): ");
        String userInput = scanner.next();
        handleException(userInput);

        scanner.close();
    }
    public static void generateException(String text) {
        System.out.println("\n--- Attempting to Parse String to Integer ---");
        int number = Integer.parseInt(text); 
        
        System.out.println("Success! The number is: " + number);
    }
    public static void handleException(String text) {
        System.out.println("\n--- Demonstrating Try-Catch for Number Format ---");
        
        try {
            System.out.println("Converting '" + text + "' to an integer...");
            int result = Integer.parseInt(text);
            System.out.println("Conversion Successful: " + result);
            
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: The text provided is not a valid number.");
            System.out.println("Error details: " + e.getMessage());
            
        } catch (RuntimeException e) {
            System.out.println("Caught a generic RuntimeException: " + e.toString());
        } finally {
            System.out.println("Parsing attempt finished.");
        }
    }
}
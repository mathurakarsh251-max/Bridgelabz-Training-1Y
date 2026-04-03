import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string for the demonstration: ");
        String userInput = scanner.next();
        handleException(userInput);

        scanner.close();
    }
    public static void generateException(String text) {
        System.out.println("\n--- Attempting to generate IllegalArgumentException ---");
        String result = text.substring(5, 2); 
        
        System.out.println("Result: " + result);
    }
 static void handleException(String
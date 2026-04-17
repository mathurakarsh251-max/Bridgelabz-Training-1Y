import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {
    }
    public static void generateException() {
        System.out.println("--- Attempting to generate NullPointerException ---");
        String text = null;
        int length = text.length(); 
        
        System.out.println("This line will never be printed: " + length);
    }
    public static void demonstrateHandling() {
        System.out.println("\n--- Demonstrating Exception Handling ---");
        String text = null;

        try {
            System.out.println("Checking string length...");
            int length = text.length();
            System.out.println("Length is: " + length);
        } catch (NullPointerException e) {
            System.out.println("Caught an Exception: You cannot call methods on a null String!");
            System.out.println("Exception message: " + e.toString());
        } finally {
            System.out.println("The 'finally' block always executes, even after an error.");
        }
    }
}
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
import java.util.Scanner;

public class AgeValidator {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted. You are an adult.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter your age: ");
        
        try {
            int userAge = scanner.nextInt();
            validateAge(userAge);
        } catch (InvalidAgeException e) {
            System.err.println("Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the dividend (number to be divided): ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the divisor (number to divide by): ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);

        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot divide by zero. Mathematics doesn't like that!");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter whole numbers only.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Scanner closed. Program finished.");
        }
    }
}
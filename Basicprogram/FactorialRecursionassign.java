import java.util.Scanner;

public class FactorialRecursion {

    public static void main(String[] args) {
        int number = getNumberInput();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = calculateFactorial(number);
            displayResult(number, result);
        }
    }
    public static int getNumberInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
    public static void displayResult(int n, long fact) {
        System.out.println("The factorial of " + n + " (" + n + "!) is: " + fact);
    }
}
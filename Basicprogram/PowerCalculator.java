import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the power (exponent): ");
        int power = scanner.nextInt();
        if (number < 0 || power < 0) {
            System.out.println("Error: Please enter positive integers.");
        } else {
            long result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number; 
            }
            System.out.println("----------------------------");
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        }

        scanner.close();
    }
}
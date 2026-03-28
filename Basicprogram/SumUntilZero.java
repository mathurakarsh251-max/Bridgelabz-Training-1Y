import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double input;

        System.out.println("Enter numbers to sum them up (Enter 0 to stop):");
        System.out.print("Enter a number: ");
        input = scanner.nextDouble();
        while (input != 0) {
            total += input;
            System.out.print("Enter next number (or 0 to see total): ");
            input = scanner.nextDouble();
        }
        System.out.println("----------------------------");
        System.out.println("The final sum is: " + total);

        scanner.close();
    }
}
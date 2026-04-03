import java.util.Scanner;

public class PowerWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the power (exponent): ");
        int power = scanner.nextInt();
        long result = 1;
        int counter = 0;
        while (counter < power) {
            result *= number;
            counter++;
        }
        System.out.println("----------------------------");
        System.out.println(number + " to the power of " + power + " is: " + result);

        scanner.close();
    }
}
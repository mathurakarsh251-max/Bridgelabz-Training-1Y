import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer to check: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (isPrime(number)) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is NOT a prime number.");
            }
        } else {
            System.out.println("Invalid input. Please enter a whole number.");
        }
        
        scanner.close();
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
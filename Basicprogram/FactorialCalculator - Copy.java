import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("Error: Please enter a non-negative integer.");
        } else {
            long factorial = 1; 
            int i = 1;          
            
            while (i <= n) {
                factorial *= i; 
                i++;            
            }
            System.out.println("The factorial of " + n + " is: " + factorial);
        }

        scanner.close();
    }
}
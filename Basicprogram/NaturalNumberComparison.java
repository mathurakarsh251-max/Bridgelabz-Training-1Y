import java.util.Scanner;

public class NaturalNumberComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number (n): ");
        int n = scanner.nextInt();
        if (n >= 1) {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            int i = 1; 
            while (i <= n) {
                sumLoop += i; 
                i++;          
            }
            System.out.println("----------------------------------------");
            System.out.println("Results for n = " + n + ":");
            System.out.println("Sum using Formula: " + sumFormula);
            System.out.println("Sum using While Loop: " + sumLoop);
            
            if (sumFormula == sumLoop) {
                System.out.println("Comparison: Both computations are CORRECT and match.");
            } else {
                System.out.println("Comparison: There is a discrepancy in the calculations.");
            }
            System.out.println("----------------------------------------");

        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        scanner.close();
    }
}
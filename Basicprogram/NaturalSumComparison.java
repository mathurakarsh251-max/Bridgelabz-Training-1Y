import java.util.Scanner;

public class NaturalSumComparison {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number (n): ");
        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }
        
        int n = input.nextInt();

        if (n < 1) {
            System.out.println("Error: " + n + " is not a natural number. Please enter n >= 1.");
        } else {
            long recursiveSum = sumRecursion(n);
            long formulaSum = sumFormula(n);
            System.out.println("--- Results ---");
            System.out.println("Sum using Recursion: " + recursiveSum);
            System.out.println("Sum using Formula:   " + formulaSum);

            if (recursiveSum == formulaSum) {
                System.out.println("Success: Both computations match!");
            } else {
                System.out.println("Warning: Discrepancy found in calculations.");
            }
        }
        input.close();
    }
    public static long sumRecursion(int n) {
        if (n == 1) {
            return 1; 
        }
        return n + sumRecursion(n - 1); 
    }
    public static long sumFormula(int n) {
        return (long) n * (n + 1) / 2;
    }
}
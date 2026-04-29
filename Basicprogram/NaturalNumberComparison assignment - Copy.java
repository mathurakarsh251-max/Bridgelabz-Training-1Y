import java.util.Scanner;

public class NaturalNumberComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number (n): ");
        int n = scanner.nextInt();
        if (n >= 1) {
            long sumFormula = (long) n * (n + 1) / 2;
            long sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("----------------------------------------");
            System.out.println("Results for n = " + n + ":");
            System.out.println("Sum using Formula: " + sumFormula);
            System.out.println("Sum using For Loop: " + sumLoop);
            
            if (sumFormula == sumLoop) {
                System.out.println("Status: Both computations match perfectly.");
            } else {
                System.out.println("Status: Error! The results do not match.");
            }
            System.out.println("----------------------------------------");

        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        scanner.close();
    }
}
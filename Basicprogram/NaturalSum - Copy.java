import java.util.Scanner;

public class NaturalSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer (n): ");
        int n = input.nextInt();

        if (n < 1) {
            System.out.println("Please enter a natural number (1 or greater).");
        } else {
            int totalSum = findSumOfNaturalNumbers(n);
            System.out.println("The sum of the first " + n + " natural numbers is: " + totalSum);
        }

        input.close();
    }
    public static int findSumOfNaturalNumbers(int n) {
        int sum = 0; 
        for (int i = 1; i <= n; i++) {
            sum += i; 
        }

        return sum;
    }
}
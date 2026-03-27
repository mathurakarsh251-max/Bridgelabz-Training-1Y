import java.util.Scanner;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to find its factors: ");
        int number = input.nextInt();
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        System.out.println("The factors of " + number + " are:");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + (i < factors.length - 1 ? ", " : ""));
        }
        
        System.out.println("\nTotal number of factors: " + count);
        input.close();
    }
}
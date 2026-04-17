import java.util.Scanner;

public class FactorCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = input.nextInt();

        if (num <= 0) {
            System.out.println("Please enter a positive integer greater than zero.");
        } else {
            int[] factors = findFactors(num);
            System.out.print("Factors of " + num + " are: ");
            for (int f : factors) System.out.print(f + " ");
            System.out.println();
            System.out.println("Sum of factors: " + findSum(factors));
            System.out.println("Product of factors: " + findProduct(factors));
            System.out.println("Sum of squares of factors: " + findSumOfSquares(factors));
        }
        input.close();
    }
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factorsArray = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factorsArray[index] = i;
                index++;
            }
        }
        return factorsArray;
    }
    public static int findSum(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }
    public static long findProduct(int[] factors) {
        long product = 1;
        for (int f : factors) product *= f;
        return product;
    }
    public static double findSumOfSquares(int[] factors) {
        double sumSquares = 0;
        for (int f : factors) {
            sumSquares += Math.pow(f, 2);
        }
        return sumSquares;
    }
}
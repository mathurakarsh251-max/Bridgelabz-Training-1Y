import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to analyze: ");
        int num = Math.abs(input.nextInt());
        int count = countDigits(num);
        int[] digits = getDigitsArray(num, count);

        System.out.println("--- Analysis for " + num + " ---");
        System.out.println("Digit Count: " + count);
        int sum = findSumOfDigits(digits);
        System.out.println("Sum of Digits: " + sum);
        double sumSq = findSumOfSquares(digits);
        System.out.println("Sum of Squares of Digits: " + sumSq);
        System.out.println("Is Harshad Number? " + isHarshad(num, sum));
        int[][] freq = findDigitFrequency(digits);
        System.out.println("\nDigit Frequency Table:");
        System.out.println("Digit | Frequency");
        for (int[] row : freq) {
            if (row[1] > 0) {
                System.out.println("  " + row[0] + "   |    " + row[1]);
            }
        }
        input.close();
    }
    public static int countDigits(int num) {
        if (num == 0) return 1;
        return (int) Math.log10(num) + 1;
    }
    public static int[] getDigitsArray(int num, int size) {
        int[] digits = new int[size];
        int temp = num;
        for (int i = size - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }
    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }
    public static double findSumOfSquares(int[] digits) {
        double sumSq = 0;
        for (int d : digits) {
            sumSq += Math.pow(d, 2);
        }
        return sumSq;
    }
    public static boolean isHarshad(int num, int sum) {
        if (sum == 0) return false;
        return num % sum == 0;
    }
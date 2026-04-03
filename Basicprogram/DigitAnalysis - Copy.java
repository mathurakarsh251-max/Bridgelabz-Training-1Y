import java.util.Scanner;

public class DigitAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        int temp = number;
        int count = String.valueOf(number).length();
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        System.out.println("\nDigits stored in array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.println("\n\nLargest digit: " + largest);
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest: None (all digits are the same)");
        } else {
            System.out.println("Second largest digit: " + secondLargest);
        }

        input.close();
    }
}
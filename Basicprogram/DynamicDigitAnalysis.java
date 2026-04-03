import java.util.Scanner;

public class DynamicDigitAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        long number = input.nextLong();
        long temp = number;
        int maxDigit = 5; 
        int[] digits = new int[maxDigit];
        int index = 0;
        if (temp == 0) {
            digits[index++] = 0;
        }

        while (temp > 0) {
            if (index == maxDigit) {
                System.out.println("...Array full at " + maxDigit + ". Increasing size by 10...");
                maxDigit += 10;
                int[] newArray = new int[maxDigit];
                System.arraycopy(digits, 0, newArray, 0, digits.length);
                digits = newArray; 
            }

            digits[index] = (int)(temp % 10);
            temp = temp / 10;
            index++;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        System.out.println("\nFinal Array Size: " + digits.length);
        System.out.println("Largest digit: " + (largest == Integer.MIN_VALUE ? "N/A" : largest));
        System.out.println("Second largest: " + (secondLargest == Integer.MIN_VALUE ? "None" : secondLargest));

        input.close();
    }
}
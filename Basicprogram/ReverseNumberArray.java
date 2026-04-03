import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to reverse: ");
        long number = input.nextLong();
        long temp = Math.abs(number);
        int digitCount = String.valueOf(temp).length();
        long[] digits = new long[digitCount];
        int index = 0;
        while (temp > 0) {
            digits[index] = temp % 10;
            temp = temp / 10;
            index++;
        }
        System.out.print("Reversed digits in array: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
            if (i < digitCount - 1) {
                System.out.print(" ");
            }
        }
        
        System.out.println(); 
        input.close();
    }
}
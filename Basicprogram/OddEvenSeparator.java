import java.util.Scanner;
import java.util.Arrays;

public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the maximum number: ");
        int max = input.nextInt();
        int evenCount = max / 2;
        int oddCount = max - evenCount;
        int[] evenNumbers = new int[evenCount];
        int[] oddNumbers = new int[oddCount];
        int evenIndex = 0;
        int oddIndex = 0;
        for (int i = 1; i <= max; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }
        System.out.println("\n--- Results ---");
        System.out.println("Even Numbers Array: " + Arrays.toString(evenNumbers));
        System.out.println("Odd Numbers Array: " + Arrays.toString(oddNumbers));

        input.close();
    }
}
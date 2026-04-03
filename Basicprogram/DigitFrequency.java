import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to find digit frequency: ");
        long number = input.nextLong();
        long temp = Math.abs(number);
        int[] frequency = new int[10];
        if (temp == 0) {
            frequency[0] = 1;
        }
        while (temp > 0) {
            int digit = (int) (temp % 10); 
            frequency[digit]++;            
            temp = temp / 10;              
        }
        System.out.println("\n--- Digit Frequencies ---");
        System.out.printf("%-10s %-10s\n", "Digit", "Frequency");
        System.out.println("-------------------------");

        for (int i = 0; i <= 9; i++) {
            if (frequency[i] > 0) {
                System.out.printf("%-10d %-10d\n", i, frequency[i]);
            }
        }

        input.close();
    }
}
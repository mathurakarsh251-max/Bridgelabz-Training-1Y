import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Please enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
            if (numbers[i] > 0) {
                System.out.print(" -> Positive");
                if (numbers[i] % 2 == 0) {
                    System.out.println(" and Even");
                } else {
                    System.out.println(" and Odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println(" -> Negative");
            } else {
                System.out.println(" -> Zero");
            }
        }
        System.out.println("\n--- Comparison Results ---");
        int first = numbers[0];
        int last = numbers[4];

        if (first == last) {
            System.out.println("The first element (" + first + ") is equal to the last element (" + last + ").");
        } else if (first > last) {
            System.out.println("The first element (" + first + ") is greater than the last element (" + last + ").");
        } else {
            System.out.println("The first element (" + first + ") is less than the last element (" + last + ").");
        }

        input.close();
    }
}
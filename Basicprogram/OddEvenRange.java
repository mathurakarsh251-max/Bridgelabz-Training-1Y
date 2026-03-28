import java.util.Scanner;

public class OddEvenRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("Please enter a natural number (1 or greater).");
        } else {
            System.out.println("Results from 1 to " + number + ":");
            System.out.println("-----------------------------");

            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
            }
        }

        scanner.close();
    }
}
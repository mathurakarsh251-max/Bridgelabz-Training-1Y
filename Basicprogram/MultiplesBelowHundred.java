import java.util.Scanner;

public class MultiplesBelowHundred {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        if (number <= 0 || number >= 100) {
            System.out.println("Error: Please enter a positive integer between 1 and 99.");
        } else {
            System.out.println("Multiples of " + number + " below 100 (counting backwards):");
            System.out.println("---------------------------------------------------------");
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(); 
        }

        scanner.close();
    }
}
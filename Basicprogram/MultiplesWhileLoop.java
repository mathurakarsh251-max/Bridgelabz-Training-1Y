import java.util.Scanner;

public class MultiplesWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        if (number <= 0 || number >= 100) {
            System.out.println("Error: Please enter a number between 1 and 99.");
        } else {
            System.out.println("Checking factors of " + number + " below the number itself:");
            int counter = number - 1;
            while (counter > 1) {
                if (number % counter == 0) {
                    System.out.println(counter + " is a factor of " + number);
                }
                counter--;
            }
        }

        scanner.close();
    }
}
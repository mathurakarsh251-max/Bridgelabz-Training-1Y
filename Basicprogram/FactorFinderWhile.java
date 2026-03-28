import java.util.Scanner;

public class FactorFinderWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
        } else {
            System.out.print("Factors of " + number + " (excluding itself) are: ");
            int counter = 1;
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
            System.out.println(); 
        }

        scanner.close();
    }
}
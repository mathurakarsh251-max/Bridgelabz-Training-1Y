import java.util.Scanner;

public class SumWithBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.in);
        double total = 0.0;
        double input;

        System.out.println("Enter numbers to sum (Enter 0 or a negative number to stop):");
        while (true) {
            System.out.print("Enter a number: ");
            input = scanner.nextDouble();
            if (input <= 0) {
                break; 
            }
            total += input;
        }
        System.out.println("----------------------------");
        System.out.println("The final sum of positive numbers is: " + total);
        
        scanner.close();
    }
}
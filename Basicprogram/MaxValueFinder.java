import java.util.Scanner;

public class MaxValueFinder {

    public static void main(String[] args) {
        System.out.println("--- Maximum Value Finder ---");
        int num1 = getIntegerInput("Enter first number: ");
        int num2 = getIntegerInput("Enter second number: ");
        int num3 = getIntegerInput("Enter third number: ");
        int max = findMaximum(num1, num2, num3);
        System.out.println("\nThe maximum value among " + num1 + ", " + num2 + ", and " + num3 + " is: " + max);
    }
    public static int getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print(prompt);
            scanner.next(); 
        }
        return scanner.nextInt();
    }
    public static int findMaximum(int a, int b, int c) {
        int max = a; 

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }
}
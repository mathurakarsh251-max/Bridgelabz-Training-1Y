import java.util.Scanner;

public class ArrayAnalysis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Analysis Results ---");
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (isPositive(num)) {
                String parity = isEven(num) ? "Even" : "Odd";
                System.out.println(num + " is Positive and " + parity);
            } else if (num == 0) {
                System.out.println(num + " is Zero");
            } else {
                System.out.println(num + " is Negative");
            }
        }
        int comparison = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.println("\n--- Boundary Comparison ---");
        if (comparison == 1) {
            System.out.println("The first element is Greater than the last element.");
        } else if (comparison == 0) {
            System.out.println("The first and last elements are Equal.");
        } else {
            System.out.println("The first element is Less than the last element.");
        }

        input.close();
    }
    public static boolean isPositive(int n) {
        return n > 0;
    }
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    public static int compare(int n1, int n2) {
        if (n1 > n2) return 1;
        if (n1 == n2) return 0;
        return -1;
    }
}
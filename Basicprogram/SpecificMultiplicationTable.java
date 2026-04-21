import java.util.Scanner;

public class SpecificMultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number for the multiplication table: ");
        int number = scanner.nextInt();

        System.out.println("Multiplication table for " + number + " (from 6 to 9):");
        System.out.println("-------------------------------------------");
        for (int i = 6; i <= 9; i++) {
            int result = number * i;
            System.out.println(number + " * " + i + " = " + result);
        }

        scanner.close();
    }
}
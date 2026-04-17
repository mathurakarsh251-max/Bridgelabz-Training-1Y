import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = input.nextInt();
        int[] tableResults = new int[11];
        for (int i = 1; i <= 10; i++) {
            tableResults[i] = number * i;
        }
        System.out.println("\nMultiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + tableResults[i]);
        }

        input.close();
    }
}
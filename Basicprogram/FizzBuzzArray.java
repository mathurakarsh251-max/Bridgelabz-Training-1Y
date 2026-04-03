import java.util.Scanner;

public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = input.nextInt();
        if (num < 0) {
            System.out.println("Please enter a positive number.");
        } else {
            String[] results = new String[num + 1];
            for (int i = 0; i <= num; i++) {
                if (i == 0) {
                    results[i] = "0"; 
                } else if (i % 3 == 0 && i % 5 == 0) {
                    results[i] = "FizzBuzz";
                } else if (i % 3 == 0) {
                    results[i] = "Fizz";
                } else if (i % 5 == 0) {
                    results[i] = "Buzz";
                } else {
                    results[i] = Integer.toString(i);
                }
            }
            System.out.println("\n--- FizzBuzz Results ---");
            for (int i = 0; i < results.length; i++) {
                System.out.print("Position " + i + " = " + results[i]);
                if (i < results.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        input.close();
    }
}
import java.util.Scanner;

public class StringLengthDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a single word: ");
        String input = scanner.next();
        int manualLength = findLengthManually(input);
        int builtInLength = input.length();
        System.out.println("\n--- Results ---");
        System.out.println("Manual length (via Exception): " + manualLength);
        System.out.println("Built-in .length() result:     " + builtInLength);

        if (manualLength == builtInLength) {
            System.out.println("Success: Both methods match!");
        }

        scanner.close();
    }
    public static int findLengthManually(String text) {
        int count = 0;
        
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
}
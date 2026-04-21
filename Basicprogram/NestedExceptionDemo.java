import java.util.Scanner;

public class NestedExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {100, 200, 300, 400, 500};

        try {
            System.out.print("Enter an array index (0-4): ");
            int index = scanner.nextInt();
            
            int element = numbers[index]; 
            System.out.println("Retrieved element: " + element);

            try {
                System.out.print("Enter a divisor: ");
                int divisor = scanner.nextInt();
                
                int result = element / divisor; 
                System.out.println("Result of " + element + " / " + divisor + " = " + result);

            } catch (ArithmeticException e) {
                System.err.println("Inner Catch Error: Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Outer Catch Error: That index does not exist in the array.");
        } catch (Exception e) {
            System.err.println("General Error: Please enter valid numbers.");
        } finally {
            scanner.close();
            System.out.println("Program cleanup complete.");
        }
    }
}
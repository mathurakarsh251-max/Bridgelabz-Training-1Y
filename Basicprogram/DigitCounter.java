import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long number = scanner.nextLong(); 
        long temp = Math.abs(number); 
        int count = 0;
        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp = temp / 10;
                count++;
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("The number of digits in " + number + " is: " + count);

        scanner.close();
    }
}
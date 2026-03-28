import java.util.Scanner;

public class LargestCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter number 2: ");
        int number2 = scanner.nextInt();
        System.out.print("Enter number 3: ");
        int number3 = scanner.nextInt()
        boolean isFirstLargest = (number1 >= number2 && number1 >= number3);
        boolean isSecondLargest = (number2 >= number1 && number2 >= number3);
        boolean isThirdLargest = (number3 >= number1 && number3 >= number2);
        System.out.println("Is the first number the largest? " + isFirstLargest);
        System.out.println("Is the second number the largest? " + isSecondLargest);
        System.out.println("Is the third number the largest? " + isThirdLargest);
        
        scanner.close();
    }
}
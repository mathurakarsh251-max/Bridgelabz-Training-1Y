import java.util.Scanner;

public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first, second;
        String op;
        System.out.print("Enter the first number: ");
        first = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        op = scanner.next();

        System.out.print("Enter the second number: ");
        second = scanner.nextDouble();

        double result;
        switch (op) {
            case "+":
                result = first + second;
                System.out.println("Result: " + first + " + " + second + " = " + result);
                break;

            case "-":
                result = first - second;
                System.out.println("Result: " + first + " - " + second + " = " + result);
                break;

            case "*":
                result = first * second;
                System.out.println("Result: " + first + " * " + second + " = " + result);
                break;

            case "/":
                if (second != 0) {
                    result = first / second;
                    System.out.println("Result: " + first + " / " + second + " = " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid Operator! Please use +, -, *, or /.");
                break;
        }

        scanner.close();
    }
}
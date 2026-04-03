import static java.lang.Math.*;

public class StaticImportDemo {
    public static void main(String[] args) {
        double num1 = 25.0;
        double num2 = -10.5;
        int a = 50, b = 80;

        System.out.println("--- Math Operations using Static Import ---");
        System.out.println("Square root of " + num1 + " is: " + sqrt(num1));
        System.out.println(num1 + " raised to the power 2 is: " + pow(num1, 2));
        System.out.println("Absolute value of " + num2 + " is: " + abs(num2));
        System.out.println("Maximum of " + a + " and " + b + " is: " + max(a, b));
        System.out.println("Minimum of " + a + " and " + b + " is: " + min(a, b));
        System.out.println("Value of PI: " + PI);
    }
}
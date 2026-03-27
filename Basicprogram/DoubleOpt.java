import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c;
        System.out.print("Enter decimal value for a: ");
        a = input.nextDouble();

        System.out.print("Enter decimal value for b: ");
        b = input.nextDouble();

        System.out.print("Enter decimal value for c: ");
        c = input.nextDouble();
        double op1 = a + b * c;
        double op2 = a * b + c;
        double op3 = c + a / b;
        double op4 = a % b + c;
        System.out.println("The results of Double Operations are:");
        System.out.println("a + b * c = " + op1);
        System.out.println("a * b + c = " + op2);
        System.out.println("c + a / b = " + op3);
        System.out.println("a % b + c = " + op4);

        input.close();
    }
}
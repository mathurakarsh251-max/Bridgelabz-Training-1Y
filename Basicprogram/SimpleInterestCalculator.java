import java.util.Scanner;

public class SimpleInterestCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the Rate of interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter the Time (in years): ");
        double time = input.nextDouble();
        double si = calculateSI(principal, rate, time);
        System.out.println("The Simple Interest is " + si + 
                           " for Principal " + principal + 
                           ", Rate of Interest " + rate + 
                           " and Time " + time);
        
        input.close();
    }
    public static double calculateSI(double p, double r, double t) {
        return (p * r * t) / 100;
    }
}
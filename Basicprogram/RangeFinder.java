import java.util.Scanner;

public class RangeFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three numbers:");
        double n1 = input.nextDouble();
        double n2 = input.nextDouble();
        double n3 = input.nextDouble();
        double[] results = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest number: " + results[0]);
        System.out.println("Largest number: " + results[1]);

        input.close();
    }
    public static double[] findSmallestAndLargest(double a, double b, double c) {
        double smallest = Math.min(a, Math.min(b, c));
        double largest = Math.max(a, Math.max(b, c));

        return new double[]{smallest, largest};
    }
}
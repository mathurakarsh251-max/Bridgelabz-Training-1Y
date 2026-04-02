import java.util.Scanner;

public class TrigFunctions {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double degrees = input.nextDouble();
        double[] results = calculateTrigonometricFunctions(degrees);
        System.out.println("For an angle of " + degrees + " degrees:");
        System.out.printf("Sine: %.4f%n", results[0]);
        System.out.printf("Cosine: %.4f%n", results[1]);
        System.out.printf("Tangent: %.4f%n", results[2]);

        input.close();
    }
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }
}
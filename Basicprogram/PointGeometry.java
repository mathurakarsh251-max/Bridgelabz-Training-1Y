import java.util.Scanner;

public class PointGeometry {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coordinates for Point 1 (x1 y1):");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.println("Enter coordinates for Point 2 (x2 y2):");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double distance = calculateDistance(x1, y1, x2, y2);
        String equation = getLineEquation(x1, y1, x2, y2);

        System.out.println("\n--- Geometric Analysis ---");
        System.out.printf("Euclidean Distance: %.4f units%n", distance);
        System.out.println("Equation of the Line: " + equation);

        input.close();
    }
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double xSquared = Math.pow(x2 - x1, 2);
        double ySquared = Math.pow(y2 - y1, 2);
        return Math.sqrt(xSquared + ySquared);
    }
    public static String getLineEquation(double x1, double y1, double x2, double y2) {
        if (x2 - x1 == 0) {
            return "x = " + x1 + " (Vertical Line)";
        }
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);
        String operator = (b >= 0) ? "+ " : "- ";
        return "y = " + String.format("%.2f", m) + "x " + operator + String.format("%.2f", Math.abs(b));
    }
}
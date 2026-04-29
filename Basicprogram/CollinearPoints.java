import java.util.Scanner;

public class CollinearPoints {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coordinates for Point A (x1 y1):");
        double x1 = input.nextDouble(), y1 = input.nextDouble();

        System.out.println("Enter coordinates for Point B (x2 y2):");
        double x2 = input.nextDouble(), y2 = input.nextDouble();

        System.out.println("Enter coordinates for Point C (x3 y3):");
        double x3 = input.nextDouble(), y3 = input.nextDouble();
        boolean slopeCollinear = checkCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaCollinear = checkCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("\n--- Results ---");
        System.out.println("Collinear by Slope Formula: " + slopeCollinear);
        System.out.println("Collinear by Area Formula:  " + areaCollinear);
        
        input.close();
    }
    public static boolean checkCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double slopeAB_num = (y2 - y1) * (x3 - x2);
        double slopeBC_num = (y3 - y2) * (x2 - x1);
        
        return slopeAB_num == slopeBC_num;
    }
    public static boolean checkCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
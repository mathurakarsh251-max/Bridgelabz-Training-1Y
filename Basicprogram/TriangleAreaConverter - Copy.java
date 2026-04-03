import java.util.Scanner;

public class TriangleAreaConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base of the triangle (in cm): ");
        double baseCm = input.nextDouble();

        System.out.print("Enter the height of the triangle (in cm): ");
        double heightCm = input.nextDouble();
        double areaSqCm = 0.5 * baseCm * heightCm;
        double areaSqIn = areaSqCm / 6.4516;
        System.out.println("The Area of the triangle in sq in is " + areaSqIn + 
                           " and sq cm is " + areaSqCm);

        input.close();
    }
}
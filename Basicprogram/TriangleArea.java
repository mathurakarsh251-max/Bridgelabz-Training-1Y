import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base of the triangle (in inches): ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle (in inches): ");
        double height = input.nextDouble();
        double areaInches = 0.5 * base * height;
        double areaCm = areaInches * 6.4516;
        System.out.println("The Area in square inches is " + areaInches + 
                           " while in square centimeters is " + areaCm);

        input.close();
    }
}
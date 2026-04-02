import java.util.Scanner;

public class AthleteRounds {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the three sides of the triangular park (in meters):");
        System.out.print("Side 1: ");
        double side1 = input.nextDouble();
        System.out.print("Side 2: ");
        double side2 = input.nextDouble();
        System.out.print("Side 3: ");
        double side3 = input.nextDouble();
        double roundsNeeded = calculateRounds(side1, side2, side3);
        System.out.printf("To complete a 5 km run, the athlete must complete %.2f rounds.%n", roundsNeeded);

        input.close();
    }
    public static double calculateRounds(double s1, double s2, double s3) {
        double goalInMeters = 5000;
        double perimeter = s1 + s2 + s3;
        if (perimeter <= 0) {
            return 0;
        }

        return goalInMeters / perimeter;
    }
}
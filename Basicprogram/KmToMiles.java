import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in Kilometers: ");
        double kilometers = input.nextDouble();
        double miles = kilometers * 0.621371;
        System.out.println(kilometers + " km is equal to " + miles + " miles.");

        input.close();
    }
}
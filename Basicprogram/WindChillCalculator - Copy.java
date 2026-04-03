import java.util.Scanner;

public class WindChillCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temp = input.nextDouble();

        System.out.print("Enter the wind speed in miles per hour: ");
        double speed = input.nextDouble();
        double windChill = calculateWindChill(temp, speed);
        System.out.printf("The calculated Wind Chill temperature is: %.2f°F%n", windChill);

        input.close();
    }
    public static double calculateWindChill(double temperature, double windSpeed) {
        double windEffect = Math.pow(windSpeed, 0.16);
        
        double windChill = 35.74 + (0.6215 * temperature) + 
                          ((0.4275 * temperature) - 35.75) * windEffect;
        
        return windChill;
    }
}
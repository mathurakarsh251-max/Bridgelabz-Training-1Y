import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Temperature Converter ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose an option (1 or 2): ");
        
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = scanner.nextDouble();
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%.2f°C is equal to %.2f°F%n", celsius, fahrenheit);
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = scanner.nextDouble();
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.printf("%.2f°F is equal to %.2f°C%n", fahrenheit, celsius);
        } else {
            System.out.println("Invalid choice. Please restart the program.");
        }

        scanner.close();
    }
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }
}
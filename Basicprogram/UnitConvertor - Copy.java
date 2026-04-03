public class UnitConvertor {
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static double convertPoundsToKilograms(double pounds) {
        double conversionFactor = 0.453592;
        return pounds * conversionFactor;
    }
    public static double convertKilogramsToPounds(double kilograms) {
        double conversionFactor = 2.20462;
        return kilograms * conversionFactor;
    }
    public static double convertGallonsToLiters(double gallons) {
        double conversionFactor = 3.78541;
        return gallons * conversionFactor;
    }
    public static double convertLitersToGallons(double liters) {
        double conversionFactor = 0.264172;
        return liters * conversionFactor;
    }
    public static void main(String[] args) {
        System.out.println("--- Temperature ---");
        System.out.printf("98.6 F to C: %.2f%n", convertFahrenheitToCelsius(98.6));
        System.out.printf("0 C to F: %.2f%n", convertCelsiusToFahrenheit(0));

        System.out.println("\n--- Weight ---");
        System.out.printf("150 lbs to kg: %.2f%n", convertPoundsToKilograms(150));
        System.out.printf("70 kg to lbs: %.2f%n", convertKilogramsToPounds(70));

        System.out.println("\n--- Volume ---");
        System.out.printf("1 Gallon to Liters: %.2f%n", convertGallonsToLiters(1));
        System.out.printf("5 Liters to Gallons: %.2f%n", convertLitersToGallons(5));
    }
}
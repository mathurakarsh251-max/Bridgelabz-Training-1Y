public class UnitConvertor {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    public static void main(String[] args) {
        System.out.println("--- Distance Conversions ---");
        
        double km = 5.0;
        System.out.printf("%.2f km to Miles: %.4f%n", km, convertKmToMiles(km));
        
        double miles = 3.1;
        System.out.printf("%.2f miles to Km: %.4f%n", miles, convertMilesToKm(miles));
        
        double meters = 100.0;
        System.out.printf("%.2f meters to Feet: %.4f%n", meters, convertMetersToFeet(meters));
        
        double feet = 6.0;
        System.out.printf("%.2f feet to Meters: %.4f%n", feet, convertFeetToMeters(feet));
    }
}
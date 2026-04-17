public interface UnitConverter {
    double KM_TO_MILES_FACTOR = 0.621371;
    double KG_TO_LBS_FACTOR = 2.20462;
    static double kilometersToMiles(double km) {
        return km * KM_TO_MILES_FACTOR;
    }
    static double kilogramsToLbs(double kg) {
        return kg * KG_TO_LBS_FACTOR;
    }
}
public class LogisticsApp {
    public static void main(String[] args) {
        double distanceKm = 150.0;
        double weightKg = 75.0;
        double miles = UnitConverter.kilometersToMiles(distanceKm);
        double lbs = UnitConverter.kilogramsToLbs(weightKg);

        System.out.println("--- Logistics Conversion Report ---");
        System.out.println("Distance: " + distanceKm + " km = " + String.format("%.2f", miles) + " miles");
        System.out.println("Weight: " + weightKg + " kg = " + String.format("%.2f", lbs) + " lbs");
    }
}
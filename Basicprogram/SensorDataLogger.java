import java.util.ArrayList;

public class SensorDataLogger {
    private static ArrayList<Double> temperatureHistory = new ArrayList<>();

    public static void main(String[] args) {
        double rawSensorValue = 24.5;
        Double cachedValue = 26.8;

        System.out.println("--- Logging Sensor Data ---");
        logTemperature(rawSensorValue); 
        logTemperature(cachedValue);
        logTemperature(null); 

        displayLog();
    }
    public static void logTemperature(Double value) {
        if (value == null) {
            System.out.println("Warning: Received null sensor data. Skipping log.");
            return;
        }
        temperatureHistory.add(value);
        System.out.println("Logged: " + value + "°C");
    }

    public static void displayLog() {
        System.out.println("\n--- Final Temperature History ---");
        double sum = 0;
        
        for (Double temp : temperatureHistory) {
            sum += temp; 
            System.out.print(temp + " ");
        }
        
        if (!temperatureHistory.isEmpty()) {
            System.out.println("\nAverage Temperature: " + (sum / temperatureHistory.size()) + "°C");
        }
    }
}
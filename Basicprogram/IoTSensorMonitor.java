import java.util.Arrays;
import java.util.List;

class SensorData {
    String sensorId;
    double temperature; 

    public SensorData(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
    }

    public double getTemperature() { return temperature; }

    @Override
    public String toString() {
        return String.format("Sensor: %s | Temp: %.1f°C", sensorId, temperature);
    }
}

public class IoTSensorMonitor {
    public static void main(String[] args) {
        final double THRESHOLD = 75.0;

        List<SensorData> readings = Arrays.asList(
            new SensorData("S-101", 22.5),
            new SensorData("S-102", 78.2), 
            new SensorData("S-103", 45.0),
            new SensorData("S-104", 81.5), 
            new SensorData("S-105", 19.8)
        );

        System.out.println("--- CRITICAL TEMPERATURE ALERTS ---");
        readings.stream()
            .filter(data -> data.getTemperature() > THRESHOLD)
            .forEach(data -> System.out.println("⚠️ ALERT: " + data));

        System.out.println("--- Monitoring Active ---");
    }
}
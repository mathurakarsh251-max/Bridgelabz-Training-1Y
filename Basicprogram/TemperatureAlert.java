import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        double threshold = 38.0;
        Predicate<Double> isOverThreshold = (temp) -> temp > threshold;
        double roomTemp = 25.5;
        double engineTemp = 42.3;

        checkTemperature(roomTemp, isOverThreshold);
        checkTemperature(engineTemp, isOverThreshold);
    }

    public static void checkTemperature(double temp, Predicate<Double> alertCondition) {
        if (alertCondition.test(temp)) {
            System.out.println("ALERT: Temperature " + temp + "°C has crossed the threshold! [cite: 13]");
        } else {
            System.out.println("Temperature " + temp + "°C is within safe limits.");
        }
    }
}
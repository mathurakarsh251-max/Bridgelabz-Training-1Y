interface GPS {
    String getCurrentLocation();
    void updateLocation(double latitude, double longitude);
}
abstract class RideVehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation = "Stationary";

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public abstract double calculateFare(double distance);
    public void getVehicleDetails() {
        System.out.println("ID: " + vehicleId + " | Driver: " + driverName + 
                           " | Rate/km: $" + ratePerKm);
    }
    public String getCurrentLocation() { return currentLocation; }
    public void updateLocation(double lat, double lon) {
        this.currentLocation = lat + ", " + lon;
    }
    public double getRatePerKm() { return ratePerKm; }
    public String getDriverName() { return driverName; }
}
class Car extends RideVehicle {
    private double baseFare = 5.00;

    public Car(String id, String driver) { super(id, driver, 1.50); }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (getRatePerKm() * distance);
    }
}

class Bike extends RideVehicle {
    public Bike(String id, String driver) { super(id, driver, 0.80); }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; 
    }
}

class Auto extends RideVehicle {
    private double convenienceFee = 2.00;

    public Auto(String id, String driver) { super(id, driver, 1.10); }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + convenienceFee;
    }
}
import java.util.*;

public class UberApp {
    public static void estimateRide(RideVehicle vehicle, double distance) {
        System.out.println("Estimating ride for " + vehicle.getDriverName() + "...");
        double fare = vehicle.calculateFare(distance);
        vehicle.getVehicleDetails();
        System.out.println("Distance: " + distance + " km | Total Fare: $" + fare);
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        List<RideVehicle> availableRides = new ArrayList<>();
        double tripDistance = 12.5;

        availableRides.add(new Car("C-99", "Rahul"));
        availableRides.add(new Bike("B-22", "Amit"));
        availableRides.add(new Auto("A-44", "Suresh"));

        System.out.println("--- Ride-Hailing Estimates ---");
        for (RideVehicle ride : availableRides) {
            estimateRide(ride, tripDistance);
        }
    }
}
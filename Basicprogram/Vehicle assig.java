import java.util.*;
abstract class Vehicle {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + name;
    }
}
class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }
    @Override
    public String getType() {
        return "Truck";
    }
}
class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }
    @Override
    public String getType() {
        return "Bike";
    }
}
class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
        System.out.println(vehicle + " added to fleet.");
    }

    public void showFleet() {
        System.out.println("Fleet contains:");
        for (T v : fleet) {
            System.out.println("- " + v);
        }
    }
}

public class FleetManagerDemo {
    public static void main(String[] args) {
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Volvo Truck"));
        truckFleet.addVehicle(new Truck("Tata Truck"));
        truckFleet.showFleet();

        System.out.println();
        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Yamaha Bike"));
        bikeFleet.addVehicle(new Bike("Honda Bike"));
        bikeFleet.showFleet();
    }
}

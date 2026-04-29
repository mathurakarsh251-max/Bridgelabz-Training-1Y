import java.util.ArrayList;
import java.util.List;
interface GPS {
    void navigateTo(String destination);
}
abstract class Vehicle {
    private String registrationNumber;
    protected int speed;

    public Vehicle(String regNum) {
        this.registrationNumber = regNum;
    }
    public final void displayId() {
        System.out.println("Vehicle ID: " + registrationNumber);
    }
    public abstract void move();
    public String getRegNum() { return registrationNumber; }
}
class Car extends Vehicle implements GPS {
    
    public Car(String regNum) {
        super(regNum); 
    }
    @Override
    public void move() {
        System.out.println("Car is driving on four wheels.");
    }

    @Override
    public void navigateTo(String destination) {
        System.out.println("Car GPS routing to: " + destination);
    }
}

class Truck extends Vehicle {
    public Truck(String regNum) {
        super(regNum);
    }

    @Override
    public void move() {
        System.out.println("Truck is hauling heavy cargo on the highway.");
    }
}
class FleetManager {
    private final List<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }

    public void runFleet() {
        for (Vehicle v : fleet) {
            v.displayId(); 
            System.out.println("-------------------");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        FleetManager myFleet = new FleetManager();
        Vehicle myCar = new Car("DL-1234");
        Vehicle myTruck = new Truck("UP-5678");

        myFleet.addVehicle(myCar);
        myFleet.addVehicle(myTruck);

        System.out.println("=== EXECUTING FLEET OPERATIONS ===");
        myFleet.runFleet();
        if (myCar instanceof GPS) {
            ((GPS) myCar).navigateTo("GLA University, Mathura");
        }
    }
}
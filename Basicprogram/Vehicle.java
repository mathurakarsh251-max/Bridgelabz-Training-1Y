interface Vehicle {
    void rent();
    void returnVehicle();
}
class Car implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Car: Rented. GPS and insurance check complete.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car: Returned. Checking for fuel level and scratches.");
    }
}
class Bike implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bike: Rented. Helmet provided.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike: Returned. Checking tire pressure and chain.");
    }
}
class Bus implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bus: Rented for group travel. Driver assigned.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus: Returned. Interior cleaning scheduled.");
    }
}
public class RentalSystem {
    public static void main(String[] args) {
        Vehicle[] fleet = { new Car(), new Bike(), new Bus() };

        System.out.println("--- Processing Daily Rentals ---");
        for (Vehicle v : fleet) {
            v.rent();
        }

        System.out.println("\n--- Processing Returns ---");
        for (Vehicle v : fleet) {
            v.returnVehicle();
        }
    }
}
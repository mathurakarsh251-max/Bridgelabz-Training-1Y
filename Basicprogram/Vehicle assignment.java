class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 1500.00;
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    void displayVehicleDetails() {
        System.out.println("Owner Name:     " + ownerName);
        System.out.println("Vehicle Type:   " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
        System.out.println("------------------------------------");
    }
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println(">> System Alert: Registration Fee updated to ₹" + newFee + " <<\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Arjun Kumar", "SUV");
        Vehicle v2 = new Vehicle("Sneha Reddy", "Sedan");
        System.out.println("--- Initial Records ---");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        Vehicle.updateRegistrationFee(1850.00);
        System.out.println("--- Updated Records ---");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
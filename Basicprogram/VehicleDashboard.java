interface VehicleDashboard {
    void displaySpeed(int speed);
    default void displayBattery(int percentage) {
    }
}
class PetrolCar implements VehicleDashboard {
    @Override
    public void displaySpeed(int speed) {
        System.out.println("Analog Dial: " + speed + " km/h");
    }
}
class ElectricCar implements VehicleDashboard {
    @Override
    public void displaySpeed(int speed) {
        System.out.println("Digital HUD: " + speed + " km/h");
    }
    @Override
    public void displayBattery(int percentage) {
        System.out.println("Battery Level: [" + "=".repeat(percentage/10) + " ] " + percentage + "%");
    }
}
public class SmartDashboardApp {
    public static void main(String[] args) {
        VehicleDashboard myFuelCar = new PetrolCar();
        VehicleDashboard myTesla = new ElectricCar();

        System.out.println("--- Petrol Vehicle Dashboard ---");
        myFuelCar.displaySpeed(80);
        myFuelCar.displayBattery(0); 

        System.out.println("\n--- Electric Vehicle Dashboard ---");
        myTesla.displaySpeed(100);
        myTesla.displayBattery(85); 
    }
}
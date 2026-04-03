interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber; 

    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }
    public abstract double calculateRentalCost(int days);
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    protected String getInsurancePolicyNumber() { return insurancePolicyNumber; }
    public void setInsurancePolicyNumber(String policyNumber) { 
        this.insurancePolicyNumber = policyNumber; 
    }
}
class Car extends Vehicle implements Insurable {
    public Car(String num, double rate, String policy) { super(num, "Car", rate, policy); }

    @Override
    public double calculateRentalCost(int days) { return getRentalRate() * days; }

    @Override
    public double calculateInsurance() { return getRentalRate() * 0.05; } 

    @Override
    public String getInsuranceDetails() { return "Car Policy: " + getInsurancePolicyNumber(); }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String num, double rate, String policy) { super(num, "Bike", rate, policy); }

    @Override
    public double calculateRentalCost(int days) { return getRentalRate() * days; }

    @Override
    public double calculateInsurance() { return 10.0; } 

    @Override
    public String getInsuranceDetails() { return "Bike Policy: " + getInsurancePolicyNumber(); }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String num, double rate, String policy) { super(num, "Truck", rate, policy); }

    @Override
    public double calculateRentalCost(int days) { 
        return (getRentalRate() * days) + 500; 
    }

    @Override
    public double calculateInsurance() { return getRentalRate() * 0.15; } 

    @Override
    public String getInsuranceDetails() { return "Commercial Truck Policy: " + getInsurancePolicyNumber(); }
}
import java.util.*;

public class RentalSystem {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        int rentalDays = 5;

        fleet.add(new Car("C123", 50.0, "POL-CAR-99"));
        fleet.add(new Bike("B456", 15.0, "POL-BIKE-22"));
        fleet.add(new Truck("T789", 200.0, "POL-TRK-55"));

        System.out.println("--- Fleet Rental Report (" + rentalDays + " Days) ---");
        
        for (Vehicle v : fleet) {
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insurance = 0;
            String details = "N/A";

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                insurance = ins.calculateInsurance();
                details = ins.getInsuranceDetails();
            }

            System.out.println("Vehicle: " + v.getVehicleNumber() + " [" + v.getType() + "]");
            System.out.println(" - Rental Cost: $" + rentalCost);
            System.out.println(" - Insurance: $" + insurance);
            System.out.println(" - " + details);
            System.out.println("-----------------------------------");
        }
    }
}
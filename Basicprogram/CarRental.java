class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate;
    CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }
    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }
    void displayRentalInvoice() {
        System.out.println("======= CAR RENTAL INVOICE =======");
        System.out.println("Customer:      " + customerName);
        System.out.println("Car Model:     " + carModel);
        System.out.println("Rental Period: " + rentalDays + " days");
        System.out.println("Daily Rate:    ₹" + dailyRate);
        System.out.println("----------------------------------");
        System.out.println("TOTAL AMOUNT:  ₹" + calculateTotalCost());
        System.out.println("==================================");
    }
}

public class Main {
    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Amit Sharma", "Honda City", 5, 2500.00);
        CarRental rental2 = new CarRental("Priya Patel", "Toyota Fortuner", 3, 5000.00);
        rental1.displayRentalInvoice();
        System.out.println(); 
        rental2.displayRentalInvoice();
    }
}
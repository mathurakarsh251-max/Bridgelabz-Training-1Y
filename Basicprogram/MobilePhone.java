class MobilePhone {
    String brand;
    String model;
    double price;
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    void displayPhoneDetails() {
        System.out.println("========== Device Info ==========");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
        System.out.println("=================================");
    }
}

public class Main {
    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S24", 79999.00);
        MobilePhone phone2 = new MobilePhone("Apple", "iPhone 15", 71000.00);
        phone1.displayPhoneDetails();
        phone2.displayPhoneDetails();
    }
}
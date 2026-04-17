import java.util.*;
abstract class Product {
    private double price;

    public Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
class Mobile extends Product {
    private String model;
    public Mobile(String model, double price) {
        super(price);
        this.model = model;
    }
    @Override
    public String toString() {
        return "Mobile: " + model + " (₹" + getPrice() + ")";
    }
}
class Laptop extends Product {
    private String brand;
    public Laptop(String brand, double price) {
        super(price);
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "Laptop: " + brand + " (₹" + getPrice() + ")";
    }
}

public class PriceCalculatorDemo {
    public static double calculateTotal(List<? extends Product> items) {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(new Mobile("iPhone", 80000));
        mobiles.add(new Mobile("Samsung Galaxy", 60000));
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Dell", 70000));
        laptops.add(new Laptop("HP", 65000));

        System.out.println("Mobiles:");
        for (Mobile m : mobiles) System.out.println(m);
        System.out.println("Total Mobile Price: ₹" + calculateTotal(mobiles));

        System.out.println("\nLaptops:");
        for (Laptop l : laptops) System.out.println(l);
        System.out.println("Total Laptop Price: ₹" + calculateTotal(laptops));
    }
}

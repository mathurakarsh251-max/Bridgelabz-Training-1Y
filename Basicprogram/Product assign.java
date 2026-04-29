interface Taxable {
    double calculateTax(double price);
    void getTaxDetails();
}
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public abstract double calculateDiscount();
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }
}
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) { super(id, name, price); }

    @Override
    public double calculateDiscount() { return getPrice() * 0.15; } 

    @Override
    public double calculateTax(double price) { return price * 0.18; } 

    @Override
    public void getTaxDetails() { System.out.println("Tax Category: Electronics (18%)"); }
}

class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) { super(id, name, price); }

    @Override
    public double calculateDiscount() { return getPrice() * 0.20; } 
    @Override
    public double calculateTax(double price) { return price * 0.05; } 
	
    @Override
    public void getTaxDetails() { System.out.println("Tax Category: Apparel (5%)"); }
}

class Groceries extends Product {
    public Groceries(int id, String name, double price) { super(id, name, price); }

    @Override
    public double calculateDiscount() { return getPrice() * 0.05; } 
}
import java.util.*;

public class ECommerceApp {
    
    public static void processOrder(List<Product> cart) {
        System.out.println("--- Order Summary ---");
        for (Product p : cart) {
            double discount = p.calculateDiscount();
            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax(p.getPrice());
            }

            double finalPrice = p.getPrice() - discount + tax;

            System.out.printf("Item: %-12s | Base: $%.2f | Discount: -$%.2f | Tax: +$%.2f | Final: $%.2f%n", 
                              p.getName(), p.getPrice(), discount, tax, finalPrice);
        }
    }

    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();
        
        cart.add(new Electronics(1, "Smartphone", 800.00));
        cart.add(new Clothing(2, "Jeans", 50.00));
        cart.add(new Groceries(3, "Almonds", 20.00));

        processOrder(cart);
    }
}
interface Discountable {
    double applyDiscount(double price);
    void getDiscountDetails();
}
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public abstract double calculateTotalPrice();
    public void getItemDetails() {
        System.out.println("Item: " + itemName + " | Price: $" + price + " | Qty: " + quantity);
    }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        if (quantity >= 0) this.quantity = quantity;
    }
}
class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double total) { return total * 0.90; } 

    @Override
    public void getDiscountDetails() { System.out.println("Offer: 10% Green-Monday Discount Applied!"); }
}

class NonVegItem extends FoodItem {
    private double surcharge = 2.00;

    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + surcharge) * getQuantity();
    }
}
import java.util.*;

public class FoodDeliveryApp {
    
    public static void processOrder(List<FoodItem> cart) {
        double grandTotal = 0;
        System.out.println("--- Your Order Summary ---");

        for (FoodItem item : cart) {
            double itemTotal = item.calculateTotalPrice();
            if (item instanceof Discountable) {
                ((Discountable) item).getDiscountDetails();
                itemTotal = ((Discountable) item).applyDiscount(itemTotal);
            }

            item.getItemDetails();
            System.out.println(" > Subtotal for this item: $" + itemTotal);
            grandTotal += itemTotal;
            System.out.println("---------------------------");
        }
        System.out.println("TOTAL AMOUNT PAYABLE: $" + grandTotal);
    }

    public static void main(String[] args) {
        List<FoodItem> myCart = new ArrayList<>();

        myCart.add(new VegItem("Paneer Tikka", 12.00, 2));
        myCart.add(new NonVegItem("Chicken Curry", 15.00, 1));
        myCart.add(new VegItem("Garlic Naan", 3.00, 3));

        processOrder(myCart);
    }
}
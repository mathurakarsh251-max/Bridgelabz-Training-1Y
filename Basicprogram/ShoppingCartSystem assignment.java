import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Map<String, Double> cart = new LinkedHashMap<>();
        cart.put("Gaming Mouse", 1200.0);
        cart.put("Mechanical Keyboard", 3500.0);
        cart.put("Monitor Stand", 800.0);
        cart.put("HDMI Cable", 450.0);
        cart.put("LED Strip", 600.0);
        displayCart(cart);
        System.out.println("\nRemoving HDMI Cable...");
        cart.remove("HDMI Cable");
        calculateFinalBill(cart);
    }

    public static void displayCart(Map<String, Double> cart) {
        System.out.println("--- Your Shopping Cart ---");
        for (Map.Entry<String, Double> item : cart.entrySet()) {
            System.out.println("- " + item.getKey() + ": ₹" + item.getValue());
        }
    }

    public static void calculateFinalBill(Map<String, Double> cart) {
        double subtotal = 0;
        
        for (double price : cart.values()) {
            subtotal += price;
        }

        System.out.printf("%nSubtotal: ₹%.2f%n", subtotal);
        if (subtotal > 5000) {
            double discount = subtotal * 0.10;
            double finalTotal = subtotal - discount;
            System.out.printf("10%% Discount Applied: -₹%.2f%n", discount);
            System.out.printf("Total Amount Payable: ₹%.2f%n", finalTotal);
        } else {
            System.out.printf("Total Amount Payable: ₹%.2f%n", subtotal);
        }
    }
}
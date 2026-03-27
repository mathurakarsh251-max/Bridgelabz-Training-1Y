class Order {
    int orderId;
    double baseAmount;
    static double deliveryCharge = 40.0;
    public Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Base Price: ₹" + baseAmount);
    }
}

class RegularOrder extends Order {
    public RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }
    @Override
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

class PremiumOrder extends Order {
    public PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }
    @Override
    public double calculateBill() {
        double discountedPrice = baseAmount * 0.80; 
        return discountedPrice + deliveryCharge;
    }
}

public class FoodApp {
    public static void main(String[] args) {
        Order myOrder1 = new RegularOrder(5001, 300.0);
        Order myOrder2 = new PremiumOrder(7005, 500.0);

        System.out.println("--- Regular Order ---");
        myOrder1.showOrderDetails();
        System.out.println("Final Bill (Base + Delivery): ₹" + myOrder1.calculateBill());

        System.out.println("\n--- Premium Order ---");
        myOrder2.showOrderDetails();
        System.out.println("Final Bill (20% Discount + Delivery): ₹" + myOrder2.calculateBill());
    }
}
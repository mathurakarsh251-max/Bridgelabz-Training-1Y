class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0; 
    }
    void addItem(int qty) {
        if (qty > 0) {
            this.quantity += qty;
            System.out.println(qty + " " + itemName + "(s) added to cart.");
        }
    }
    void removeItem(int qty) {
        if (qty > 0 && (this.quantity - qty) >= 0) {
            this.quantity -= qty;
            System.out.println(qty + " " + itemName + "(s) removed from cart.");
        } else {
            System.out.println("Error: Cannot remove " + qty + ". Current quantity: " + this.quantity);
        }
    }
    void displayTotal() {
        double total = price * quantity;
        System.out.println("----- Cart Summary -----");
        System.out.println("Item:     " + itemName);
        System.out.println("Price:    ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total:    ₹" + total);
        System.out.println("------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        CartItem myItem = new CartItem("Wireless Mouse", 1200.00);
        myItem.addItem(3);      
        myItem.removeItem(1);   
        myItem.displayTotal();
        myItem.removeItem(5);   
    }
}
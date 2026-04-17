class Product {
    String name;
    double price;
    int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%s (Stock: %d, Price: $%.2f)", name, stock, price);
    }
}
import java.util.*;

public class SupermarketSystem {
    private Set<String> productNames = new HashSet<>();
    private List<Product> inventory = new ArrayList<>();
    private Queue<Product> restockQueue = new LinkedList<>();
    private Stack<Product> restockHistory = new Stack<>();
    public void addProduct(String name, double price, int stock) {
        if (productNames.add(name)) { 
            Product newProduct = new Product(name, price, stock);
            inventory.add(newProduct);
            System.out.println("Added: " + name);
        } else {
            System.out.println("Skipped: " + name + " already exists.");
        }
    }
    public void identifyLowStock(int threshold) {
        for (Product p : inventory) {
            if (p.stock < threshold && !restockQueue.contains(p)) {
                restockQueue.add(p);
                System.out.println("Enqueued for restock: " + p.name);
            }
        }
    }
    public void processRestock(int quantity) {
        if (restockQueue.isEmpty()) {
            System.out.println("Restock queue is empty.");
            return;
        }
        Product p = restockQueue.poll();
        p.stock += quantity;
        restockHistory.push(p); 
        System.out.println("Restocked " + p.name + ". New stock: " + p.stock);
    }
    public void undoRestock(int quantity) {
        if (!restockHistory.isEmpty()) {
            Product lastRestocked = restockHistory.pop();
            lastRestocked.stock -= quantity;
            System.out.println("Undo successful. " + lastRestocked.name + " stock reverted to: " + lastRestocked.stock);
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
import java.util.Objects;

class Order {
    private String orderId;
    private String customerName;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    public String getOrderId() { return orderId; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order[" + orderId + " - " + customerName + "]";
    }
}
import java.util.*;

public class OrderProcessor {
    public static void main(String[] args) {
        List<Order> incomingOrders = new ArrayList<>();
        incomingOrders.add(new Order("101", "Alice"));
        incomingOrders.add(new Order("102", "Bob"));
        incomingOrders.add(new Order("101", "Alice")); 
        incomingOrders.add(new Order("103", "Charlie"));
        Set<Order> uniqueOrders = new LinkedHashSet<>(incomingOrders);
        System.out.println("Unique Orders Identified: " + uniqueOrders.size());
        Queue<Order> processQueue = new LinkedList<>(uniqueOrders);
        Stack<Order> retryStack = new Stack<>();

        System.out.println("\n--- Processing Orders ---");
        while (!processQueue.isEmpty()) {
            Order current = processQueue.poll();
            if (current.getOrderId().equals("102")) {
                System.out.println("FAILED: " + current + ". Adding to retry stack.");
                retryStack.push(current);
            } else {
                System.out.println("SUCCESS: Processed " + current);
            }
        }
        System.out.println("\n--- Retrying Failed Orders ---");
        while (!retryStack.isEmpty()) {
            Order retryOrder = retryStack.pop();
            System.out.println("RETRY SUCCESS: Processed " + retryOrder);
        }
    }
}
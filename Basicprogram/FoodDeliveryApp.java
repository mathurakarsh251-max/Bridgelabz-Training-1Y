import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Order implements Runnable {
    private String orderId;
    private String restaurant;
    private int deliveryTimeSeconds;
    private String deliveryType;
    private int priority;

    public Order(String id, String restaurant, int seconds, String type, int priority) {
        this.orderId = id;
        this.restaurant = restaurant;
        this.deliveryTimeSeconds = seconds;
        this.deliveryType = type;
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        String agentName = Thread.currentThread().getName();
        
        long startTime = System.currentTimeMillis();

        System.out.println(">>> [ORDER " + orderId + "] " + agentName + " picked up from " + restaurant + 
                           " (Type: " + deliveryType + ")");

        try {
            System.out.println("... [ORDER " + orderId + "] is In Transit (" + deliveryTimeSeconds + "s expected)");
            Thread.sleep(deliveryTimeSeconds * 1000);
            long endTime = System.currentTimeMillis();
            double totalTime = (endTime - startTime) / 1000.0;
            
            System.out.println("SUCCESS: [ORDER " + orderId + "] Delivered by " + agentName + 
                               "! Total Time: " + totalTime + " seconds.");
            
        } catch (InterruptedException e) {
            System.out.println("Order " + orderId + " was cancelled due to an error.");
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Order o1 = new Order("ORD001", "Pizza Hut", 3, "Express", 10);
        Order o2 = new Order("ORD002", "Burger King", 5, "Standard", 5);
        Order o3 = new Order("ORD003", "Sushi Zen", 8, "Economy", 3);
        Order o4 = new Order("ORD004", "Taco Bell", 2, "Express", 10);
        Order o5 = new Order("ORD005", "Pasta Palace", 6, "Standard", 5);
        Thread agent1 = new Thread(o1, "Agent-Alpha");
        Thread agent2 = new Thread(o2, "Agent-Bravo");
        Thread agent3 = new Thread(o3, "Agent-Charlie");
        Thread agent4 = new Thread(o4, "Agent-Delta");
        Thread agent5 = new Thread(o5, "Agent-Echo");
        agent1.start();
        agent2.start();
        agent3.start();
        agent4.start();
        agent5.start();
    }
}
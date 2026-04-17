import java.util.Objects;

class Booking implements Comparable<Booking> {
    String userId;
    String eventName;
    boolean isVIP;

    public Booking(String userId, String eventName, boolean isVIP) {
        this.userId = userId;
        this.eventName = eventName;
        this.isVIP = isVIP;
    }
    @Override
    public int compareTo(Booking other) {
        if (this.isVIP && !other.isVIP) return -1;
        if (!this.isVIP && other.isVIP) return 1;
        return 0; 
    }

    @Override
    public String toString() {
        return (isVIP ? "[VIP] " : "[Regular] ") + "User: " + userId;
    }
}
import java.util.*;

public class TicketSystem {
    private Set<String> registeredUsers = new HashSet<>();
    private List<Booking> confirmedBookings = new ArrayList<>();
    private Queue<Booking> standardQueue = new LinkedList<>();
    private PriorityQueue<Booking> priorityQueue = new PriorityQueue<>();
    public boolean registerUser(String userId) {
        if (registeredUsers.add(userId)) {
            System.out.println("User " + userId + " registered successfully.");
            return true;
        }
        System.out.println("Registration failed: User " + userId + " already exists.");
        return false;
    }
    public void requestBooking(String userId, String event, boolean isVIP) {
        if (!registeredUsers.contains(userId)) {
            System.out.println("Error: User must register before booking.");
            return;
        }
        
        Booking newBooking = new Booking(userId, event, isVIP);
        if (isVIP) {
            priorityQueue.add(newBooking);
        } else {
            standardQueue.add(newBooking);
        }
    }
    public void processAllConfirmations() {
        System.out.println("\n--- Processing Confirmations ---");
        while (!priorityQueue.isEmpty()) {
            confirm(priorityQueue.poll());
        }
        while (!standardQueue.isEmpty()) {
            confirm(standardQueue.poll());
        }
    }

    private void confirm(Booking b) {
        confirmedBookings.add(b);
        System.out.println("Confirmed: " + b);
    }
}
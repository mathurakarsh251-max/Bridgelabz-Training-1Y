import java.util.Objects;

class Parcel implements Comparable<Parcel> {
    String deliveryId;
    String address;
    int priority; 

    public Parcel(String deliveryId, String address, int priority) {
        this.deliveryId = deliveryId;
        this.address = address;
        this.priority = priority;
    }

    @Override
    public int compareTo(Parcel other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parcel)) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(deliveryId, parcel.deliveryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId);
    }

    @Override
    public String toString() {
        return "ID: " + deliveryId + " | Priority: " + priority + " | To: " + address;
    }
}
import java.util.*;

public class CourierRoutingSystem {
    private PriorityQueue<Parcel> expressQueue = new PriorityQueue<>();
    private Queue<Parcel> standardQueue = new LinkedList<>();
    private Set<String> assignedIds = new HashSet<>();
    private List<Parcel> completedDeliveries = new ArrayList<>();
    public void addParcel(String id, String address, int priority) {
        if (assignedIds.contains(id)) {
            System.out.println("Duplicate ID detected: " + id + ". Skipping.");
            return;
        }

        Parcel p = new Parcel(id, address, priority);
        assignedIds.add(id);

        if (priority <= 2) { 
            expressQueue.add(p);
        } else {
            standardQueue.add(p);
        }
    }
    public void dispatchAgent() {
        Parcel toDeliver = null;
        if (!expressQueue.isEmpty()) {
            toDeliver = expressQueue.poll();
            System.out.print("[EXPRESS DISPATCH] ");
        } else if (!standardQueue.isEmpty()) {
            toDeliver = standardQueue.poll();
            System.out.print("[STANDARD DISPATCH] ");
        }

        if (toDeliver != null) {
            System.out.println("Delivering " + toDeliver.deliveryId);
            completedDeliveries.add(toDeliver); 
        } else {
            System.out.println("No parcels pending delivery.");
        }
    }
}
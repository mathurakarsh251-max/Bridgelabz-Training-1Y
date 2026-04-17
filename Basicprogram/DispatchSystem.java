class Driver {
    String id;
    String name;

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        return id.equals(((Driver) o).id);
    }
    @Override
    public int hashCode() { return id.hashCode(); }
}

class RideRequest implements Comparable<RideRequest> {
    String passengerName;
    int proximity; 
    boolean isUrgent;

    public RideRequest(String name, int proximity, boolean isUrgent) {
        this.passengerName = name;
        this.proximity = proximity;
        this.isUrgent = isUrgent;
    }

    @Override
    public int compareTo(RideRequest other) {
        if (this.isUrgent != other.isUrgent) {
            return this.isUrgent ? -1 : 1;
        }
        return Integer.compare(this.proximity, other.proximity);
    }
}
import java.util.*;

public class DispatchSystem {
    private PriorityQueue<RideRequest> pendingRequests = new PriorityQueue<>();
    private Set<Driver> availableDrivers = new HashSet<>();
    private List<String> rideHistory = new ArrayList<>();
    public void addRequest(RideRequest request) {
        pendingRequests.add(request);
        System.out.println("New Request: " + request.passengerName + 
                           (request.isUrgent ? " [URGENT]" : ""));
    }
    public void dispatchRide() {
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending rides.");
            return;
        }
        if (availableDrivers.isEmpty()) {
            System.out.println("No drivers available right now.");
            return;
        }
        RideRequest currentRide = pendingRequests.poll();
        Driver assignedDriver = availableDrivers.iterator().next();
        availableDrivers.remove(assignedDriver);

        System.out.println("Assigned Driver " + assignedDriver.name + 
                           " to " + currentRide.passengerName);
        completeRide(currentRide, assignedDriver);
    }

    private void completeRide(RideRequest ride, Driver driver) {
        String record = "Ride for " + ride.passengerName + " completed by " + driver.name;
        rideHistory.add(record);
        availableDrivers.add(driver); 
    }

    public void addDriver(Driver d) {
        availableDrivers.add(d);
    }
}
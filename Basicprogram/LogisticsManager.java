import java.util.Objects;

class Package {
    String packageId;
    String destination;
    double weight;

    public Package(String packageId, String destination, double weight) {
        this.packageId = packageId;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Package)) return false;
        Package p = (Package) o;
        return packageId.equals(p.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId);
    }

    @Override
    public String toString() {
        return "ID: " + packageId + " | To: " + destination;
    }
}
import java.util.*;

public class LogisticsManager {
    private Queue<Package> pendingDeliveries = new LinkedList<>();
    private Set<String> uniqueIds = new HashSet<>();
    private List<Package> deliveredLog = new ArrayList<>();
    private Stack<Package> returnedStack = new Stack<>()
    public void addPackage(Package pkg) {
        if (uniqueIds.add(pkg.packageId)) {
            pendingDeliveries.add(pkg);
            System.out.println("Package " + pkg.packageId + " added to queue.");
        } else {
            System.out.println("Error: Package ID " + pkg.packageId + " already exists!");
        }
    }
    public void deliverNext() {
        if (!pendingDeliveries.isEmpty()) {
            Package current = pendingDeliveries.poll();
            deliveredLog.add(current);
            System.out.println("Delivered: " + current.packageId);
        } else {
            System.out.println("No pending deliveries.");
        }
    }
    public void returnPackage(String packageId) {
        for (Package p : deliveredLog) {
            if (p.packageId.equals(packageId)) {
                returnedStack.push(p);
                deliveredLog.remove(p);
                System.out.println("Package " + packageId + " moved to returns.");
                return;
            }
        }
    }
    public void displaySummary() {
        System.out.println("\n--- Logistics Summary ---");
        System.out.println("Pending: " + pendingDeliveries.size());
        System.out.println("Delivered Total: " + deliveredLog.size());
        System.out.println("Returned Total: " + returnedStack.size());
        System.out.println("-------------------------\n");
    }
}
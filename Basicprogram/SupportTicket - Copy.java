import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class SupportTicket extends Thread {
    private int ticketId;
    private String type;
    private int priority;
    private long startTime;
    
    private static Map<Integer, List<Long>> stats = new ConcurrentHashMap<>();

    public SupportTicket(int id, String type, int priority) {
        this.ticketId = id;
        this.type = type;
        this.priority = priority;
        this.setName("Agent-" + id); 
        this.setPriority(priority);
    }

    @Override
    public void run() {
        this.startTime = System.currentTimeMillis();
        Random random = new Random();
        
        System.out.println("[START] " + getName() + " handling Ticket #" + ticketId + 
                           " [" + type + "] | Priority: " + priority);

        try {
            int processTime = (random.nextInt(5) + 1) * 1000;
            Thread.sleep(processTime);
            
            long endTime = System.currentTimeMillis();
            long totalTime = (endTime - startTime) / 1000;

            stats.computeIfAbsent(priority, k -> Collections.synchronizedList(new ArrayList<>()))
                 .add(totalTime);

            System.out.println("[COMPLETE] Ticket #" + ticketId + " processed in " + 
                               totalTime + "s by " + getName());
            
        } catch (InterruptedException e) {
            System.out.println("Ticket #" + ticketId + " processing interrupted.");
        }
    }

    public static void displayStatistics() {
        System.out.println("\n--- Support System Statistics ---");
        stats.forEach((priority, times) -> {
            double avg = times.stream().mapToLong(Long::longValue).average().orElse(0.0);
            String label = getLabel(priority);
            System.out.printf("Priority %d (%s): Average Processing Time = %.2fs\n", 
                              priority, label, avg);
        });
    }

    private static String getLabel(int p) {
        if (p == 10) return "Critical Bug";
        if (p == 4) return "Feature Request";
        if (p == 2)
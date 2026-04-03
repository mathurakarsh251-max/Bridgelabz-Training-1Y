import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class SmartDevice implements Runnable {
    private String deviceName;
    private int intervalSeconds;
    private int priority;
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public SmartDevice(String name, int intervalSeconds, int priority) {
        this.deviceName = name;
        this.intervalSeconds = intervalSeconds;
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);

        for (int i = 1; i <= 5; i++) {
            String timestamp = LocalTime.now().format(timeFormatter);
            System.out.println("[" + timestamp + "] " + deviceName + 
                               " (Priority: " + priority + ") - Cycle " + i + " running...");

            try {
                Thread.sleep(intervalSeconds * 1000);
            } catch (InterruptedException e) {
                System.out.println(deviceName + " interrupted.");
            }
        }
        System.out.println(">> " + deviceName + " completed its 5 cycles and is shutting down.");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        System.out.println("Starting Smart Home System...\n");
        Thread tempSensor = new Thread(new SmartDevice("Temperature Sensor", 5, 7));
        Thread securityCamera = new Thread(new SmartDevice("Security Camera", 3, 10));
        Thread lightController = new Thread(new SmartDevice("Light Controller", 4, 5));
        Thread doorLock = new Thread(new SmartDevice("Door Lock Monitor", 6, 5));
        tempSensor.start();
        securityCamera.start();
        lightController.start();
        doorLock.start();
        try {
            tempSensor.join();
            securityCamera.join();
            lightController.join();
            doorLock.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll smart devices have successfully completed their cycles. System Terminated.");
    }
}
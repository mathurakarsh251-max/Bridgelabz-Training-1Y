import java.util.HashMap;
import java.util.Map;
@FunctionalInterface
interface LightBehavior {
    void execute();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        Map<String, LightBehavior> triggers = new HashMap<>();
        triggers.put("MOTION_DETECTED", () -> {
            System.out.println("Trigger: Motion");
            System.out.println("Action: Brightness 100%, Color: Cool White, Duration: 5 mins.");
        });

        triggers.put("NIGHT_TIME", () -> {
            System.out.println("Trigger: Time of Day (10 PM)");
            System.out.println("Action: Brightness 10%, Color: Warm Amber (Dimmed).");
        });

        triggers.put("VOICE_PARTY_MODE", () -> {
            System.out.println("Trigger: Voice Command 'Party Mode'");
            System.out.println("Action: Multi-color cycling, Pulse effect enabled.");
        });

        triggers.put("AWAY_MODE", () -> {
            System.out.println("Trigger: Security Armed");
            System.out.println("Action: Randomize lights to simulate occupancy.");
        });
        simulateEvent(triggers, "MOTION_DETECTED");
        System.out.println("---");
        simulateEvent(triggers, "VOICE_PARTY_MODE");
        System.out.println("---");
        simulateEvent(triggers, "MORNING_ALARM"); 
    }
    public static void simulateEvent(Map<String, LightBehavior> registry, String event) {
        LightBehavior behavior = registry.get(event);
        if (behavior != null) {
            behavior.execute();
        } else {
            System.out.println("No behavior defined for trigger: " + event);
        }
    }
}
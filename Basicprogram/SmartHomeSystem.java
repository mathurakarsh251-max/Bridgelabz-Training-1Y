interface SmartDevice {
    void turnOn();
    void turnOff();
}
class Light implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Light: Bulb is now glowing.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light: Bulb is switched off.");
    }
}
class AC implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("AC: Cooling started at 24°C.");
    }

    @Override
    public void turnOff() {
        System.out.println("AC: Powering down compressor.");
    }
}
class TV implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("TV: Displaying home screen.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV: Entering standby mode.");
    }
}
public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartDevice[] myDevices = { new Light(), new AC(), new TV() };

        System.out.println("--- Activating Home ---");
        for (SmartDevice device : myDevices) {
            device.turnOn();
        }

        System.out.println("\n--- Shutting Down ---");
        for (SmartDevice device : myDevices) {
            device.turnOff();
        }
    }
}
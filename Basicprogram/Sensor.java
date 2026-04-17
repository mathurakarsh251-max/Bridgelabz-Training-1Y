class Sensor {
    protected boolean isReady = false;

    public void initialize() {
        System.out.println("Base: Warming up hardware...");
        isReady = true; 
    }

    public void readData() {
        if (!isReady) throw new IllegalStateException("Sensor not initialized!");
        System.out.println("Reading generic data...");
    }
}

class TemperatureSensor extends Sensor {
    @Override
    public void initialize() {
        System.out.println("Subclass: Calibrating digital thermometer...");
    }
}
abstract class SensorTest {
    abstract Sensor createSensor();

    @Test
    void testInitializationSetsReadyFlag() {
        Sensor s = createSensor();
        s.initialize();
        assertTrue(s.isReady, "Subclass must set isReady to true after init!");
    }
}
class TempSensorTest extends SensorTest {
    @Override
    Sensor createSensor() { return new TemperatureSensor(); }
}
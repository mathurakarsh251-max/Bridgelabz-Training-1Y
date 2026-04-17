class Engine {
    void start() { System.out.println("Vroom!"); }
}
class Car extends Engine { 
    void drive() {
        start(); 
        System.out.println("Driving...");
    }
}
class Engine {
    void start() { System.out.println("Engine started."); }
}

class Car {
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    void drive() {
        engine.start();
        System.out.println("Car is moving.");
    }
}
Engine electricEngine = new Engine();
Car myTesla = new Car(electricEngine);
class Device {
    protected String brand;
    public Device(String brand) { this.brand = brand; }
}

class Laptop extends Device {
    private String model;
    public Laptop(String brand, String model) {
        super(brand); 
        this.model = model;
    }
}
class Parent {
    public Parent() {
        init(); 
    }
    public void init() { System.out.println("Parent init"); }
}

class Child extends Parent {
    private String data;
    public Child() { this.data = "Hello World"; }

    @Override
    public void init() {
        System.out.println("Data length: " + data.length()); 
    }
}
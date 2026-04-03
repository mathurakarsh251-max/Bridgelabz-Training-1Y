class Circle {
    double radius;
    Circle() {
        this(1.0); 
        System.out.println("Default constructor called (Radius set to 1.0)");
    }
    Circle(double radius) {
        this.radius = radius;
        System.out.println("Parameterized constructor called (Radius set to " + radius + ")");
    }
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    void display() {
        System.out.println("Circle Radius: " + radius);
        System.out.printf("Circle Area:   %.2f\n", calculateArea());
        System.out.println("-------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        defaultCircle.display();
        Circle customCircle = new Circle(5.5);
        customCircle.display();
    }
}
import java.util.Scanner;

class Circle {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    void displayResults() {
        System.out.println("----- Circle Properties -----");
        System.out.printf("Radius:         %.2f\n", radius);
        System.out.printf("Area:           %.2f\n", calculateArea());
        System.out.printf("Circumference:  %.2f\n", calculateCircumference());
        System.out.println("-----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5.5);
        myCircle.displayResults();
    }
}
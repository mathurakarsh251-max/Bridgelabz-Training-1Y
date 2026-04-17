import java.util.*;
class Animal {
    String name;
    Animal(String name) { this.name = name; }
    public String toString() { return "Animal: " + name; }
}
class Dog extends Animal {
    Dog(String name) { super(name); }
    @Override
    public String toString() { return "Dog: " + name; }
}
class Cat extends Animal {
    Cat(String name) { super(name); }
    @Override
    public String toString() { return "Cat: " + name; }
}

public class AnimalHierarchyDemo {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Bulldog"));
        dogs.add(new Dog("Beagle"));
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Persian"));
        cats.add(new Cat("Siamese"));

        System.out.println("Printing Dogs:");
        printAnimals(dogs);

        System.out.println("\nPrinting Cats:");
        printAnimals(cats);
    }
}

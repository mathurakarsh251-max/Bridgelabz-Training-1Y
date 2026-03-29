class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Original object created: " + name);
    }
    Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
        System.out.println("Copy constructor called: Cloned " + otherPerson.name);
    }
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Person original = new Person("Arjun", 25);
        System.out.print("Original Data -> ");
        original.display();
        Person clone = new Person(original);
        System.out.print("Cloned Data   -> ");
        clone.display();
        clone.name = "Vikram";
        System.out.println("\n--- After modifying the clone ---");
        System.out.print("Original remains: ");
        original.display();
        System.out.print("Clone is now:     ");
        clone.display();
    }
}
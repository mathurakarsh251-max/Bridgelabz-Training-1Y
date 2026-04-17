class Fruit {
    public String getName() {
        return "Generic Fruit";
    }
}

class Apple extends Fruit {
    @Override
    public String getName() {
        return "Apple 🍎";
    }
}

class Mango extends Fruit {
    @Override
    public String getName() {
        return "Mango 🥭";
    }
}
class Car {
    public String getModel() {
        return "Sedan";
    }
}
import java.util.ArrayList;
import java.util.List;

class FruitBox<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void displayFruits() {
        for (T fruit : fruits) {
            System.out.println("In the box: " + fruit.getName());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.addFruit(new Apple());
        appleBox.displayFruits();
        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.addFruit(new Mango());
        mangoBox.displayFruits();
    }
}
import java.util.ArrayList;
import java.util.List;
class Cart<T> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
        System.out.println(item + " added to cart.");
    }
    public void removeItem(T item) {
        if (items.remove(item)) {
            System.out.println(item + " removed from cart.");
        } else {
            System.out.println(item + " not found in cart.");
        }
    }
    public void displayItems() {
        System.out.println("Items in cart:");
        for (T item : items) {
            System.out.println("- " + item);
        }
    }
}
class Electronics {
    String name;
    Electronics(String name) { this.name = name; }
    public String toString() { return "Electronics: " + name; }
}

class Clothing {
    String name;
    Clothing(String name) { this.name = name; }
    public String toString() { return "Clothing: " + name; }
}

public class GenericCartDemo {
    public static void main(String[] args) {
        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Smartphone"));
        electronicsCart.displayItems();

        System.out.println();
        Cart<Clothing> clothingCart = new Cart<>();
        clothingCart.addItem(new Clothing("T-Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));
        clothingCart.displayItems();
    }
}

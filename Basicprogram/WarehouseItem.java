import java.util.*;
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return getCategory() + ": " + name;
    }
}
class Electronics extends WarehouseItem {
    public Electronics(String name) { super(name); }
    @Override
    public String getCategory() { return "Electronics"; }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) { super(name); }
    @Override
    public String getCategory() { return "Groceries"; }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) { super(name); }
    @Override
    public String getCategory() { return "Furniture"; }
}
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println(item + " added to storage.");
    }

    public List<T> getItems() {
        return items;
    }
}
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        System.out.println("Items in storage:");
        for (WarehouseItem item : items) {
            System.out.println("- " + item);
        }
    }
}
public class SmartWarehouseDemo {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println();
        WarehouseUtils.displayItems(electronicsStorage.getItems());
        WarehouseUtils.displayItems(groceriesStorage.getItems());
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}

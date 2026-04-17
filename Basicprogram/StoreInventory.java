import java.util.HashMap;
import java.util.Map;

public class StoreInventory {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apples", 50);
        inventory.put("Bread", 10);
        inventory.put("Milk", 5);
        inventory.put("Eggs", 12);
        String purchase = "Milk";
        int quantityBought = 5;
        if (inventory.containsKey(purchase)) {
            int currentStock = inventory.get(purchase);
            inventory.put(purchase, currentStock - quantityBought);
            if (inventory.get(purchase) <= 0) {
                inventory.put(purchase, 0); 
            }
        }
        String shipmentItem = "Bread";
        int shipmentAmount = 20;
        inventory.put(shipmentItem, inventory.getOrDefault(shipmentItem, 0) + shipmentAmount);
        checkStock(inventory, "Apples");
        checkStock(inventory, "Milk");
        checkStock(inventory, "Chocolate"); 
        System.out.println("\n--- Out of Stock Items ---");
        boolean anyOutOfStock = false;
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println("- " + entry.getKey());
                anyOutOfStock = true;
            }
        }
        if (!anyOutOfStock) System.out.println("None - All items in stock!");
    }

    public static void checkStock(Map<String, Integer> map, String item) {
        if (map.containsKey(item)) {
            System.out.println(item + " remaining: " + map.get(item));
        } else {
            System.out.println(item + ": Not stocked");
        }
    }
}
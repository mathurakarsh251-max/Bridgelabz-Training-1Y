class Item {
    int itemCode;
    String itemName;
    double price;
    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    void displayItemInfo() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: " + price);
    }
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Item product = new Item(5001, "Mechanical Keyboard", 75.50);
        
        int quantityOrdered = 3;
        System.out.println("----- Inventory Check -----");
        product.displayItemInfo();
        System.out.println("Quantity:   " + quantityOrdered);
        System.out.println("Total Cost: " + product.calculateTotalCost(quantityOrdered));
        System.out.println("---------------------------");
    }
}
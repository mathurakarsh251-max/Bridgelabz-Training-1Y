class Product {
    int productId;
    String productName;
    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
    public boolean isMatch(String keyword) {
        return productName.toLowerCase().contains(keyword.toLowerCase());
    }

    public void display() {
        System.out.println("[" + productId + "] " + productName);
    }
}

class ElectronicProduct extends Product {
    String brand;

    public ElectronicProduct(int productId, String productName, String brand) {
        super(productId, productName);
        this.brand = brand;
    }
    @Override
    public boolean isMatch(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        boolean nameMatch = productName.toLowerCase().contains(lowerKeyword);
        boolean brandMatch = brand.toLowerCase().equalsIgnoreCase(lowerKeyword);
        
        return nameMatch || brandMatch;
    }

    @Override
    public void display() {
        System.out.println("[" + productId + "] " + productName + " (Brand: " + brand + ")");
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Product p1 = new Product(1001, "Leather Messenger Bag");
        Product p2 = new ElectronicProduct(2002, "Whirlpool Refrigerator", "Whirlpool");

        String searchKey = "Whirlpool";

        System.out.println("Searching for: " + searchKey);
        
        if (p1.isMatch(searchKey)) {
            p1.display();
        }
        
        if (p2.isMatch(searchKey)) {
            p2.display();
        }
    }
}
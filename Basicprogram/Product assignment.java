class Product {
    String productName;
    double price;
    static int totalProducts = 0;
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    void displayProductDetails() {
        System.out.println("Product: " + productName + " | Price: ₹" + price);
    }
    static void displayTotalProducts() {
        System.out.println("Total Products in Inventory: " + totalProducts);
        System.out.println("-------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000.00);
        Product p2 = new Product("Smartphone", 25000.00);
        Product p3 = new Product("Headphones", 2000.00);
        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();
        Product.displayTotalProducts();
    }
}
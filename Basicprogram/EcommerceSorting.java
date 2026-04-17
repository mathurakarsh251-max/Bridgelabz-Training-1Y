import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    int discount;

    public Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Price: ₹%-6.0f | Rating: %.1f | Discount: %d%%", 
                              name, price, rating, discount);
    }
}

public class EcommerceSorting {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("Smartphone", 15000, 4.5, 10),
            new Product("Laptop", 55000, 4.8, 5),
            new Product("Headphones", 2000, 4.2, 25),
            new Product("Smartwatch", 4500, 4.0, 15),
            new Product("Charger", 800, 3.9, 50)
        ));
        System.out.println("--- Sorting by Price (Low to High) ---");
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);
        System.out.println("\n--- Sorting by Rating (High to Low) ---");
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        products.forEach(System.out::println);
        System.out.println("\n--- Sorting by Discount (High to Low) ---");
        products.sort((p1, p2) -> Integer.compare(p2.discount, p1.discount));
        products.forEach(System.out::println);
    }
}
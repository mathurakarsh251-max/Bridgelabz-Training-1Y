import java.util.*;
interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    @Override
    public String getCategoryName() { return "Book"; }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() { return "Clothing"; }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() { return "Gadget"; }
}
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getName() { return name; }
    public T getCategory() { return category; }

    @Override
    public String toString() {
        return category.getCategoryName() + " - " + name + " (₹" + price + ")";
    }
}
class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
        System.out.println("Discount applied: " + percentage + "% off " + product.getName());
    }
}
public class MarketplaceDemo {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 800, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000, new GadgetCategory());
        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        System.out.println("Catalog:");
        for (Product<? extends Category> p : catalog) {
            System.out.println("- " + p);
        }

        System.out.println();
        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(shirt, 20);
        MarketplaceUtils.applyDiscount(phone, 5);
        System.out.println("\nUpdated Catalog:");
        for (Product<? extends Category> p : catalog) {
            System.out.println("- " + p);
        }
    }
}

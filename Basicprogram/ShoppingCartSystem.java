import java.util.ArrayList;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        String[] itemPrices = {"250", "499", "abc", "99", "invalid_price"};

        int totalSum = 0;
        int validItemsCount = 0;
        int invalidItemsCount = 0;

        System.out.println("--- Processing Shopping Cart ---");

        for (String priceStr : itemPrices) {
            try {
                int price = Integer.parseInt(priceStr);
                
                totalSum += price;
                validItemsCount++;
                System.out.println("Item added: " + price);
                
            } catch (NumberFormatException e) {
                invalidItemsCount++;
                System.out.println("Skipping invalid price: \"" + priceStr + "\"");
            }
        }
        System.out.println("\n--- Order Summary ---");
        System.out.println("Total Valid Items: " + validItemsCount);
        System.out.println("Total Invalid Items Skipped: " + invalidItemsCount);
        System.out.println("Total Price to Pay: " + totalSum);
    }
}
public class ShoppingCartCalculator {
    public static void main(String[] args) {
        String[] itemPrices = {"250", "499", "abc", "99", "75x"};

        int totalPrice = 0;
        int processedCount = 0;
        int errorCount = 0;

        System.out.println("--- Processing Shopping Cart ---");

        for (String priceStr : itemPrices) {
            try {
                int price = Integer.parseInt(priceStr);
                
                totalPrice += price;
                processedCount++;
                System.out.println("Added Item: " + price);

            } catch (NumberFormatException e) {
                errorCount++;
                System.out.println("Skipped Invalid Price: \"" + priceStr + "\"");
            }
        }
        System.out.println("\n--- Cart Summary ---");
        System.out.println("Total Items Added: " + processedCount);
        System.out.println("Invalid Items Skipped: " + errorCount);
        System.out.println("Grand Total: " + totalPrice);
    }
}
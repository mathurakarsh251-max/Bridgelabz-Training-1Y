import java.util.Arrays;
import java.util.List;

class StockUpdate {
    String ticker;
    double price;
    String timestamp;

    public StockUpdate(String ticker, double price, String timestamp) {
        this.ticker = ticker;
        this.price = price;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-5s: $%.2f", timestamp, ticker, price);
    }
}

public class StockPriceLogger {
    public static void main(String[] args) {
        List<StockUpdate> liveFeed = Arrays.asList(
            new StockUpdate("AAPL", 175.40, "10:00:01"),
            new StockUpdate("GOOGL", 2840.15, "10:00:02"),
            new StockUpdate("TSLA", 710.20, "10:00:03"),
            new StockUpdate("AMZN", 3350.10, "10:00:04"),
            new StockUpdate("MSFT", 310.55, "10:00:05")
        );

        System.out.println("--- LIVE STOCK FEED ACTIVE ---");
        liveFeed.forEach(System.out::println);

        System.out.println("--- END OF FEED ---");
    }
}
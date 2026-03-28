public class ProfitLossCalculator {
    public static void main(String[] args) {
        double costPrice = 129.0;
        double sellingPrice = 191.0;
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;
        System.out.println("Cost Price: INR " + costPrice + 
                           "\nSelling Price: INR " + sellingPrice + 
                           "\nProfit: INR " + profit + 
                           "\nProfit Percentage: " + profitPercentage + "%");
    }
}
public class BankTransactionUtility {

    public static void main(String[] args) {
        Double databaseLimit1 = 5000.00;
        Double databaseLimit2 = null; 
        double currentWithdrawal = 1200.50;

        System.out.println("--- Withdrawal Limit Check ---");
        System.out.println("Remaining (Case 1): " + getRemainingLimit(databaseLimit1, currentWithdrawal));
        System.out.println("Remaining (Case 2): " + getRemainingLimit(databaseLimit2, currentWithdrawal));
    }
    public static double getRemainingLimit(Double dailyLimit, double spentAmount) {
        if (dailyLimit == null) {
            return 0.0;
        }
        double remaining = dailyLimit - spentAmount;
        return Math.max(0.0, remaining);
    }
}
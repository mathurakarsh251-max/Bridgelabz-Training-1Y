import java.util.*;
import java.util.stream.Collectors;

public class BankBalanceTracker {
    public static void main(String[] args) {
        Map<String, Double> bankAccounts = new HashMap<>();
        bankAccounts.put("ACC001", 1500.50);
        bankAccounts.put("ACC002", 52000.00);
        bankAccounts.put("ACC003", 890.00);
        bankAccounts.put("ACC004", 12500.75);
        bankAccounts.put("ACC005", 3100.00);
        bankAccounts.put("ACC006", 45000.00);
        processTransaction(bankAccounts, "ACC001", 500.00, true);  
        processTransaction(bankAccounts, "ACC003", 1000.00, false); 
        processTransaction(bankAccounts, "ACC004", 2500.00, false); 
        printSortedAccounts(bankAccounts);
        printTopCustomers(bankAccounts, 3);
    }
    public static void processTransaction(Map<String, Double> map, String accNum, double amount, boolean isDeposit) {
        if (!map.containsKey(accNum)) {
            System.out.println("Error: Account " + accNum + " not found.");
            return;
        }

        double currentBalance = map.get(accNum);

        if (isDeposit) {
            map.put(accNum, currentBalance + amount);
            System.out.printf("Deposited $%.2f to %s. New Balance: $%.2f%n", amount, accNum, map.get(accNum));
        } else {
            if (amount > currentBalance) {
                System.out.printf("Transaction Failed: Insufficient funds in %s for withdrawal of $%.2f%n", accNum, amount);
            } else {
                map.put(accNum, currentBalance - amount);
                System.out.printf("Withdrew $%.2f from %s. New Balance: $%.2f%n", amount, accNum, map.get(accNum));
            }
        }
    }
    public static void printSortedAccounts(Map<String, Double> map) {
        System.out.println("\n--- All Accounts (Highest to Lowest) ---");
        map.entrySet()
           .stream()
           .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
           .forEach(entry -> System.out.printf("Account: %s | Balance: $%.2f%n", entry.getKey(), entry.getValue()));
    }
    public static void printTopCustomers(Map<String, Double> map, int limit) {
        System.out.println("\n--- Top " + limit + " Customers ---");
        List<Map.Entry<String, Double>> topList = map.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(limit)
            .collect(Collectors.toList());

        for (int i = 0; i < topList.size(); i++) {
            System.out.printf("%d. %s ($%.2f)%n", i + 1, topList.get(i).getKey(), topList.get(i).getValue());
        }
    }
}
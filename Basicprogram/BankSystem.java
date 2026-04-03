class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Transaction denied. Current balance: $" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: $" + balance);
    }
}
public class BankSystem {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(500.00);

        double[] requests = {100.00, -50.00, 600.00};

        for (double req : requests) {
            try {
                System.out.println("\nAttempting to withdraw: $" + req);
                myAccount.withdraw(req);
            } catch (InsufficientBalanceException e) {
                System.err.println("Banking Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Input Error: " + e.getMessage());
            }
        }
    }
}
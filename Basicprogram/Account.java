class Account {
    long accountNumber;
    double balance;
    static String bankName = "National Apex Bank";
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public double calculateInterest() {
        return 0.0;
    }

    public void displayAccountInfo() {
        System.out.println("Bank: " + bankName);
        System.out.println("A/C No: " + accountNumber + " | Current Balance: ₹" + balance);
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount(9876543210L, 50000.0);
        Account acc2 = new CurrentAccount(1234567890L, 120000.0);

        System.out.println("--- Savings Account Details ---");
        acc1.displayAccountInfo();
        System.out.println("Annual Interest (4%): ₹" + acc1.calculateInterest());

        System.out.println("\n--- Current Account Details ---");
        acc2.displayAccountInfo();
        System.out.println("Annual Interest (2%): ₹" + acc2.calculateInterest());
    }
}
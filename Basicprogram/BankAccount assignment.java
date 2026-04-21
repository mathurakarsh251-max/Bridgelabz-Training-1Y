class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }
}
class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountSummary() {
        System.out.println("======= SAVINGS ACCOUNT =======");
        System.out.println("A/C Number: " + accountNumber); 
        System.out.println("Holder:     " + accountHolder); 
        System.out.println("Balance:    ₹" + getBalance());
        
        System.out.println("Interest:   " + interestRate + "%");
        System.out.println("===============================");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SBI-9988", "Rohan Mehra", 10000.0, 4.5);
        sa.accountNumber = "SBI-0001"; 
        sa.deposit(5000);
        sa.withdraw(2000);
        sa.displayAccountSummary();
    }
}
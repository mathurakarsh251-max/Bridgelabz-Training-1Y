interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
    public abstract double calculateInterest();
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
}
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; 

    public SavingsAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; 
    }

    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.01; 
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; 
    }

    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }
}
import java.util.*;

public class BankingApp {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SAV123", "John Doe", 5000));
        accounts.add(new CurrentAccount("CUR456", "Tech Corp", 20000));

        System.out.println("--- Monthly Banking Statement ---");
        for (BankAccount acc : accounts) {
            double interest = acc.calculateInterest();
            
            System.out.println("Account: " + acc.getAccountNumber() + " | Holder: " + acc.getHolderName());
            System.out.println(" - Current Balance: $" + acc.getBalance());
            System.out.println(" - Interest Earned: $" + interest);
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println(" - Loan Eligibility: Up to $" + loanAcc.calculateLoanEligibility());
            }
            System.out.println("---------------------------------");
        }
    }
}
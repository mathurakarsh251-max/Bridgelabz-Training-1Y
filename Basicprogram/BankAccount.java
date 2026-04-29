class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;
    BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Transaction failed.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
        }
    }
    void displayBalance() {
        System.out.println("----------------------------------");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("----------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("Vikram Aditya", "SBI123456", 5000.00);
        myAccount.displayBalance();
        myAccount.deposit(1500.00);
        myAccount.withdraw(2000.00);
        myAccount.withdraw(10000.00); 
        myAccount.displayBalance();
    }
}
class BankAccount {
    public double balance; 
}
class FraudulentAccount extends BankAccount {
    void glitch() { balance = 1000000; } 
}
class BankAccount {
    private double balance; 

    protected void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
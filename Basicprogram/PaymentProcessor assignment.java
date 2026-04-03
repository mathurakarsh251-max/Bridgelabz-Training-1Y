abstract class PaymentProcessor {
    protected double amount;
    public void logTransaction() {
        System.out.println("Transaction of " + amount + " logged at " + new java.util.Date());
    }
    public abstract void executePayment();
}

class UPIPayment extends PaymentProcessor {
    @Override
    public void executePayment() {
        System.out.println("Processing UPI transfer via VPA...");
    }
}
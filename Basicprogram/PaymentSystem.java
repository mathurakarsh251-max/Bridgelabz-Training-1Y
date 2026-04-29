interface Payment {
    void pay(double amount);
}
class UPI implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing ₹" + amount + " via UPI. Secure PIN verified.");
    }
}
class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing ₹" + amount + " via Credit Card. Gateway authorization successful.");
    }
}
class Wallet implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing ₹" + amount + " via Wallet. Balance deducted.");
    }
}
public class PaymentSystem {
    public static void main(String[] args) {
        Payment upiPayment = new UPI();
        Payment cardPayment = new CreditCard();
        Payment walletPayment = new Wallet();

        System.out.println("--- Transaction History ---");
        processTransaction(upiPayment, 500.0);
        processTransaction(cardPayment, 1200.50);
        processTransaction(walletPayment, 150.75);
    }
    public static void processTransaction(Payment p, double amount) {
        p.pay(amount);
    }
}
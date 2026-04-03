interface PaymentProcessor {
    void processPayment(double amount);
    default void refund(double amount) {
        System.out.println("Generic Refund: Processing ₹" + amount + " refund.");
        System.out.println("Note: This provider is using the default system-wide refund logic.");
    }
}
class LegacyGateway implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Legacy Gateway: Payment of ₹" + amount + " processed.");
    }
}
class ModernGateway implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Modern Gateway: Fast payment of ₹" + amount + " completed.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Modern Gateway: Issuing instant refund of ₹" + amount + " to original source.");
    }
}
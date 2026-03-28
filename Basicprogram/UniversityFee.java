public class UniversityFee {
    public static void main(String[] args) {
        double originalFee = 125000.0;
        double discountPercent = 10.0;
        double discountAmount = (discountPercent / 100) * originalFee;
        double finalPrice = originalFee - discountAmount;
        System.out.println("Original Course Fee: INR " + originalFee);
        System.out.println("Discount Amount (10%): INR " + discountAmount);
        System.out.println("Final Discounted Price to Pay: INR " + finalPrice);
    }
}
import java.util.*;
import java.util.stream.Collectors;

class InsuranceClaim {
    private String type; 
    private double amount;

    public InsuranceClaim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
}

public class ClaimAnalysis {
    public static void main(String[] args) {
        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("Auto", 15000.50),
            new InsuranceClaim("Health", 2500.00),
            new InsuranceClaim("Home", 45000.00),
            new InsuranceClaim("Auto", 8000.00),
            new InsuranceClaim("Health", 1200.75),
            new InsuranceClaim("Home", 12000.00),
            new InsuranceClaim("Auto", 2200.00)
        );
        Map<String, Double> averageClaimsByType = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getType,           
                Collectors.averagingDouble(InsuranceClaim::getAmount) 
            ));

        System.out.println("--- Average Claim Amount by Category ---");
        averageClaimsByType.forEach((type, avg) -> 
            System.out.printf("%-8s: ₹%.2f%n", type, avg)
        );
    }
}
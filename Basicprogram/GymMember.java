import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

class GymMember {
    private String name;
    private LocalDate expiryDate;

    public GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() { return name; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return String.format("%-15s | Expires: %s", name, expiryDate);
    }
}

public class MembershipFilter {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);

        List<GymMember> members = Arrays.asList(
            new GymMember("Alice", today.plusDays(10)),  
            new GymMember("Bob", today.plusDays(45)),    
            new GymMember("Charlie", today.plusDays(5)), 
            new GymMember("Diana", today.plusDays(29)),  
            new GymMember("Ethan", today.plusDays(60))   
        );
        List<GymMember> expiringSoon = members.stream()
            .filter(m -> m.getExpiryDate().isAfter(today.minusDays(1)) && 
                         m.getExpiryDate().isBefore(thirtyDaysFromNow.plusDays(1)))
            .collect(Collectors.toList());

        System.out.println("--- Members Expiring Within 30 Days ---");
        if (expiringSoon.isEmpty()) {
            System.out.println("No memberships expiring soon.");
        } else {
            expiringSoon.forEach(System.out::println);
        }
    }
}
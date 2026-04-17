import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HRNameFormatter {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
            "arjun mehta", 
            "sara gilbert", 
            "liam o'connor", 
            "priya sharma", 
            "kenji sato"
        );
        List<String> upperCaseNames = employees.stream()
                                               .map(String::toUpperCase)
                                               .collect(Collectors.toList());
        System.out.println("--- Formatted Employee List (HR Internal) ---");
        upperCaseNames.forEach(System.out::println);
    }
}
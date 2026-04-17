import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerNameTransformer {
    public static void main(String[] args) {
        List<String> customers = Arrays.asList(
            "liam neeson", 
            "ada lovelace", 
            "tony stark", 
            "grace hopper", 
            "steve rogers"
        );
        List<String> formattedNames = customers.stream()
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("--- Alphabetical Customer Directory ---");
        formattedNames.forEach(System.out::println);
    }
}
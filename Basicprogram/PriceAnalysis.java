import java.util.ArrayList;
import java.util.Collections;

public class PriceAnalysis {
    public static void main(String[] args) {
        double[] prices = {10.5, 20.0, 35.75, 5.5};
        ArrayList<Double> priceList = new ArrayList<>();
        for (double p : prices) {
            priceList.add(p); 
        }
        double highest = Collections.max(priceList);
        double sum = 0;
        for (Double price : priceList) {
            sum += price; 
        }
        double average = sum / priceList.size();
        System.out.println("Price List (ArrayList): " + priceList);
        System.out.println("----------------------------");
        System.out.println("Highest Price: " + highest);
        System.out.println("Average Price: " + average);
    }
}
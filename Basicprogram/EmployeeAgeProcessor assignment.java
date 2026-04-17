import java.util.ArrayList;
import java.util.Collections;

public class EmployeeAgeProcessor {
    public static void main(String[] args) {
        int[] primitiveAges = {22, 45, 30, 19, 58, 34};
        ArrayList<Integer> ageList = new ArrayList<>();
        
        for (int age : primitiveAges) {
            ageList.add(age); 
        }
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);
        System.out.println("Employee Age List (ArrayList): " + ageList);
        System.out.println("------------------------------------");
        System.out.println("Youngest Employee Age: " + youngest);
        System.out.println("Oldest Employee Age: " + oldest);
    }
}
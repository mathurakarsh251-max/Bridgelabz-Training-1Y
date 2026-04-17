import java.util.*;
interface MealPlan {
    String getPlanName();
    boolean isValid();
}
class VegetarianMeal implements MealPlan {
    private String name;
    public VegetarianMeal(String name) { this.name = name; }
    @Override
    public String getPlanName() { return "Vegetarian - " + name; }
    @Override
    public boolean isValid() { return true; } 
}

class VeganMeal implements MealPlan {
    private String name;
    public VeganMeal(String name) { this.name = name; }
    @Override
    public String getPlanName() { return "Vegan - " + name; }
    @Override
    public boolean isValid() { return true; }
}

class KetoMeal implements MealPlan {
    private String name;
    public KetoMeal(String name) { this.name = name; }
    @Override
    public String getPlanName() { return "Keto - " + name; }
    @Override
    public boolean isValid() { return true; }
}

class HighProteinMeal implements MealPlan {
    private String name;
    public HighProteinMeal(String name) { this.name = name; }
    @Override
    public String getPlanName() { return "High-Protein - " + name; }
    @Override
    public boolean isValid() { return true; }
}
class Meal<T extends MealPlan> {
    private T mealPlan;
    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }
    public T getMealPlan() { return mealPlan; }
    @Override
    public String toString() {
        return mealPlan.getPlanName();
    }
}
class MealPlanGenerator {
    public static <T extends MealPlan> void generatePlan(T mealPlan) {
        if (mealPlan.isValid()) {
            System.out.println("Generated meal plan: " + mealPlan.getPlanName());
        } else {
            System.out.println("Invalid meal plan: " + mealPlan.getPlanName());
        }
    }
}
public class PersonalizedMealPlanDemo {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal("Paneer Curry"));
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal("Vegan Salad"));
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal("Keto Chicken"));
        Meal<HighProteinMeal> proteinMeal = new Meal<>(new HighProteinMeal("Protein Shake"));
        List<Meal<? extends MealPlan>> catalog = new ArrayList<>();
        catalog.add(vegMeal);
        catalog.add(veganMeal);
        catalog.add(ketoMeal);
        catalog.add(proteinMeal);
        System.out.println("Meal Catalog:");
        for (Meal<? extends MealPlan> m : catalog) {
            System.out.println("- " + m);
            MealPlanGenerator.generatePlan(m.getMealPlan());
        }
    }
}

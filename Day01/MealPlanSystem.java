interface MealPlan {
    String getMealDetails();
}
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: Includes vegetables, grains, and dairy.";
    }
}
class VeganMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegan Meal: Includes plant-based foods only, no animal products.";
    }
}
class KetoMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Keto Meal: Low-carb, high-fat diet with proteins and healthy fats.";
    }
}
class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "High-Protein Meal: Rich in lean meats, eggs, and legumes.";
    }
}
// Generic class 
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }
    public void displayMeal() {
        System.out.println(meal.getMealDetails());
    }
}
// Utility 
class MealPlanGenerator {
    // Private constructor to prevent instantiation
    private MealPlanGenerator() {}

    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        System.out.println("Generating meal plan...");
        return new Meal<>(meal);
    }
}
// Utility class for additional helper methods
class MealPlanUtils {
    // Private constructor to prevent instantiation
    private MealPlanUtils() {}

    public static void listAvailableMealPlans() {
        System.out.println("Available Meal Plans:");
        System.out.println("1. Vegetarian Meal");
        System.out.println("2. Vegan Meal");
        System.out.println("3. Keto Meal");
        System.out.println("4. High-Protein Meal");
    }
}
public class MealPlanSystem {
    public static void main(String[] args) {
        // Display available meal plans
        MealPlanUtils.listAvailableMealPlans();

        // Generate different meal plans dynamically
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        // Display meal details
        vegetarianMeal.displayMeal();
        veganMeal.displayMeal();
        ketoMeal.displayMeal();
        highProteinMeal.displayMeal();
    }
}

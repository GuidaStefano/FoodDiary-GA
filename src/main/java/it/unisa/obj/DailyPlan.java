package it.unisa.obj;

import java.util.HashMap;
import java.util.Map;

public class DailyPlan {

    private Map<MealOfDay, Meal> meals;
    private double fitness;

    public DailyPlan(Map<MealOfDay, Meal> meals) {
        this.meals = meals;
    }

    public DailyPlan() {
        this(new HashMap<>());
    }

    public static DailyPlan generate(int targetCalories) {
        DailyPlan plan = new DailyPlan();

        for (MealOfDay m : MealOfDay.values()) {
            Meal meal = switch (m) {
                case BREAKFAST -> Meal.generate(targetCalories / 100 * 20);
                case LUNCH -> Meal.generate(targetCalories / 100 * 35);
                case SNACK -> Meal.generate(targetCalories / 100 * 15);
                case DINNER -> Meal.generate(targetCalories / 100 * 30);
            };

            plan.meals.put(m, meal);
        }

        return plan;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getCalories() {
        return meals.values().stream().mapToInt(Meal::getCalories).sum();
    }

    public double getTotalFat() {
        return meals.values().stream().mapToDouble(Meal::getTotalFat).sum();
    }

    public double getProtein() {
        return meals.values().stream().mapToDouble(Meal::getProtein).sum();
    }

    public double getCarbohydrate() {
        return meals.values().stream().mapToDouble(Meal::getCarbohydrate).sum();
    }

    public Map<MealOfDay, Meal> getMeals() {
        return meals;
    }

    public void setMeals(Map<MealOfDay, Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "DailyPlan{" +
                "meals=" + meals +
                '}';
    }
}

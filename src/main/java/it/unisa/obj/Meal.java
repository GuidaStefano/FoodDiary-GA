package it.unisa.obj;

import it.unisa.loader.FoodLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static it.unisa.util.CollectionUtil.getRandomElement;

public class Meal {

    private Map<Food, Integer> foods;

    public Meal(Map<Food, Integer> foods) {
        this.foods = foods;
    }

    public Meal() {
        this(new HashMap<>());
    }

    public static Meal generate(int targetCalories) {
        Meal meal = new Meal();
        Random random = new Random();

        int offset = 50 + random.nextInt(100);
        while (meal.getCalories() < targetCalories - offset) {
            Food food = getRandomElement(FoodLoader.ALL_FOODS);

            int amount;
            if (food.getCalories() > 450) { // cibi altamente calorici
                amount = 5 + random.nextInt(20); // intero tra 20 e 25
            } else {
                amount = 60 + random.nextInt(120); // intero tra 60 e 180
            }

            meal.foods.put(food, amount);
        }

        return meal;
    }

    public int getCalories() {
        int calories = 0;
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            Food food = entry.getKey();
            int amount = entry.getValue();

            calories += food.getCalories() * amount / 100;
        }

        return calories;
    }

    public float getTotalFat() {
        float totalFat = 0;
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            Food food = entry.getKey();
            int amount = entry.getValue();

            totalFat += food.getTotalFat() * amount / 100;
        }

        return totalFat;
    }

    public float getProtein() {
        float protein = 0;
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            Food food = entry.getKey();
            int amount = entry.getValue();

            protein += food.getProtein() * amount / 100;
        }

        return protein;
    }

    public float getCarbohydrate() {
        float carbohydrate = 0;
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            Food food = entry.getKey();
            int amount = entry.getValue();

            carbohydrate += food.getCarbohydrate() * amount / 100;
        }

        return carbohydrate;
    }

    public Map<Food, Integer> getFoods() {
        return foods;
    }

    public void setFoods(Map<Food, Integer> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "calories=" + getCalories() +
                ", carbohydrate=" + getCarbohydrate() +
                ", protein=" + getProtein() +
                ", fat=" + getTotalFat() +
                '}';
    }
}

package it.unisa.obj;

public class TargetParams {

    private int targetCalories;
    private float targetCarbohydrate;
    private float targetProtein;
    private float targetFat;

    public TargetParams(int targetCalories, float targetCarbohydrate, float targetProtein, float targetFat) {
        this.targetCalories = targetCalories;
        this.targetCarbohydrate = targetCarbohydrate;
        this.targetProtein = targetProtein;
        this.targetFat = targetFat;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public void setTargetCalories(int targetCalories) {
        this.targetCalories = targetCalories;
    }

    public float getTargetCarbohydrate() {
        return targetCarbohydrate;
    }

    public void setTargetCarbohydrate(float targetCarbohydrate) {
        this.targetCarbohydrate = targetCarbohydrate;
    }

    public float getTargetProtein() {
        return targetProtein;
    }

    public void setTargetProtein(float targetProtein) {
        this.targetProtein = targetProtein;
    }

    public float getTargetFat() {
        return targetFat;
    }

    public void setTargetFat(float targetFat) {
        this.targetFat = targetFat;
    }
}

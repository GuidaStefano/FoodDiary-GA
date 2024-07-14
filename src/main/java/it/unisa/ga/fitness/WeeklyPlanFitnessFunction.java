package it.unisa.ga.fitness;

import it.unisa.obj.DailyPlan;
import it.unisa.obj.TargetParams;
import it.unisa.obj.WeeklyPlan;

public class WeeklyPlanFitnessFunction extends FitnessFunction<WeeklyPlan> {

    private final TargetParams targetParams;
    private final double acceptedVariation; // valore tra 0 e 1

    public WeeklyPlanFitnessFunction(TargetParams targetParams, double acceptedVariation) {
        super(true);
        this.targetParams = targetParams;
        this.acceptedVariation = acceptedVariation;
    }

    @Override
    public void evaluate(WeeklyPlan individual) {
        double fitness = 0;
        for (DailyPlan dailyPlan : individual.getPlan().values())
            fitness += evaluateDaily(dailyPlan);

        individual.setFitness(fitness);
    }

    private double evaluateDaily(DailyPlan dailyPlan) {
        double fitness = evaluateDailyCalories(dailyPlan) + evaluateDailyCarbohydrate(dailyPlan)
                + evaluateDailyProtein(dailyPlan) + evaluateDailyFat(dailyPlan);
        dailyPlan.setFitness(fitness);
        return fitness;
    }

    private double evaluateDailyCalories(DailyPlan dailyPlan) {
        double lowerBound = targetParams.getTargetCalories() * (1 - acceptedVariation / 2);
        double upperBound = targetParams.getTargetCalories() * (1 + acceptedVariation / 2);
        double minimumBound = targetParams.getTargetCalories() * (1 - acceptedVariation);
        double maximumBound = targetParams.getTargetCalories() * (1 + acceptedVariation);

        int calories = dailyPlan.getCalories();

        if (lowerBound <= calories && calories <= upperBound)
            return 2;
        else if ((minimumBound <= calories && calories < lowerBound)
                || (upperBound < calories && calories <= maximumBound))
            return 0;
        else
            return -2;
    }

    private double evaluateDailyCarbohydrate(DailyPlan dailyPlan) {
        double lowerBound = targetParams.getTargetCarbohydrate() * (1 - acceptedVariation / 2);
        double upperBound = targetParams.getTargetCarbohydrate() * (1 + acceptedVariation / 2);
        double minimumBound = targetParams.getTargetCarbohydrate() * (1 - acceptedVariation);
        double maximumBound = targetParams.getTargetCarbohydrate() * (1 + acceptedVariation);

        double carbohydrate = dailyPlan.getCarbohydrate();

        if (lowerBound <= carbohydrate && carbohydrate <= upperBound)
            return 2;
        else if ((minimumBound <= carbohydrate && carbohydrate < lowerBound)
                || (upperBound < carbohydrate && carbohydrate <= maximumBound))
            return 0;
        else
            return -2;
    }

    private double evaluateDailyProtein(DailyPlan dailyPlan) {
        double lowerBound = targetParams.getTargetProtein() * (1 - acceptedVariation / 2);
        double upperBound = targetParams.getTargetProtein() * (1 + acceptedVariation / 2);
        double minimumBound = targetParams.getTargetProtein() * (1 - acceptedVariation);
        double maximumBound = targetParams.getTargetProtein() * (1 + acceptedVariation);

        double protein = dailyPlan.getProtein();

        if (lowerBound <= protein && protein <= upperBound)
            return 2;
        else if ((minimumBound <= protein && protein < lowerBound)
                || (upperBound < protein && protein <= maximumBound))
            return 0;
        else
            return -2;
    }

    private double evaluateDailyFat(DailyPlan dailyPlan) {
        double lowerBound = targetParams.getTargetFat() * (1 - acceptedVariation / 2);
        double upperBound = targetParams.getTargetFat() * (1 + acceptedVariation / 2);
        double minimumBound = targetParams.getTargetFat() * (1 - acceptedVariation);
        double maximumBound = targetParams.getTargetFat() * (1 + acceptedVariation);

        double fat = dailyPlan.getTotalFat();

        if (lowerBound <= fat && fat <= upperBound)
            return 2;
        else if ((minimumBound <= fat && fat < lowerBound)
                || (upperBound < fat && fat <= maximumBound))
            return 0;
        else
            return -2;
    }

}

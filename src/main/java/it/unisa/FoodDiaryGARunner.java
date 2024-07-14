package it.unisa;

import it.unisa.ga.fitness.WeeklyPlanFitnessFunction;
import it.unisa.ga.initializers.WeeklyPlanInitializer;
import it.unisa.ga.metaheuristics.SimpleGeneticAlgorithm;
import it.unisa.ga.operators.crossover.WeeklyPlanSinglePointCrossover;
import it.unisa.ga.operators.mutation.WeeklyPlanRandomResettingMutation;
import it.unisa.ga.operators.selection.RouletteWheelSelection;
import it.unisa.ga.results.Results;
import it.unisa.loader.FoodLoader;
import it.unisa.obj.TargetParams;
import it.unisa.obj.WeeklyPlan;

public class FoodDiaryGARunner {

    public static void main(String[] args) throws CloneNotSupportedException {
        final int numberOfIndividuals = 100;
        final double mutationProbability = 0.3;
        final int maxIterations = 3000;
        final int maxIterationNoImprovements = 600;

        FoodLoader.init();

        TargetParams targetParams = new TargetParams(1900, 165, 160, 60);
        double acceptedVariation = 0.25;

        WeeklyPlanFitnessFunction fitnessFunction = new WeeklyPlanFitnessFunction(targetParams, acceptedVariation);
        WeeklyPlanInitializer initializer = new WeeklyPlanInitializer(numberOfIndividuals, targetParams);

        RouletteWheelSelection<WeeklyPlan> selectionOperator = new RouletteWheelSelection<>();


        WeeklyPlanRandomResettingMutation mutationOperator = new WeeklyPlanRandomResettingMutation(targetParams);
        WeeklyPlanSinglePointCrossover crossoverOperator = new WeeklyPlanSinglePointCrossover();


        SimpleGeneticAlgorithm<WeeklyPlan> geneticAlgorithm = new SimpleGeneticAlgorithm<>(fitnessFunction, initializer, selectionOperator, crossoverOperator,
                mutationOperator, mutationProbability, maxIterations, maxIterationNoImprovements);

        Results<WeeklyPlan> results = geneticAlgorithm.run();
        WeeklyPlan bestWeeklyPlan = results.getBestIndividual();
        results.getLog().forEach(System.out::println);
        System.out.printf("Ricerca terminata in %d/%d iterazioni.%n", results.getNumberOfIterations(), geneticAlgorithm.getMaxIterations());

        bestWeeklyPlan.getPlan().forEach(((dayOfWeek, dailyPlan) -> {
            System.out.printf("%s : %d calorie (C: %.2f - P: %.2f - F: %.2f)\n", dayOfWeek,
                    dailyPlan.getCalories(), dailyPlan.getCarbohydrate(), dailyPlan.getProtein(), dailyPlan.getTotalFat());
        }));
    }
}

package it.unisa.ga.initializers;

import it.unisa.ga.populations.FixedSizePopulation;
import it.unisa.ga.populations.Population;
import it.unisa.obj.TargetParams;
import it.unisa.obj.WeeklyPlan;

public class WeeklyPlanInitializer extends Initializer<WeeklyPlan> {

    private final int numberOfIndividuals;
    private final TargetParams targetParams;

    public WeeklyPlanInitializer(int numberOfIndividuals, TargetParams targetParams) {
        this.numberOfIndividuals = Math.max(numberOfIndividuals, 1);
        this.targetParams = targetParams;
    }

    @Override
    public Population<WeeklyPlan> initialize() {
        FixedSizePopulation<WeeklyPlan> population = new FixedSizePopulation<>(0, numberOfIndividuals);
        for(int i = 0; i < numberOfIndividuals; i++){
            WeeklyPlan individual = WeeklyPlan.generate(targetParams);
            population.add(individual);
        }

        return population;
    }

}

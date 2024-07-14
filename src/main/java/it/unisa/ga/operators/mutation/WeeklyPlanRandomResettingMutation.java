package it.unisa.ga.operators.mutation;

import it.unisa.obj.DailyPlan;
import it.unisa.obj.TargetParams;
import it.unisa.obj.WeeklyPlan;

import java.time.DayOfWeek;
import java.util.Random;

public class WeeklyPlanRandomResettingMutation extends RandomResettingMutation<WeeklyPlan> {

    private final TargetParams targetParams;

    public WeeklyPlanRandomResettingMutation(TargetParams targetParams) {
        this.targetParams = targetParams;
    }

    @Override
    protected WeeklyPlan mutate(WeeklyPlan individual, Random rand) throws CloneNotSupportedException {
        DayOfWeek dayToMutate = DayOfWeek.of(rand.nextInt(7) + 1);
        double min = Double.MAX_VALUE;
        for (DayOfWeek d : DayOfWeek.values()) {
            double f = individual.getPlan().get(d).getFitness();
            if (f < min) {
                min = f;
                dayToMutate = d;
            }
        }

        individual.getPlan().put(dayToMutate, DailyPlan.generate(targetParams.getTargetCalories()));

        return individual;
    }

}

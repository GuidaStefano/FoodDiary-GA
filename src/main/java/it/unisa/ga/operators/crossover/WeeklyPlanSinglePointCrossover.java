package it.unisa.ga.operators.crossover;

import it.unisa.ga.populations.Population;
import it.unisa.obj.DailyPlan;
import it.unisa.obj.WeeklyPlan;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Random;

public class WeeklyPlanSinglePointCrossover extends CrossoverOperator<WeeklyPlan> {

    @Override
    public Population<WeeklyPlan> apply(Population<WeeklyPlan> population, Random rand) {
        Population<WeeklyPlan> offsprings = population.clone();
        offsprings.setId(population.getId() + 1);
        offsprings.clear();

        //Effettua il crossover
        List<Pairing> pairings = makeRandomPairings(population);
        for (Pairing pairing : pairings){
            WeeklyPlan first = pairing.firstParent;
            WeeklyPlan second = pairing.secondParent;

            int cutPoint = rand.nextInt(7) + 1;

            for (int i = cutPoint; i <= 7; i++) {
                DayOfWeek dayOfWeek = DayOfWeek.of(i);
                DailyPlan firstDailyPlan = first.getPlan().get(dayOfWeek);
                DailyPlan secondDailyPlan = second.getPlan().get(dayOfWeek);

                first.getPlan().put(dayOfWeek, secondDailyPlan);
                second.getPlan().put(dayOfWeek, firstDailyPlan);

                offsprings.add(first);
                offsprings.add(second);
            }

        }

        return offsprings;
    }
}

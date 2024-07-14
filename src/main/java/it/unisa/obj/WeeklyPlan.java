package it.unisa.obj;

import it.unisa.ga.individuals.Individual;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class WeeklyPlan extends Individual {

    private Map<DayOfWeek, DailyPlan> plan;

    public WeeklyPlan(Map<DayOfWeek, DailyPlan> plan) {
        this.plan = plan;
    }

    public WeeklyPlan() {
        this(new HashMap<>());
    }

    public static WeeklyPlan generate(TargetParams targetParams) {
        WeeklyPlan weeklyPlan = new WeeklyPlan();
        for (DayOfWeek day : DayOfWeek.values()) {
            DailyPlan dailyPlan = DailyPlan.generate(targetParams.getTargetCalories());
            weeklyPlan.plan.put(day, dailyPlan);
        }

        return weeklyPlan;
    }

    public Map<DayOfWeek, DailyPlan> getPlan() {
        return plan;
    }

    public void setPlan(Map<DayOfWeek, DailyPlan> plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "WeeklyPlan{" +
                "plan=" + plan +
                '}';
    }
}

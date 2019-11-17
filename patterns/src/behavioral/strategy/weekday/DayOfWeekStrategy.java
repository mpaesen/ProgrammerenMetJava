package behavioral.strategy.weekday;


public class DayOfWeekStrategy {
    private CalculateDayOfWeek strategy;


    public DayOfWeekStrategy() {

        this.strategy = new DefaultDayOfWeek();
    }

    public CalculateDayOfWeek getStrategy() {
        return strategy;
    }

    public void setStrategy(CalculateDayOfWeek strategy) {
        this.strategy = strategy;
    }
}

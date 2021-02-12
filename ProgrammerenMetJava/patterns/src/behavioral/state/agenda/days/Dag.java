package behavioral.state.agenda.days;

public abstract class Dag {
    private String weekDay;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "\nDay " + getWeekDay();
    }

    public abstract String weekDayBehavior();
}

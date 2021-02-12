package behavioral.state.agenda.days;

public class Friday extends Dag {

    public Friday() {
        // TODO Auto-generated constructor stub
        setWeekDay("Friday");
    }

    @Override
    public String weekDayBehavior() {
        // TODO Auto-generated method stub
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n\tAt 8h: ");
        buffer.append("Projectmeeting");

        buffer.append("\n\tAt 12h: ");
        buffer.append("lunch");
        buffer.append("\n\tAt 13h: ");
        buffer.append("Go To Airport");
        buffer.append("\n\tAt 16h: ");
        buffer.append("Fly back home");
        return buffer.toString();
    }

    @Override
    public String toString() {
        return super.toString() + weekDayBehavior();
    }

}

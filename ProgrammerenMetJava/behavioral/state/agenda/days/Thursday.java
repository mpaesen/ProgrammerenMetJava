package behavioral.state.agenda.days;

public class Thursday extends Dag {

	public Thursday() {
		// TODO Auto-generated constructor stub
		setWeekDay("Thursday");
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
		buffer.append("Planning meeting");
		buffer.append("\n\tAt 19h: ");
		buffer.append("Dinner");
		buffer.append("\n\tAt 21h: ");
		buffer.append("Go To hotel");
		return buffer.toString();
	}
	@Override
	public String toString(){
		return super.toString()+weekDayBehavior();
	}

}

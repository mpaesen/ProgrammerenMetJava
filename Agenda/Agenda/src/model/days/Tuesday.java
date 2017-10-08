package model.days;

public class Tuesday extends Dag {

	public Tuesday() {
		// TODO Auto-generated constructor stub
		setWeekDay("Tuesday");
	}

	@Override
	public String weekDayBehavior() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\tAt 8h: ");
		buffer.append("dentist");
		buffer.append("\n\tAt 10h: ");
		buffer.append("taxi to office");
		buffer.append("\n\tAt 12h: ");
		buffer.append("lunch");
		buffer.append("\n\tAt 14h: ");
		buffer.append("appointment with CEO");
		buffer.append("\n\tAt 16h: ");
		buffer.append("Team meeting");
		buffer.append("\n\tAt 18h: ");
		buffer.append("Go Home");
		buffer.append("\n\tAt 20h: ");
		buffer.append("Squash");
		return buffer.toString();
	}
	@Override
	public String toString(){
		return super.toString()+weekDayBehavior();
	}

}

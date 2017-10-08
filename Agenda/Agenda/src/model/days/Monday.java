package model.days;

public class Monday extends Dag {

	public Monday() {
		// TODO Auto-generated constructor stub
		setWeekDay("Monday");
	}

	@Override
	public String weekDayBehavior() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\tVacation!!!!");
		return buffer.toString();
	}
	@Override
	public String toString(){
		return super.toString()+weekDayBehavior();
	}

}

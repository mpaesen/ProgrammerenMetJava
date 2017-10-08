package model.days;

public class Sunday extends Dag {

	public Sunday() {
		// TODO Auto-generated constructor stub
		setWeekDay("Sunday");
	}

	@Override
	public String weekDayBehavior() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\tAt 8h: ");
		buffer.append("Hire Sailing boat");
		buffer.append("\n\tAt 18h: ");
		buffer.append("Drive home");
		
		return buffer.toString();
	}
	@Override
	public String toString(){
		return super.toString()+weekDayBehavior();
	}

}

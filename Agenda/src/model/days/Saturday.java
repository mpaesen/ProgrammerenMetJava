package model.days;

public class Saturday extends Dag {

	public Saturday() {
		// TODO Auto-generated constructor stub
		setWeekDay("Saturday");
	}

	@Override
	public String weekDayBehavior() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\tAt 8h: ");
		buffer.append("Drive to coast");

		buffer.append("\n\tAt 10h: ");
		buffer.append("Arrive at Knokke");
		buffer.append("\n\tAt 11h-18h: ");
		buffer.append("Do shopping with wife (boring)");
		
		
		return buffer.toString();
	}
	@Override
	public String toString(){
		return super.toString()+weekDayBehavior();
	}

}

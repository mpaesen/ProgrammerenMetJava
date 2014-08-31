package model.days;

public class Wednesday extends Dag {

	public Wednesday() {
		// TODO Auto-generated constructor stub
		setWeekDay("Wednesday");
	}

	@Override
	public String weekDayBehavior() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\tAt 7h: arrive at airport");
		buffer.append("\n\tTravel to HQ");
		buffer.append("\n\tAt 18h: arrival at HQ");
		buffer.append("\n\tAt 19h: Lunch with customer");
		return buffer.toString();
	}
	@Override
	public String toString(){
		return super.toString()+weekDayBehavior();
	}

}

package ch3;
public class Zoo{
	public static int getTicketPrice(int dayOfWeek, int age, boolean isAHoliday){
		int retValue = 0;
		switch(dayOfWeek){
			case 0:
				retValue = 15;
				break;			
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				retValue = 10;
				break;
			case 6:
				retValue = 15;
				break;
			default:
				break;
		}
			
		if (age >= 65)
			retValue -= 2;
		else if (age <= 4)
			retValue = 0;
		else if ((age >= 5) && (age <= 10)) 
			retValue--;

		if((isAHoliday)&&(retValue > 9))
			retValue = 9;			
		return retValue;
	}
	
	
	public static void testTicketPrice(int dayOfWeek, int age, boolean isAHoliday){
		System.out.println("Ticke price for day " + dayOfWeek +" is "+ getTicketPrice(dayOfWeek, age, true));
		
	}
	
	public static void main(String [] args){
		int day =0;
		testTicketPrice(day++, 70, true);
		testTicketPrice(day++, 30, true);
		testTicketPrice(day++, 1, true);
		testTicketPrice(day++, 9, true);
		testTicketPrice(day++, 65, true);
		testTicketPrice(day++, 4, true);
		testTicketPrice(day++, 35, true);
		}
}
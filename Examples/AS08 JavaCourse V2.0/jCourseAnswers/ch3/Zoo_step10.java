public class Zoo
{
    public static int getTicketPrice(int dayOfWeek, int age, boolean isAHoliday)
    {
        int retValue = 15;
        if (age <= 4)
          retValue = 0;
        else if (dayOfWeek >= 1 && dayOfWeek <= 5)
          retValue = 10;
        if (age >= 65)
          retValue -= 2;
        else if (age > 4 && age <= 10)
          retValue--;
        if (isAHoliday)
          retValue = Math.min(retValue, 9);
        return retValue;
    }

    public static void testTicketPrice(int dayOfWeek, int age, boolean isAHoliday)
    {
        System.out.println("Ticket price for day " + dayOfWeek + " is " + getTicketPrice(dayOfWeek,age,isAHoliday));
    }
    public static void main(String args[])
    {
        testTicketPrice(0,70,true);
        testTicketPrice(1,30,true);
        testTicketPrice(2,1,true);
        testTicketPrice(3,9,true);
        testTicketPrice(4,65,true);
        testTicketPrice(5,4,true);
        testTicketPrice(6,35,true);
    }
}
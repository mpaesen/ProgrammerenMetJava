public class Zoo
{
    public static int getTicketPrice(int dayOfWeek, int age)
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
        return retValue;
    }

    public static void testTicketPrice(int dayOfWeek, int age)
    {
        System.out.println("Ticket price for day " + dayOfWeek + " is " + getTicketPrice(dayOfWeek,age));
    }
    public static void main(String args[])
    {
        testTicketPrice(0,70);
        testTicketPrice(1,30);
        testTicketPrice(2,1);
        testTicketPrice(3,9);
        testTicketPrice(4,65);
        testTicketPrice(5,4);
        testTicketPrice(6,35);
    }
}
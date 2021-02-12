public class Zoo
{
    public static int getTicketPrice(int dayOfWeek)
    {
        int retValue = 15;
        if (dayOfWeek >= 1 && dayOfWeek <= 5)
          retValue = 10;
        return retValue;
    }
    public static void testTicketPrice(int dayOfWeek)
    {
        System.out.println("Ticket price for day " + dayOfWeek + " is " + getTicketPrice(dayOfWeek));
    }
    public static void main(String args[])
    {
        testTicketPrice(0);
        testTicketPrice(1);
        testTicketPrice(2);
        testTicketPrice(3);
        testTicketPrice(4);
        testTicketPrice(5);
        testTicketPrice(6);
    }
}
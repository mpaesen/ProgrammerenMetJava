public class DateTimeThings
{
    private long startTime;
    private long endTime;

    public void startTiming()
    {
        startTime = System.currentTimeMillis();
    }

    public void endTiming()
    {
        endTime = System.currentTimeMillis();
    }

    public String displayElapsedTime()
    {
        String retString;
        long   elapsed = (endTime - startTime);
        long   seconds = elapsed / 1000;
        long   milli   = elapsed % 1000;
        retString = new String("seconds="+seconds+",milliseconds="+milli);
        return retString;
    }

    public static void main(String args[])
    {
        DateTimeThings me  = new DateTimeThings();
        String blankString = new String();
        StringBuffer blankStringBuffer = new StringBuffer();
        int iters = 100000;
        me.startTiming();
        for (int idx=0; idx<iters; idx++)
           blankString.concat(" ");
        me.endTiming();
        System.out.println();
        System.out.println("Timing test 1: " + me.displayElapsedTime());
        me.startTiming();
        blankStringBuffer.ensureCapacity(iters);
        for (int idx=0; idx<iters; idx++)
           blankStringBuffer.append(' ');
        me.endTiming();
        System.out.println("Timing test 2: " + me.displayElapsedTime());
    }
}

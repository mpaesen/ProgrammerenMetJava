public class WorkWithNumbers
{
    private int count=0;
    private int sum=0;

    public int getCount()
    {
        return count;
    }

    public int getSum()
    {
        return sum;
    }

    public static void main(String args[])
    {
        WorkWithNumbers me = new WorkWithNumbers();
        System.out.println("total numbers: " + me.getCount());
        System.out.println("total sum: " + me.getSum());
        int average = me.getCount() > 0 ? me.getSum()/me.getCount() : 0;
        System.out.println("average number: " + average);
    } // end main

} // end of class WorkWithNumbers
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

    public void initWithFor()
    {
        for (int currNbr=0; currNbr!=-9999;)
        {
           currNbr = ReadIntegers.readNextInteger();
           if (currNbr != -9999)
             {
              sum += currNbr;
              count++;
             }
        }
    } // end of initWithFor method

    public void initWithWhile()
    {
        int currNbr = 0;
        while (currNbr!=-9999)
        {
           currNbr = ReadIntegers.readNextInteger();
           if (currNbr != -9999)
             {
              sum += currNbr;
              count++;
             }
        }
    } // end of initWithWhile method

    public static void main(String args[])
    {
        WorkWithNumbers me = new WorkWithNumbers();
        //me.initWithFor();
        me.initWithWhile();
        System.out.println("total numbers: " + me.getCount());
        System.out.println("total sum: " + me.getSum());
        int average = me.getCount() > 0 ? me.getSum()/me.getCount() : 0;
        System.out.println("average number: " + average);
    } // end main

} // end of class WorkWithNumbers
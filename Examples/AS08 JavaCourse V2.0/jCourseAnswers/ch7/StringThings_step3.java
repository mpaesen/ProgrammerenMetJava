
public class StringThings
{

    public static String center(String oldString, int width)
    {
        String trimmedString = oldString.trim();
        int len = trimmedString.length();
        if (len >= width)
          return trimmedString;
        StringBuffer retString = new StringBuffer(width);
        int delta = width - len;
        int left = delta / 2;
        int right = delta - left;
        for (int idx=0; idx<left; idx++)
        {
           retString.append(' ');
        }
        retString.append(trimmedString);
        for (int idx=0; idx<right; idx++)
        {
           retString.append(' ');
        }
        return retString.toString();
    } // end method center

    public static void main(String args[])
    {
        String inString, outString;
        inString = " hello ";
        outString = center(inString,10);
        System.out.println("input: '" + inString + "', output: '" + outString + "'");
        outString = center(inString,11);
        System.out.println("input: '" + inString + "', output: '" + outString + "'");
        outString = center(inString,12);
        System.out.println("input: '" + inString + "', output: '" + outString + "'");
    }

} // end class StringThings

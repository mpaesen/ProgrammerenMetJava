
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

    public static String propogate(char propChar, int width)
    {
        StringBuffer retString = new StringBuffer(width);
        for (int idx=0; idx<width; idx++)
        {
           retString.append(propChar);
        }
        return retString.toString();
    }

    public static void getLibAndObj(String fullname, StringBuffer lib, StringBuffer obj)
    {
        int index = fullname.indexOf('/');
        lib.setLength(0);
        obj.setLength(0);
        if (index != -1)
          {
             lib.append(fullname.substring(0,index));
             obj.append(fullname.substring(index+1));
          }
        else
          {
             lib.append("*LIBL");
             obj.append(fullname);
          }
    }

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
        String line = propogate('-',12);
        String fullname="MYLIB/MYOBJ";
        StringBuffer lib = new StringBuffer();
        StringBuffer obj = new StringBuffer();
        getLibAndObj(fullname,lib,obj);
        System.out.println("full="+fullname+",lib="+lib+",obj="+obj);
        fullname = "MYOBJ";
        getLibAndObj(fullname,lib,obj);
        System.out.println("full="+fullname+",lib="+lib+",obj="+obj);
    }

} // end class StringThings

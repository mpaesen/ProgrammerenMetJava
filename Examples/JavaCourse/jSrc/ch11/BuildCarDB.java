package jSrc.ch11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BuildCarDB
{
    private String filename;
    public static final String makes[] = {"Ford","GM","Chrysler","Toyota","Nissan","Honda","Volkswagen"};
    public static final String classes[] = {"Economy","Midsize","Luxury"};
    public static final String colors[] = {"Blue","Red","Green","Purple","Pearl","Grey","Silver","White","Black"};

    public BuildCarDB(String filename)
    {
        this.filename = filename;
    }

    public void populate(int count)
    {
        PrintWriter outFileStream = null;
        File outFile = new File(filename);
        try {
           outFileStream = new PrintWriter(new FileOutputStream(outFile));
        }
        catch (IOException exc)
        {
          System.out.println(exc.getMessage());
          return;
        }
        String theMake;
        String thePlate;
        String theClass;
        String theColor;
        Random random = new Random();
        int    nextRandom;
        for (int idx=0; idx<count; idx++)
        {
           nextRandom = Math.abs(random.nextInt());
           thePlate = makeXXDigits(nextRandom,6);
           theMake = makes[nextRandom % makes.length];
           theClass= classes[nextRandom % classes.length];
           theColor= colors[nextRandom % colors.length];
           outFileStream.println(thePlate + " " + theClass + " " + theMake + " " + theColor);
        }
        outFileStream.flush();
        outFileStream.close();
    }

    public String makeXXDigits(int value, int digits)
    {
        Integer intobj = new Integer(value);
        String  intString = intobj.toString();
        int     len = intString.length();
        if (len > digits)
          intString = intString.substring(0,digits);
        else if (len < digits)
          {
            int delta = digits - len;
            for (int idx=0; idx<delta; idx++)
               intString += "0";
          }
        return intString;
    } // end makeXXDigits

    public static void main(String arg[])
    {
        BuildCarDB me = new BuildCarDB("cars.dat");
        me.populate(2000);
    }
}

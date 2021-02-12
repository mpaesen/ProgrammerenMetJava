package jSrc.ch12a;

import jSrc.ch12a.cars.Car;
import jSrc.ch12a.cars.CarLot;
import jSrc.ch12a.dates.DateDelta;

import java.io.*;
import java.util.StringTokenizer;

public class RentalMethods implements Runnable
{
    private static final String CAR_FILE = "cars.dat";
    private CarLot carlot;
    private Thread thread;
    private boolean stopThread = false;

    public RentalMethods()
    {
        carlot = new CarLot(1000); // initial guess at capacity
    }

    public void populateLot()
    {
        stopThread = false;
        thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        populateLotFromFile();
    }

    public boolean populateLotFromFile()
    {
        if (stopThread)
          return false;
        File inFile = new File(CAR_FILE);
        BufferedReader inFileStream = null;
        try
        {
           inFileStream = new BufferedReader(new InputStreamReader (new FileInputStream(inFile) ) );
        }
        catch (Exception exc)
        {
           System.out.println("error opening file " + CAR_FILE + ": " + exc.getMessage());
           return false;
        }
        carlot = new CarLot(1000); // initial guess at capacity
        String newLine = null;
        boolean done = false;
        Car nextcar = null;
        StringTokenizer tokens = null;
        String plate, classification, make, color;
        while (!done && !stopThread)
        {
           try
           {
             newLine = inFileStream.readLine();
           }
           catch (IOException exc)
           {
              newLine = null;
           }
           if (newLine != null)
             {
              tokens = new StringTokenizer(newLine);
              // word1: plate number
              // word2: classification
              // word3: make
              // word4: color
              plate = tokens.nextToken();
              classification = tokens.nextToken();
              make = tokens.nextToken();
              color = tokens.nextToken();
              carlot.addCarToLot(plate, classification, make, color);
             }
           else
             done = true;
        } // end while-loop
        try {
          inFileStream.close();
        } catch (IOException exc) {}
        return true;
    } // end populateLotFromFile

    public void waitOnThread()
    {
        if (thread.isAlive())
          {
             try {
               thread.join();
             }
             catch (InterruptedException exc) {}
          }
    } // end waitOnThread method

    public void stopThread()
    {
        if (thread.isAlive())
          stopThread = true;
    }

    public String rentCar(String classString, String colorString, String makeString)
    {
        waitOnThread();
        if (colorString.equals("*ANY"))
          colorString = null;
        if (makeString.equals("*ANY"))
          makeString = null;
        return carlot.rentACar(classString,colorString,makeString);
    }

    public DateDelta returnCar(String plate)
    {
        return carlot.returnACar(plate);
    }

    public String displayCarInfo(String plate)
    {
        return carlot.displayCarInfo(plate,false);
    }

    public String displayRentedCarInfo(String plate)
    {
        return carlot.displayCarInfo(plate,true);
    }

    public EnumerateRentedCars getRentedEnumeration()
    {
        return new EnumerateRentedCars(carlot);
    }

    public CarLot getCarLot()
    {
        return carlot;
    }
} // end RentalMethods class

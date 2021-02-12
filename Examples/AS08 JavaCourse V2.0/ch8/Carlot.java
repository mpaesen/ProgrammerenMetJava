package ch8;

import java.util.GregorianCalendar;
import java.util.Vector;

public class Carlot{
   private int [] carPlates;
   private char [] carStatus;
   private int maxCars;
   private Vector carRentalStart;
   private Vector carRentalEnd;

   public static final int PLATES_NOTSET = -999999;
   public static final char STATUS_RENTED = 'R', STATUS_NOTRENTED = 'A',STATUS_NOTSET = ' ';

   public Carlot(int maxCars){
      this.maxCars = maxCars;
      this.carPlates = new int[maxCars];
      this.carStatus = new char[maxCars];
      carRentalStart = new Vector(maxCars);
      carRentalEnd = new Vector(maxCars);
      for(int i =0; i<carPlates.length; i++){
            carPlates[i]=PLATES_NOTSET;
            carStatus[i]=STATUS_NOTSET;
         }
      }

   private int getAvailableSlot(){
         int retidx = -1;
         for(int i = 0; i<carStatus.length; i++){
               if(carStatus[i] == STATUS_NOTSET){
                  retidx = i;
                  break;
               }
            }
         return retidx;
      }

   private int getAvailableRental(){
         int retidx = -1;
         for(int i = 0; i<carStatus.length; i++){
               if((carStatus[i] == STATUS_NOTSET) || (carStatus[i] == STATUS_NOTRENTED)){
                  retidx = i;
                  break;
               }
            }
         return retidx;
      }

   public void addCarToLot(int plate){
         int nextSlot = getAvailableSlot();
         carPlates[nextSlot] = plate;
         carStatus[nextSlot] = STATUS_NOTRENTED;
         carRentalStart.addElement(null);
         carRentalEnd.addElement(null);
      }

   public int rentACar(){
         int nextRental = getAvailableRental();
         carStatus[nextRental] = STATUS_RENTED;
         carRentalStart.setElementAt(new GregorianCalendar(), nextRental);
         return carPlates[nextRental] ;
      }

   public boolean returnACar(int plate){
         int plateidx = -1;
         GregorianCalendar start, end;
         for(int i = 0; i<carPlates.length; i++){
               if(carPlates[i]== plate){
                  plateidx = i;
                  carStatus[plateidx] = STATUS_NOTRENTED;
                  carRentalEnd.setElementAt(new GregorianCalendar(), plateidx);
                  start = (GregorianCalendar)carRentalStart.elementAt(plateidx);
                  end = (GregorianCalendar)carRentalEnd.elementAt(plateidx);
                  DateDelta elapsed = new DateDelta(start, end);
                  System.out.println("Car rented for "+elapsed);
                  return true;
               }
            }
         return false;
      }

   public void displayRentedCars(){
         GregorianCalendar rentedDate;
         DatFmt date = new DatFmt();
         System.out.println("Rented cars:");
         for(int i = 0; i<carStatus.length; i++){
               if(carStatus[i] == STATUS_RENTED){
                     rentedDate = (GregorianCalendar)carRentalStart.elementAt(i);
                     System.out.println("Car plate: " + carPlates[i]);
                     System.out.println("\tRental Date: " + date.format(rentedDate.getTime()));
                  }
               }
            }
      }

package ch8;

import java.util.Vector;

public class CarlotVector{
   private Vector carPlates;
   private Vector carStatus;
   private int maxCars;

   public static final Integer PLATES_NOTSET = new Integer(-999999);
   public static final Character STATUS_RENTED = new Character('R'),
      STATUS_NOTRENTED = new Character('A'), STATUS_NOTSET = new Character(' ');

   public CarlotVector(int maxCars){
      this.maxCars = maxCars;
      this.carPlates = new Vector(maxCars);
      this.carStatus = new Vector(maxCars);
      for(int i =0; i<carPlates.size(); i++){
            carPlates.addElement(PLATES_NOTSET);
            carStatus.addElement(STATUS_NOTSET);
         }
      }

   private int getAvailableSlot(){
         return carStatus.indexOf(STATUS_NOTSET);
      }

   private int getAvailableRental(){
         return carStatus.indexOf(STATUS_NOTRENTED);
      }

   public void addCarToLot(int plate){
         int nextSlot = getAvailableSlot();
         carPlates.setElementAt(new Integer(plate), nextSlot);
         carStatus.setElementAt(STATUS_NOTRENTED, nextSlot);
      }

   public int rentACar(){
         int nextRental = getAvailableRental();
         Integer temp = new Integer(nextRental);
         carStatus.setElementAt(STATUS_RENTED, nextRental);
         return ((Integer)carPlates.elementAt(nextRental)).intValue() ;
      }

   public boolean returnACar(int plate){
         int idx = -1;
         idx = carPlates.indexOf(new Integer(plate));
         return false;
      }

   public void displayRentedCars(){
         System.out.println("Rented cars:");
         for(int i = 0; i<carStatus.size(); i++){
               if(carStatus.elementAt(i) == STATUS_RENTED)
                  System.out.println("Car plate: " + carPlates.elementAt(i));
               }
            }
      }

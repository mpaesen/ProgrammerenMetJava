package ch6;

import java.util.Vector;

public class CarlotVector{
   private Vector carPlates;
   private Vector carStatus;
   private int maxCars;

   public static final Character STATUS_RENTED = new Character('R'),
      STATUS_NOTRENTED = new Character('A');

   public CarlotVector(int maxCars){
      this.maxCars = maxCars;
      this.carPlates = new Vector(maxCars);
      this.carStatus = new Vector(maxCars);
      }

    private int getAvailableRental(){
         return carStatus.indexOf(STATUS_NOTRENTED);
      }

   public void addCarToLot(int plate){
         carPlates.addElement(new Integer(plate));
         carStatus.addElement(STATUS_NOTRENTED);
      }

   public int rentACar(){
         int nextRental = getAvailableRental();
         if (nextRental == -1)
            	return nextRental;
         Integer temp = new Integer(nextRental);
         carStatus.setElementAt(STATUS_RENTED, nextRental);
         return ((Integer)carPlates.elementAt(nextRental)).intValue() ;
      }

   public boolean returnACar(int plate){
         int idx = carPlates.indexOf(new Integer(plate));
         return idx != -1;
      }

   public void displayRentedCars(){
         System.out.println("Rented cars:");
         for(int i = 0; i<carStatus.size(); i++){
               if(carStatus.elementAt(i)== STATUS_RENTED)
                  System.out.println("Car plate: " + ((Integer)carPlates.elementAt(i)).intValue());
               }
            }
      }

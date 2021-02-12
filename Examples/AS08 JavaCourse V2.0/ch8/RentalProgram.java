package ch8;

public class RentalProgram{
      public static final char REQUEST_QUIT = 'Q',
         REQUEST_RENT = 'R', REQUEST_RETURN = 'A', REQUEST_DISPLAY = 'D';
      private Carlot carlot;

      public RentalProgram(){
         carlot = new Carlot(100);
         for(int i = 0 ; i<49; i++){
            carlot.addCarToLot(111111 + i);
            }
         }

      public void run(){
            Console console = new Console();
            int plate;
            char cmdChar = ' ';
            while(cmdChar != REQUEST_QUIT){
               cmdChar = Character.toUpperCase(console.readChar("What do you want to do? \n \'R\': Rent a car, \'A\': Return a car,\'D\': Display Rented cars, \'Q\': Quit"));
               switch(cmdChar){
                  case REQUEST_RENT:
                     plate = carlot.rentACar();
                     System.out.println(" Rent: Your rental car's plate numer is:" + plate);
                     break;
                  case REQUEST_RETURN:
                     plate = console.readInteger("What is the plate number?");
                     if(!carlot.returnACar(plate))
                        System.out.println(" Return: error, plate number not found or rented");
                     else
                        System.out.println(" Car returned successfully!");
                     break;
                  case REQUEST_DISPLAY:
                        carlot.displayRentedCars();
                        break;
                  case REQUEST_QUIT:
                        break;
                  default:
                        System.out.println("Unknown request. Try again.");
                        break;
                }//end switch
             System.out.println();
            }
             System.out.println("Bye");
         }

      public static void main(String []args){
         RentalProgram rentalProgram = new RentalProgram();
         rentalProgram.run();
         }
   }
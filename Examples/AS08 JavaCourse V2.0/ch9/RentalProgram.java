package ch9;

class RentalProgram {
    private static final char REQUEST_QUIT = 'Q';
    private static final char REQUEST_RENT = 'R';
    private static final char REQUEST_RETURN = 'A';
    private static final char REQUEST_DISPLAY = 'D';
    private CarLot carlot;

    public RentalProgram() {
        carlot = new CarLot(100);
        for (int idx = 0; idx < 50; idx++) {
            carlot.addCarToLot(111111 + idx);
        }
    }

    public void run() {
        Console console = new Console();
        int plate;
        char cmdChar = ' ';
        while (cmdChar != REQUEST_QUIT) {
            cmdChar = console.readChar("What do you want to do? ('R': rent a car, 'A': return a rented car, 'D': display rented cars, 'Q': quit)");
            cmdChar = Character.toUpperCase(cmdChar);
            switch (cmdChar) {
                case REQUEST_RENT:
                    plate = carlot.rentACar();
                    System.out.println(" Rent: Your rental car's plate number is: " + plate);
                    break;
                case REQUEST_RETURN:
                    plate = console.readInteger(" Return: What is the plate number?");
                    if (!carlot.returnACar(plate))
                        System.out.println(" Return: error, plate number not found or rented!");
                    else
                        System.out.println(" Car returned successfully.");
                    break;
                case REQUEST_DISPLAY:
                    carlot.displayRentedCars();
                    break;
                case REQUEST_QUIT:
                    break;
                default:
                    System.out.println("Unknown request. Try again.");
                    break;
            } // end switch
            System.out.println();
        } // end while loop
        System.out.println("Bye");
    } // end run

    public static void main(String args[]) {
        RentalProgram rp = new RentalProgram();
        rp.run();
    }
} // end class RentalProgram

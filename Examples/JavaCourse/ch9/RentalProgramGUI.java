package ch9;
import javax.swing.*;

public class RentalProgramGUI {
	public static final char REQUEST_QUIT = 'Q',
		REQUEST_RENT = 'R',
		REQUEST_RETURN = 'A',
		REQUEST_DISPLAY = 'D';
	private CarLot carlot;

	public RentalProgramGUI() {
		carlot = new CarLot(100);
		for (int i = 0; i < 49; i++) {
			carlot.addCarToLot(111111 + i);
		}
	}

	public void run() {

		int plate;
		char cmdChar = ' ';
		while (cmdChar != REQUEST_QUIT) {
			cmdChar =
				getChoice("What do you want to do? \n \'R\': Rent a car, \'A\': Return a car,\'D\': Display Rented cars, \'Q\': Quit");
			switch (cmdChar) {
				case REQUEST_RENT :
					plate = carlot.rentACar();
					JOptionPane.showMessageDialog(
						null,
						"Your rental car's plate numer is:" + plate,
						"Rent",
						JOptionPane.INFORMATION_MESSAGE);
					break;
				case REQUEST_RETURN :
					plate = getInteger("What is the plate number?");
					if (!carlot.returnACar(plate))
						JOptionPane.showMessageDialog(
							null,
							"Plate number not found or rented",
							"Error",
							JOptionPane.ERROR_MESSAGE);

					else
						JOptionPane.showMessageDialog(
							null,
							"Car "+plate+" returned successfully!",
							"Return",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				case REQUEST_DISPLAY :
					displayRentedCars(carlot);
					break;
				case REQUEST_QUIT :
					break;
				default :
					JOptionPane.showMessageDialog(
						null,
						"Unknown request. Try again.",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					break;
			} //end switch

		}
		JOptionPane.showMessageDialog(
			null,
			"Bye",
			"Exit",
			JOptionPane.INFORMATION_MESSAGE);

	}

	public static int getInteger(String instruction) {
		String stringValue;
		int intValue = 0;
		boolean isNumber = false;
		do {
			stringValue = JOptionPane.showInputDialog(instruction);
			try {
				intValue = Integer.parseInt(stringValue);
				isNumber = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
					null,
					"Give a number please!",
					"No Number!",
					JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!isNumber);
		return intValue;
	}
	public static char getChoice(String instruction) {
		String stringValue;
		char charValue = ' ';

		stringValue = JOptionPane.showInputDialog(instruction);
		if(stringValue.equals(""))
			stringValue="Unknown";
		charValue = Character.toUpperCase(stringValue.charAt(0));

		return charValue;
	}
	

	public void displayRentedCars(CarLot carlot) {
		//System.out.println("Rented cars:");
		StringBuffer rented = new StringBuffer(100);
		for (int idx = 0; idx < carlot.getCars().size(); idx++) {
			Car currCar = (Car)carlot.getCars().elementAt(idx);
			if (currCar.isRented())			
				rented.append("\n" + currCar);
			//System.out.println("Car plate: " + carPlates[i]);
		}
		JOptionPane.showMessageDialog(
			null,
			rented.toString(),
			"Rented cars",
			JOptionPane.INFORMATION_MESSAGE);
	}


	public static void main(String[] args) {
		RentalProgramGUI rentalProgram = new RentalProgramGUI();
		rentalProgram.run();
	}
}
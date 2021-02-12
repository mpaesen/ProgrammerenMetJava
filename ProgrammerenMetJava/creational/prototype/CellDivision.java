package creational.prototype;

/**
 * Shows how to use the clone.
 */
public class CellDivision {
	public static void main(String[] args) {
		PlantCell cell = new PlantCell();
		// create a clone
		PlantCell newPlantCell = 
			(PlantCell) cell.split();
	}

}// End of class
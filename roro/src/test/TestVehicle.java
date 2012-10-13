package test;

import java.util.Random;
import model.Schip;

/**
 * @author Mathy
 * @version januari 4, 2008
 * 
 */
public class TestVehicle {
	private static Random random = new Random();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Schip schip = new Schip();
		int cars, vans;
		for (int i = 0; i < Schip.MAX_PARKING; i++) {
			cars = 1+ Math.abs(random.nextInt(Schip.MAX_PARKING / 2));
			vans = Schip.MAX_PARKING - cars;
			schip.addSmallCars(random.nextInt(cars));
			schip.addBigCars(random.nextInt(vans));
		}
		System.out.printf("%s", schip);
	}
}

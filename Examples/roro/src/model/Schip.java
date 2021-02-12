package model;


import factory.Factory;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class Schip
 * 
 * @author Mathy
 * @version januari 4, 2008
 */
public class Schip {
	private LinkedList<Vehicle> vehicles;
	public static final int MAX_WEIGHT = 110000;
	public static final int MAX_PARKING = 100;


	/**
	 * Constructor for objects of class Schip
	 */
	public Schip() {
		vehicles = new LinkedList<Vehicle>();

	}

	/**
	 * Add Small cars
	 * 
	 * @param y
	 *            number of cars
	 * @return
	 */
	
	public void addSmallCars(int cars) {
		addVehicles(cars, Vehicle.CAR);
		while (overflow()){
			removeSmallCars(1);
		}
	}

	/**
	 * Add Big cars
	 * 
	 * @param y
	 *            number of cars
	 * @return
	 */

	public void addBigCars(int vans) {
		addVehicles(vans, Vehicle.VAN);
		while (overflow()){
			removeBigCars(1);
		}
	}

	/**
	 * Add any vehicle
	 * 
	 * @param quantity
	 *            number of cars, vehicle type
	 * @return
	 */
	private void addVehicles(int quantity, int vehicle) {
		for (int i = 0; i < quantity; i++) {
			vehicles.add(Factory.getVehicle(vehicle));
		}
	}
	
	private boolean overflow() {

		if (totalWeight() > MAX_WEIGHT) {
			return true;
		}
		if (totalParking() > MAX_PARKING) {
			return true;
		}
		return false;
	}
	/**
	 * Remove Small cars
	 * 
	 * @param y
	 *            number of cars
	 * @return
	 */
	private void removeSmallCars(int cars) {
		removeVehicles(cars, Vehicle.CAR);
	}

	/**
	 * Remove Big cars
	 * 
	 * @param y
	 *            number of cars
	 * @return
	 */
	private void removeBigCars(int vans) {
		removeVehicles(vans, Vehicle.VAN);
	}

	/**
	 * Remove any vehicle
	 * 
	 * @param quantity
	 *            number of cars, vehicle type
	 * @return
	 */
	private void removeVehicles(int quantity, int type) {
		int number = quantity;
		Iterator<Vehicle> it = vehicles.iterator();
		Vehicle vehicle;
		while (it.hasNext() && number > 0) {
			vehicle = it.next();
			//System.out.println(vehicle.getClass().getName());
			if (vehicle.getClass().getName().equals("model.Van") && type == Vehicle.VAN) {
				it.remove();
				number--;
			}else if(vehicle.getClass().getName().equals("model.Car") && type == Vehicle.CAR){
				it.remove();
				number--;
			}
		}
	}

	/**
	 * Calculate the total weight of the boat
	 * 
	 * @param
	 * @return total weight
	 */
	public int totalWeight() {
		Iterator<Vehicle> it = vehicles.iterator();
		int total = 0;
		while (it.hasNext()) {
			total += it.next().getWeight();
		}
		return total;
	}

	/**
	 * Calculate the total number of parkings of the boat
	 * 
	 * @param
	 * @return total weight
	 */
	public int totalParking() {
		Iterator<Vehicle> it = vehicles.iterator();
		int total = 0;
		while (it.hasNext()) {
			total += it.next().getParking();
		}
		return total;
	}
	
	/**
	 * Calculate number of cars on the boat
	 * 
	 * @return
	 */
	public int countCars(){
		int total = 0;
		Iterator<Vehicle> it = vehicles.iterator();
		while (it.hasNext()) {
			if(it.next().getClass().getName().equals("model.Car")){
				total ++;	
			}			
		}
		return total;
	}
	
	/**
	 * Calculate number of vans on the boat
	 * 
	 * @return
	 */
	public int countVans(){
		int total = 0;
		Iterator<Vehicle> it = vehicles.iterator();
		while (it.hasNext()) {
			if(it.next().getClass().getName().equals("model.Van")){
				total ++;	
			}		
		}
		return total;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("The boat has "+vehicles.size());;
		buffer.append(" vehicles:\n\t");
		Iterator<Vehicle> it = vehicles.iterator();
		int number = 0;
		Vehicle vehicle;
		while (it.hasNext()) {	
			vehicle = it.next();
			buffer.append((number++ ==0?"":", "));		
			buffer.append("Vehicle "+vehicle.getNumber());
			buffer.append(" is a ");
			buffer.append(vehicle);
			if(number>2){
				buffer.append(",\n\t");
				number =0;
			}
		}
		buffer.append("\nthere are "+countCars()+" cars and ");
		buffer.append(countVans()+" vans ");
		buffer.append("with a total weight of "+totalWeight());
		buffer.append("kg and they take "+totalParking());
		buffer.append(" parkings.");
		return buffer.toString();
	}
}

package com.ibm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Aims {

	public Aims() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread memDaemon = new Thread(new MemoryDeamon());
		memDaemon.setDaemon(true);
		memDaemon.start();
		
		Order anOrder = new Order();
		
		CompactDisc cd1 = new CompactDisc();
		cd1.setTitle("IBM Symphony");
		cd1.setCategory("Instrumental");
		cd1.setCost(29.95f);
		cd1.setArtist("IBM Band");
		
		Track t1 = new Track();
		t1.setTitle("Warmup");
		t1.setLength(3);
		cd1.addTrack(t1);
		
		Track t2 = new Track();
		t2.setTitle("Scales");
		t2.setLength(4);
		cd1.addTrack(t2);
		
		Track t3 = new Track();
		t3.setTitle("Introduction");
		t3.setLength(6);
		cd1.addTrack(t3);
		try {
			cd1.play();
		} catch (PlayerException e1) {
			e1.printStackTrace();
		}
		anOrder.addMedia(cd1);
		
		Collection collection = new ArrayList();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc();
		dvd1.setTitle("The lion king");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Alers");
		dvd1.setLength(87);
		anOrder.addMedia(dvd1);
		collection.add(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc();
		dvd2.setTitle("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("Georges Lucas");
		dvd2.setLength(124);
		anOrder.addMedia(dvd2);
		collection.add(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc();
		dvd3.setTitle("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Muskers");
		dvd3.setLength(90);
		try {
			dvd3.play();
		} catch (PlayerException e1) {
			e1.printStackTrace();
		}
		anOrder.addMedia(dvd3);
		collection.add(dvd3);
		
		System.out.println("\nDVD list Before sorting");
		Iterator it = collection.iterator();
		iterateCollection(it);
		
		Collections.sort((List)collection);
		System.out.println("\nDVD list After sorting");
		it = collection.iterator();
		iterateCollection(it);

		Book book = new Book();
		book.setTitle("Java programming");
		book.setCost(18.99f);
		book.setCategory("Animation");
		book.addAuthor("Joe Wigglesworth");
		book.addAuthor("Paula Lumby");
		anOrder.addMedia(book);
		
		System.out.println("\nBefore Serialization: ");
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		try {
			OrderSaver.saveOrder("Orders.ser", anOrder);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		anOrder = null;
		
		try {
			anOrder = OrderSaver.restoreOrder("Orders.ser");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("After Serialization: ");
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());

		System.out.println("Saved Media: ");
		it = anOrder.getOrders().iterator();
		iterateCollection(it);
	}

	private static void iterateCollection(Iterator it) {
		while(it.hasNext()){
			Media medium = (Media)it.next();
			System.out.print(medium);
		}
	}
}

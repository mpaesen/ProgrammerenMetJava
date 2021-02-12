package com.ibm;

import java.io.*;

public class OrderSaver {
	
	public static void saveOrder( String fileName, Order order)throws IOException{
		File file = new File(fileName);
		if(file.exists()){
			file.delete();
		}
		ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(file));
		objectStream.writeObject(order);
		objectStream.flush();
		objectStream.close();
	}
	public static Order restoreOrder(String fileName)throws IOException, ClassNotFoundException{
		File file = new File(fileName);
		Order order;
		ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(file));
		order = (Order)objectStream.readObject();
		return order;
	}
}

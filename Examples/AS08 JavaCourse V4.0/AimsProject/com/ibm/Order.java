package com.ibm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Order implements Serializable{
	private ArrayList orders = new ArrayList(3);
	
	public Order() {
	}

	public void addMedia(Media mediaItem){
		if(!orders.contains(mediaItem)){
			orders.add(mediaItem);
		}
	}
	public void removeMedia(Media mediaItem){
		if(orders.contains(mediaItem)){
			orders.remove(mediaItem);
		}
	}
	public float totalCost(){
		float total = 0;
		Media mediaItem;
		Iterator it = orders.iterator();
		while(it.hasNext()){
			mediaItem = (Media)it.next();
			total += mediaItem.getCost();
		}
		return total;
	}

	public ArrayList getOrders() {
		return orders;
	}

	public void setOrders(ArrayList orders) {
		this.orders = orders;
	}
	
	
}

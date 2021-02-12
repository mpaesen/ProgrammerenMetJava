package com.ibm;

import java.io.Serializable;

public abstract class Media implements Comparable, Serializable{
	private String title;
	private String category;
	private float cost;
	public Media() {
		super();
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String toString(){
		return "\tTitle: "+getTitle()+"\n\tCategory :"+getCategory()+ "\n\tCost :"+getCost();
	}
}

package model;

import java.util.ArrayList;

public class Tiger {
	public enum MyValues {
		Ronny, Peter, Magda, Kevin
	}

    private static final int MAX = 20;

	private ArrayList<Integer> list = new ArrayList<Integer>();

	public void displayMyValues() {
		for (MyValues i : MyValues.values())
			System.out.println(i);
	}
	
	public void setList(){
		for(int i =0; i< MAX; i++){
			list.add(i);
		}
	}
	
	public void displayList(){
		for (Integer i : list){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}

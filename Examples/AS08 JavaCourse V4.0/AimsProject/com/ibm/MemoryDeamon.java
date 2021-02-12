package com.ibm;

public class MemoryDeamon implements Runnable {
	private long memoryUsed = 0l;
	public long getMemoryUsed() {
		return memoryUsed;
	}

	public void setMemoryUsed(long memoryUsed) {
		this.memoryUsed = memoryUsed;
	}

	public MemoryDeamon() {
	}

	public void run(){
		Runtime rt = Runtime.getRuntime();
		long used;
		while(true){
			used= Runtime.getRuntime().totalMemory() - rt.freeMemory();
			if(used != memoryUsed){
				System.out.println("\tMemory used =" + used);
				memoryUsed = used;
			}
		}
	}
}

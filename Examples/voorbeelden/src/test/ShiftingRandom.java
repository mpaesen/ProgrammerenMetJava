package test;
import java.util.Random;
public class ShiftingRandom{
	public static void main(String args[]){
		Random rand = new Random();
		int x;
		for(int i = 1; i<= 20; i++){
			x= 100+100*rand.nextInt(9);
			System.out.print((i%4==0?" "+x+"\n":" "+x));
		}
	}
}
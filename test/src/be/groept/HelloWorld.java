package be.groept;

public class HelloWorld {
	public static final int ZERO = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != ZERO)
			System.out.printf("%s", args[0]);
		else
			System.out.printf("%s", "Hallo allemaal");
	}

}

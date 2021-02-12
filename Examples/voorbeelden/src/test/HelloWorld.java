package test;
public class HelloWorld {
	public static void main(String args[]) {
		if (args.length == 1) {
			System.out.println("Dag " + args[0]);
		} else if (args.length > 1) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]+" ");
			}
		} else {
			System.out.println("Dag Allemaal");
		}
	}
}
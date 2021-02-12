package structural.decorator;

/**
 * Decorates the branch of the tree with coloured balls.
 */
public class BallDecorator extends Decorator {

	// Default Constructor
	public BallDecorator(ChristmasTree tree) {
		Branch branch = tree.getBranch();
		place(branch);
	}

	/*
	 * The method places each decorative item on the tree.
	 */
	public void place(Branch branch) {
		branch.put("ball");
	}

}// End of class
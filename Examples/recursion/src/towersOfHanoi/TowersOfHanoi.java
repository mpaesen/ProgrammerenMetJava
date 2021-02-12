package towersOfHanoi;

/**
 * Class for solving the "Towers of Hanoi" puzzle.
 */
class TowersOfHanoi
{
	static long step;

	public static void main(final String[] args)
	{
		final int nDisks;
		if (args.length > 0)
		{
			nDisks = Integer.parseInt(args[0]);
		}
		else
		{
			nDisks = 4;
		}
		doTowers(nDisks, 'A', 'B', 'C');
		System.out.printf("\n\n%d Steps are needed to move a tower of %d disks: ", (int) Math.pow(2, nDisks) - 1, nDisks);
	}

	public static void doTowers(final int topN, final char from, final char inter, final char to)
	{
		if (topN == 1)
		{
			System.out.printf("\nStep %5d: Disk %2d from %c to %c", ++step, topN, from, to);
		}
		else
		{
			doTowers(topN - 1, from, to, inter);
			System.out.printf("\nStep %5d: Disk %2d from %c to %c", ++step, topN, from, to);
			doTowers(topN - 1, inter, from, to);
		}
	}
}

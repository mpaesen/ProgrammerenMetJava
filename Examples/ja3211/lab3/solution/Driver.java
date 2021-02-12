package lab3.solution;

/**
 * Insert the type's description here.
 * Creation date: (2/26/2002 5:28:22 PM)
 * @author: ILS User
 */
public class Driver {
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	if (args.length == 0) {
		System.out.println("Please pass test statistics on the command line.");
		System.out.println("Format: name1 score1 name2 score2 ...");
		System.exit(1);
	}

	if ((args.length % 2) > 0) {
		System.out.println("Must have even number of arguments");
		System.out.println("Format: name1 score1 name2 score2 ...");
		System.exit(1);
	}

	java.util.Vector names = new java.util.Vector();
	java.util.Vector scores = new java.util.Vector();

	int index = 0;
	while (index < args.length) {
		names.add(args[index++]);
		scores.add(args[index++]);
	}

	int hiScoreIndex = 0;
	int loScoreIndex = 0;
	int loScore =Integer.MAX_VALUE;
	int hiScore = 0;
	
	for (index = 0; index < scores.size(); index++) {
		//Get the score string
		String scoreString = (String) scores.get(index);
		//Convert scoreString to an int
		int score = Integer.parseInt(scoreString);
		// Accumulate index of low and high scores
		if (score < loScore) {
			loScoreIndex = index;
			loScore = score;
		}
		if (score > hiScore) {
			hiScoreIndex = index;
			hiScore = score;
		}
	}

	//Print results
	System.out.println("High scorer was " + names.get(hiScoreIndex) +
		" with a score of " + scores.get(hiScoreIndex));
	System.out.println("Low scorer was " + names.get(loScoreIndex) +
		" with a score of " + scores.get(loScoreIndex));
}
}

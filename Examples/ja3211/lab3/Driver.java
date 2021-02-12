package lab3;
public class Driver {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please pass test statistics on the command line.");
			System.out.println("Format: name1 score1 name2 score2 ...");
			System.exit(1);
		}
		
		if ((args.length % 2) > 0) {
			System.out.println("You must have an even number of arguments.");
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
		int lowScoreIndex = 0;
		int hiScore = 0;
		int lowScore = Integer.MAX_VALUE;
		
		for (index = 0; index < scores.size() ; index++) {
			// Get the score string
			String scoreString = (String) scores.get(index);
			// Convert scoreString to an int
			int score = Integer.parseInt(scoreString);
			
			if (score < lowScore) {
				lowScore = score;
				lowScoreIndex = index;
			}
			
			if (score > hiScore) {
				hiScore = score;
				hiScoreIndex = index;
			}
		}
		
		// Print results
		System.out.println("High scorer was " + names.get(hiScoreIndex) +
		   " with a score of " + scores.get(hiScoreIndex));
		System.out.println("Low scorer was " + names.get(lowScoreIndex) +
		   " with a score of " + scores.get(lowScoreIndex));		
	}
}


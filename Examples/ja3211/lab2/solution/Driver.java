package lab2.solution;

/**
 * Insert the type's description here.
 * Creation date: (2/26/2002 4:58:16 PM)
 * @author: ILS User
 */
public class Driver {
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
    double[] testScores = { 16.0, 22.0, 24.0, 24.0, 27.0, 
	    28.0, 29.0, 30.0 };
    int testCount = testScores.length; // number of scores
    double totalScore = 0.0;
    double meanScore = 0.0;
    int index;

    // Compute the mean (arithmetic average) test score
	for (index = 0; index < testCount; index++) {
		totalScore = totalScore + testScores[index];
	}
	meanScore = totalScore / testCount;

	System.out.println("The arithmetic mean is " + meanScore);

	double sum = 0.0;
	for (index = 0; index < testCount; index++) {
		// Compute each score's difference from the mean
		double distFromMean = testScores[index] - meanScore;
		// Accumulate its square
		double distFromMeanSquared = distFromMean * distFromMean;
		sum += distFromMeanSquared;
	}

	double meanOfSquares = sum / testCount;

	double stdDeviation = Math.sqrt(meanOfSquares);

	System.out.println("The standard deviation is " +
		stdDeviation);
}
}

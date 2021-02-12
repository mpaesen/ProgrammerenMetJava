package lab2;
public class Driver {
	public static void main(String[] args) {
		double[] testScores = {16.0, 22.0, 24.0, 24.0, 27.0,
			28.0, 29.0, 30.0};
		int testCount = testScores.length; // number of scores
		double totalScore = 0.0;
		double meanScore = 0.0;
		int index;
		
		for (index = 0; index < testCount; index++) {
			totalScore = totalScore + testScores[index];
		}
		
		meanScore = totalScore / testCount;
		
		System.out.println("The arithmetic mean is " + meanScore);
		
		double sum = 0.0;
		for (index = 0; index < testCount ; index++) {
			// compute each score's difference from the mean
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


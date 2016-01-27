import acm.program.*;

public class BiasFreeJudge extends ConsoleProgram {

	public void init() {
		scores = new double[readInt("Enter a number of judges: ")];
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = readDouble("Enter score for judge " + (i + 1) + ": ");
		}
	}
	
	public void run() {
		println("The average score is " + biasFreeAverage());
	}
	
	private double biasFreeAverage() {
		double sum = 0;
		double lower = 0, higher = 0; 
		
		for (int i = 0; i < scores.length; i++) {
			if (i == 0) {
				higher = lower = scores[i];
			} else if (scores[i] > higher) {
				higher = scores[i];
			} else if (scores[i] < lower) {
				lower = scores[i];
			}

			sum += scores[i];
		}
		sum -= higher + lower;
		
		return sum / (scores.length - 2);
	}

	private double[] scores;
}
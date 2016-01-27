import acm.program.*;

public class GymnasticsJudge extends ConsoleProgram {

	public void init() {
		scores = new double[readInt("Enter a number of judges: ")];
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = readDouble("Enter score for judge " + (i + 1) + ": ");
		}
	}
	
	public void run() {
		println("The average score is " + Mean.mean(scores));
	}
	
	private double averageScore() {
		double sum = 0;
		
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		return sum / scores.length;
	}

	private double[] scores;
}

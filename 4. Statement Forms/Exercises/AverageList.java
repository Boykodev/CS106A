/*
 * AverageList.java
 * ---------------------
 * Averages list of numbers entered until sentinel.
 */

import acm.program.*;

public class AverageList extends DialogProgram {
	private static final int SENTINEL = -1;
	double score, sum, average;
	int index;
	
	public void run() {
		showInfo();
		averageIntegers();
		showResult();
	}

	private void showInfo() {
		println("Program averages exam scores entered before special number (-1).");
	}
	
	private void averageIntegers() {
		for (;;index++) {
			score = readDouble("Enter score # " + (index + 1) + ": ");
			if (score == SENTINEL) break;
			sum += score;
		}
		if (index != 0) average = sum / index;
	}
	
	private void averageIntegers2() {
		score = readDouble("Enter score # " + (index + 1) + ": ");
		while (score != SENTINEL) {
			sum += score;
			index++;
			score = readDouble("Enter score # " + (index + 1) + ": ");
		}
		if (index != 0) average = sum / index;
	}

	private void showResult() {
		println("Average of " + index + " students' scores is: " + average + ".");
	}
}
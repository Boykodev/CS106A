/*
 * AverageList.java
 * ---------------------
 * Averages list of numbers entered until sentinel.
 */

import acm.program.*;

/** Averages list of numbers.*/
public class AverageList extends DialogProgram {
	private static final String SENTINEL = "";
	double sum, average;
	int index;
	
	public void run() {
		showInfo();
		averageIntegers();
		showResult();
	}

	private void showInfo() {
		println("Program averages numbers entered before blank line.");
	}
	
	private void averageIntegers() {
		for (;;index++) {
			String number = readLine("Enter number # " + (index + 1) + ": ");
			
			if (number.equals(SENTINEL)) break;
			Double n = new Double(number);
			
			sum += n.doubleValue();
		}
		if (index != 0) average = sum / index;
	}
	
	private void averageIntegers2() {
		String number = readLine("Enter number # " + (index + 1) + ": ");
		Double n = new Double(number);
		
		while (!number.equals(SENTINEL)) {
			sum += n.doubleValue();
			index++;
			number = readLine("Enter number # " + (index + 1) + ": ");
			n = new Double(number);
		}
		if (index != 0) average = sum / index;
	}

	private void showResult() {
		println("Average of " + index + " numbers is: " + average + ".");
	}
}
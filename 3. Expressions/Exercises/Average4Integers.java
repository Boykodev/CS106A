/*
 * Average4Integers.java
 * ---------------
 * Averages four integer numbers.
 */

import acm.program.*;

public class Average4Integers extends ConsoleProgram {
	int n1, n2, n3, n4;
	double average;
	
	public void run() { 
		showInfo();
		takeNumbers();
		avarageNumbers();
		showResult();
	}
	
	private void showInfo() {
		println("This program averages four integers: ");
	}
	
	private void takeNumbers() {
		n1 = readInt("Enter first number: ");
		n2 = readInt("Enter second number: ");
		n3 = readInt("Enter third number: ");
		n4 = readInt("Enter forth number: ");
	}
	
	private void avarageNumbers() {
		average = (n1 + n2 + n3 + n4) / 4.0;
	}
	
	private void showResult() {
		println("The average is: " + average + ".");
	}
}
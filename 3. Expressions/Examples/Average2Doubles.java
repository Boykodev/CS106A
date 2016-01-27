/*
 * Average2Doubles.java
 * ---------------
 * Averages two double-precision floating-point numbers.
 */

import acm.program.*;

public class Average2Doubles extends ConsoleProgram {
	public void run() { 
		println("This program averages two numbers: ");
		double n1 = readDouble("Enter first number: ");
		double n2 = readDouble("Enter second number: ");
		double average = (n1 + n2) / 2;
		println("The average is: " + average + ".");
	}
}
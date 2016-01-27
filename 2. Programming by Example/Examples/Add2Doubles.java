/*
 * Add2Doubles.java
 * ---------------
 * Adds two real numbers and prints their sum.
 */

import acm.program.*;

public class Add2Doubles extends ConsoleProgram {
	public void run() { 
		println("This program adds two real numbers: ");
		double n1 = readDouble("Enter first number: ");
		double n2 = readDouble("Enter second number: ");
		double total = n1 + n2;
		println("The total is: " + total + ".");
	}
}
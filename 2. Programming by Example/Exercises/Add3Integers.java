/*
 * Add3Integers.java
 * ---------------
 * Adds three integers and displays their sum.
 */

import acm.program.*;

public class Add3Integers extends DialogProgram {
	public void run() { 
		println("This program adds three integers: ");
		int n1 = readInt("Enter first number: ");
		int n2 = readInt("Enter second number: ");
		int n3 = readInt("Enter third number: ");
		int total = n1 + n2 + n3;
		println("The total is: " + total + ".");
	}
}
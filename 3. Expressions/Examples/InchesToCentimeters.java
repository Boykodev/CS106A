/*
 * InchesToCentimeters.java
 * ------------------------
 * Converts inches to centimeters.
 */

import acm.program.*;

public class InchesToCentimeters extends ConsoleProgram {
	public void run() {
		println("This program converts inches to centimeters: ");
		double inch = readDouble("Enter inches to convert: ");
		double cm = inch * 2.54;
		println(inch + " inches = " + cm + " centimeters.");
	}
}
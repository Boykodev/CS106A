/*
 * FeetAndInchesToCentimeters.java
 * -------------------------------
 * Converts feet and inches to centimeters.
 */

import acm.program.*;

public class FeetAndInchesToCentimeters extends ConsoleProgram {
	public void run() {
		int feet, inches, totalInches;
		double cm;
		
		println("Program converts feet and inches to centimeters.");
		feet = readInt("Enter number of feet to convert: ");
		inches = readInt("Enter number of inches to convert: ");
		
		totalInches = feet * INCHES_PER_FOOT + inches;
		cm = totalInches * CENTIMETERS_PER_INCH;
		println(feet + " ft, "+ inches +" in = " + cm + " cm.");
	}
	private static final int INCHES_PER_FOOT = 12;
	private static final double CENTIMETERS_PER_INCH = 2.54;
}
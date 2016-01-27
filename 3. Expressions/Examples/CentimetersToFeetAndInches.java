/*
 * CentimetersToFeetAndInches.java
 * -------------------------------
 * Converts centimeters to feet and inches.
 */

import acm.program.*;

public class CentimetersToFeetAndInches extends ConsoleProgram {
	public void run() {
		println("Program converts centimeters to feet and inches.");
		int cm = readInt("Enter number of centimeters to convert: ");
		double totalInches = cm / CENTIMETERS_PER_INCH;
		int feet =  (int) (totalInches / INCHES_PER_FOOT);
		int inches = (int) (totalInches - feet * INCHES_PER_FOOT);
		println(cm + " cm = " + feet + " ft, "+ inches +" in.");
	}
	private static final int INCHES_PER_FOOT = 12;
	private static final double CENTIMETERS_PER_INCH = 2.54;
}
/*
 * KilogramsToPoundsAndOunces.java
 * -------------------------------
 * Converts metric weight to the
 * corresponding English weight.
 */

import acm.program.*;

public class KilogramsToPoundsAndOunces extends ConsoleProgram {
	double kilo, ounces, totalOunces;
	int pounds;
	
	public void run() {
		showInfo();
		takeKilograms();
		conversion();
		showResult();
	}
	
	private void showInfo() {
		println("Program converts from metric weight to English measurements.");
	}
	
	private void takeKilograms() {
		kilo = readDouble("Enter kilograms to convert: ");
	}
	
	private void conversion() {
		totalOunces = kilo * KG_TO_POUNDS * POUNDS_TO_OUNCES;
		pounds = (int) (totalOunces / POUNDS_TO_OUNCES);
		ounces = totalOunces - pounds * POUNDS_TO_OUNCES;
	}

	private void showResult() {
		println(kilo + " kg = " + pounds + " pounds, " + ounces + " ounces.");
	}
	
	private static final double KG_TO_POUNDS = 2.2;
	
	private static final int POUNDS_TO_OUNCES = 16;
}
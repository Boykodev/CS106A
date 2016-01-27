/*
 * LeapYear.java
 * -------------
 * Program takes a year and determines
 * if it is a leap year or not.
 */

import acm.program.*;

public class LeapYear extends DialogProgram {
	public void run() {
		int y;
		showInfo();
		y = takeYear();
		showResult(isLeapYear(y), y);
	}
	
	private void showInfo() {
		println("This program checks for leap years.");
	}
	
	private int takeYear() {
		return readInt("Enter year: ");
	}
	
	private boolean isLeapYear(int y) {
		return ((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0);
	}
	
	private void showResult(boolean isLeapYear, int y) {
		if (isLeapYear) {
			println("Year " + y + " is a leap year.");
		} else {
			println("Year " + y + " is NOT a leap year.");
		}
	}
}
/*
 * FahrenheitToCelsium.java
 * ---------------
 * Convert temperature from Fahrenheit
 * to corresponding value in Celsium.
 */

import acm.program.*;

public class FahrenheitToCelsium extends ConsoleProgram {
	double c, f;
	
	public void run() {
		println("Program converts temperature from Fahrenheit to Celsium.");
		takeFahrenheit();
		convertValue();
		showResult();
	}
	
	private void takeFahrenheit() {
		f = readDouble("Enter temperature in Fahrenheit: ");
	}
	
	private void convertValue() {
		c = 5 * (f - 32) / 9;
	}
	
	private void showResult() {
		println("Celsium equivalent = " + c);
	}
}
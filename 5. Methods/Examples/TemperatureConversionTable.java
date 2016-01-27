/*
 * Draws a table of Celsius to Fahrenheit
 * conversions (using function).
 */

import acm.program.*;

public class TemperatureConversionTable extends ConsoleProgram {
	private static final int LOWER_LIMIT = 0;
	private static final int UPPER_LIMIT = 100;
	private static final int STEP = 5;
	
	public void run() {
		for (int i = LOWER_LIMIT; i <= UPPER_LIMIT; i += STEP) {
			if (i < 10) {
				println("Celsium = " + i + "  || Fahrenheit = " + celsiumToFahrenheit(i));
			} else if (i >= 10 && i < 100) {
				println("Celsium = " + i + " || Fahrenheit = " + celsiumToFahrenheit(i));
			} else {
				println("Celsium = " + i + "|| Fahrenheit = " + celsiumToFahrenheit(i));
			}
		}
	}
	
	double celsiumToFahrenheit(int c) {
		return 9.0 / 5.0 * c + 32;
	}
}
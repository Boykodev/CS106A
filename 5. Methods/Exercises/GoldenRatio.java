/*
 * Displays golden ratio constant.
 */

import acm.program.*;

public class GoldenRatio extends ConsoleProgram {
	private final static double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;
	
	public void run() {
		println("Golden Ratio(φ) is: " + GOLDEN_RATIO);
	}
}

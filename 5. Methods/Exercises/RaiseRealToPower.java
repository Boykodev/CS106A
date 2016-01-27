/*
 * Raises floating-point
 * number to power.
 */

import acm.program.*;

public class RaiseRealToPower extends ConsoleProgram {
	public void run() {
		double n; 
		int kLower, kUpper;
		println("This program raises 'n' to 'k' power.");
		n = readDouble("Enter number: ");
		kLower = readInt("Enter lower power: ");
		kUpper = readInt("Enter upper power: ");
		for (int i = kLower; i <= kUpper; i++) {
			println(n + "(" + i + ") = " + ((i == 0) ? "1" : raiseIntToPower(n, i)));
		}
	}

	private double raiseIntToPower(double n, int k) {
		double product = 1;
		if (k > 0) {
			for (int i = 0; i < k; i++) {
				product *= n;
			}
			return product;
		} else if (k < 0) {
			for (int i = 0; i < Math.abs(k); i++) {
				product *= n;
			}
			return 1 / product;
		} else {
			return product;
		}
	}
}

/*
 * Raises 'n' to 'k' power.
 */

import acm.program.*;

public class RaiseIntToPower extends ConsoleProgram {
	public void run() {
		int n, k;
		println("This program raises 'n' to 'k' power.");
		n = readInt("Enter number: ");
		k = readInt("Enter power: ");
		for (int i = 0; i <= k; i++) {
			println(n + "(" + i + ") = " + raiseIntToPower(n, i));
		}
	}

	private int raiseIntToPower(int n, int k) {
		int product = 1;
		for (int i = 0; i < k; i++) {
			product *= n;
		}
		return product;
	}
}

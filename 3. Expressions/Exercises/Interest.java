/*
 * Interest.java
 * -------------
 * Program calculates
 * annual interest rates.
 */

import acm.program.*;

public class Interest extends ConsoleProgram {
	double balance, interest;
	public void run() {
		
		println("Interest calculation program");
		balance = readDouble("Enter starting balance: ");
		interest = readDouble("Enter annual interest rate: ");
		interestToBalance();
		println("Balance after one year: " + balance);
		interestToBalance();
		println("Balance after two years: " + balance);
	}
	private void interestToBalance() {
		balance += balance  * (interest / 100);
	}
}
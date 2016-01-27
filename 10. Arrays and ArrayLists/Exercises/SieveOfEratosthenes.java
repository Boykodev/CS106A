import java.util.*;

import acm.program.*;

public class SieveOfEratosthenes extends ConsoleProgram {

	private static final int FIRST_NUMBER = 2;
	private static final int LAST_NUMBER = 1000;
	
	public void run() {
		int[] numbers = new int[LAST_NUMBER - FIRST_NUMBER];
		
		for (int i = 0; i < LAST_NUMBER - FIRST_NUMBER; i++) {
			numbers[i] = FIRST_NUMBER + i;
		}
		ArrayList<Integer> primes = getPrimeNumbers(numbers);
		
		for (int i = 0; i < primes.size(); i++) {
			println(primes.get(i));
		}
	}
	
	private ArrayList<Integer> getPrimeNumbers(int[] numbers) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 0; i < LAST_NUMBER - FIRST_NUMBER; i++) {
			if (numbers[i] == 2 || numbers[i] == 3) {
				primes.add(numbers[i]);
			} else if (numbers[i] % 2 != 0 && numbers[i] % 3 != 0 &&
					numbers[i] % 5 != 0 && numbers[i] % 7 != 0 && numbers[i] != 1) {
				primes.add(numbers[i]);
			}
		}
		return primes;
	}
}

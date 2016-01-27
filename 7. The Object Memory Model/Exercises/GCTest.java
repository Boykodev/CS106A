import acm.program.*;

/** Test the java runtime environment.*/
public class GCTest extends ConsoleProgram {

	private static final int TOTAL_OBJECTS = 10000;
	
	public void init() {
		long initial, after, freed;
		
		Runtime myRuntime = Runtime.getRuntime();
		
		initial = myRuntime.freeMemory();
		println("Free memory: " + addCommasToNumericString(""+initial+"") + " bytes.");
		
		println("Allocating 10000 Rational objects");
		for (int i = 0; i < TOTAL_OBJECTS; i++) {
			Rational r = new Rational();
		}
		
		after = myRuntime.freeMemory();
		println("Free memory: " + addCommasToNumericString(""+after+"") + " bytes.");
		
		println("Starting garbage collector...");
		myRuntime.gc();
		
		freed = myRuntime.freeMemory();
		println("Free memory: " + addCommasToNumericString(""+freed+"") + " bytes.");
		
		freed -= after;
		println("Freed memory: " + addCommasToNumericString(""+freed+"") + " bytes.");
	}
	
	private String addCommasToNumericString(String digits) {
		if (digits.length() <= 3) {
			return digits;
		}
		
		for (int i = 3; digits.length() - i > 0; i += 4) {
			digits = digits.substring(0, digits.length() - i)
			+ "," + digits.substring(digits.length() - i);
		}
		
		return digits;
	}
}

class Rational {
	
	Rational() { this(0,1); }

	public Rational(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	private int num;
	private int den;
}
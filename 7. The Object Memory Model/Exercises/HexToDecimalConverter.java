import acm.program.*;

/** Converts hexadecimal numbers to decimal equivalents.*/
public class HexToDecimalConverter extends ConsoleProgram {

    private static final int SENTINEL = 0;

    public void init() {
		println("This program converts hexadecimal to decimal.");
		println("Print " + SENTINEL + " to stop.");
		
		while (true) {
		    String hex = readLine("Enter a hexadecimal number: ");
		    Integer dec = Integer.parseInt(hex, 16);
		    if (dec.intValue() == SENTINEL) {
			break;
		    }
		    println(hex + " hex = " + dec + " decimal");
		}
    }
}

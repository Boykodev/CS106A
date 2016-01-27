import acm.program.*;

/** Separates digits with commas.*/
public class DigitsWithCommas extends ConsoleProgram {
	
	public void run()
	{
		while (true) {
        		String digits = readLine("Enter a numeric string: ");
        		
        		if (digits.length() == 0) {
        			break;
        		}
        		
        		println(addCommasToNumericString(digits));
        	}
	}

	private String addCommasToNumericString(String digits)
	{
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
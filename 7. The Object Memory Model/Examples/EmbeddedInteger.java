import acm.program.*;
import acm.util.*;

/** Test program.*/
public class EmbeddedInteger extends ConsoleProgram
{
	public void init()
	{
		Number x = new Number(10);
		
		println(x.getValue());
		
		changeNumber(x);
		
		println(x);
	}

	private void changeNumber(Number n)
	{
		n.setValue(15);
		
		println(n);
	}
}

class Number
{
	private int value;
	
	Number(int n) { value = n; }
	
	int getValue() { return value; }
	
	void setValue(int n) { this.value = n; }
	
	public String toString() { return "" + value; }
}
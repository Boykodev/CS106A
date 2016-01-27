import acm.program.*;

/** Removes all occurrences of selected character.*/
public class OccurrencesRemoval extends ConsoleProgram
{
	public void init()
	{
		println(removeAllOccurrences("This is a test", 't')); // returns "This is a es" 
		println(removeAllOccurrences("Summer is here!", 'e')); // returns "Summr is hr" 
		println(removeAllOccurrences("---0---", '-')); // returns "0"
	}
	
	public String removeAllOccurrences(String str, char ch)
	{
		
		while (str.indexOf(ch) != -1)
		{
			if (str.indexOf(ch) == 0)
			{
				str = str.substring(1);
			}
			else if (str.indexOf(ch) == str.length() - 1)
			{
				str = str.substring(0, str.indexOf(ch));
			}
			else
			{
				str = str.substring(0, str.indexOf(ch)) + str.substring(str.indexOf(ch) + 1);
			}
		}
		
		return str;
	}
}
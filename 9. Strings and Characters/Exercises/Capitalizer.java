import java.util.*;
import acm.program.*;

/** Capitalizes words.*/
public class Capitalizer extends ConsoleProgram
{
	public void init()
	{
		this.setFont("Helvetica-25");
		
		String text = readLine("Enter string for capitalizer: ");
		
		text = capitalize(text);
		
		println(text);
	}

	private String capitalize(String text)
	{
		StringTokenizer token = new StringTokenizer(text, ".,:; 	");
		
		while (token.hasMoreElements())
		{
			String nextWord = token.nextToken();
			int nextWordIndex = text.indexOf(nextWord);
			
			nextWord = capitalizeWord(nextWord);
			
			text = text.substring(0, nextWordIndex) +
			nextWord + text.substring(nextWordIndex + nextWord.length());
		}
		return text;
	}

	private String capitalizeWord(String word)
	{
		word = word.toLowerCase();
		
		char firstLetter = Character.toUpperCase(word.charAt(0));
		
		word = firstLetter + word.substring(1);
		
		return word;
	}
}

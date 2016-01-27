import acm.program.*;

/** Program displays all English consonants.*/
public class EnglishConsonants extends ConsoleProgram
{

	public void init()
	{
		this.setFont("Helvetica-25");
		
		println("List of English Consonants:\n");
		
		for(char ch = 'A'; ch <= 'Z'; ch++)
		{
			if (isEnglishConsonant(ch))
			{
				print(ch + ((ch == 'Z') ? "." : ", "));
			}
		}
	}

	public static boolean isEnglishConsonant(char ch)
	{
		ch = Character.toLowerCase(ch);
		
		return ch != 'a' && ch != 'e' &&
		ch != 'i' && ch != 'o' && ch != 'u';
	}
}

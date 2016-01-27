import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/** Prints out random "words".*/
public class RandomWord extends ConsoleProgram
{
	private static final int MIN_LETTERS = 3;
	private static final int MAX_LETTERS = 5;
	
	int lang;
	
	RandomGenerator rgen = new RandomGenerator();
	
	public void init()
	{
		lang = 1;
		
		this.setFont("Helvetica-15");
		
		for (int i = 0; i < 100; i++)
		{
			println(randomWord() + "\n");
		}
	}

	private String randomWord()
	{
		String word = "";
		int lenght = rgen.nextInt(MIN_LETTERS, MAX_LETTERS);
		
		for (int i = 0; i < lenght; i++)
		{
			word += randomLetter();
		}
		return word;
	}

	private char randomLetter()
	{
		if (lang == 0) return (char) rgen.nextInt('a', 'z');
		if (lang == 1) return (char) rgen.nextInt('а', 'я');
		
		return 0;
	}
}

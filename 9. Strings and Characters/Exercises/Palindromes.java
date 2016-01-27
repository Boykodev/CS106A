import java.util.StringTokenizer;
import acm.program.*;

public class Palindromes extends ConsoleProgram {

	public void init()
	{
		while (true) {
			String text = "";
			
			while (text.length() == 0) {
				text = readLine("Enter text for palindrome test: ");
			}
			
			if (isPalindrome(text)) {
				println("Yes, it's a palindrome!");
			} else {
				println("Sorry, it's not a palindrome.");
			}
		}
	}

	private boolean isPalindrome(String text)
	{
		text = text.toLowerCase();
		StringTokenizer token = new StringTokenizer(text, ".,:;!?' 	");
		text = "";
		
		while (token.hasMoreElements()) {
			text += token.nextToken();
		}
		
		for (int i = 0; i < text.length() / 2; i++) {
			if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}
}
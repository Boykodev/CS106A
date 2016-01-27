import acm.program.*;

/** Simulates Caesar method of encryption.*/
public class CaesarSifer extends ConsoleProgram {
	
	private static final int ALPHABET = 26;
	
	/** Program initialization.*/
	public void init()
	{
		String plainText = readLine("Enter plain text to encrypt: ");
		int key = readInt("Enter key for encryption: ");
		
		String encryptedText = encryptText(plainText, key);
		println(encryptedText);
		
		plainText = "";
		
		key = readInt("Enter key for decryption: ");
		
		println(deCryptText(encryptedText, key));
	}
	
	/** Decodes encrypted text.*/
	private String deCryptText(String encryptedText, int key)
	{
		return encryptText(encryptedText, -key);
	}
	
	/** Encrypts text.*/
	private String encryptText(String plainText, int key)
	{
		String result = "";
		
		for (int i = 0; i < plainText.length(); i++) {
			result += encryptChar(plainText.charAt(i), key);
		}
		
		return result;
	}
	
	/** Encrypts a character.*/
	private char encryptChar(char ch, int key)
	{
		if (Character.isLetter(ch)) {
			if (Character.toLowerCase(ch) + key % 26 > 'z') {
				key = (key % ALPHABET) - ALPHABET ;
			}
			if (Character.toLowerCase(ch) + key % 26 < 'a') {
				key = ALPHABET + (key % ALPHABET);
			}
			
			return (char) (ch + (key % ALPHABET));
		}
		
		return ch;
	}
}
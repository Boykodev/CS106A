import acm.program.*;

/** Transforms English noun to its plural form.*/
public class PluralForm extends ConsoleProgram {
	
	public void init() {
		String noun = readLine("Write a noun to transform to plural form: ");
		
		String plural = regularPluralForm(noun);
		
		println("Plural: " + plural);
	}

	private String regularPluralForm(String noun) {
		if (caseES(noun)) {
			noun += "es";
		}
		else if (caseIES(noun)) {
			noun += "ies";
		}
		else {
			noun += "s";
		}
		
		return noun;
	}
	
	private boolean caseES(String noun) {
		if (noun.charAt(noun.length() - 1) == 's' ||
				noun.charAt(noun.length() - 1) == 'x' ||
				noun.charAt(noun.length() - 1) == 'z') return true;
		
		if (noun.charAt(noun.length() - 1) == 'h') {
			if (noun.charAt(noun.length() - 2) == 's') return true;
			if (noun.charAt(noun.length() - 2) == 'c') return true;
		}
		
		return false;
	}
	
	private boolean caseIES(String noun) {
		if (noun.charAt(noun.length() - 1) == 'y') {
			
			if(EnglishConsonants.isEnglishConsonant(noun.charAt(noun.length() - 2))) {
				return true;
			}
		}
		
		return false;
	}
}

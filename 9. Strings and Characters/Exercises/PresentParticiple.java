import acm.program.*;

/** Conjugates English verbs to present participle.*/
public class PresentParticiple extends ConsoleProgram {
	
	public void init() {
		String verb = readLine("Write a verb for conjugation: ");
		
		verb = presentParticiple(verb);
		
		println("Present Participle: " + verb);
	}

	private String presentParticiple(String verb) {
		if (caseE(verb)) {
			verb = verb.substring(0, verb.length() - 1) + "ing";
		}
		else if (caseDouble(verb)) {
			verb += verb.charAt(verb.length() - 1) + "ing";
		}
		else {
			verb += "ing";
		}
		
		return verb;
	}
	
	private boolean caseE(String verb) {
		if (verb.charAt(verb.length() - 1) == 'e') {
			
			if(EnglishConsonants.isEnglishConsonant(verb.charAt(verb.length() - 2))) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean caseDouble(String verb) {
		if (EnglishConsonants.isEnglishConsonant(verb.charAt(verb.length() - 1))) {
			
			if(!EnglishConsonants.isEnglishConsonant(verb.charAt(verb.length() - 2))) {
				return true;
			}
		}
		
		return false;
	}
}
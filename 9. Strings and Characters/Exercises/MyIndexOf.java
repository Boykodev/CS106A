import acm.program.*;

/** Implements a personal string search method.*/
public class MyIndexOf extends ConsoleProgram {
	
	public void init() {
		String text = "TESTING";
		String search = "ING";
		int index;
		
		index = myIndexOf(text, search);
		
		println(index);
	}

	private int myIndexOf(String text, String search) {
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == search.charAt(0)) {
				if (checkForMatch(text, i, search)) return i;
			}
		}
		return -1;
	}

	private boolean checkForMatch(String text, int i, String search) {
		return (text.substring(i, i + search.length()).equals(search));
	}
}

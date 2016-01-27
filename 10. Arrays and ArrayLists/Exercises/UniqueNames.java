import java.io.*;
import java.util.*;

import acm.util.*;
import acm.program.*;

public class UniqueNames extends ConsoleProgram {

	public void run() {
		getNames();
		showUnique();
	}

	private void getNames() {
		names = new ArrayList<String>();
		
		while (true) {
			String line = readLine("Enter name: ");
			
			if (line.length() == 0) {
				println("Thanks for your cooperation.");
				break;
			}
			
			names.add(line);
		}
	}
	
	private void showUnique() {
		ArrayList<String> uniqueNames = getUniqueNames();
		
		println("Unique names list contains:");
		
		for (int i = 0; i < uniqueNames.size(); i++) {
			println(uniqueNames.get(i));
		}
	}

	private ArrayList<String> getUniqueNames() {
		ArrayList<String> unique = new ArrayList<String>();
		
		for (int i = 0; i < names.size(); i++) {
			unique.add(names.get(i));
		}
		
		for (int i = 0; i < unique.size(); i++) {
			for (int j = 1; j < unique.size() - i; j++) {
				if (unique.get(i).equals(unique.get(i + j))) {
					unique.remove(i + j);
					j--;
				}
			}
		}
		
		return unique;
	}

	private ArrayList<String> names;
}

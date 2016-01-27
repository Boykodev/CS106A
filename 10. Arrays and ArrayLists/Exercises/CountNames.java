import java.util.*;

import acm.program.*;

public class CountNames extends ConsoleProgram {
	
	public void run() {
		//getNames();
		//printResult();
		getNamesHM();
		printResultHM();
	}
	
	private void getNames() {
		key = new ArrayList<String>();
		freq = new ArrayList<Integer>();
		
		while (true) {
			String line = readLine("Enter name: ");
			
			if (line.equals("")) {
				break;
			}
			
			if (key.contains(line)) {
				int index = key.indexOf(line);
				freq.set(index, freq.get(index) + 1);
			} else {
				key.add(line);
				freq.add(1);
			}
		}
		
	}
	
	private void printResult() {
		for(int i = 0; i < key.size(); i ++) {
			println("Entry [" + key.get(i) + "] has count " + freq.get(i));
		}
	}

	private void getNamesHM() {
		names = new HashMap<String, Integer>();
		
		while (true) {
			String line = readLine("Enter name: ");
			
			if (line.equals("")) {
				break;
			}
			
			if (names.containsKey(line)) {
				names.put(line, names.get(line) + 1);
			} else {
				names.put(line, 1);
			}
		}
	}

	private void printResultHM() {
		Iterator<String> it = names.keySet().iterator();
		while (it.hasNext()) {
			String name = it.next();
			println("Entry [" + name + "] has count " + names.get(name));
		}
		for (String name : names.keySet()) {
			println("Entry [" + name + "] has count " + names.get(name));
		}
	}

	private ArrayList<String> key;
	private ArrayList<Integer> freq;
	private Map<String, Integer> names;
}

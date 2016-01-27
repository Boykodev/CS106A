import java.io.*;
import java.util.*;

import acm.util.*;
import acm.program.*;

public class Histogram extends ConsoleProgram {
	
	private static final String FILE_NAME = "Scores.txt";

	public void run() {
		getThrough(FILE_NAME);
		printResult();
	}

	private void getThrough(String fileName) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			scores = new ArrayList<Integer>();
			
			for (totalLines = 0; true; totalLines++) {
				String line = rd.readLine();
				if (line == null) break;
				scores.add(Integer.parseInt(line));
			}
			rd.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}
	}
	
	private void printResult() {
		int[] range = new int[11];
		
		for (int i = 0; i < scores.size(); i++) {
			if (scores.get(i) >= 0 && scores.get(i) <= 9) {
				range[0]++;
			} else if (scores.get(i) >= 10 && scores.get(i) <= 19) {
				range[1]++;
			} else if (scores.get(i) >= 20 && scores.get(i) <= 29) {
				range[2]++;
			} else if (scores.get(i) >= 30 && scores.get(i) <= 39) {
				range[3]++;
			} else if (scores.get(i) >= 40 && scores.get(i) <= 49) {
				range[4]++;
			} else if (scores.get(i) >= 50 && scores.get(i) <= 59) {
				range[5]++;
			} else if (scores.get(i) >= 60 && scores.get(i) <= 69) {
				range[6]++;
			} else if (scores.get(i) >= 70 && scores.get(i) <= 79) {
				range[7]++;
			} else if (scores.get(i) >= 80 && scores.get(i) <= 89) {
				range[8]++;
			} else if (scores.get(i) >= 90 && scores.get(i) <= 99) {
				range[9]++;
			} else if (scores.get(i) == 100) {
				range[10]++;
			}
		}
		
		for (int i = 0; i < range.length; i++) {
			switch (i) {
			case 0:
				print("0-9   | ");
				break;
			case 1:
				print("10-09 | ");
				break;
			case 2:
				print("20-09 | ");
				break;
			case 3:
				print("30-09 | ");
				break;
			case 4:
				print("40-09 | ");
				break;
			case 5:
				print("50-09 | ");
				break;
			case 6:
				print("60-09 | ");
				break;
			case 7:
				print("70-09 | ");
				break;
			case 8:
				print("80-09 | ");
				break;
			case 9:
				print("90-09 | ");
				break;
			case 10:
				print("100   | ");
				break;
			default:
				break;
			}
			
			for (int j = 0; j < range[i]; j++) {
				print("*");
			}
			
			print("\n");
		}
	}

	private ArrayList<Integer> scores;
	int totalLines;
}

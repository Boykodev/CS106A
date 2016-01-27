import java.io.*;
import java.util.*;

import acm.util.*;
import acm.program.*;

public class Writer extends ConsoleProgram {
	
	private static final String FILE_NAME = "Scores.txt";

	public void run() {
		writeIn(FILE_NAME);
		printResult();
	}

	private void printResult() {
		println("Writing finished!");
	}

	private void writeIn(String fileName) {
		try {
			//BufferedReader rd = new BufferedReader(new FileReader(fileName));
			PrintWriter wr = new PrintWriter(new FileWriter(fileName));
			
			for (int i = 0; i < totalLines; i++) {
				wr.println(rgen.nextInt(0, 100));
			}
			
			wr.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}
	}
	
	private int totalLines = 100;
	private RandomGenerator rgen = new RandomGenerator();
}

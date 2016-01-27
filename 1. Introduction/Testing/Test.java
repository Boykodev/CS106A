import acm.program.*;
import acm.util.*;

/** Test program.*/
public class Test extends ConsoleProgram {
	
	public void run() {
		String[][] array = new String[10][10];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = "[" + i + ":" + j + "]";
			}
		}
		printArray(array);
	}

	private void printArray(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				print(array[i][j]);
			}
			println();
		}
	}

}
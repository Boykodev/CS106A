import acm.program.*;

public class ReverseArray extends ConsoleProgram {

	private static final int N_VALUES = 5;

	public void run() {
		int[] array = new int[N_VALUES];
		
		readArray(array);
		reverseArray(array);
		printArray(array);
	}

	private void readArray(int[] array) {
		println("This program reverses elements in the array.");
		
		for (int i = 0; i < array.length; i++) {
			array[i] = readInt(" ? ");
		}
	}

	private void reverseArray(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			swapElements(array, i, array.length - i - 1);
		}
	}

	private void swapElements(int[] array, int left, int right) {
		left += right;
		right = left - right;
		left -= right;
	}

	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			println(array[i]);
		}
	}
	
}

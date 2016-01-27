import acm.program.*;
import acm.graphics.*;

public class Flip extends GraphicsProgram {

	public void run() {
		GImage milkmaid = new GImage("milkmaid.jpg");
		
		GImage flipped = flipHorizontal(milkmaid);
		
		add(milkmaid);
		add(flipped, milkmaid.getWidth(), 0);
	}

	private GImage flipHorizontal(GImage image) {
		int[][] pixels = image.getPixelArray();
		
		reverseArray(pixels);
		
		return new GImage(pixels);
	}
	
	private void reverseArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length / 2; j++) {
				swapElements(array, i, j, array[0].length - j - 1);
			}
		}
	}

	private void swapElements(int[][] array, int row, int left, int right) {
		int temp = array[row][left];
		array[row][left] = array[row][right];
		array[row][right] = temp;
	}
	
}

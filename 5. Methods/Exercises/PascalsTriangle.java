/*
 * Draws first eight rows
 * of Pascal's Triangle.
 */

import acm.program.*;
import acm.graphics.*;

public class PascalsTriangle extends GraphicsProgram {
	private static final int NUMBER_OF_ROWS = 8;
	private static final int LABEL_GAP = 20;
	private static final int LABEL_SPACE = 20;
	public void run() {
		for (int i = NUMBER_OF_ROWS; i >= 0; i--) {
			drawCombinationsLine(i);
		}
	}
	
	int combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
	
	int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	void drawCombinationsLine(int index) {
		int x, y;
		double totalWidth = 0;
		for (int i = 0; i <= index; i++) {
			GLabel comb = new GLabel("C(" + index +"," + i +")");
			totalWidth += comb.getWidth();
		}
		totalWidth += index * LABEL_GAP;
		x = getWidth() / 2 - (int)totalWidth / 2;
		y = getHeight() - (NUMBER_OF_ROWS - index) * LABEL_SPACE;
		for (int i = 0; i <= index; i++) {
			GLabel comb = new GLabel("C(" + index +"," + i +")");
			add(comb, x, y);
			x += LABEL_GAP + comb.getWidth();
		}
	}
	
	void drawNumbersLine(int index) {
		int x, y;
		double totalWidth = 0;
		for (int i = 0; i <= index; i++) {
			GLabel comb = new GLabel("" + combinations(index, i) + "");
			totalWidth += comb.getWidth();
		}
		totalWidth += index * LABEL_GAP;
		x = getWidth() / 2 - (int)totalWidth / 2;
		y = getHeight() - (NUMBER_OF_ROWS - index) * LABEL_SPACE;
		for (int i = 0; i <= index; i++) {
			GLabel comb = new GLabel("" + combinations(index, i) + "");
			add(comb, x, y);
			x += LABEL_GAP + comb.getWidth();
		}
	}
}

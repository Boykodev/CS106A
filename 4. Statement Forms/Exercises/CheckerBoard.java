/*
 * CheckerBoard.java
 * -----------------
 * Draws a checker board.
 */

import acm.program.*;
import acm.graphics.*;

public class CheckerBoard extends GraphicsProgram {
	private static final int ROWS = 8;
	private static final int SQUARE_SIDE = 50;
	private static final int OVAL_SIZE = (int) (SQUARE_SIDE * 0.75);
	int x, y;
	
	public void run() {
		boolean odd = true;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < (ROWS / 2); j++) {
				if (odd) {
					drawRectOval();
				} else {
					drawOvalRect();
				}
				x += SQUARE_SIDE * 2;
			}
			odd = (odd != true);
			newLine();
		}
	}

	private void drawRectOval() {
		add(new GRect(SQUARE_SIDE, SQUARE_SIDE), x, y);
		add(new GRect(SQUARE_SIDE, SQUARE_SIDE), x + SQUARE_SIDE, y);
		add(new GOval(OVAL_SIZE, OVAL_SIZE), x + SQUARE_SIDE + ((SQUARE_SIDE - OVAL_SIZE) / 2), y + ((SQUARE_SIDE - OVAL_SIZE) / 2));
	}

	private void drawOvalRect() {
		add(new GRect(SQUARE_SIDE, SQUARE_SIDE), x, y);
		add(new GOval(OVAL_SIZE, OVAL_SIZE), x + ((SQUARE_SIDE - OVAL_SIZE) / 2), y + ((SQUARE_SIDE - OVAL_SIZE) / 2));
		add(new GRect(SQUARE_SIDE, SQUARE_SIDE), x + SQUARE_SIDE, y);
	}
	
	private void newLine() {
		x = 0;
		y += SQUARE_SIDE;
	}
}
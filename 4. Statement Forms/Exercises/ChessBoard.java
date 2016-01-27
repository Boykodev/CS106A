/* Draws a board for chess game. */

import acm.program.*;
import acm.graphics.*;

public class ChessBoard extends GraphicsProgram {
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;
	int squareSide;
	int x, y;
	
	public void run() {
		squareSide = getHeight() / ROWS;
		boolean odd = true;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < (COLUMNS / 2); j++) {
				if (odd) {
					drawEmptyFilled();
				} else {
					drawFilledEmpty();
				}
				x += squareSide * 2;
			}
			odd = (odd != true);
			newLine();
		}
	}

	private void drawEmptyFilled() {
		GRect empty = new GRect(x, y, squareSide, squareSide);
		add(empty);
		GRect filled = new GRect(x + squareSide, y, squareSide, squareSide);
		filled.setFilled(true);
		add(filled);
	}

	private void drawFilledEmpty() {
		GRect filled = new GRect(x, y, squareSide, squareSide);
		filled.setFilled(true);
		add(filled);
		GRect empty = new GRect(x + squareSide, y, squareSide, squareSide);
		add(empty);
	}
	
	private void newLine() {
		x = 0;
		y += squareSide;
	}
}

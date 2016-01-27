import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class CheckersGraphics extends GraphicsProgram {

	private static final int CHECKERBOARD_SIZE = 8;
	private static final int SQUARE_SIZE = 50;
	private static final int CHECKER_SIZE = SQUARE_SIZE / 2;
	
	public void run() {
		initCheckerBoard();
		displayCheckerBoard();
	}
	
	private void initCheckerBoard() {
		checkerBoard = new GCompound[CHECKERBOARD_SIZE][CHECKERBOARD_SIZE];
		
		for (int i = 0; i < checkerBoard.length; i++) {
			for (int j = 0; j < checkerBoard[i].length; j++) {
				if (i % 2 == 0) {
					char[] col = {'_', 'b', '_', '-', '_', 'r', '_', 'r'};
					checkerBoard[i][j] = drawSquare(col[j]);
				} else {
					char[] col = {'b', '_', 'b', '_', '-', '_', 'r', '_'};
					checkerBoard[i][j] = drawSquare(col[j]);
				}
			}
		}
	}

	private GCompound drawSquare(char ch) {
		GCompound cell = new GCompound();
		GRect square = new GRect(SQUARE_SIZE, SQUARE_SIZE);
		switch (ch) {
		case '_':
			cell.add(square);
			return cell;
		case '-':
			square.setFillColor(Color.GRAY);
			square.setFilled(true);
			cell.add(square);
			return cell;
		case 'b': case 'r':
			GOval checker = new GOval(CHECKER_SIZE, CHECKER_SIZE);
			square.setFillColor(Color.GRAY);
			square.setFilled(true);
			cell.add(square);
			
			checker.setFilled(true);
			cell.add(checker, (SQUARE_SIZE - CHECKER_SIZE) / 2,
					(SQUARE_SIZE - CHECKER_SIZE) / 2);
			if (ch == 'b') {
				return cell;
			} else if (ch == 'r') {
				checker.setColor(Color.RED);
				return cell;
			}
		default:
			return null;
		}
	}

	private void displayCheckerBoard() {
		for (int i = 0; i < checkerBoard.length; i++) {
			for (int j = 0; j < checkerBoard[i].length; j++) {
				add(checkerBoard[i][j], i * SQUARE_SIZE, j * SQUARE_SIZE);
			}
		}
	}

	private GCompound[][] checkerBoard;
}

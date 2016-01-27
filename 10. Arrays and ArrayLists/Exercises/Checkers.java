import acm.program.*;

public class Checkers extends ConsoleProgram {

	private static final char WHITE_SQUARE = '⬜';
	private static final char BLACK_SQUARE = '⬛';
	
	private static final char RED_CHECKER = 'Ⓡ';
	private static final char BLACK_CHECKER = 'Ⓑ';
	
	private static final int CHECKERBOARD_SIZE = 8;
	
	public void run() {
		setFont("Helvetica-30");
		initCheckerBoard();
		displayCheckerBoard();
	}
	
	private void initCheckerBoard() {
		checkerBoard = new char[CHECKERBOARD_SIZE][CHECKERBOARD_SIZE];
		
		for (int i = 0; i < checkerBoard.length; i++) {
			for (int j = 0; j < checkerBoard[i].length; j++) {
				if (i % 2 == 0) {
					char[] col = new char[] {WHITE_SQUARE, BLACK_CHECKER, WHITE_SQUARE, BLACK_SQUARE,
							WHITE_SQUARE, RED_CHECKER, WHITE_SQUARE, RED_CHECKER};
					checkerBoard[i][j] = col[j];
				} else {
					char[] col = new char[]{BLACK_CHECKER, WHITE_SQUARE, BLACK_CHECKER, WHITE_SQUARE,
							BLACK_SQUARE, WHITE_SQUARE, RED_CHECKER, WHITE_SQUARE};
					checkerBoard[i][j] = col[j];
				}
			}
		}
	}

	private void displayCheckerBoard() {
		for (int i = 0; i < checkerBoard.length; i++) {
			for (int j = 0; j < checkerBoard[i].length; j++) {
				print(checkerBoard[j][i] + "  ");
			}
			println();
		}
	}

	private char[][] checkerBoard;
}

import acm.program.*;

public class ChessBoard extends ConsoleProgram {
	
	public void run() {
		char [][] chessBoard = new char [8][8];
		
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				initBoard(chessBoard, i, j);
			}
		}
		
		printBoard(chessBoard);
	}

	private void printBoard(char[][] chessBoard) {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				print(chessBoard[i][j]);
			}
			println();
		}
	}

	private void initBoard(char[][] chessBoard, int i, int j) {
		switch (i) {
		case 0:
			chessBoard[i][j] = mainRow(j);
			break;
		case 1:
			chessBoard[i][j] = 'p';
			break;
		case 6:
			chessBoard[i][j] = 'P';
			break;
		case 7:
			chessBoard[i][j] = Character.toUpperCase(mainRow(j));
			break;
		default:
			chessBoard[i][j] = '-';
			break;
		}
	}

	private char mainRow(int index) {
		switch (index) {
		case 0: case 7:
			return 'r';
		case 1: case 6:
			return 'n';
		case 2: case 5:
			return 'b';
		case 3:
			return 'q';
		case 4:
			return 'k';
		default:
			return '-';
		}
	}
	
}
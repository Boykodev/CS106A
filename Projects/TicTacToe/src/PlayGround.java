import acm.graphics.*;

public class PlayGround {
	
	private static final int ROWS = 3;
	private static final int COLS = 3;
	
	private static final char X = 'X';
	private static final char O = 'O';
	private static final char SPACE = ' ';
	
	PlayGround(int size) {
		field = new GCompound[ROWS][COLS];
		state = new char[ROWS][COLS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				field[i][j] = new GCompound();
				field[i][j].add(new GRect(size, size));
				
				state[i][j] = SPACE;
			}
		}
	}

	public void putX(GCompound[][] field, int row, int col) {
		GLabel x = new GLabel("X");
		x.setFont("Helvetica-25");
		field[row][col].add(x, (field[row][col].getWidth() - x.getWidth()) / 2,
				(field[row][col].getHeight() + x.getAscent()) / 2);
		state[row][col] = X;
	}
	
	public void putO(GCompound[][] field, int row, int col) {
		GLabel o = new GLabel("O");
		o.setFont("Helvetica-25");
		field[row][col].add(o, (field[row][col].getWidth() - o.getWidth()) / 2,
				(field[row][col].getHeight() + o.getAscent()) / 2);
		state[row][col] = O;
	}
	
	public boolean emptyLeft() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (isEmpty(i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isEmpty(int row, int col) {
		return state[row][col] == SPACE;
	}
	
	public boolean hasX(int row, int col) {
		return state[row][col] == X;
	}
	
	public boolean hasO(int row, int col) {
		return state[row][col] == O;
	}
	
	public boolean hasAny(int row, int col) {
		if (hasX(row, col)) {
			return true;
		} else if (hasO(row, col)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean gameOver() {
		int vert, horyz, diagR = 0, diagL = 0;
		for (int i = 0; i < ROWS; i++) {
			vert = 0;
			for (int j = 0; j < COLS; j++) {
				vert += state[i][j];
				if (j == COLS - 1 && state[i][j] != SPACE &&
						vert == state[i][j] * COLS) {
					return true;
				}
				horyz = 0;
				for (int k = 0; k < ROWS; k++) {
					horyz += state[k][j];
					if (k == j) {
						diagR += state[k][j];
					}
					if (k == COLS - j - 1) {
						diagL += state[k][j];
					}
					if (k == ROWS - 1 && state[k][j] != SPACE &&
							horyz == state[k][j] * ROWS) {
						return true;
					}
				}
				if (state[0][0] != SPACE && diagR == state[0][0] * ROWS ||
						state[0][COLS - 1] != SPACE && diagL == state[0][COLS - 1] * ROWS) {
					return true;
				}
			}
		}
		/*
		if (state[0][0] != SPACE && state[0][0] == state[0][1] && state[0][1] == state[0][2]) {
			return true;
		} else if (state[1][0] != SPACE && state[1][0] == state[1][1] && state[1][1] == state[1][2]) {
			return true;
		} else if (state[2][0] != SPACE && state[2][0] == state[2][1] && state[2][1] == state[2][2]) {
			return true;
		} else if (state[0][0] != SPACE && state[0][0] == state[1][0] && state[1][0] == state[2][0]) {
			return true;
		} else if (state[0][1] != SPACE && state[0][1] == state[1][1] && state[1][1] == state[2][1]) {
			return true;
		} else if (state[0][2] != SPACE && state[0][2] == state[1][2] && state[1][2] == state[2][2]) {
			return true;
		} else if (state[0][0] != SPACE && state[0][0] == state[1][1] && state[1][1] == state[2][2]) {
			return true;
		} else if (state[2][0] != SPACE && state[2][0] == state[1][1] && state[1][1] == state[0][2]) {
			return true;
		}
		*/
		return false;
	}
	
	public GCompound[][] getField() {
		return field;
	}
	
	public char[][] getState() {
		return state;
	}

	private GCompound[][] field;
	private char[][] state;
}

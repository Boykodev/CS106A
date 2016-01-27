import java.awt.Point;
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;

public class TicTacToe extends GraphicsProgram {

	private static final int SIZE = 50;
	private static final int EXTRA_X = 1;
	private static final int EXTRA_Y = 23;
	
	public void init() {
		gameMode = 1;
		
		pg = new PlayGround(SIZE);
		ai = new Ai();
		
		setSize(SIZE * pg.getField()[0].length +
				EXTRA_X, SIZE * pg.getField().length + EXTRA_Y);
	}
	
	public void run() {
		drawField();
		addMouseListeners();
	}
	
	private void newGame() {
		removeAll();
		pg = new PlayGround(SIZE);
		drawField();
	}

	private void drawField() {
		for (int i = 0; i < pg.getField().length; i++) {
			for (int j = 0; j < pg.getField()[0].length; j++) {
				add(pg.getField()[i][j], SIZE * i, SIZE * j);
			}
		}
	}
	
	public void mouseClicked(MouseEvent e){
		if (pg.gameOver() || !pg.emptyLeft()) {
			newGame();
			return;
		}
		Point cell = cellThatWasClicked(e.getPoint());
		int row = cell.x;
		int col = cell.y;
		
		if (pg.hasAny(row, col) || row == -1) {
			return;
		}
		
		if (gameMode == 0) {
			multiPlayer(row, col);
		} else if (gameMode == 1) {
			singlePlayer(row, col);
		}
	}
	
	private Point cellThatWasClicked(Point e) {
		GObject current = getElementAt(e.x, e.y);
		int row = -1, col = 0;
		if (current != null) {
			for (int i = 0; i < pg.getField().length; i++) {
				for (int j = 0; j < pg.getField()[0].length; j++) {
					if (current.equals(pg.getField()[i][j])) {
						row = i;
						col = j;
						break;
					}
				}
				if (row != -1) break;
			}	
		}
		return new Point(row, col);
	}

	private void singlePlayer(int row, int col) {
		pg.putX(pg.getField(), row, col);
		if (pg.gameOver()) return;
		ai.makeTurn(pg);
	}

	private void multiPlayer(int row, int col) {
		if (turnX) {
			pg.putX(pg.getField(), row, col);
			turnX = !turnX;
		} else {
			pg.putO(pg.getField(), row, col);
			turnX = !turnX;
		}
	}

	private Ai ai;
	private PlayGround pg;
	private int gameMode;
	private boolean turnX = true;
}
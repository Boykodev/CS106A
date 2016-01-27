import java.awt.event.*;

import acm.program.*;
import acm.graphics.*;

public class Frogger extends GraphicsProgram {

	public static final int SQSIZE = 75;
	public static final int NCOLS = 9;
	public static final int NROWS = 5;
	
	
	public void init() {
		setSize(SQSIZE * NCOLS, SQSIZE * NROWS);
		frog = new GImage("frog.png");
		frog.scale(0.1);
		frog.setLocation((SQSIZE * NCOLS - frog.getWidth()) / 2,
				(SQSIZE - frog.getHeight()) / 2 + SQSIZE * (NROWS - 1));
		add(frog);
		addMouseListeners();
	}
	
	public void run() {
		for (int i = 0; i < NROWS; i++) {
			for (int j = 0; j < NCOLS; j++) {
				add(new GRect(SQSIZE, SQSIZE), j * SQSIZE, i * SQSIZE);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		frogCenterX = frog.getX() + frog.getWidth() / 2;
		frogCenterY = frog.getY() + frog.getHeight() / 2;
		
		chooseDirection();
	}
	
	private void chooseDirection() {
		char direction;
		
		if (frogCenterY - mouseY > SQSIZE / 2 &&
				Math.abs(frogCenterX - mouseX) < SQSIZE / 2) {
			direction = 'U';
			jump(direction);
		} else if (mouseY - frogCenterY > SQSIZE / 2 &&
				Math.abs(frogCenterX - mouseX) < SQSIZE / 2) {
			direction = 'D';
			jump(direction);
		} else if (frogCenterX - mouseX > SQSIZE / 2 &&
				Math.abs(frogCenterY - mouseY) < SQSIZE / 2) {
			direction = 'L';
			jump(direction);
		} else if (mouseX - frogCenterX > SQSIZE / 2 &&
				Math.abs(frogCenterY - mouseY) < SQSIZE / 2) {
			direction = 'R';
			jump(direction);
		}
	}

	private void jump(char direction) {
		switch (direction) {
		case 'U':
			frog.move(0, -SQSIZE);
			break;
		case 'D':
			frog.move(0, SQSIZE);
			break;
		case 'L':
			frog.move(-SQSIZE, 0);
			break;
		case 'R':
			frog.move(SQSIZE, 0);
			break;
		default:
			break;
		}
	}
	
	private int mouseX;
	private int mouseY;
	
	private GImage frog;
	private double frogCenterX;
	private double frogCenterY;
}

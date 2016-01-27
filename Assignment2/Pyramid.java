/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 25;

/** Brick creation delay.*/
	private static final double DELAY = 25;
	
	int x, y;
	
	public void run() {
		/* You fill this in. */
		firstBrick();
		for(int i = 0; i < BRICKS_IN_BASE; i++) {
			for(int j = 0; j < BRICKS_IN_BASE - i; j++) {
				drawBrick();
				pause(DELAY);
				x += BRICK_WIDTH;
			}
			backToStart(i);
			newStair();
		}
	}

	private void backToStart(int i) {
		// TODO Auto-generated method stub
		x -= BRICK_WIDTH * (BRICKS_IN_BASE - i);
	}

	private void firstBrick() {
		// TODO Auto-generated method stub
		x = (getWidth() - BRICKS_IN_BASE * BRICK_WIDTH) / 2;
		y = getHeight() - BRICK_HEIGHT;
	}

	private void drawBrick() {
		// TODO Auto-generated method stub
		add(new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT ));
	}

	private void newStair() {
		// TODO Auto-generated method stub
		x += BRICK_WIDTH / 2;
		y -= BRICK_HEIGHT;
	}
}
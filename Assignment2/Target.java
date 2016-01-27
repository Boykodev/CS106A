/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	private static final int OUTER_WIDTH = 360;
	private static final int WHITE_WIDTH = (int)(OUTER_WIDTH * 0.65);
	private static final int INNER_WIDTH = (int)(OUTER_WIDTH * 0.3);

	public void run() {
		int midX, midY;
		int outerX, outerY;
		int whiteX, whiteY;
		int innerX, innerY;
		midX = getWidth() / 2;
		midY = getHeight() / 2;
		outerX = midX - OUTER_WIDTH / 2;
		outerY = midY - OUTER_WIDTH / 2;
		whiteX = midX - WHITE_WIDTH / 2;
		whiteY = midY - WHITE_WIDTH / 2;
		innerX = midX - INNER_WIDTH / 2;
		innerY = midY - INNER_WIDTH / 2;
		drawOuterCircle(outerX, outerY, OUTER_WIDTH);
		drawWhiteCircle(whiteX, whiteY, WHITE_WIDTH);
		drawInnerCircle(innerX, innerY, INNER_WIDTH);
	}

	private void drawOuterCircle(int x, int y, int width) {
		// TODO Auto-generated method stub
		GOval outer = new GOval(x, y, width, width);
		outer.setColor(Color.RED);
		outer.setFilled(true);
		add(outer);
	}

	private void drawWhiteCircle(int x, int y, int width) {
		// TODO Auto-generated method stub
		GOval white = new GOval(x, y, width, width);
		white.setColor(Color.WHITE);
		white.setFilled(true);
		add(white);
	}

	private void drawInnerCircle(int x , int y, int width) {
		// TODO Auto-generated method stub
		GOval inner = new GOval(x, y, width, width);
		inner.setColor(Color.RED);
		inner.setFilled(true);
		add(inner);
	}
}
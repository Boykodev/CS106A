/*
 * Draws a robot face.
 */

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class RobotFace extends GraphicsProgram {
	private static final int HEAD_WIDTH = 220;
	private static final int HEAD_HEIGHT = (int)(HEAD_WIDTH * 1.5);
	private static final int EYE_RADIUS = HEAD_WIDTH / 10;
	private static final int MOUTH_WIDTH = HEAD_WIDTH / 2;
	private static final int MOUTH_HEIGHT = MOUTH_WIDTH / 2;
	
	public void run() {
		drawHead();
		drawEyes();
		drawMouth();
	}
	private void drawHead() {
		GRect head = new GRect(HEAD_WIDTH, HEAD_HEIGHT);
		head.setFillColor(Color.LIGHT_GRAY);
		head.setFilled(true);
		add(head, getWidth() / 2 - HEAD_WIDTH / 2, getHeight() / 2 - HEAD_HEIGHT / 2);
		
	}
	private void drawEyes() {
		GOval leftEye = filledCircle(EYE_RADIUS, this.getWidth() / 2 - HEAD_WIDTH / 4, this.getHeight() / 2 - HEAD_HEIGHT / 4, Color.YELLOW);
		GOval rightEye = filledCircle(EYE_RADIUS, this.getWidth() / 2 + HEAD_WIDTH / 4, this.getHeight() / 2 - HEAD_HEIGHT / 4, Color.YELLOW);
		
		add(leftEye);
		add(rightEye);
	}
	private void drawMouth() {
		GRect mouth = new GRect(MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		add(mouth, getWidth() / 2 - MOUTH_WIDTH / 2, getHeight() / 2 + HEAD_HEIGHT / 4 - MOUTH_HEIGHT);
	}
	
	private GOval filledCircle(int radius, int x, int y, Color color) {
		GOval circle = new GOval(x - radius, y - radius, radius * 2, radius * 2);
		circle.setFilled(true);
		circle.setColor(color);
		return circle;
	}
}

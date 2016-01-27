/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	private static final int TILE_WIDTH = 222;
	private static final int TILE_HEIGHT = 66;
	
	public void run() {
		drawUpperTile(canvasCenterX(), canvasCenterY());
		drawMiddleTile(canvasCenterX(), canvasCenterY());
		drawLeftTile(canvasCenterX(), canvasCenterY());
		drawRightTile(canvasCenterX(), canvasCenterY());
		drawLines(canvasCenterX(), canvasCenterY());
	}

	private int canvasCenterX() {
		// TODO Auto-generated method stub
		return getWidth() / 2;
	}
	
	private int canvasCenterY() {
		// TODO Auto-generated method stub
		return getHeight() / 2 - TILE_HEIGHT;
	}

	private void drawUpperTile(int x, int y) {
		// TODO Auto-generated method stub
		GRect upper = new GRect(x - TILE_WIDTH / 2, y - TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(upper);
		GLabel label = new GLabel("Program");
		label.setFont("Helvetica-bold-20");
		add(label, x - label.getWidth() / 2, y - TILE_HEIGHT / 2 + label.getAscent() / 2);
	}

	private void drawMiddleTile(int x, int y) {
		// TODO Auto-generated method stub
		GRect middle = new GRect(x - TILE_WIDTH / 2, y + TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(middle);
		GLabel label = new GLabel("GraphicsProgram");
		label.setFont("Helvetica-bold-20");
		add(label, x - label.getWidth() / 2, y + TILE_HEIGHT * 1.5 + label.getAscent() / 2);
	}

	private void drawLeftTile(int x, int y) {
		// TODO Auto-generated method stub
		GRect left = new GRect(x - (TILE_WIDTH / 2 + TILE_SPACE + TILE_WIDTH), y + TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(left);
		GLabel label = new GLabel("ConsoleProgram");
		label.setFont("Helvetica-bold-20");
		add(label, x - label.getWidth() / 2 - TILE_WIDTH - TILE_SPACE, y + TILE_HEIGHT * 1.5 + label.getAscent() / 2);
	}

	private void drawRightTile(int x, int y) {
		// TODO Auto-generated method stub
		GRect right = new GRect(x + (TILE_WIDTH / 2 + TILE_SPACE), y + TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(right);
		GLabel label = new GLabel("DialogProgram");
		label.setFont("Helvetica-bold-20");
		add(label, x - label.getWidth() / 2 + TILE_WIDTH + TILE_SPACE, y + TILE_HEIGHT * 1.5 + label.getAscent() / 2);
	}
	
	private void drawLines(int x, int y) {
		add(new GLine(x, y, x - (TILE_SPACE + TILE_WIDTH), y + TILE_HEIGHT));
		add(new GLine(x, y, x, y + TILE_HEIGHT));
		add(new GLine(x, y, x + (TILE_SPACE + TILE_WIDTH), y + TILE_HEIGHT));
	}
}
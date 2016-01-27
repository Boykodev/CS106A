/*
 * Displays a square that
 * randomly changes color.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class ColorChangingSquare extends GraphicsProgram {
	private static final int SQUARE_SIDE = 100;
	private static final int PAUSE_TIME = 1000; // in milliseconds
	
	public void run() {
		GRect square = new GRect(SQUARE_SIDE, SQUARE_SIDE);
		square.setFilled(true);
		add(square, (getWidth() - SQUARE_SIDE) / 2,
				(getHeight() - SQUARE_SIDE) / 2);
		
		while(true) {
			square.setColor(rgen.nextColor());
			pause(PAUSE_TIME);
		}
	}
	
	//private RandomGenerator rgen = new RandomGenerator();
	private RandomGenerator rgen = RandomGenerator.getInstance();
}

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/** Moves a label across the display.*/
public class TimeSquare extends GraphicsProgram {
	private static final String HEADLINE = "JUST DO IT!";
	private static final double PAUSE_TIME = 20;
	private static final int DELTA = 1;
	
	private GLabel headline;
	
	private RandomGenerator rgen = new RandomGenerator();
	
	public void run() {
		boolean first = true;
		setSize(300, 100);
		while (true) {
			headline = new GLabel(HEADLINE);
			headline.setFont("Times-72");
			add(headline, getWidth(), (headline.getAscent() + getHeight()) / 2);
			if (first) {
				first = false;
			} else {
				headline.setColor(rgen.nextColor());
			}
			while (isOnCanvas()) {
				headline.move(-DELTA, 0);
				pause(PAUSE_TIME);
			}
		}
	}

	private boolean isOnCanvas() {
		return headline.getX() + headline.getWidth() > 0;
	}
}
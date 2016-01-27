import acm.util.*;
import acm.program.*;
import acm.graphics.*;

public class ProbabilityBoard extends GraphicsProgram {

	private static final int BOUNCES = 9;
	
	private static final double DELAY = 500;
	
	public void run() {
		container = new Container();
		add(container, (getWidth() - container.WIDTH) / 2,
				(getHeight() - container.HEIGHT) / 2);
		
		while (!container.isFull()) {
			container.dropTheMarble(getMarble(), randomChannel());
			pause(DELAY);
		}
	}

	private GOval getMarble() {
		GOval marble = new GOval(container.GAP, container.GAP);
		marble.setColor(rgen.nextColor());
		marble.setFilled(true);
		return marble;
	}

	private int randomChannel() {
		int shift = 0;
		for (int i = 0; i < BOUNCES; i++) {
			if (rgen.nextBoolean()) {
				shift++;
			} else {
				shift--;
			}
		}
		switch (shift) {
		case -9:
			return 1;
		case -7:
			return 2;
		case -5:
			return 3;
		case -3:
			return 4;
		case -1:
			return 5;
		case 1:
			return 6;
		case 3:
			return 7;
		case 5:
			return 8;
		case 7:
			return 9;
		case 9:
			return 10;
		default:
			return 0;
		}
	}
	
	private Container container;
	private RandomGenerator rgen = new RandomGenerator();
}

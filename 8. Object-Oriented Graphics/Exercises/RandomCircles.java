import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/**
 * Draws a random circles on the canvas
 */
public class RandomCircles extends GraphicsProgram {
	
	private static final int MIN_RADIUS = 5;
	private static final int MAX_RADIUS = 50;
	
	private RandomGenerator rgen = new RandomGenerator();
	private GOval circle;
	
	public void run() {
		int mode = 1;
		switch (mode) {
		case 0:
			for (int i = 0; i < 100; i++) { setup(); pause(100); } break;
		case 1:
			for (int i = 0; i < 100; i++) { setupX(); pause(100); } break;
		default:
			break;
		}
	}

	public void setup() {
		while (true) {
			int radius = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
			int x = rgen.nextInt(0, this.getWidth());
			int y = rgen.nextInt(0, this.getHeight());
			circle = new GOval(x, y, radius * 2, radius * 2);
			if (isInsideCanvas(x, y, radius)) {
				circle.setColor(rgen.nextColor());
				circle.setFilled(true);
				add(circle);
				break;
			}
		}
	}
	
	public void setupX() {
		while (true) {
			int radius = MAX_RADIUS;
			int x = rgen.nextInt(0, this.getWidth());
			int y = rgen.nextInt(0, this.getHeight());
			circle = new GOval(x, y, radius * 2, radius * 2);
			if (isInsideCanvas(x, y, radius)) {
				circle.setColor(rgen.nextColor());
				circle.setFilled(true);
				double scale = 0;
				double tempRadius = 0;
				while (scale <= 1) {
					tempRadius = radius * scale;
					scale += 0.03;
					pause(20);
					circle.setSize((radius * 2) * scale, (radius * 2) * scale);
					
					if (tempRadius == 0) {
						circle.movePolar(radius - (radius * scale), -45);
					} else {
						circle.movePolar((radius * scale) - tempRadius, 135);
					}
					
					add(circle);
				}
				break;
			}
		}
	}
	
	private boolean isInsideCanvas(int x, int y, int r) {
		return (circle.getX() + r * 2 <= this.getWidth() &&
				circle.getY() + r * 2 <= this.getHeight());
	}
}
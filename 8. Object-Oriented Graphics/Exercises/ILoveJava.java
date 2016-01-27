import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/** Bounces a label around the canvas.*/
public class ILoveJava extends GraphicsProgram {
	
	private static final double DELAY = 10;
	private static final double VEL_X = 2;
	private static final double VEL_Y = 2;
	
	private int out;
	private int cooldown;
	private GLabel label;
	
	private double velX = VEL_X;
	private double velY = VEL_Y;
	
	private RandomGenerator rgen = new RandomGenerator();
	
	public void init() {
		setLabel();
		waitForClick();
		while(true) {
			moveLabel();
			if (isLabelOut() && cooldown == 0) changeDirection();
			pause(DELAY);
			if (cooldown != 0) cooldown--;
		}
	}

	private void moveLabel() {
		label.move(velX, velY);
	}

	private void changeDirection() {
		cooldown = 3;
		label.setColor(rgen.nextColor());
		switch (out) {
		case 1:
		case 2:
			velX = -velX;
			return;
		case 3:
		case 4:
			velY = -velY;
			return;
		default:
			return;
		}
	}

	private boolean isLabelOut() {
		if (label.getX() < 0) {
			out = 1;
			return true;
		}
		else if (label.getX() + label.getWidth() > getWidth()) {
			out = 2;
			return true;
		}
		else if (label.getY() - label.getAscent() < 0) {
			out = 3;
			return true;
		}
		else if (label.getY() + label.getDescent() > getHeight()) {
			out = 4;
			return true;
		}
		return false;
	}

	private void setLabel() {
		label = new GLabel("I Love Java");
		label.setFont("Helvetica-48");
		
		double centerX = (getWidth() - label.getWidth()) / 2;
		double centerY = (getHeight() - label.getAscent()) / 2;
		add(label, centerX, centerY);	
	}
}

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class HeartProgram extends GraphicsProgram {
	
	private double centerX;
	private double centerY;
	private Heart heart;
	
	public void init() {
		heart = new Heart(300, 300, Color.RED, true);
		
		centerX = (getWidth() - heart.getWidth()) / 2;
		centerY = (getHeight() - heart.getHeight()) / 2;
		
		add(heart, centerX, centerY);
	}
}

/** Draws a heart.*/
class Heart extends GCompound {

	public Heart() { this(50, 50, Color.RED, true); }
	
	public Heart(int width, int height) { this(width, height, Color.BLACK, false); }
	
	public Heart(int width, int height, Color color) { this(width, height, color, false); }
	
	public Heart(int width, int height, Color color, boolean isFilled) {
		drawSemiCircles(width, height, isFilled);
		
		if (isFilled) {
			drawPolygon(width, height, isFilled);
		}
		else {
			drawLines(width, height);
		}
		this.setColor(color);
	}
	
	private void drawSemiCircles(int width, int height, boolean isFilled) {
		
		GArc leftPart = new GArc(width * 0.58, height * 0.66, 45, 180);
		GArc rightPart = new GArc(width * 0.58, height * 0.66, -45, 180);
		
		leftPart.setFilled(isFilled);
		rightPart.setFilled(isFilled);
		
		add (leftPart);
		add (rightPart, width * 0.41, 0);
	}
	
	private void drawLines(int width, int height) {
		
		GLine leftLine = new GLine(width * 0.0812, height * 0.561, width * 0.4988, height);
		
		GLine rigthLine = new GLine(width * 0.9106, height * 0.561, width * 0.4988, height);
		
		add(leftLine);
		add(rigthLine);
	}
	
	private void drawPolygon(int width, int height, boolean isFilled) {
		GPolygon diamond = new GPolygon();
		
		diamond.addVertex(width * 0.4988, height);
		diamond.addVertex(width * 0.0812, height * 0.561);
		diamond.addVertex(width * 0.4988, height * 0.091);
		diamond.addVertex(width * 0.9106, height * 0.561);
		
		diamond.setFilled(isFilled);
		
		add(diamond);
	}
}

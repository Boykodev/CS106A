import java.awt.Color;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;

/** Graphical program test */
public class GTest extends GraphicsProgram {
	
	GLabel label;
	

	private static final double WIDTH = 300;
	
	private static final double HEIGHT = 250;

	public void run() {
		this.addMouseListeners();
		drawSemiCircles();
		drawLines();


		//add(new GRect(WIDTH, HEIGHT));
	}
	
	private void drawSemiCircles() {
		
		GArc leftPart = new GArc(WIDTH * 0.58, HEIGHT * 0.66, 45, 180);
		GArc rightPart = new GArc(WIDTH * 0.58, HEIGHT * 0.66, -45, 180);
		
		add (leftPart, 0, 0);
		add (rightPart, WIDTH * 0.41, 0);
	}
	private void drawLines() {
		
		GLine leftLine = new GLine(WIDTH * 0.0812, HEIGHT * 0.561, WIDTH * 0.4988, HEIGHT);
		GLine rigthLine = new GLine(WIDTH * 0.9106, HEIGHT * 0.561, WIDTH * 0.4988, HEIGHT);
		
		add(leftLine);
		add(rigthLine);
	}
	
	public void mouseMoved(MouseEvent e) {
	if (label != null) remove(label);
	label = new GLabel("X: " + e.getX() + " Y: " + e.getY());
	add(label, (getWidth() - label.getWidth()) / 2, (getHeight() - label.getHeight()) / 2);
	
	}
}
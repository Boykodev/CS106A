import java.awt.event.*;

import acm.graphics.*;
import acm.program.*;

/** Draws lines using rubberbanding technique.*/
public class DrawLines extends GraphicsProgram {
	
	private GLine line;

	public void init() { addMouseListeners(); }
	
	public void mousePressed(MouseEvent e) {
		GPoint start = new GPoint(e.getPoint());
		line = new GLine(start.getX(), start.getY(), start.getX(), start.getY());
		add(line);
	}
	
	public void mouseDragged(MouseEvent e) {
		GPoint last = new GPoint(e.getPoint());
		line.setEndPoint(last.getX(), last.getY());
	}
}
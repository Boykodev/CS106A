import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/** Allows users to draw a rectangle. */
public class DrawRectangle extends GraphicsProgram {
	
	private GRect currentRect;
	private GObject draggedObject;
	
	private double startX;
	private double startY;
	
	private RandomGenerator rgen = new RandomGenerator();

	public void run() { addMouseListeners(); }
	
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
		if (getElementAt(startX, startY) != null) {
			draggedObject = getElementAt(startX, startY);
			return;
		}
		currentRect = new GRect(startX, startY, 0, 0);
		currentRect.setColor(rgen.nextColor());
		currentRect.setFilled(true);
		add(currentRect);
	}
	
	public void mouseDragged(MouseEvent e) {
		if (draggedObject != null) {
			draggedObject.setLocation(e.getX() - draggedObject.getWidth() / 2,
					e.getY() - draggedObject.getHeight() / 2);
			return;
		}
		double x = Math.min(e.getX(), startX);
		double y = Math.min(e.getY(), startY);
		double width = Math.abs(e.getX() - startX);
		double height = Math.abs(e.getY() - startY);
		currentRect.setBounds(x, y, width, height);
	}
	
	public void mouseReleased(MouseEvent e) { draggedObject = null; }
	
	public void mouseClicked(MouseEvent e) {
		GObject obj = getElementAt(e.getX(), e.getY());
		if (obj != null) obj.sendToFront();
	}
}
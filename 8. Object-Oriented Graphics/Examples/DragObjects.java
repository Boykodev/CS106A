import java.awt.Color;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/** Allows to drag objects with a mouse */
public class DragObjects extends GraphicsProgram {
	private static final int MIN_SIZE = 50;
	private static final int MAX_SIZE = 100;
	private static final double PAUSE_TIME = 100;
	private static final int SHAPES = 10;
	
	private int lastX;
	private int lastY;
	private GObject obj;
	private GObject gobj;
	private Reset reset;
	private RandomGenerator rgen = new RandomGenerator();
	
	public void run() {
		setup(SHAPES, PAUSE_TIME);
		reset = new Reset();
		add(reset);
		addMouseListeners();
	}

	private void setup(int i, double pause) {
		while (i > 0) {
			int size = rgen.nextInt(MIN_SIZE, MAX_SIZE);
			int x = rgen.nextInt(0, this.getWidth());
			int y = rgen.nextInt(0, this.getHeight());
			boolean oval = rgen.nextBoolean();
			if (oval) {
				obj = new GOval(x, y, size, size);
			} else {
				obj = new GRect(x, y, size, size);
			}
			
			if (isInsideCanvas(size)) {
				obj.setColor(rgen.nextColor());
				if (oval) {
					((GOval) obj).setFilled(true);
				} else {
					((GRect) obj).setFilled(true);
				}
				pause(pause);
				add(obj);
				i--;
			}
		}
	}
	
	private boolean isInsideCanvas(int size) {
		return (obj.getX() + size <= this.getWidth() &&
				obj.getY() + size <= this.getHeight());
	}
	
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
		gobj = getElementAt(lastX, lastY);
	}
	
	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - lastX, e.getY() - lastY);
			lastX = e.getX();
			lastY = e.getY();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (gobj.equals(reset)) {
			removeAll();
			setup(SHAPES, 0);
			reset = new Reset();
			add(reset);
		} else if (gobj != null) gobj.sendToFront();
	}
};

class Reset extends GCompound {
	private static final int RESET_W = 100;
	private static final int RESET_H = 50;
	
	private GRect reset;
	
	public Reset() {
		reset = new GRect(RESET_W, RESET_H);
		reset.setFilled(true);
		reset.setColor(Color.RED);
		add(reset, 0, 0);
		GLabel label = new GLabel("RESET");
		label.setColor(Color.WHITE);
		label.setFont("Times-28");
		add(label, (RESET_W - label.getWidth()) / 2,
				(RESET_H + label.getAscent()) / 2);
	}
};
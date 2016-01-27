import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;

/** Simulates signal towers from LOTR movie.*/
public class BeaconsOfGondor extends GraphicsProgram {
	
	private static final int TOTAL_TOWERS = 9;
	private static final int TOWERS_WIDTH = 20;
	private static final int TOWERS_HEIGHT = 100;
	
	public void init() {
		this.setSize(800, 200);
		
		createSignalTowers(TOWERS_WIDTH, TOWERS_HEIGHT);
		
		drawTowers();
		
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		GObject obj = getElementAt(e.getX(), e.getY());
		
		if (obj != null) {
			kindleTowers(obj);
		}
	}
	
	private void kindleTowers(GObject obj) {
		if (obj == minasTirith) {
			minasTirith.signal();
		} else if (obj == amonDin) {
			amonDin.signal();
		} else if (obj == eilenach) {
			eilenach.signal();
		} else if (obj == nardol) {
			nardol.signal();
		} else if (obj == erelas) {
			erelas.signal();
		} else if (obj == calenhad) {
			calenhad.signal();
		} else if (obj == halifirien) {
			halifirien.signal();
		} else if (obj == rohan) {
			rohan.signal();
		}
	}

	private void drawTowers() {
		double centerY = (getHeight() - rohan.getHeight()) / 2;
		double gap = (getWidth() - (getWidth() * 0.1 + TOWERS_WIDTH)) / (TOTAL_TOWERS - 1);
		
		add(minasTirith, 0.05 * getWidth(), centerY);
		add(amonDin, 0.05 * getWidth() + gap, centerY);
		add(eilenach, 0.05 * getWidth() + gap * 2, centerY);
		add(nardol, 0.05 * getWidth() + gap * 3, centerY);
		add(erelas, 0.05 * getWidth() + gap * 4, centerY);
		add(minRimmon, 0.05 * getWidth() + gap * 5, centerY);
		add(calenhad, 0.05 * getWidth() + gap * 6, centerY);
		add(halifirien, 0.05 * getWidth() + gap * 7, centerY);
		add(rohan, 0.05 * getWidth() + gap * 8, centerY);
	}

	private void createSignalTowers(double w, double h) {
		rohan = new SignalTower("Rohan", null, w, h);
		halifirien = new SignalTower("Halifirien", rohan, w, h);
		calenhad = new SignalTower("Calenhad", halifirien, w, h);
		minRimmon = new SignalTower("Min-Rimmon", calenhad, w, h);
		erelas = new SignalTower("Erelas", minRimmon, w, h);
		nardol = new SignalTower("Nardol", erelas, w, h);
		eilenach = new SignalTower("Eilenach", nardol, w, h);
		amonDin = new SignalTower("Amon Din", eilenach, w, h);
		minasTirith = new SignalTower("Minas Tirith", amonDin, w, h);
	}
	
	private SignalTower rohan;
	private SignalTower halifirien;
	private SignalTower calenhad;
	private SignalTower minRimmon;
	private SignalTower erelas;
	private SignalTower nardol;
	private SignalTower eilenach;
	private SignalTower amonDin;
	private SignalTower minasTirith;
}

class SignalTower extends GCompound {
	
	SignalTower(String name, SignalTower nextTower, double width, double height) {
		rect = new GRect(width, height);
		add(rect);
		
		GLabel label = new GLabel(name);
		add(label, (rect.getWidth() - label.getWidth()) / 2, height + label.getHeight());
		
		this.next = nextTower;
	}
	
	void signal() {
		lightCurrentTower();
		if (next != null) {
			next.signal();
		}
	}
	
	void lightCurrentTower() {
		rect.setColor(Color.RED);
		rect.setFilled(true);
	}

	private GRect rect;
	private SignalTower next;
}

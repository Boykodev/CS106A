import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

/** Program draws a Halloween pumpkin.*/
public class DrawPumpkin extends GraphicsProgram {
	public void init() {
		Pumpkin pumpkin = new Pumpkin(300);
		
		double centerX = (getWidth() - pumpkin.getWidth()) / 2;
		double centerY = (getHeight() - pumpkin.getHeight()) / 2;
		
		add(pumpkin, centerX, centerY);
	}
}

class Pumpkin extends GCompound {
	
	/* Scales:*/
	private static final double STEM_H = 0.07;
	private static final double STEM_W = 0.05;
	private static final double NOSE = 0.15;
	private static final double EYE = 0.15;
	private static final double MOUTH = 0.05;
	
	private double size;
	
	private GRect stem;
	private GOval head;
	private GPolygon nose;
	private GPolygon mouth;
	private GPolygon leftEye;
	private GPolygon rightEye;
	
	public Pumpkin(double size) {
		this.size = size;
		addStem();
		addHead();
		addNose();
		addEyes();
		addMouth();
	}

	private void addHead() {
		head = new GOval(size, size);
		head.setColor(Color.ORANGE);
		head.setFilled(true);
		add(head);
	}

	private void addStem() {
		stem = new GRect(size * STEM_W, size * STEM_H);
		stem.setFilled(true);
		add(stem, (size - size * STEM_W) / 2, -(size * STEM_H));
	}

	private void addNose() {
		nose = new GPolygon();
		nose.addVertex(0, -(size * NOSE) / 2);
		nose.addVertex((size * NOSE) / 2, (size * NOSE) / 2);
		nose.addVertex(-(size * NOSE) / 2, (size * NOSE) / 2);
		nose.setFilled(true);
		add(nose, size / 2, size / 2);
	}

	private void addEyes() {
		leftEye = new GPolygon();
		leftEye.addVertex(-(size * EYE) / 2, -(size * EYE) / 2);
		leftEye.addVertex((size * EYE) / 2, -(size * EYE) / 2);
		leftEye.addVertex(0, (size * EYE) / 2);
		leftEye.setFilled(true);
		add(leftEye, size / 3, size / 3);
		
		rightEye = new GPolygon();
		rightEye.addVertex(-(size * EYE) / 2, -(size * EYE) / 2);
		rightEye.addVertex((size * EYE) / 2, -(size * EYE) / 2);
		rightEye.addVertex(0, (size * EYE) / 2);
		rightEye.setFilled(true);
		add(rightEye, size / 1.5, size / 3);
	}

	private void addMouth() {
		mouth = new GPolygon();
		mouth.addVertex(0, 0);
		mouth.addPolarEdge(size * MOUTH, 225);
		mouth.addPolarEdge(size * MOUTH, 135);
		mouth.addPolarEdge(size * MOUTH, 225);
		mouth.addPolarEdge(size * MOUTH, 135);
		mouth.addPolarEdge(size * MOUTH, 225);
		mouth.addPolarEdge((size * MOUTH) * 2, 315);
		mouth.addPolarEdge(size * MOUTH, 45);
		mouth.addPolarEdge(size * MOUTH, 315);
		mouth.addPolarEdge(size * MOUTH, 45);
		mouth.addPolarEdge(size * MOUTH, 315);
		mouth.addPolarEdge(size * MOUTH, 45);
		mouth.addPolarEdge(size * MOUTH, 315);
		mouth.addPolarEdge((size * MOUTH) * 2, 45);
		mouth.addPolarEdge(size * MOUTH, 135);
		mouth.addPolarEdge(size * MOUTH, 225);
		mouth.addPolarEdge(size * MOUTH, 135);
		mouth.addPolarEdge(size * MOUTH, 225);
		
		mouth.setFilled(true);
		
		add(mouth, size / 2, size / 1.5);
	}
	
	public void setSize(double size) { this.size = size; }
}

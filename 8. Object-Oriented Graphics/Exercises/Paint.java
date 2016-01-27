import java.awt.Color;
import java.awt.event.*;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/** Simple drawing app.*/
public class Paint extends GraphicsProgram {
	
	private static final double BUTTON_SIZE = 0.075;
	
	private GRect currentRect;
	private GOval currentOval;
	private GLine currentLine;
	
	private double startX;
	private double startY;
	
	private Color currentColor = Color.BLACK;
	private RandomGenerator rgen = new RandomGenerator();
	
	private GCompound button1;
	private GCompound button2;
	private GCompound button3;
	private GCompound button4;
	private GCompound button5;
	private GCompound button6;
	private GCompound button7;
	private GCompound button8;
	private GCompound button9;
	private GCompound button10;
	private GCompound button11;
	private GCompound button12;
	
	private int shape;

	private GRect currentRandom;

	public void init() {
		addPanel();
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
		
		if (setButton()) return;
		
		addShapes();
	}
	
	public void mouseDragged(MouseEvent e) {
		drawShapes(e.getX(), e.getY());
	}
	
	private void addShapes() {
		switch (shape) {
		case 1:
			currentRect = new GRect(startX, startY, 0, 0);
			currentRect.setColor(currentColor);
			currentRect.setFilled(true);
			add(currentRect);
			return;
		case 2:
			currentRect = new GRect(startX, startY, 0, 0);
			currentRect.setColor(currentColor);
			add(currentRect);
			return;
		case 3:
			currentOval = new GOval(startX, startY, 0, 0);
			currentOval.setColor(currentColor);
			currentOval.setFilled(true);
			add(currentOval);
			return;
		case 4:
			currentOval = new GOval(startX, startY, 0, 0);
			currentOval.setColor(currentColor);
			add(currentOval);
			return;
		case 5:
			currentLine = new GLine(startX, startY, startX, startY);
			currentLine.setColor(currentColor);
			add(currentLine);
		case 7:
			currentLine = new GLine(startX, startY, startX, startY);
			currentLine.setColor(currentColor);
			add(currentLine);
		default:
			return;
		}
	}

	private void drawShapes(double currentX, double currentY) {
		double x, y, width, height;
		
		switch (shape) {
		case 1:
		case 2:
			if (!isButton(currentX, currentY)) {
			x = Math.min(currentX, startX);
			y = Math.min(currentY, startY);
			width = Math.abs(currentX - startX);
			height = Math.abs(currentY - startY);
			currentRect.setBounds(x, y, width, height);
			}
			return;
		case 3:
		case 4:
			if (!isButton(currentX, currentY)) {
			x = Math.min(currentX, startX);
			y = Math.min(currentY, startY);
			width = Math.abs(currentX - startX);
			height = Math.abs(currentY - startY);
			currentOval.setBounds(x, y, width, height);
			}
			return;
		case 5:
			if (!isButton(currentX, currentY)) {
				currentLine.setEndPoint(currentX, currentY);
				currentLine = new GLine(currentX, currentY, currentX, currentY);
				currentLine.setColor(currentColor);
				add(currentLine);
			}
			return;
		case 7:
			if (!isButton(currentX, currentY)) {
				currentLine.setEndPoint(currentX, currentY);
				currentLine = new GLine(startX, startY, startX, startY);
				currentLine.setColor(currentColor);
				add(currentLine);
			}
			return;
		default:
			return;
		}
	}
	
	private boolean setButton() {
		if (isButton(startX, startY)) {
			if (getElementAt(startX, startY) == button1) {
				shape = 1;
				return true;
			}
			else if (getElementAt(startX, startY) == button2) {
				shape = 2;
				return true;
			}
			else if (getElementAt(startX, startY) == button3) {
				shape = 3;
				return true;
			}
			else if (getElementAt(startX, startY) == button4) {
				shape = 4;
				return true;
			}
			else if (getElementAt(startX, startY) == button5) {
				shape = 5;
				return true;
			}
			else if (getElementAt(startX, startY) == button6) {
				removeAll();
				addPanel();
				return true;
			}
			else if (getElementAt(startX, startY) == button7) {
				shape = 7;
				return true;
			}
			else if (getElementAt(startX, startY) == button8) {
				currentColor = Color.RED;
				return true;
			}
			else if (getElementAt(startX, startY) == button9) {
				currentColor = Color.GREEN;
				return true;
			}
			else if (getElementAt(startX, startY) == button10) {
				currentColor = Color.BLUE;
				return true;
			}
			else if (getElementAt(startX, startY) == button11) {
				currentColor = Color.BLACK;
				return true;
			}
			else if (getElementAt(startX, startY) == button12) {
				currentColor = rgen.nextColor();
				currentRandom.setFillColor(currentColor);
				return true;
			}
		}
		return false;
	}
	
	private boolean isButton(double x, double y) {
		return getElementAt(x, y) == button1 || getElementAt(x, y) == button2 ||
		getElementAt(x, y) == button3 || getElementAt(x, y) == button4 ||
		getElementAt(x, y) == button5 || getElementAt(x, y) == button6 ||
		getElementAt(x, y) == button7 || getElementAt(x, y) == button8 ||
		getElementAt(x, y) == button9 || getElementAt(x, y) == button10 ||
		getElementAt(x, y) == button11 || getElementAt(x, y) == button12;
	}

	private void addPanel() {
		button1 = new GCompound();
		button2 = new GCompound();
		button3 = new GCompound();
		button4 = new GCompound();
		button5 = new GCompound();
		button6 = new GCompound();
		button7 = new GCompound();
		button8 = new GCompound();
		button9 = new GCompound();
		button10 = new GCompound();
		button11 = new GCompound();
		button12 = new GCompound();
		
		drawButtons();
		
		double step = 0;
		add(button1);
		
		step += getHeight() * BUTTON_SIZE;
		add(button2, 0, step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button3, 0, step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button4, 0, step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button5, 0, step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button6, 0, step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button7, 0, step);
		
		step = 0;
		
		add(button8, getWidth() - button8.getWidth(), step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button9, getWidth() - button9.getWidth(), step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button10, getWidth() - button10.getWidth(), step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button11, getWidth() - button11.getWidth(), step);
		
		step += getHeight() * BUTTON_SIZE;
		add(button12, getWidth() - button12.getWidth(), step);
		
	}
	
	private void drawButtons() {
		
		button1.add(new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE));
		GRect rect = new GRect(getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.5);
		rect.setFilled(true);
		button1.add(rect, (button1.getWidth() - rect.getWidth()) / 2,
				(button1.getHeight() - rect.getHeight()) / 2);
		
		button2.add(new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE));
		rect = new GRect(getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.5);
		button2.add(rect, (button2.getWidth() - rect.getWidth()) / 2,
				(button2.getHeight() - rect.getHeight()) / 2);
		
		button3.add(new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE));
		GOval oval = new GOval(getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.5);
		oval.setFilled(true);
		button3.add(oval, (button3.getWidth() - oval.getWidth()) / 2,
				(button3.getHeight() - oval.getHeight()) / 2);
		
		button4.add(new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE));
		oval = new GOval(getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.5);
		button4.add(oval, (button4.getWidth() - oval.getWidth()) / 2,
				(button4.getHeight() - oval.getHeight()) / 2);
		
		button5.add(new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE));
		GLine line = new GLine(getHeight() * BUTTON_SIZE * 0.25, getHeight() * BUTTON_SIZE * 0.75,
				getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.25);
		button5.add(line);
		
		button6.add(new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE));
		line = new GLine(getHeight() * BUTTON_SIZE * 0.25, getHeight() * BUTTON_SIZE * 0.75,
				getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.25);
		button6.add(line);
		line = new GLine(getHeight() * BUTTON_SIZE * 0.25, getHeight() * BUTTON_SIZE * 0.25,
				getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.75);
		button6.add(line);
		
		button7.add(new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE));
		line = new GLine(getHeight() * BUTTON_SIZE * 0.25, getHeight() * BUTTON_SIZE * 0.75,
				getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.25);
		button7.add(line);
		line = new GLine(getHeight() * BUTTON_SIZE * 0.25, getHeight() * BUTTON_SIZE * 0.25,
				getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.75);
		button7.add(line);
		line = new GLine(getHeight() * BUTTON_SIZE * 0.25, getHeight() * BUTTON_SIZE * 0.5,
				getHeight() * BUTTON_SIZE * 0.75, getHeight() * BUTTON_SIZE * 0.5);
		button7.add(line);
		line = new GLine(getHeight() * BUTTON_SIZE * 0.5, getHeight() * BUTTON_SIZE * 0.25,
				getHeight() * BUTTON_SIZE * 0.5, getHeight() * BUTTON_SIZE * 0.75);
		button7.add(line);
		
		rect = new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE);
		rect.setColor(Color.BLACK);
		rect.setFillColor(Color.RED);
		rect.setFilled(true);
		button8.add(rect);
		
		rect = new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE);
		rect.setColor(Color.BLACK);
		rect.setFillColor(Color.GREEN);
		rect.setFilled(true);
		button9.add(rect);
		
		rect = new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE);
		rect.setColor(Color.BLACK);
		rect.setFillColor(Color.BLUE);
		rect.setFilled(true);
		button10.add(rect);
		
		rect = new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE);
		rect.setColor(Color.BLACK);
		rect.setFillColor(Color.BLACK);
		rect.setFilled(true);
		button11.add(rect);
		
		currentRandom = new GRect(getHeight() * BUTTON_SIZE, getHeight() * BUTTON_SIZE);
		currentRandom.setColor(Color.BLACK);
		currentRandom.setFillColor(Color.WHITE);
		currentRandom.setFilled(true);
		button12.add(currentRandom);
	}
}
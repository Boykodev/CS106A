import java.awt.Color;
import java.awt.event.*;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/**Draws confusing labels, that you should say aloud.*/
public class SayColor extends GraphicsProgram {
	
	/**
	 * Program language.
	 * 0 - English.
	 * 1 - Ukrainian.
	 * 2 - Russian.
	 */
	private int lang;
	
	/** Random generator.*/
	private RandomGenerator rgen = new RandomGenerator();

	private GLabel label;
	private int currentLabel;
	private Color currentColor;
	
	public void init() {
		lang = 0;
		putLabel();
		addMouseListeners();
		addKeyListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		revealColor();
	}
	
	public void mouseReleased(MouseEvent e) {
		returnColor();
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			putNewLabel();
		}
	}
	
	private void putNewLabel() {
		removeAll();
		putLabel();
	}

	private void putLabel() {

		label = new GLabel("");
		label.setFont("Helvetica-75");
		
		Color randomColor = rgen.nextColor();
		label.setColor(randomColor);
		
		currentColor = randomColor;
		currentLabel = rgen.nextInt(7);
		
		switch(currentLabel) {
		case 0:
			if (lang == 0) label.setLabel("RED");
			if (lang == 1) label.setLabel("ЧЕРВОНИЙ");
			if (lang == 2) label.setLabel("КРАСНЫЙ");
			break;
		case 1:
			if (lang == 0) label.setLabel("ORANGE");
			if (lang == 1) label.setLabel("ПОМАРАНЧЕВИЙ");
			if (lang == 2) label.setLabel("ОРАНЖЕВЫЙ");
			break;
		case 2:
			if (lang == 0) label.setLabel("YELLOW");
			if (lang == 1) label.setLabel("ЖОВТИЙ");
			if (lang == 2) label.setLabel("ЖЕЛТЫЙ");
			break;
		case 3:
			if (lang == 0) label.setLabel("GREEN");
			if (lang == 1) label.setLabel("ЗЕЛЕНИЙ");
			if (lang == 2) label.setLabel("ЗЕЛЕНЫЙ");
			break;
		case 4:
			if (lang == 0) label.setLabel("CYAN");
			if (lang == 1) label.setLabel("БЛАКИТНИЙ");
			if (lang == 2) label.setLabel("ГОЛУБОЙ");
			break;
		case 5:
			if (lang == 0) label.setLabel("BLUE");
			if (lang == 1) label.setLabel("СИНІЙ");
			if (lang == 2) label.setLabel("СИНИЙ");
			break;
		case 6:
			if (lang == 0) label.setLabel("MAGENTA");
			if (lang == 1) label.setLabel("РОЖЕВИЙ");
			if (lang == 2) label.setLabel("РОЗОВЫЙ");
			break;
		default:
			break;
		}
		add(label, (getWidth() - label.getWidth()) / 2, (getHeight() + label.getAscent()) / 2);
	}
	
	private void revealColor() {
		switch(currentLabel) {
		case 0:
			label.setColor(Color.RED);
			break;
		case 1:
			label.setColor(Color.ORANGE);
			break;
		case 2:
			label.setColor(Color.YELLOW);
			break;
		case 3:
			label.setColor(Color.GREEN);
			break;
		case 4:
			label.setColor(Color.CYAN);
			break;
		case 5:
			label.setColor(Color.BLUE);
			break;
		case 6:
			label.setColor(Color.MAGENTA);
			break;
		default:
			break;
		}
	}
	
	private void returnColor() {
		label.setColor(currentColor);
	}
}

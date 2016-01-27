import java.awt.event.*;
import javax.swing.*;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class MagicSquare extends ConsoleProgram {
	
	private static final int FIELD_SIZE = 300;
	private static final String FONT_SIZE = "Helvetica-25";
	private static final String GENERATE_BUTTON = "Generate";
	
	public void init() {
		canvas = new GCanvas();
		add(canvas);
		setFont(FONT_SIZE);
		println("Welcome to MagicSquareGeneratorª");
		addButtons();
		addActionListeners();
	}
	
	private void addButtons() {
		sm = new JRadioButton("3");
		med = new JRadioButton("4");
		lrg = new JRadioButton("5");
		maxNumber = new JComboBox();
		for (int i = 0; i < 10; i++) {
			maxNumber.addItem("" + i + "");
		}
		maxNumber.setEditable(true);
		
		ButtonGroup size = new ButtonGroup();
		size.add(sm);
		size.add(med);
		size.add(lrg);
		sm.setSelected(true);
		
		add(new JLabel("Pick size: "), SOUTH);
		add(sm, SOUTH);
		add(med, SOUTH);
		add(lrg, SOUTH);
		
		add(new JButton(GENERATE_BUTTON), SOUTH);
		
		add(new JLabel("Max number: "), SOUTH);
		add(maxNumber, SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd == GENERATE_BUTTON) {
			canvas.removeAll();
			printSquare(getMagicSquare());
			println("\nMagic square was found after " + attempts +
					" attempt" + ((attempts == 1) ? "." : "s."));
			println("Magic square sums up to " + sum);
			attempts = 0;
		}
	}
	
	private boolean isMagicSquare(int[][] square) {
		attempts++;
		double vSum = 0, hSum = 0, slashSum = 0, backslashSum = 0;
		for (int i = 0; i < square.length; i++) {
			vSum = 0;
			hSum = 0;
			for (int j = 0; j < square[i].length; j++) {
				vSum += square[i][j];
				hSum += square[j][i];
				if (i == j) {
					backslashSum += square[i][j];
				}
				if (i == square[i].length - j - 1) {
					slashSum += square[i][j];
				}
			}
			if (i == 0) {
				 if (vSum != hSum) return false;
				 sum = (int)vSum;
			} else if (i > 0) {
				if (vSum != sum || hSum != sum) return false;
			}
		}
		if (slashSum == backslashSum && slashSum == sum) {
			return true;
		}
		return false;
	}

	private int[][] getMagicSquare() {
		setSquareSize();
		int max = getMaxNumber();
		int[][] square = new int[size][size];
		while (true) {
			for (int i = 0; i < square.length; i++) {
				for (int j = 0; j < square[i].length; j++) {
					square[i][j] = rgen.nextInt(0, max);
				}
			}
			if (isMagicSquare(square)) break;
		}
		return square;
	}

	private void setSquareSize() {
		if (sm.isSelected()) {
			size = 3;
		} else if (med.isSelected()) {
			size = 4;
		} else if (lrg.isSelected()) {
			size = 5;
		}
	}

	private int getMaxNumber() {
		int n;
		String number = (String) maxNumber.getSelectedItem();
		try {
			n = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return 0;
		}
		return n;
	}

	private void printSquare(int[][] square) {
		GCompound field = new GCompound();
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				GCompound cell = new GCompound();
				GLabel number = new GLabel("" + square[i][j] + "");
				number.setFont(FONT_SIZE);
				cell.add(new GRect(FIELD_SIZE / size, FIELD_SIZE / size));
				cell.add(number, (cell.getWidth() - number.getWidth()) / 2,
						(cell.getHeight() + number.getAscent()) / 2);
				field.add(cell, cell.getWidth() * i, cell.getHeight() * j);
			}
		}
		canvas.add(field, (canvas.getWidth() - field.getWidth()) / 2,
				(canvas.getHeight() - field.getHeight()) / 2);
	}

	private int sum;
	private int size;
	private long attempts;
	private GCanvas canvas;
	private JRadioButton sm;
	private JRadioButton med;
	private JRadioButton lrg;
	private JComboBox maxNumber;
	
	private RandomGenerator rgen = new RandomGenerator();
}
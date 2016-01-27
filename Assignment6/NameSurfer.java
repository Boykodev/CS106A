/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the top of the window.
 */
	public void init() {
		add(canvas);
		setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	    add(new JLabel("Name"), SOUTH);
	    name = new JTextField(TEXT_FIELD_LENGTH);
	    name.addActionListener(this);
	    add(name, SOUTH);
	    add(new JButton(ADD), SOUTH);
	    add(new JButton(CLEAR), SOUTH);
	    addActionListeners();
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(ADD) || e.getSource() == name) {
			String input = name.getText();
			input = input.toLowerCase();
			input = Character.toUpperCase(input.charAt(0)) + input.substring(1);
			NameSurferEntry entry = db.findEntry(input);
			if (entry != null) {
				canvas.addEntry(entry);
				name.setText("");
			}
		} else if (e.getActionCommand().equals(CLEAR)) {
			canvas.clear();
		}
	}
	
	JTextField name;
	NameSurferGraph canvas = new NameSurferGraph();
	NameSurferDataBase db = new NameSurferDataBase(NAMES_DATA_FILE);
}

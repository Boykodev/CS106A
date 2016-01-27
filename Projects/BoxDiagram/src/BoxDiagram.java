import java.awt.event.*;
import java.util.*;

import acm.graphics.GObject;
import acm.program.*;

public class BoxDiagram extends GraphicsProgram {
	
	public void init() {
		panel = new BoxPanel();
		addButtonListeners();
		addActionListeners();
		addMouseListeners();
		add(panel, SOUTH);
	}
	
	private void addButtonListeners() {
		panel.getNameField().addActionListener(this);
		panel.getAddButton().addActionListener(this);
		panel.getRemoveButton().addActionListener(this);
		panel.getClearButton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (e.getSource() == panel.getNameField() || cmd.equals(BoxPanel.ADD)) {
			addBox(panel.getNameField().getText());
		} else if (cmd.equals(BoxPanel.REMOVE)) {
			removeBox(panel.getNameField().getText());
		} else if (cmd.equals(BoxPanel.CLEAR)) {
			clearBoxes();
		}
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
	
	private void addBox(String text) {
		box = new Box(text);
		double centerX = (getWidth() - box.getWidth()) / 2;
		double centerY = (getHeight() - box.getHeight()) / 2;
		add(box, centerX, centerY);
		boxes.add(box);
	}

	private void removeBox(String text) {
		Iterator<Box> it = boxes.iterator();
		while (it.hasNext()) {
			Box currentBox = it.next();
			if (currentBox.getText().equals(text)) {
				remove(currentBox);
				it.remove();
				break;
			}
		}
	}

	private void clearBoxes() {
		Iterator<Box> it = boxes.iterator();
		while (it.hasNext()) {
			Box currentBox = it.next();
			remove(currentBox);
			it.remove();
		}
	}

	private GObject gobj;
	private double lastX;
	private double lastY;
	
	private Box box;
	private BoxPanel panel;
	private ArrayList<Box> boxes = new ArrayList<Box>();
}

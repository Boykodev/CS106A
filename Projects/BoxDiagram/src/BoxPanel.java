import javax.swing.*;

public class BoxPanel extends JPanel {
	
	public static final String ADD = "Add";
	public static final String REMOVE = "Remove";
	public static final String CLEAR = "Clear";
	
	BoxPanel() {
		add(new JLabel("Name"));
		nameField = new JTextField(15);
		add(nameField);
		
		add = new JButton(ADD);
		remove = new JButton(REMOVE);
		clear = new JButton(CLEAR);
		
		add(add);
		add(remove);
		add(clear);
	}
	
	public JTextField getNameField() {
		return nameField;
	}
	
	public JButton getAddButton() {
		return add;
	}
	
	public JButton getRemoveButton() {
		return remove;
	}
	
	public JButton getClearButton() {
		return clear;
	}
	
	private JButton add;
	private JButton remove;
	private JButton clear;
	private JTextField nameField;
}

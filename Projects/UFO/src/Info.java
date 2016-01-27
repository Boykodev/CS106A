import java.awt.Color;

import acm.graphics.*;

public class Info extends GCompound {
	static final int INFO_H = 25;
	static final int INFO_W = INFO_H * 7;
	
	private GRect box;
	private GLabel label;
	
	public Info() {
		box = new GRect(INFO_W, INFO_H);
		box.setFilled(true);
		add(box, 0, 0);
		label = new GLabel("");
		label.setFont("Helvetica-15");
		add(label, (INFO_W - label.getWidth()) / 2,
				(INFO_H + label.getAscent()) / 2);
	}
	
	public void setLevel(int level) {
		box.setColor(Color.RED);
		label.setColor(Color.WHITE);
		label.setLabel("LEVEL " + level + " GET READY!");
		label.setLocation((INFO_W - label.getWidth()) / 2,
				(INFO_H + label.getAscent()) / 2);
	}
	
	public void setTotal(int total, int best) {
		box.setColor(Color.WHITE);
		label.setColor(Color.RED);
		label.setLabel("TOTAL: " + total + " BEST: " + best);
		label.setLocation((INFO_W - label.getWidth()) / 2,
				(INFO_H + label.getAscent()) / 2);
	}
}
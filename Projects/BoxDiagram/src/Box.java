import acm.graphics.*;

public class Box extends GCompound {
	
	private static final int BOX_WIDTH = 120;
	private static final int BOX_HEIGHT = 50;
	
	Box(String text) {
		label = new GLabel(text);
		add(new GRect(BOX_WIDTH, BOX_HEIGHT));
		add(label, (BOX_WIDTH - label.getWidth()) / 2,
				(BOX_HEIGHT + label.getAscent()) / 2);
	}
	
	public String getText() {
		return label.getLabel();
	}
	
	GLabel label;
}

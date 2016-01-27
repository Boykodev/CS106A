/*
 * Prints hello world with a style.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class FancyHello extends GraphicsProgram {
	public void run() {
		GLabel label = new GLabel("Hello, world!");
		label.setFont("Serif-46");
		label.setColor(Color.RED);
		add(label, (this.getWidth() - label.getWidth()) / 2, (this.getHeight() + label.getAscent()) / 2);
	}
}

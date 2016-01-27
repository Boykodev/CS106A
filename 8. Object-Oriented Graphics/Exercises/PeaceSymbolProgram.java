import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

/** Draws a peace symbol.*/
public class PeaceSymbolProgram extends GraphicsProgram {
	
	public void init() {
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		
		drawPeaceSymbol(centerX, centerY, 100);
	}
	
	private void drawPeaceSymbol(double x, double y, double r) {
		add(new PeaceSymbol(r), x - r, y - r);
	}
}

class PeaceSymbol extends GCompound {
	
	public PeaceSymbol(double radius) {
		GOval circle = new GOval(radius * 2, radius * 2);
		GLine mainLine = new GLine(radius, 0, radius, radius * 2);
		GLine leftLine = new GLine(radius, radius, radius * 0.3, radius * 1.7);
		GLine rightLine = new GLine(radius, radius, radius * 1.7, radius * 1.7);
		add(circle);
		add(mainLine);
		add(leftLine);
		add(rightLine);
	}
}

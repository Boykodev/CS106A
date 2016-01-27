import acm.program.*;
import acm.graphics.*;

/** Draws my initials.*/
public class DrawInitials extends GraphicsProgram {
	
	Initials initials;
	
	public void init() {
		initials = new Initials('s', 'b', 100);
		
		double centerX = (getWidth() - initials.getWidth()) * 0.5;
		double centerY = (getHeight() - initials.getHeight()) * 0.5;
		
		add(initials, centerX, centerY);
	}
}

class Initials extends GCompound {

	public Initials(char firstName, char secondName, int size) {
		add(getLetter(firstName, size));
		add(getLetter(secondName, size), size, 0);
	}
	
	public static GCompound getLetter(char name, int size) {
		GCompound letter = new GCompound();
		switch(name) {
		case 's':
			letter.add(new GArc(size / 2, size / 2, 0, 270), 0, 0);
			letter.add(new GArc(size / 2, size / 2, 90, -270), 0, size / 2);
			
			return letter;
		case 'b':
			letter.add(new GLine(0, 0, 0, size));
			letter.add(new GLine(0, 0, size * 0.25, 0));
			letter.add(new GLine(0, size * 0.5, size * 0.25, size * 0.5));
			letter.add(new GLine(0, size, size * 0.25, size));
			letter.add(new GArc(size * 0.5, size * 0.5, 90, -180), 0, 0);
			letter.add(new GArc(size * 0.5, size * 0.5, 90, -180), 0, size * 0.5);
			
			return letter;
		default:
			letter.add(new GLabel("Letter is not"), 0, 10);
			letter.add(new GLabel("database yet."), 0, 20);
			
			return letter;
		}
	}
}
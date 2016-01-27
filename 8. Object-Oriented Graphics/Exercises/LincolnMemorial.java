import acm.graphics.*;
import acm.program.*;

/** Draws a picture of Lincoln Memorial.*/
public class LincolnMemorial extends GraphicsProgram {
	
	/* Fractions.*/
	private static final double ROOF_WIDTH = 0.9;
	private static final double ROOF_HEIGHT = 0.15;
	private static final double CIRCLE = 0.033;
	private static final double TOTAL_CIRCLES = 12;
	private static final double TOTAL_LINES = TOTAL_CIRCLES;
	
	private double memorialHeight;
	private double memorialWidth;

	public void init() {
		memorialWidth = 500;
		memorialHeight = 300;
		
		GCompound memorial = getMemorial();
		
		double centerX = (getWidth() - memorial.getWidth()) / 2;
		double centerY = (getHeight() - memorial.getHeight()) / 2;
		
		add(memorial, centerX, centerY);
	}

	private GCompound getMemorial() {
		GCompound memorial = new GCompound();
		
		memorial.add(getRoof(), memorialWidth * ((1 - ROOF_WIDTH) / 2), 0);
		
		memorial.add(getBase(), 0, memorialHeight * ROOF_HEIGHT);
		
		return memorial;
	}

	private GRect getRoof() {
		return new GRect(memorialWidth * ROOF_WIDTH, memorialHeight * ROOF_HEIGHT);
	}

	private GCompound getBase() {
		GCompound base = new GCompound();
		
		base.add(getTop());
		
		base.add(getMiddle(), 0, memorialHeight * ROOF_HEIGHT);
		
		base.add(getBottom(), 0, memorialHeight * (1 - ROOF_HEIGHT * 2));
		
		return base;
	}

	private GCompound getTop() {
		GCompound top = new GCompound();
		
		top.add(new GRect(memorialWidth, memorialHeight * ROOF_HEIGHT));
		
		double pillar = 0.04;
		double gap = 0.04727273;
		double curPos = 0;
		for (int i = 0; i < TOTAL_CIRCLES; i++) {
			GOval circle = new GOval(memorialHeight * CIRCLE, memorialHeight * CIRCLE);
			top.add(circle, curPos + (memorialWidth * pillar - circle.getWidth()) / 2,
					memorialHeight * ROOF_HEIGHT / 2 - circle.getHeight() / 2);
			
			curPos += memorialWidth * pillar + memorialWidth * gap;
		}
		
		return top;
	}

	private GCompound getMiddle() {
		GCompound middle = new GCompound();
		
		double pillar = 0.04;
		double gap = 0.04727273;
		double curPos = 0;
		for (int i = 0; i < TOTAL_LINES; i++) {
		
			middle.add(new GLine(curPos, 0, curPos, memorialHeight * (1 - ROOF_HEIGHT * 3)));
			
			curPos += memorialWidth * pillar;
			
			if (i == TOTAL_LINES / 2 - 1) {
				GCompound person = getPerson();
				middle.add(person, curPos + (memorialWidth * gap - person.getWidth()) / 2,
						middle.getHeight() - person.getHeight());
			}
			
			middle.add(new GLine(curPos, 0, curPos, memorialHeight * (1 - ROOF_HEIGHT * 3)));
			
			curPos += memorialWidth * gap;
		}
		return middle;
	}

	private GCompound getPerson() {
		GCompound person = new GCompound();
		
		GOval circle = new GOval(memorialHeight * CIRCLE, memorialHeight * CIRCLE);
		person.add(circle);
		
		GRect body = new GRect (memorialHeight * CIRCLE, memorialHeight * CIRCLE * 1.5);
		person.add(body, 0, memorialHeight * CIRCLE);
		
		return person;
	}

	private GRect getBottom() {
		return new GRect(memorialWidth, memorialHeight * ROOF_HEIGHT);
	}
}

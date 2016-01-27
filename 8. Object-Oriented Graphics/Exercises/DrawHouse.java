import acm.graphics.*;
import acm.program.*;

/** Draws a simple house.*/
public class DrawHouse extends GraphicsProgram {
	public void init() {
		House house = new House(500, 400);
		
		double centerX = (getWidth() - house.getWidth()) / 2;
		double centerY = (getHeight() - house.getHeight()) / 2;
		
		add(house, centerX, centerY);
	}
}

class House extends GCompound {
	
	private static final double ROOF_HEIGHT = 0.25;
	
	private static final double DOOR_WIDTH = 0.13;	
	private static final double DOOR_KNOB = 0.13; //fraction to door width
	
	private static final double SMALL_WINDOW_WIDTH = 0.1;
	private static final double SMALL_WINDOW_HEIGHT = 0.15;
	
	private static final double BIG_WINDOW_WIDTH = 0.2;
	private static final double BIG_WINDOW_HEIGHT = 0.2;
	
	private double width;
	private double height;
	
	GCompound base;
	
	public House(double width, double height) {
		this.height = height;
		this.width = width;
		
		addRoof();
		addBase();
		
		addDoor();
		addWindows();
	}

	private void addRoof() {
		GLine roofLeft = new GLine(0, height * ROOF_HEIGHT, width / 2, 0);
		GLine roofRight = new GLine(width, height * ROOF_HEIGHT, width / 2, 0);
		
		add(roofLeft);
		add(roofRight);
	}
	
	private void addBase() {
		base = new GCompound();
		base.add(new GRect(width, height - height * ROOF_HEIGHT));
		
		add(base, 0, height * ROOF_HEIGHT);
	}

	private void addDoor() {
		GCompound door = new GCompound();
		
		GRect casing = new GRect(width * DOOR_WIDTH, height * DOOR_WIDTH * 2);
		GOval knob = new GOval(casing.getWidth() * DOOR_KNOB, casing.getWidth() * DOOR_KNOB);
		
		door.add(casing);
		door.add(knob, door.getWidth() * 0.75, door.getHeight() * 0.5);
		add(door, (width - door.getWidth()) / 2, height - door.getHeight());
	}

	private void addWindows() {
		base.add(getSmallWindow(), base.getWidth() * 0.25, base.getHeight() * 0.25);
		base.add(getSmallWindow(), base.getWidth() * 0.75, base.getHeight() * 0.25);
		
		base.add(getBigWindow(), base.getWidth() * 0.25, base.getHeight() * 0.75);
		base.add(getBigWindow(), base.getWidth() * 0.75, base.getHeight() * 0.75);
	}

	private GCompound getSmallWindow() {
		GCompound small = new GCompound();
		GRect casing = new GRect(width * SMALL_WINDOW_WIDTH, height * SMALL_WINDOW_HEIGHT);
		GLine bar1 = new GLine(0, -casing.getHeight() / 2, 0, casing.getHeight() / 2);
		GLine bar2 = new GLine(-casing.getWidth() / 2, 0, casing.getWidth() / 2, 0);
		
		small.add(casing, -casing.getWidth() / 2, -casing.getHeight() / 2);
		small.add(bar1);
		small.add(bar2);
		
		return small;
	}

	private GCompound getBigWindow() {
		GCompound big = new GCompound();
		GRect casing = new GRect(width * BIG_WINDOW_WIDTH, height * BIG_WINDOW_HEIGHT);
		GLine bar1 = new GLine(-casing.getWidth() / 2, 0, casing.getWidth() / 2, 0);
		
		GLine bar2 = new GLine(-casing.getWidth() / 6, -casing.getHeight() / 2,
				-casing.getWidth() / 6, casing.getHeight() / 2);
		
		GLine bar3 = new GLine(casing.getWidth() / 6, -casing.getHeight() / 2,
				casing.getWidth() / 6, casing.getHeight() / 2);
		
		big.add(casing, -casing.getWidth() / 2, -casing.getHeight() / 2);
		big.add(bar1);
		big.add(bar2);
		big.add(bar3);
		
		return big;
	}
}
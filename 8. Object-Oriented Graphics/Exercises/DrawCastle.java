import acm.graphics.*;
import acm.program.*;

/** Draws a castle.*/
public class DrawCastle extends GraphicsProgram {

	private static final double TOWER_WIDTH = 0.13;
	private static final double TOWER_HEIGHT = 0.9;
	
	private static final double HOUSE_WIDTH = 1 - (TOWER_WIDTH * 2);
	
	private static final double DOOR_WIDTH = 0.1;
	private static final double DOOR_HEIGHT = 0.2;
	
	private static final double WINDOW_SIZE = 0.1;
	
	/* Fractions for roofs.*/
	private static final double TOWER = 0.2;
	private static final double DOOR = 0.3;
	private static final double HOUSE = 0.4;
	
	double castleWidth;
	double castleHeight;
	
	public void init() {
		
		castleWidth = 350;
		castleHeight = 400;
		
		GCompound castle = getCastle();
		
		double centerX = (getWidth() - castle.getWidth()) / 2;
		double centerY = (getHeight() - castle.getHeight()) / 2;
		
		add(castle, centerX, centerY);
	}

	private GCompound getCastle() {
		GCompound castle = new GCompound();
		
		castle.add(getHouse(castleWidth, castleHeight), castleWidth * TOWER_WIDTH, 0);
		
		GCompound leftTower = getTower(castleWidth * TOWER_WIDTH, castleHeight * TOWER_HEIGHT, TOWER);
		castle.add(leftTower, 0, castleHeight * (1 - TOWER_HEIGHT));
		
		GCompound rightTower = getTower(castleWidth * TOWER_WIDTH, castleHeight * TOWER_HEIGHT, TOWER);
		castle.add(rightTower, castleWidth * (1 - TOWER_WIDTH), castleHeight * (1 - TOWER_HEIGHT));
		
		return castle;
	}

	private GCompound getHouse(double castleWidth, double castleHeight) {
		GCompound house = new GCompound();
		
		double houseWidth = castleWidth * HOUSE_WIDTH;
		
		house.add(getTower(houseWidth, castleHeight, HOUSE));
		
		GCompound door = getTower(castleWidth * DOOR_WIDTH, castleHeight * DOOR_HEIGHT, DOOR);
		house.add(door, (house.getWidth() - door.getWidth()) / 2, house.getHeight() - door.getHeight());
		
		GRect leftWindow = new GRect(castleWidth * WINDOW_SIZE, castleWidth * WINDOW_SIZE);
		house.add(leftWindow, house.getWidth() * 0.25 - door.getWidth() / 2,
				house.getHeight() / 2);
		
		GRect rightWindow = new GRect(castleWidth * WINDOW_SIZE, castleWidth * WINDOW_SIZE);
		house.add(rightWindow, house.getWidth() * 0.75 - door.getWidth() / 2,
				house.getHeight() / 2);
		
		return house;
	}

	private GCompound getTower(double width, double height, double roofFraction) {
		GCompound tower = new GCompound();
		
		double roofHeight = height * roofFraction;
		
		GPolygon roof = new GPolygon();
		roof.addVertex(width / 2, 0);
		roof.addVertex(width, roofHeight);
		roof.addVertex(0, roofHeight);
			tower.add(roof);
			
		GRect main = new GRect(width, height - roofHeight);
			tower.add(main, 0, roofHeight);
		
		return tower;
	}
}
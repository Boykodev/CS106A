import acm.graphics.*;

public class Container extends GCompound {
	
	private static final int CHANNELS = 10;
	
	public static final int WIDTH = 250;
	public static final int HEIGHT = 250;
	
	public static final int GAP = WIDTH / CHANNELS;
	private static final int MAX_MARBLES = HEIGHT / GAP;
	
	private static final double DELAY = 5;
	
	Container() {
		initContainer();
	}
	
	private void initContainer() {
		marbles = new GOval[CHANNELS][MAX_MARBLES];
		indices = new int[CHANNELS];
		
		for (int i = 0; i < CHANNELS + 1; i++) {
			GLine line = new GLine(GAP * i, 0, GAP * i, HEIGHT);
			add(line);
		}
		GLine line = new GLine(0, HEIGHT, WIDTH, HEIGHT);
		add(line);
	}

	public boolean isFull() {
		for (int i = 0; i < indices.length; i++) {
			if (indices[i] == MAX_MARBLES) {
				return true;
			}
		}
		return false;
	}

	public void dropTheMarble(GOval marble, int randomChannel) {
		add(marble, GAP * (randomChannel - 1), 0);
		marbles[randomChannel - 1][indices[randomChannel - 1]++] = marble;
		while (marble.getY() < HEIGHT - marble.getHeight() * indices[randomChannel - 1]) {
			marble.move(0, 1);
			pause(DELAY);
		}
	}
	
	GOval[][] marbles;
	int[] indices;
}

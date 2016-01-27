import acm.graphics.GCompound;
import acm.util.*;

public class Ai {

	public void makeTurn(PlayGround pg) {
		if (!pg.emptyLeft()) return;
		int rows = pg.getField().length;
		int cols = pg.getField()[0].length;
		boolean complete = false;
		
		while (!complete) {
			int randomRow = rgen.nextInt(0, rows - 1);
			int randomCol = rgen.nextInt(0, cols - 1);
			
			if (pg.isEmpty(randomRow, randomCol)) {
				pg.putO(pg.getField(), randomRow, randomCol);
				complete = true;
			}
		}
	}
	
	private RandomGenerator rgen = new RandomGenerator();
}

import stanford.karel.*;

public class KarelBorder extends SuperKarel {

	public void run() {
		for (int i = 0; i < 4;) {
			if (frontIsClear()) {
				move();
			} else {
				turnLeft();
				move();
				i++;
			}
			
			if (frontIsBlocked()) {	
					turnLeft();
					move();
					i++;
			}
			
			turnLeft();
			move();
			
			if (noBeepersPresent()) {
				putBeeper();
			}
			
			turnAround();
			move();
			turnLeft();
		}	
	}
}
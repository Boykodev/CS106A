/* Program prints out a month calendar. */

import acm.program.*;
import acm.graphics.*;

public class Calendar extends GraphicsProgram {
	private static final int DAYS_IN_WEEK = 7;
	private static final int DAYS_IN_MONTH = 31;
	private static final int DAY_MONTH_STARTS = 4;
	private static final int DAY_WIDTH = 80;
	private static final int DAY_HEIGHT = 60;
	int x, y, rows, day;
	
	public void run() {
		rowsNumber();
		switchDay();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < (DAYS_IN_WEEK); j++) {
				drawDay();
				x += DAY_WIDTH;
			}
			newLine();
		}
	}

	private void rowsNumber() {
		if (DAY_MONTH_STARTS == 5 && DAYS_IN_MONTH == 31 || 
		DAY_MONTH_STARTS == 6 && DAYS_IN_MONTH == 30 | DAYS_IN_MONTH == 31) {
			rows = 6;
		} else if (DAY_MONTH_STARTS == 0 && DAYS_IN_MONTH == 28) {
			rows = 4;
		} else {
			rows = 5;
		}
	}

	private void switchDay() {
		switch (DAY_MONTH_STARTS) {
		case 0: day = 1; break;
		case 1: day = 0; break;
		case 2: day = -1; break;
		case 3: day = -2; break;
		case 4: day = -3; break;
		case 5: day = -4; break;
		case 6: day = -5; break;
		default: break;
		}
	}

	private void drawDay() {
		add(new GRect(DAY_WIDTH, DAY_HEIGHT), x, y);
		if (day > 0 && day <= DAYS_IN_MONTH) add(new GLabel(""+day+""), x + DAY_WIDTH * 0.1, y + DAY_HEIGHT * 0.3);
		day++;
	}

	private void newLine() {
		x = 0;
		y += DAY_HEIGHT;
	}
}

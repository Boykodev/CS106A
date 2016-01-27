/*
 * DrawRobot.java
 * ---------------
 * Draws a robot.
 */

import acm.program.*;
import acm.graphics.*;

public class DrawRobot extends GraphicsProgram {
	public void run() { 
		GOval head = new GOval(80, 80);
		add(head, 340, 50);
		GRect body = new GRect(150, 150);
		add(body, 305, 130);
		GRect leftLeg = new GRect(20, 100);
		add(leftLeg, 330, 280);
		GRect rightLeg = new GRect(20, 100);
		add(rightLeg, 410, 280);
	}
}
/*
 * SnowPerson.java
 * ---------------
 * Draws a snowperson.
 */

import acm.program.*;
import acm.graphics.*;

public class SnowPerson extends GraphicsProgram {
	public void run() { 
		GOval head = new GOval(80, 80);
		add(head, 340, 30);
		GOval body = new GOval(150, 150);
		add(body, 305, 110);
		GOval bottom = new GOval(230, 230);
		add(bottom, 265, 260);
		GOval leftEye = new GOval(20, 20);
		add(leftEye, 360, 40);
		GOval rightEye = new GOval(20, 20);
		add(rightEye, 385, 40);
		GOval leftEyeApple = new GOval(5, 5);
		add(leftEyeApple, 365, 45);
		GOval rightEyeApple = new GOval(5, 5);
		add(rightEyeApple, 390, 45);
		GLabel nose = new GLabel("V");
		add(nose, 380, 75);
		GOval mouse = new GOval(30, 10);
		add(mouse, 368, 82);
		GRect button1 = new GRect(10, 10);
		add(button1, 375, 130);
		GRect button2 = new GRect(10, 10);
		add(button2, 375, 170);
		GRect button3 = new GRect(10, 10);
		add(button3, 375, 210);
	}
}
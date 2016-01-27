/*
 * HelloProgram.java
 * ---------------
 * Prints "Hello, world!"
 */

import acm.program.*;
import acm.graphics.*;

public class HelloProgram extends GraphicsProgram {
	public void run() { 
		add(new GLabel("I love Java!"), 30, 50);
		add(new GLabel("by Boykodev"), 600, 450);
	}
}
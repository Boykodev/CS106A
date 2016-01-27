import java.awt.*;

/**
 * This class represents a simple
 * implementation of a stoplight.
 */

public class Stoplight {
	
/** Constant indicating the color GREEN */
	public static final Color GREEN = Color.GREEN;
/** Constant indicating the color YELLOW */
	public static final Color YELLOW = Color.YELLOW;
/** Constant indicating the color RED */
	public static final Color RED = Color.RED;
	
/** Creates a new Stoplight object, which is initially GREEN. */
	public Stoplight() { state = GREEN; }

/**
 * Returns the current state of the spotlight.
 * @return The state of the spotlight. (GREEN, YELLOW, or RED)
 */
	public Color getState() { return state; }
	
/**
 * Advances the stoplight to the next state.
 */
	public void advance() {
		if (state == RED) {
			state = GREEN;
		} else if (state == YELLOW) {
			state = RED;
		} else if (state == GREEN) {
			state = YELLOW;
		}
	}
	
/** Private instance variable. */
	private Color state;
}

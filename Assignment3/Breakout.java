import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/** Breakout the Game.
 * @author Boykodev */
public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels.*/
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board.*/
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle.*/
	private static final int PADDLE_WIDTH = APPLICATION_WIDTH / 4;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom.*/
	static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row.*/
	static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks.*/
	static final int NBRICK_ROWS = 10;

/** Separation between bricks.*/
	private static final int BRICK_SEP = 4;

/** Width of a brick.*/
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick.*/
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels.*/
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top.*/
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns.*/
	static final int NTURNS = 3;
	
/** Speed fraction.*/
	private static double SPEED = 1;
	
/** Ball animation delay.*/
	private double delay;
	
/** Game result.*/
	private boolean win = false;
	
/** Counter for removed bricks.*/
	private int counter;
	
/** Check mouse click for start and restart.*/
	private boolean click = false;
	
/* Various shapes that construct the game.*/
	private GRect border;
	private GRect paddle;
	private GOval ball;
	private Score score;
	private Turns turns;
	private Start start;
	
	private RandomGenerator rgen = new RandomGenerator();
	private AudioClip bounce = MediaTools.loadAudioClip("bounce.au");
	
/** Runs the Breakout program. */
	public void run() {
		setup();
		play();
		restart();
	}

/** Assembles the game.*/
	private void setup() {
		setWindow();
		drawBorders();
		drawBricks();
		addScore();
		addTurns();
		addStart();
		drawPaddle();
	}
	
/** Adds start to the board.*/	
	private void addStart() {
		start = new Start();
		add(start, (WIDTH - Start.START_W) / 2, HEIGHT - Score.SCORE_H);
	}

/** Adds score to the board.*/
	private void addScore() {
		score = new Score();
		add(score, 0, HEIGHT - Score.SCORE_H);
	}

/** Adds turns count to the board.*/
	private void addTurns() {
		turns = new Turns();
		add(turns, WIDTH - Turns.TURNS_W, HEIGHT - Turns.TURNS_H);
	}
	
/** Sets the window for the game.*/
	private void setWindow() { setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT); }

/** Draws a rectangle that serves as a border.*/
	private void drawBorders() {
		border = new GRect(WIDTH, HEIGHT);
		border.setColor(Color.GRAY);
		add(border, 0, 0);
	}

/** Draws colorful bricks to destroy.*/	
	private void drawBricks() {
		double originX = (WIDTH - ((NBRICKS_PER_ROW - 1) * BRICK_SEP + NBRICKS_PER_ROW * BRICK_WIDTH)) / 2;
		double originY = BRICK_Y_OFFSET;
		
		for (int i = 0; i < NBRICK_ROWS; i++) {
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {
				GRect brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				
				if (i == 0 || i == 1) {
					brick.setColor(Color.RED);
				} else if (i == 2 || i == 3) {
					brick.setColor(Color.ORANGE);
				} else if (i == 4 || i == 5) {
					brick.setColor(Color.YELLOW);
				} else if (i == 6 || i == 7) {
					brick.setColor(Color.GREEN);
				} else if (i == 8 || i == 9) {
					brick.setColor(Color.CYAN);
				}
				
				add(brick, originX + (BRICK_WIDTH + BRICK_SEP) * j, originY + (BRICK_HEIGHT + BRICK_SEP) * i);
				pause(20);
			}
		}
	}

/** Draws a paddle.*/	
	private void drawPaddle() {
		paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle, (WIDTH - PADDLE_WIDTH) / 2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		pause(50);
	}

/** Starts a game.*/
	private void play() {
		addMouseListeners();
		click = false;
		win = false;
		for (int i = NTURNS; i > 0; i--) {
			drawBall();
			
			while (!click) {
				start.setVisible(!start.isVisible());
				pause(200);
			}
			remove(start);
			
			startBall();
			if (win) break;
			turns.setTurns(i - 1);
		}
	}
	
/** Restarts the game.*/
	private void restart() {
		click = false;
		addStart();
		start.setRestart();
		start.sendToBack();
		
		while (!click) {
			start.setVisible(!start.isVisible());
			pause(250);
		}
		
		removeAll();
		counter = 0;
		run();
	}
	
/** Moves a paddle according to mouse position.*/
	public void mouseMoved(MouseEvent e) {
		int mouseX = e.getX();
		movePaddle(mouseX);
	}
	
/** Checks for clicks to start a game.*/	
	public void mouseClicked(MouseEvent e) { click = true; }
	
/** Moves a paddle according to mouse arrow position.*/
	private void movePaddle(int x) {
		if (x > PADDLE_WIDTH / 2 && x < WIDTH - PADDLE_WIDTH / 2) {
			paddle.setLocation(x - PADDLE_WIDTH / 2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		} else if (x < PADDLE_WIDTH / 2) {
			paddle.setLocation(0, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		} else if (x > WIDTH - PADDLE_WIDTH / 2) {
			paddle.setLocation(WIDTH - PADDLE_WIDTH, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}
	
/** Draws a ball.*/
	private void drawBall() {
		ball = new GOval(BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		add(ball, WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 - BALL_RADIUS);
	}
	
/** Rolls the ball.*/
	private void startBall() {
		/** Specifies horizontal velocity for the ball. */
		double vx = rgen.nextDouble(1.5, 3.0);
		if (rgen.nextBoolean()) vx = -vx;
		double vy = 3.0;
		GObject collider;
		int cooldown = 0;
		int curCount = 0;
		delay = 20;
		
		while (counter < NBRICKS_PER_ROW * NBRICK_ROWS) {
			ball.move(vx, vy);
			collider = getCollingObject();
			
			if (isBrick(collider) && cooldown == 0) {
				bounce.play();
				remove(collider);
				counter++;
				curCount++;
				vy = -vy;
				delay *= addSpeed(curCount);
				cooldown = 0;
				score.setScore(counter);
			} else if (collider == paddle && cooldown == 0) {
				bounce.play();
				vy = -vy;
				cooldown = 10;
			}
			
			if (ball.getY() <= 0) {
				vy = -vy;
			} else if ((ball.getX() + BALL_RADIUS * 2) >= WIDTH || (ball.getX() <= 0)) {
				vx = -vx;
			} else if ((ball.getY() + BALL_RADIUS * 2) >= HEIGHT) {
				remove(ball);
				break;
			}
			pause(delay);
			if (cooldown > 0) cooldown--;
			if (counter == NBRICKS_PER_ROW * NBRICK_ROWS) {
				remove(ball);
				win = true;
			}
		}
	}
	
/** Adds speed to the ball movement.*/
	private double addSpeed(int counter) {
		switch (counter) {
			case 1:
				return SPEED;
			case 2:
				return SPEED;
			case 3:
				return SPEED;
			default:
				return 1;
		}
	}

/** Colliding object is a brick.*/
	private boolean isBrick(GObject collider) { 
		return collider != null && collider != paddle;
	}
	
/** Gets an object colliding with the ball.*/
	private GObject getCollingObject() {
		if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1) != null &&
				getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1) != border &&
				getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1) != score &&
				getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1) != turns) {
			return getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1);
		}
		else if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS * 2 + 1) != null &&
				getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS * 2 + 1) != border &&
				getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS * 2 + 1) != score &&
				getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS * 2 + 1) != turns) {
			return getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS * 2 + 1);
		}
		else if (getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != null &&
				getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != border &&
				getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != score &&
				getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != turns) {
			return getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS);
		}
		else if (getElementAt(ball.getX() + BALL_RADIUS * 2 + 1, ball.getY() + BALL_RADIUS) != null &&
				getElementAt(ball.getX() + BALL_RADIUS * 2 + 1, ball.getY() + BALL_RADIUS) != border &&
				getElementAt(ball.getX() + BALL_RADIUS * 2 + 1, ball.getY() + BALL_RADIUS) != score &&
				getElementAt(ball.getX() + BALL_RADIUS * 2 + 1, ball.getY() + BALL_RADIUS) != turns) {
			return getElementAt(ball.getX() + BALL_RADIUS * 2 + 1, ball.getY() + BALL_RADIUS);
		}
		return null;
	}
}

class Score extends GCompound {
	static final int SCORE_H = Breakout.PADDLE_Y_OFFSET;
	private static final int SCORE_W = SCORE_H * 2;
	
	private GRect box;
	private GLabel label;
	
	public Score() {
		box = new GRect(SCORE_W, SCORE_H);
		box.setFilled(true);
		box.setColor(Color.RED);
		add(box, 0, 0);
		label = new GLabel("0");
		label.setColor(Color.WHITE);
		label.setFont("Helvetica-20");
		add(label, (SCORE_W - label.getWidth()) / 2,
				(SCORE_H + label.getAscent()) / 2);
	}
	
	public void setScore(int score) {
		label.setLabel("" + score + "");
		label.setLocation((SCORE_W - label.getWidth()) / 2,
				(SCORE_H + label.getAscent()) / 2);
		if (score == Breakout.NBRICKS_PER_ROW * Breakout.NBRICK_ROWS) {
			label.setLabel("WIN");
			label.setLocation((SCORE_W - label.getWidth()) / 2,
					(SCORE_H + label.getAscent()) / 2);
		}
	}
}

class Turns extends GCompound {
	static final int TURNS_H = Breakout.PADDLE_Y_OFFSET;
	static final int TURNS_W = TURNS_H * 2;
	
	private GRect box;
	private GLabel label;
	
	public Turns() {
		box = new GRect(TURNS_W, TURNS_H);
		box.setFilled(true);
		box.setColor(Color.RED);
		add(box, 0, 0);
		label = new GLabel("" + Breakout.NTURNS + "");
		label.setColor(Color.WHITE);
		label.setFont("Helvetica-20");
		add(label, (TURNS_W - label.getWidth()) / 2,
				(TURNS_H + label.getAscent()) / 2);
	}
	
	public void setTurns(int turns) {
		label.setLabel("" + turns + "");
		label.setLocation((TURNS_W - label.getWidth()) / 2,
				(TURNS_H + label.getAscent()) / 2);
		if (turns == 0) {
			label.setLabel("LOSE");
			label.setLocation((TURNS_W - label.getWidth()) / 2,
				(TURNS_H + label.getAscent()) / 2);
		}
	}
}

class Start extends GCompound {
	static final int START_H = Breakout.PADDLE_Y_OFFSET;
	static final int START_W = START_H * 4;
	
	private GRect box;
	private GLabel label;
	
	public Start() {
		box = new GRect(START_W, START_H);
		box.setFilled(true);
		box.setColor(Color.RED);
		add(box, 0, 0);
		label = new GLabel("CLICK TO START");
		label.setColor(Color.WHITE);
		label.setFont("Helvetica-13");
		add(label, (START_W - label.getWidth()) / 2,
				(START_H + label.getAscent()) / 2);
	}
	
	public void setRestart() {
		label.setFont("Helvetica-12");
		label.setLabel("CLICK TO RESTART");
		label.setLocation((START_W - label.getWidth()) / 2,
				(START_H + label.getAscent()) / 2);
	}
}
import java.awt.Color;
import java.awt.event.*;

import acm.util.*;
import acm.program.*;
import acm.graphics.*;

public class FlappyProgram extends GraphicsProgram {
	
	static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	private static final int GAP = 200;
	private static final double DELAY = 10;
	
/** Used for generating random pipes.*/
	private double bottomPipeHeight;
	
/** Box with current score.*/	
	private Score score;

/** Box with best score.*/
	private Score best;
	
	private Start start;
	private boolean play;
	
/* Images that constructs a game.*/
	private GImage background;
	private GImage flappy;
	private GImage bottomPipe;
	private GImage upperPipe;
	
/** Makes bird look like it flying.*/
	private int cooldown;
	
/** Check if game was restarted.*/	
	private boolean restart;
	
/** Counter for game score.*/
	private int counter;
	
/** Random generator for pipes.*/
	private RandomGenerator rgen = new RandomGenerator();
	
/** Runs the Flappy Bird program. */
	public void run() {
		setup();
		play();
		restart();
	}
	
/** Assembles the game.*/
	private void setup() {
		setWindow();
		addBackGround();
		addFlappy();
		addScore();
		addBest();
		addStart();
	}

/** Sets the window for the game.*/
	public void setWindow() { setSize(WIDTH, HEIGHT + HEIGHT / 28); }
	
/** Adds background.*/
	private void addBackGround() {
		background = new GImage("background.png");
		background.setSize(WIDTH, HEIGHT);
		add(background, 0, 0);
	}

/** Adds flappy bird.*/
	private void addFlappy () {
		flappy = new GImage("bird.png");
		add(flappy, WIDTH / 10, (HEIGHT - flappy.getHeight()) / 2);
	}
	
/** Adds current score box.*/
	private void addScore() {
		score = new Score();
		add(score, 0, HEIGHT - Score.SCORE_H);
	}

/** Adds best score box.*/
	private void addBest() {
		if (!restart) best = new Score();
		add(best, WIDTH - Score.SCORE_W, HEIGHT - Score.SCORE_H);
	}
	
/** Adds start to the board.*/	
	private void addStart() {
		start = new Start();
		add(start, (WIDTH - Start.START_W) / 2, HEIGHT - Score.SCORE_H);
	}
	
/** Restarts the game, keeping the best score.*/	
	private void restart() {
		cooldown = 0;
		restart = true;
		counter = 0;
		removeAll();
		run();
	}
	
/** Plays the game.*/
	private void play() {
		if (!restart) {
			addKeyListeners();
			addMouseListeners();
		}
		play = false;
		while (!play) {
			start.setVisible(!start.isVisible());
			pause(200);
		}
		remove(start);
		movePipes();
	}

/** Recursively moves pipes.*/
	private void movePipes() {
		addBottomPipe();
		addUpperPipe();
		while (bottomPipe.getX() + bottomPipe.getWidth() > 0) {
			bottomPipe.move(-5, 0);
			upperPipe.move(-5, 0);
			if (cooldown <= 19 && cooldown > 0) cooldown--;
			if (cooldown == 0) gravity();
			if (gameOver()) return;
			pause(DELAY);
		}
		counter++;
		score.setScore(counter);
		if (score.getScore() > best.getScore()) best.setScore(counter);
		movePipes();
	}

/** True if a game is over.*/
	private boolean gameOver() {
		return getCollingObject() == bottomPipe || getCollingObject() == upperPipe ||
		flappy.getY() + flappy.getHeight() <= 0 || flappy.getY() >= HEIGHT;
	}
	
/** @return The object that collides with bird.*/
	private GObject getCollingObject() {
		GPoint flappyLU = new GPoint(flappy.getX() - 1, flappy.getY() - 1);
		GPoint flappyLD = new GPoint(flappy.getX() - 1, flappy.getY() + flappy.getHeight() + 1);
		GPoint flappyRU = new GPoint(flappy.getX() + flappy.getWidth() + 1, flappy.getY() - 1);
		GPoint flappyRD = new GPoint(flappy.getX() + flappy.getWidth() + 1, flappy.getY() + flappy.getHeight() + 1);
		if (getElementAt(flappyLU) != background) return getElementAt(flappyLU);
		if (getElementAt(flappyLD) != background) return getElementAt(flappyLD);
		if (getElementAt(flappyRU) != background) return getElementAt(flappyRU);
		if (getElementAt(flappyRD) != background) return getElementAt(flappyRD);
		return null;
	}

/** The inevitable earth force.*/
	private void gravity() { flappy.move(0, 5); }

/** Keyboard control for the game.*/
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && cooldown < 20) {
			moveFlappy();
			play = true;
		}
	}
	
/** Mouse control for the game.*/
	public void mousePressed(MouseEvent e) {
		if(cooldown < 20) {
			moveFlappy();
			play = true;
		}
	}
	
/** Moves bird up.*/
	private void moveFlappy() {
		cooldown = 20;
		flappy.move(0, -(HEIGHT * 0.11));
		cooldown = 19;
	}
	
/** Adds bottom pipe.*/
	private void addBottomPipe() {
		bottomPipe = new GImage("pipe.png");
		bottomPipeHeight = rgen.nextDouble(bottomPipe.getHeight() * 0.2, bottomPipe.getHeight() * 2);
		bottomPipe.setSize(bottomPipe.getWidth(), bottomPipeHeight);
		add(bottomPipe, WIDTH, HEIGHT - bottomPipe.getHeight());
	}

/** Adds upper pipe.*/
	private void addUpperPipe() {
		upperPipe = new GImage("pipe2.png");
		upperPipe.setSize(bottomPipe.getWidth(), HEIGHT - bottomPipeHeight - GAP);
		add(upperPipe, WIDTH, 0);
	}
}

/** Displays scores of the game.*/
class Score extends GCompound {
	static final int SCORE_W = FlappyProgram.WIDTH / 11;
	static final int SCORE_H = SCORE_W / 2;
	
	private int score;
	private GRect box;
	private GLabel label;
	
	public Score() {
		box = new GRect(SCORE_W, SCORE_H);
		box.setFilled(true);
		box.setColor(Color.RED);
		add(box, 0, 0);
		label = new GLabel("0");
		label.setColor(Color.WHITE);
		label.setFont("Helvetica-25");
		add(label, (SCORE_W - label.getWidth()) / 2,
				(SCORE_H + label.getAscent()) / 2);
	}
	
	public void setScore(int score) {
		this.score = score;
		label.setLabel("" + score + "");
		label.setLocation((SCORE_W - label.getWidth()) / 2,
				(SCORE_H + label.getAscent()) / 2);
	}
	
	public int getScore() { return score; }
}

class Start extends GCompound {
	static final int START_W = FlappyProgram.WIDTH / 4;
	static final int START_H = START_W / 10;
	
	private GRect box;
	private GLabel label;
	
	public Start() {
		box = new GRect(START_W, START_H);
		box.setFilled(true);
		box.setColor(Color.RED);
		add(box, 0, 0);
		label = new GLabel("CLICK OR PRESS SPACEBAR");
		label.setColor(Color.WHITE);
		label.setFont("Helvetica-13");
		add(label, (START_W - label.getWidth()) / 2,
				(START_H + label.getAscent()) / 2);
	}
}
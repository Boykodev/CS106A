import java.awt.event.*;

import acm.util.*;
import acm.program.*;
import acm.graphics.*;

public class Ufo extends GraphicsProgram {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int BULLET_MOVE = 10;
	private static final double UFO_DELAY = 10;
	
	private int level;
	private static int ufoSpeed;
	
	private boolean moveLeft;
	private boolean moveRight;
	private boolean gameOver;
	
	private GImage background;
	private GImage player;
	private GImage ufo;
	private GImage pc;
	
	private Info info;
	private Info score;
	private int total;
	private int best;
	
	RandomGenerator rgen = new RandomGenerator();

	/** Initialize the program.*/
	public void init() {
		setupGame();
		while(!gameOver) {
			playGame();
			if (gameOver) gameOver();
		}
	}
	
	/** Restarts the game.*/
	private void gameOver() {
		remove(player);
		score = new Info();
		score.setTotal(total, best);
		add(score, (WIDTH - score.getWidth()) / 2, (HEIGHT - score.getHeight()) / 2);
		total = 0; level = 0;
		waitForClick();
		gameOver = false;
		remove(score);
		remove(ufo);
		if (pc != null) {
			remove(pc);
			pc = null;
		}
		addPlayer();
	}

	/** Assembles the game.*/
	private void setupGame() {
		setWindow();
		addBackGround();
		addPlayer();
		addMouseListeners();
	}
	
	/** Adds ufo.*/
	private void addUfo() {
		switch (rgen.nextInt(3)) {
		case 0 :
			// hard 5 turns
			ufo = new GImage("ufo1.png");
			ufo.scale(0.25);
			break;
		case 1 :
			// medium 6 turns
			ufo = new GImage("ufo2.png");
			ufo.scale(0.22);
			break;
		case 2 :
			// easy 7 turns
			ufo = new GImage("ufo3.png");
			ufo.scale(0.25);
			break;
		default:
			break;
		}
		add(ufo, (WIDTH - ufo.getWidth()) / 2, 0);
		chooseDirection();
	}
	
	/** Adds player's battleship.*/
	private void addPlayer() {
		player = new GImage("player.png");
		player.scale(0.2);
		add(player, (WIDTH - player.getWidth()) / 2, HEIGHT - player.getHeight());
	}

	/** Sets the window for the game.*/
	private void setWindow() { setSize(WIDTH, HEIGHT + 20); }

	/** Adds background.*/
	private void addBackGround() {
		background = new GImage("background.jpg");
		background.setSize(WIDTH, HEIGHT);
		add(background, 0, 0);
	}
	
	/** Manages the gameplay.*/
	private void playGame() {
		startGame();

		ufoSpeed += level;
		int ufoLeft = level - 1;
		
		/* True when all UFO on the level destroyed.*/
		boolean leverOver = false;
		while (!leverOver) {
			moveUfo();
			checkForCollision();
			if (gameOver) break;
			if (pc != null) {
				if (ufoDestroyed()) {
					total++;
					if (total > best) best = total;
					remove(pc);
					pc = null;
					remove(ufo);
					if (ufoLeft > 0){
						addUfo();
						ufoLeft--;
					} else {
						leverOver = true;
					}
				} else {
					moveBullet();
				}
			}
			pause(UFO_DELAY);
		}
	}

	/** Shows the level number.*/
	private void showInfo() {
		info = new Info();
		info.setLevel(level);
		add(info, (WIDTH - info.getWidth()) / 2, (HEIGHT - info.getHeight()) / 2);
		score = new Info();
		score.setTotal(total, best);
		score.setVisible(false);
		add(score, (WIDTH - info.getWidth()) / 2, (HEIGHT - info.getHeight()) / 2);
	}

	/** @return True if UFO collides with bullet.*/
	private boolean ufoDestroyed() { return getCollingObject(pc) == ufo; }

	/** Starts the game.*/
	private void startGame() {
		addUfo();
		ufoSpeed = 1;
		
		level += 1;
		showInfo();
		
		while (true) {
			score.setVisible(!score.isVisible());
			info.setVisible(!info.isVisible());
			pause(100);
			if (pc != null) break;
			pause(100);
			if (pc != null) break;
			pause(100);
			if (pc != null) break;
			pause(100);
			if (pc != null) break;
			pause(100);
			if (pc != null) break;
		}
		remove(info); info = null;
		remove(score); score = null;
	}

	/** Moves bullet and checks for exit.*/
	private void moveBullet() {
		pc.move(0, -BULLET_MOVE);
		if (pc.getY() + pc.getHeight() <= 0) {
			remove(pc);
			pc = null;
		}
	}
	
	/** Moves UFO according to direction.*/
	private void moveUfo() {
		if (moveRight) { ufo.move(ufoSpeed, 0); }
		if (moveLeft) { ufo.move(-ufoSpeed, 0); }
		if (isEdge()) changeDirection();
	}

	/** Checks for collision of player and UFO.*/
	private void checkForCollision() {
		if (getCollingObject(player) == ufo) {
			gameOver = true;
		}
	}
	
	/** Chooses staring direction for UFO.*/
	private void chooseDirection() {
		moveRight = false;
		moveLeft = false;
		if (rgen.nextBoolean()) {
			moveRight = true;
		} else {
			moveLeft = true;
		}
	}

	/** Changes direction and moves UFO down.*/
	private void changeDirection() {
		moveRight = !moveRight;
		moveLeft = !moveLeft;
		ufo.move(0, ufo.getHeight());
		if (moveRight) {
			
			if (ufo.getY() + ufo.getHeight() * 3.5  >= HEIGHT) {
				ufo.setLocation(0, HEIGHT - ufo.getHeight());
			}
		} 
		else if (moveLeft) {
			
			if (ufo.getY() + ufo.getHeight() * 3.5  >= HEIGHT) {
				ufo.setLocation(WIDTH - ufo.getWidth(), HEIGHT - ufo.getHeight());
			}
		}
	}

	/** @returns True if UFO is on edge.*/
	private boolean isEdge() { return ufo.getX() <= 0 || ufo.getX() + ufo.getWidth() >= WIDTH; }

	/** Moves player and checks for collisions.*/
	public void mouseMoved(MouseEvent e) {
		movePlayer(e.getX());
		checkForCollision();
	}
	
	/** Creates bullets and starts a game.*/
	public void mousePressed(MouseEvent e) {
		if (pc == null && !gameOver) {
			pc = new GImage("pc.gif");
			pc.scale(0.25);
			add(pc, player.getX() + (player.getWidth() - pc.getWidth()) / 2, player.getY() - pc.getHeight());
		}
	}

	/** Moves player according to mouse position.*/
	private void movePlayer(int x) {
		if (x > player.getWidth() / 2 && x < WIDTH - player.getWidth() / 2) {
			player.setLocation(x - player.getWidth() / 2, HEIGHT - player.getWidth());
		} else if (x < player.getWidth() / 2) {
			player.setLocation(0, HEIGHT - player.getWidth());
		} else if (x > WIDTH - player.getWidth() / 2) {
			player.setLocation(WIDTH - player.getWidth(), HEIGHT - player.getWidth());
		}
	}
	
	/** @return The object that collides with player.*/
	private GObject getCollingObject(GObject object) {
		GPoint objectLU = new GPoint(object.getX() - 1, object.getY() - 1);
		GPoint objectRU = new GPoint(object.getX() + object.getWidth() + 1, object.getY() - 1);
		GPoint objectLD = new GPoint(object.getX() - 1, object.getY() + object.getHeight() + 1);
		GPoint objectRD = new GPoint(object.getX() + object.getWidth() + 1, object.getY() + object.getHeight() + 1);
		if (getElementAt(objectLU) != background || getElementAt(objectLU) != pc) return getElementAt(objectLU);
		if (getElementAt(objectRU) != background || getElementAt(objectRU) != pc) return getElementAt(objectRU);
		if (getElementAt(objectLD) != background) return getElementAt(objectLD);
		if (getElementAt(objectRD) != background) return getElementAt(objectRD);
		return null;
	}
}
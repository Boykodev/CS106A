/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		guess = null;
		
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		
		GLine post = new GLine(centerX - BEAM_LENGTH, centerY + SCAFFOLD_HEIGHT / 2,
				centerX - BEAM_LENGTH, centerY - SCAFFOLD_HEIGHT / 2);
		GLine beam = new GLine(centerX - BEAM_LENGTH, centerY - SCAFFOLD_HEIGHT / 2,
				centerX, centerY - SCAFFOLD_HEIGHT / 2);
		rope = new GLine(centerX, centerY - SCAFFOLD_HEIGHT / 2,
				centerX, centerY - SCAFFOLD_HEIGHT / 2 + ROPE_LENGTH);
		
		add(post);
		add(beam);
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		if (guess == null) {
			guess = new GLabel(word);
			guess.setFont("Helvetica-30");
			
			add(guess, (getWidth() - guess.getWidth()) / 2,
					getHeight() - guess.getHeight() / 2);
		} else {
			guess.setLabel(word);
			guess.setLocation((getWidth() - guess.getWidth()) / 2,
			getHeight() - guess.getHeight() / 2);
		}
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(int guesses) {
		switch (guesses) {
		case 7:
			drawHead();
			break;
		case 6:
			drawBody();
			break;
		case 5:
			drawLeftHand();
			break;
		case 4:
			drawRightHand();
			break;
		case 3:
			drawLeftLeg();
			break;
		case 2:
			drawRightLeg();
			break;
		case 1:
			drawLeftFoot();
			break;
		case 0:
			drawRightFoot();
			break;
		default:
			break;
		}
	}

	private void drawHead() {
		double headX = rope.getEndPoint().getX() - HEAD_RADIUS;
		double headY = rope.getEndPoint().getY();
		
		GOval head = new GOval(HEAD_RADIUS * 2, HEAD_RADIUS * 2);
		add(head, headX, headY);
	}
	
	private void drawBody() {
		double bodyTopX = rope.getEndPoint().getX();
		double bodyTopY = rope.getEndPoint().getY() + HEAD_RADIUS * 2;
		
		double bodyBottomX = rope.getEndPoint().getX();
		double bodyBottomY = rope.getEndPoint().getY() + HEAD_RADIUS * 2 + BODY_LENGTH;
		
		body = new GLine(bodyTopX, bodyTopY,
				bodyBottomX, bodyBottomY);
		add(body);
	}
	
	private void drawLeftHand() {
		double handStartX = body.getStartPoint().getX();
		double handStartY = body.getStartPoint().getY() + ARM_OFFSET_FROM_HEAD;
		double handEndX = handStartX - UPPER_ARM_LENGTH;
		double handEndY = handStartY;
		double armEndX = handEndX;
		double armEndY = handEndY + LOWER_ARM_LENGTH;
		
		GLine hand = new GLine(handStartX, handStartY, handEndX, handEndY);
		GLine arm = new GLine(handEndX, handEndY, armEndX, armEndY);
		
		add(hand);
		add(arm);
	}
	
	private void drawRightHand() {
		double handStartX = body.getStartPoint().getX();
		double handStartY = body.getStartPoint().getY() + ARM_OFFSET_FROM_HEAD;
		double handEndX = handStartX + UPPER_ARM_LENGTH;
		double handEndY = handStartY;
		double armEndX = handEndX;
		double armEndY = handEndY + LOWER_ARM_LENGTH;
		
		GLine hand = new GLine(handStartX, handStartY, handEndX, handEndY);
		GLine arm = new GLine(handEndX, handEndY, armEndX, armEndY);
		
		add(hand);
		add(arm);
	}
	
	private void drawLeftLeg() {
		double hipStartX = body.getEndPoint().getX();
		double hipStartY = body.getEndPoint().getY();
		double hipEndX = hipStartX - HIP_WIDTH;
		double hipEndY = hipStartY;
		double legEndX = hipEndX;
		double legEndY = hipEndY + LEG_LENGTH;
		
		GLine hip = new GLine(hipStartX, hipStartY, hipEndX, hipEndY);
		leftLeg = new GLine(hipEndX, hipEndY, legEndX, legEndY);
		
		add(hip);
		add(leftLeg);
	}
	
	private void drawRightLeg() {
		double hipStartX = body.getEndPoint().getX();
		double hipStartY = body.getEndPoint().getY();
		double hipEndX = hipStartX + HIP_WIDTH;
		double hipEndY = hipStartY;
		double legEndX = hipEndX;
		double legEndY = hipEndY + LEG_LENGTH;
		
		GLine hip = new GLine(hipStartX, hipStartY, hipEndX, hipEndY);
		rightLeg = new GLine(hipEndX, hipEndY, legEndX, legEndY);
		
		add(hip);
		add(rightLeg);
	}
	
	private void drawLeftFoot() {
		double footStartX = leftLeg.getEndPoint().getX();
		double footStartY = leftLeg.getEndPoint().getY();
		
		GLine foot = new GLine(footStartX, footStartY,
				footStartX - FOOT_LENGTH, footStartY);
		add(foot);
	}
	
	private void drawRightFoot() {
		double footStartX = rightLeg.getEndPoint().getX();
		double footStartY = rightLeg.getEndPoint().getY();
		
		GLine foot = new GLine(footStartX, footStartY,
				footStartX + FOOT_LENGTH, footStartY);
		add(foot);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	private GLine rope;
	private GLine body;
	private GLine leftLeg;
	private GLine rightLeg;
	private GLabel guess;
}

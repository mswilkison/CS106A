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
		wrongGuess = 0;
		wordLabel = new GLabel("");
		wrongGuessLabel = new GLabel("");
		add(wordLabel, 20, SCAFFOLD_HEIGHT + 20);
		add(wrongGuessLabel, 20, SCAFFOLD_HEIGHT + 30);
		drawScaffold();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		wordLabel.setLabel(word);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		wrongGuessLabel.setLabel(wrongGuessLabel.getLabel() + letter);
		wrongGuess++;
		drawNext();
	}
	
	private void drawScaffold() {
		add(new GLine(20, 10, UPPER_ARM_LENGTH * 2, 10));
		add(new GLine(UPPER_ARM_LENGTH * 2, 10, UPPER_ARM_LENGTH * 2, 10 + ROPE_LENGTH));
		add(new GLine(20, 10, 20, SCAFFOLD_HEIGHT));
	}
	
	private void drawNext() {
		switch (wrongGuess) {
			case 1:
				add(new GOval(UPPER_ARM_LENGTH * 2 - HEAD_RADIUS, 10 + ROPE_LENGTH, HEAD_RADIUS * 2, HEAD_RADIUS * 2));
				break;
			case 2:
				add(new GLine(UPPER_ARM_LENGTH * 2.5 - HEAD_RADIUS, 10 + ROPE_LENGTH + HEAD_RADIUS * 2, UPPER_ARM_LENGTH * 2.5 - HEAD_RADIUS, BODY_LENGTH * 1.5));
				break;
			case 3:
				add(new GLine(UPPER_ARM_LENGTH * 2 - HEAD_RADIUS, BODY_LENGTH, UPPER_ARM_LENGTH * 2.5 - HEAD_RADIUS, BODY_LENGTH));
				break;
			case 4:
				add(new GLine(UPPER_ARM_LENGTH * 2.5 - HEAD_RADIUS, BODY_LENGTH, UPPER_ARM_LENGTH * 3 - HEAD_RADIUS, BODY_LENGTH));
				break;
			case 5:
				add(new GLine(UPPER_ARM_LENGTH * 2 - HEAD_RADIUS, BODY_LENGTH * 2, UPPER_ARM_LENGTH * 2.5 - HEAD_RADIUS, BODY_LENGTH * 1.5));
				break;
			case 6:
				add(new GLine(UPPER_ARM_LENGTH * 3 - HEAD_RADIUS, BODY_LENGTH * 2, UPPER_ARM_LENGTH * 2.5 - HEAD_RADIUS, BODY_LENGTH * 1.5));
				break;
			case 7:
				add(new GLine(UPPER_ARM_LENGTH * 1.75 - HEAD_RADIUS, BODY_LENGTH * 2, UPPER_ARM_LENGTH * 2 - HEAD_RADIUS, BODY_LENGTH * 2));
				break;
			case 8:
				add(new GLine(UPPER_ARM_LENGTH * 3 - HEAD_RADIUS, BODY_LENGTH * 2, UPPER_ARM_LENGTH * 3.25 - HEAD_RADIUS, BODY_LENGTH * 2));
				break;
		}
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
	
	private int wrongGuess = 0;
	private GLabel wordLabel;
	private GLabel wrongGuessLabel;
}

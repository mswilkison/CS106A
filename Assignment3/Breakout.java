/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/** Runs the Breakout program. */
	public void run() {
		setup();
		addMouseListeners();
		play();
	}
			
	private void setup() {
		for (int row = 0; row < NBRICK_ROWS; row++) {
			for (int col = 0; col < NBRICKS_PER_ROW; col++) {
				addBrick(col, row);
			}
		}
		addPaddle();
	}
	
	public void mouseMoved(MouseEvent e) {
		double paddleX = e.getX() - PADDLE_WIDTH / 2;
		double paddleMax = WIDTH - PADDLE_WIDTH;
		if (paddleX < 0){
			paddleX = 0;
		} else if (paddleX > paddleMax){
			paddleX = paddleMax;
		}
		paddle.setLocation(paddleX, PADDLE_Y_COORD);
	}
	
	private void addBrick(int col, int row) {
		int xCoord = BRICK_SEP + col * (BRICK_SEP + BRICK_WIDTH);
		int yCoord = BRICK_Y_OFFSET + row * (BRICK_HEIGHT + BRICK_SEP);
		GRect brick = new GRect(xCoord, yCoord, BRICK_WIDTH, BRICK_HEIGHT);
		Color color = Color.RED;
		if (row == 2 || row == 3) {
			color = Color.ORANGE;
		} else if (row == 4 || row == 5) {
			color = Color.YELLOW;
		} else if (row == 6 || row == 7) {
			color = Color.GREEN;
		} else if (row == 8 || row == 9) {
			color = Color.CYAN;
		}
		brick.setFilled(true);
		brick.setColor(color);
		add(brick);
	}
	
	private void addPaddle() {
		paddle = new GRect(PADDLE_X_COORD, PADDLE_Y_COORD, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.BLACK);
		add(paddle);
	}
	
	private void play() {
		addBall();
		moveBall();
	}
	
	private void addBall() {
		ball = new GOval((WIDTH - BALL_RADIUS * 2) / 2, (HEIGHT - BALL_RADIUS * 2) / 2, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		ball.setColor(Color.MAGENTA);
		add(ball);
	}
	
	private void moveBall() {
		vy = 3.0;
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean()) vx = -vx;
		while (bricksRemaining > 0) {
			if (ball.getY() > HEIGHT - BALL_RADIUS * 2) break;
			if (ball.getY() < 0 + BALL_RADIUS * 2) {
				vy = -vy;
				bounceClip.play();
			}
			if (ball.getX() > WIDTH - BALL_RADIUS * 2 ||
					ball.getX() < 0 + BALL_RADIUS * 2) {
				vx = -vx;
				bounceClip.play();
			}
			ball.move(vx, vy);
			GObject collider = getCollidingObject();
			if (collider == paddle) {
				vy = -vy;
				bounceClip.play();
			} else if (collider != null) {
				remove(collider);
				bricksRemaining--;
				vy = -vy;
				bounceClip.play();
			}
			pause(DELAY);
		}
	}
	
	private GObject getCollidingObject() {
		double x = ball.getX();
		double y = ball.getY();
		if (getElementAt(x, y) != null) {
			return getElementAt(x, y);
		} else if (getElementAt(x + 2 * BALL_RADIUS, y) != null) {
			return getElementAt(x + 2 * BALL_RADIUS, y);
		} else if (getElementAt(x, y + 2 * BALL_RADIUS) != null) {
			return getElementAt(x, y + 2 * BALL_RADIUS);
		} else if (getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS) != null) {
			
		}
		return null;
	}
	
	private static final int PADDLE_X_COORD = (WIDTH - PADDLE_WIDTH) / 2;
	private static final int PADDLE_Y_COORD = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
	// instance variables
	private GRect paddle;
	private GOval ball;
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int bricksRemaining = NBRICK_ROWS * NBRICKS_PER_ROW;
	private int DELAY = 10;
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
}

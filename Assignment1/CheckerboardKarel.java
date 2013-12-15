/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run() {

		doRow();
		while (frontIsBlocked()) {
			if (facingEast()) {
				if (leftIsBlocked()) break;
				turnLeft();
				move();
				turnLeft();
				move();
				doRow();
			} else if (facingWest()) {
				if (rightIsBlocked()) break;
				turnRight();
				move();
				turnRight();
				doRow();
			}
		}
	}
	
	private void doRow() {
		putBeeper();
		while(frontIsClear()) {
			move();
			if (frontIsBlocked()) break;
			move();
			putBeeper();
		}
	}	
}

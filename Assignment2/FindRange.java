/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		println("This program finds the largest and smallest numbers.");
		int num = readInt(" ? ");
		int max = num;
		int min = num;
		while (true) {
			if (num == SENTINEL) break;
			num = readInt(" ? ");
			if (num > max) max = num;
			if (num < min) min = num;
		}
		
		if (max == 0 || min == 0) {
			println("You didn't enter any numbers!");
		} else {
			println("smallest: " + min);
			println("largest: " + max);
		}
	}
	
	private static final int SENTINEL = 0;
}


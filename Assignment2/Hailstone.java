/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int num = readInt("Enter a number: ");
		int count = 0;
		while (num != 1) {
			if (num % 2 == 0) {
				println(num + "    is even, so I take half: " + (num / 2));
				num /= 2;				
			} else {
				println(num + "    is odd, so I make 3n + 1: " + (3 * num + 1));
				num = 3 * num + 1;
			}
			count++;
		}
		println("The process took " + count + " steps to reach 1");
	}
}


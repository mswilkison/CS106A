/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	public void run() {
		GRect program = new GRect((getWidth() - CLASS_WIDTH) / 2, 0, CLASS_WIDTH, CLASS_HEIGHT);
		program.setColor(Color.BLACK);
		add(program);
		GLine leftLine = new GLine((getWidth() + CLASS_WIDTH * .25) / 2, CLASS_HEIGHT, CLASS_WIDTH / 2, CLASS_HEIGHT * 2);
		add(leftLine);
		GLine midLine = new GLine((getWidth() + CLASS_WIDTH * .25) / 2, CLASS_HEIGHT, (getWidth() + CLASS_WIDTH * .25) / 2, CLASS_HEIGHT * 2);
		add(midLine);
		GLine rightLine = new GLine((getWidth() + CLASS_WIDTH * .25) / 2, CLASS_HEIGHT, (getWidth() - CLASS_WIDTH * .5), CLASS_HEIGHT * 2);
		add(rightLine);
		GRect graphicsProgram = new GRect(0, CLASS_HEIGHT * 2, CLASS_WIDTH, CLASS_HEIGHT);
		graphicsProgram.setColor(Color.BLACK);
		add(graphicsProgram);
		
		GRect consoleProgram = new GRect((getWidth() - CLASS_WIDTH) / 2, CLASS_HEIGHT * 2, CLASS_WIDTH, CLASS_HEIGHT);
		consoleProgram.setColor(Color.BLACK);
		add(consoleProgram);
		
		GRect dialogProgram = new GRect((getWidth() - CLASS_WIDTH), CLASS_HEIGHT * 2, CLASS_WIDTH, CLASS_HEIGHT);
		dialogProgram.setColor(Color.BLACK);
		add(dialogProgram);
	}
	
	private static final int CLASS_WIDTH = 50;
	private static final int CLASS_HEIGHT = 25;
}


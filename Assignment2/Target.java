/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		
		double outerRadius = (double) PIXELS_PER_INCH / 2;
		double middleRadius = outerRadius * .65;
		double innerRadius = outerRadius * .3;
		GOval outer = new GOval((getWidth() - outerRadius) / 2, (getHeight() - outerRadius) / 2, outerRadius, outerRadius);
		outer.setFilled(true);
		outer.setColor(Color.RED);
		GOval middle = new GOval((getWidth() - middleRadius) / 2, (getHeight() - middleRadius) / 2, middleRadius, middleRadius);
		middle.setFilled(true);
		middle.setColor(Color.WHITE);
		GOval inner = new GOval((getWidth() - innerRadius) / 2, (getHeight() - innerRadius) / 2, innerRadius, innerRadius);
		inner.setFilled(true);
		inner.setColor(Color.RED);
		
		add(outer);
		add(middle);
		add(inner);
	}
	
	private static final int PIXELS_PER_INCH = 72;
}

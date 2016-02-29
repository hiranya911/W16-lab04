package edu.ucsb.cs56.w16.drawings.sschwellenbach.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;


import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a basketball that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sierra Schwellenbach
   @version for CS56, W16, UCSB
   
*/
public class Basketball extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of basketball
       @param y y coord of upper left corner of basketball
       @param radius radius of basketball
    */
    public Basketball(double x, double y, double radius)
    {

	// create circle for ball
        Ellipse2D.Double Circle = new Ellipse2D.Double(x, y , radius *2, radius * 2);

	//create straight lines for ball
	GeneralPath straightLines = new GeneralPath();
	straightLines.moveTo(x + radius, y);
	straightLines.lineTo(x + radius, y + radius * 2); //make vertical line for ball
	straightLines.moveTo(x, y + radius);
	straightLines.lineTo(x + radius * 2 , y + radius); //make horizontal line for ball
	
	//create curved lines for ball
	Path2D.Double curvedLines = new Path2D.Double();

	//first curved line
	double X1 = x + radius - radius / Math.sqrt(2);
	double Y1 = y + radius - radius / Math.sqrt(2);
	double X2 = x + radius * 2 / 3;
	double Y2 = y + radius;
	double X3 = X1;
	double Y3 = y + radius +  radius / Math.sqrt(2);
	
	curvedLines.moveTo(X1, Y1);
	curvedLines.curveTo(X1, Y1, X2, Y2, X3, Y3);

	//second curved line
	X1 = x + radius + radius / Math.sqrt(2);
	X2 = x + radius * 4 / 3;
	X3 = X1;
	
	curvedLines.moveTo(X1, Y1);
	curvedLines.curveTo(X1, Y1, X2, Y2, X3, Y3);

	//draw ball
        GeneralPath wholeBasketball = this.get();
        wholeBasketball.append(Circle, false);
	wholeBasketball.append(straightLines, false);
	wholeBasketball.append(curvedLines, false);
    }
}

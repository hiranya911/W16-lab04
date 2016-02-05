package edu.ucsb.cs56.w16.drawings.sschwellenbach.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

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
        Ellipse2D.Double Circle = new Ellipse2D.Double(x, y , radius, radius);
	
	GeneralPath straightLines = new GeneralPath();
	straightLines.moveTo(x + radius, y);
	straightLines.lineTo(x + radius, y + radius * 2); //make vertical line for ball
	straightLines.moveTo(x, y + radius);
	straightLines.lineTo(x + radius * 2 , y + radius); //make horizontal line for ball
	
        GeneralPath wholeBasketball = this.get();
        wholeBasketball.append(Circle, false);
	wholeBasketball.append(straightLines, false);
	
    }
}

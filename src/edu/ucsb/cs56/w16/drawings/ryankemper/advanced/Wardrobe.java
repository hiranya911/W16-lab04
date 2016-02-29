package edu.ucsb.cs56.w16.drawings.ryankemper.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Ellipse2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a wardrobe that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Ryan Kemper
   @version for CS56, W16, UCSB
   
*/
public class Wardrobe extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of wardrobe
       @param y y coord of lower left corner of wardrobe
       @param width width of the wardrobe
       @param height height of wardrobe
    */
    public Wardrobe(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double doorHeight = height;
                
        double doorUpperLeftY = y;
        
        // Make the doors
        
        Rectangle2D.Double leftDoor = 
            new Rectangle2D.Double(x, doorUpperLeftY ,
				   width/2, doorHeight);
	Rectangle2D.Double rightDoor =
	    new Rectangle2D.Double(x+(width/2), doorUpperLeftY,
				   width/2, doorHeight);
				   
	
        // make the mirror.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
	
        Ellipse2D.Double mirror =
	    new Ellipse2D.Double(x, y,
				 width, doorHeight);
	
        // put the whole wardrobe together
	
        GeneralPath wholeWardrobe = this.get();
        wholeWardrobe.append(leftDoor, false);
	wholeWardrobe.append(rightDoor, false);
	wholeWardrobe.append(mirror, false);
        
    }
}

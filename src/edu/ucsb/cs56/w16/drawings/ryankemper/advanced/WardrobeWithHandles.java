package edu.ucsb.cs56.w16.drawings.ryankemper.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Ellipse2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a wardrobe with handles that
   implements the Shape interface, and so can be
   drawn, as well as rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Ryan Kemper
   @version for CS56, W16, UCSB
   
*/
public class WardrobeWithHandles extends Wardrobe
{
    /**
       Constructor
       
       @param x x coord of lower left corner of wardrobe
       @param y y coord of lower left corner of wardrobe
       @param width width of the wardrobe
       @param height height of wardrobe
    */
    public WardrobeWithHandles(double x, double y, double width, double height)
    {
	super(x,y,width,height);
	        	
        // make the handles.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
	
        Ellipse2D.Double leftHandle  =
	    new Ellipse2D.Double(x + width/6, y + height/2.5,
				 width/6, height/6);
	Ellipse2D.Double rightHandle =
	    new Ellipse2D.Double(x + width/2 + width/6, y + height/2.5,
				 width/6, height/6);
	
        // put the whole wardrobe with handles together
	
        GeneralPath wholeWardrobe = this.get();
        wholeWardrobe.append(leftHandle, false);
	wholeWardrobe.append(rightHandle, false);
    }
}

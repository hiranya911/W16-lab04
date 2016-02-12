package edu.ucsb.cs56.w16.drawings.metomario.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a basic Logo that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Ben Zhu
   @version for CS56, W16, UCSB
   
*/
public class Logo extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param length side length of the logo
    */
    public Logo(int length)
    {
        int sideLength = length;
	
        Rectangle2D.Double Square = new Rectangle2D.Double(0,0,sideLength,sideLength);
	
        GeneralPath LogoIcon = this.get();
	LogoIcon.append(Square,false);
	
    }
}

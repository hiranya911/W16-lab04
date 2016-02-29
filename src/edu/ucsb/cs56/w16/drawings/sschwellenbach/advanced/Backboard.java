package edu.ucsb.cs56.w16.drawings.sschwellenbach.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a backboard that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sierra Schwellenbach
   @version for CS56, W16, UCSB
   
*/
public class Backboard extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of backboard
       @param y y coord of upper left corner of backboard
       @param width width of the backboard
       @param height of backboard
    */
    public Backboard(double x, double y, double width, double height)
    {
	
        double aimSquareX = x + width / 4;
	double aimSquareY = y + height/2;
	double aimSquareWidth = width / 2;
	double aimSquareHeight = height / 2;
	

	//create backboard components
        Rectangle2D.Double LargeSquare = 
            new Rectangle2D.Double(x, y ,width, height);
	Rectangle2D.Double aimSquare =
	    new Rectangle2D.Double(aimSquareX, aimSquareY, aimSquareWidth, aimSquareHeight);
	
        GeneralPath wholeBackboard = this.get();
        wholeBackboard.append(LargeSquare, false);
        wholeBackboard.append(aimSquare, false);
    }
}

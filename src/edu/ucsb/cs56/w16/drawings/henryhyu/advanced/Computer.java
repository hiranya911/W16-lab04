package edu.ucsb.cs56.w16.drawings.henryhyu.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

// all imports needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Computer that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Henry Yu
   @version for CS56, W16, UCSB
   
*/
public class Computer extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of top left corner of the Computer
       @param y y coord of top left corner of the Computer
       @param side side length of the Computer
    */
    public Computer(double x, double y, double side)
    {
	//draw the computer 
	Rectangle2D.Double computer = new Rectangle2D.Double(x,y,side,side);
	
	//draw the stand 
		Line2D.Double vertStand =
		    new Line2D.Double(x + side/2.0, y + side, x + side/2.0 , y + side*1.2); 

		Line2D.Double horizStand =
		    new Line2D.Double(x, y + side*1.21, x + side, y + side*1.21);
	
	//put the Computer together
	GeneralPath wholeComputer = this.get();
	wholeComputer.append(computer, false);
	wholeComputer.append(vertStand,false);
	wholeComputer.append(horizStand,false);

 }
}

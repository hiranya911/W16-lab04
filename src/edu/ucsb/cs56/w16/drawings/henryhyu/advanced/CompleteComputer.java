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
   A Computer
      
   @author Phill Conrad 
   @author Henry Yu
   @version for CS56, W16, UCSB
   
*/
public class CompleteComputer extends Computer implements Shape
{
    /**
     * Constructor for objects of class CompleteComputer
     
       @param x x coor of top left corner
       @param y y coor of top left corner 
       @param side side length of Computer
     */
    public CompleteComputer(double x, double y, double side)
    {   
	super(x,y,side);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// variable for the x coordinate of the desktop
	double x1 = (x + side*1.5)+side/2.0;

	//drawing the desktop
	Rectangle2D.Double desktop = new Rectangle2D.Double(x+side*1.5, y, side*0.8, side*1.2);
	Line2D.Double decor = new Line2D.Double(x1, y, x1, y+side*1.2);
	
	gp.append(desktop,false);
	gp.append(decor,false);
	      	    
    }
}

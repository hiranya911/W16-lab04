package edu.ucsb.cs56.w16.drawings.tang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.Polygon;

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Path2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Franklin Tang
   @version for CS56, W16, UCSB
   
*/
public class Star extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of Star
       @param y y coord of lower left corner of Star
       @param edge of the Star
      
    */
    public Star(double x, double y, double edge)
    {
	
	double side = edge;
	double starX = x - (side/2)*(Math.cos(32*Math.PI/100));
	double starY = y + (side/2)*(Math.sin(32*Math.PI/100));

	double movex = side*Math.cos((2*Math.PI)/10);
	double movey = side*Math.sin((2*Math.PI)/10);
	double movx = side*Math.cos((2*Math.PI)/5);
	double movy = side*Math.sin((2*Math.PI)/5);
	
        GeneralPath star = new GeneralPath();
	
	star.moveTo(starX, starY);
	star.lineTo(starX + movex, starY - movey);
	star.lineTo(starX + movex - side, starY - movey);
	star.lineTo(starX + 2*movex -side, starY);
	star.lineTo(starX + 2*movex -side-movx, starY-movy);
        //star.lineTo(x,y); doesn't matter
	star.closePath();

	GeneralPath wholeStar = new GeneralPath();
	wholeStar.append(star,false);
	this.set(wholeStar);
	

	
    }
}

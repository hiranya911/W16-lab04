package edu.ucsb.cs56.w16.drawings.tang.advanced;

/**
 * Circle extends Ellipse2D to make it easier to draw circles
 * because the parameters to the constructor are more convenient
 * 
 * @author Franklin
 * @version CS56, W16, UCSB
 */

public class Circles 
    extends java.awt.geom.Ellipse2D.Double 
    implements java.awt.Shape
{ 
    /**
     * Constructor for objects of class Circles
     * @param x    x coordinate of center of circles
     * @param y    y coordinate of center of circles
     * @param r    radius of circles
     */
    public Circles(double x, double y, double r)
    {
        // invoke the super class constructor,
        // i.e. the one for Ellipse2D.Double, which takes
        // upper-left-x, upper-left-y (of the bounding box)
        // width, and height


	super( x - r, y - r,   /* upper left corner of bounding box */
               r * 2,  r * 2);

	
    }    
}

package edu.ucsb.cs56.w16.drawings.matthewcheung.advanced;

import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**                                                                                                                                         
   A vector drawing of a ring that implements                                                                                              
   the Shape interface
                                                                                                                                            
   @author Matthew Cheung                                                                                                                  
   @version for CS56, W16, UCSB                                                                                                         
                                                                                                                                       
*/


public class Ring extends GeneralPathWrapper implements Shape
{

    /**
       Constructor
       @param x x coord of top left of outer ring
       @param y y coord of top left of outer ring
       @param width width of outer ring
       @param height height of outer ring
    */

    public Ring(double x, double y, double width, double height)
    {
	
	Ellipse2D.Double innerRing = new Ellipse2D.Double(x+.15*width, y+.15*height, width*.7, height*.7);
	Ellipse2D.Double outerRing = new Ellipse2D.Double(x, y, width, height);
	GeneralPath wholeRing = this.get();
	wholeRing.append(innerRing, false);
	wholeRing.append(outerRing, false);

    }
}

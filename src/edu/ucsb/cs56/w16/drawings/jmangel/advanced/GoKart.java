package edu.ucsb.cs56.w16.drawings.jmangel.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a goKart that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author John Mangel 
   @version for CS56, W16, UCSB
   
*/
public class GoKart extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of goKart
       @param y y coord of lower left corner of goKart
       @param width width of the goKart
       @param height of goKart
    */
    public GoKart(double x, double y, double width, double height)
    {	
				double radius=width/10;
				Circle frontTire=new Circle(x+radius,y-radius,radius);
				Circle backTire=new Circle(x+width-radius,y-radius,radius);

				Line2D.Double floor=new Line2D.Double(x+radius*2,y-radius,x+width-2*radius,y-radius);
				Line2D.Double seat=new Line2D.Double(x+(width*3/4),y-radius,x+(width*3/4),y-height);
				Line2D.Double pedal=new Line2D.Double(x+(width*2/5),y-radius,x+(width/4),y-((height-radius)*3/7));

				// put the whole GoKart together

				GeneralPath wholeGoKart = this.get();
				wholeGoKart.append(floor, false);
				wholeGoKart.append(seat, false);
				wholeGoKart.append(pedal, false);
				wholeGoKart.append(frontTire, false);
				wholeGoKart.append(backTire, false);
		}
}

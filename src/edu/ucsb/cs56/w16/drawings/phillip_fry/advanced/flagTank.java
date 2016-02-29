package edu.ucsb.cs56.w16.drawings.phillip_fry.advanced;
import java.awt.geom.GeneralPath;  //combinations of lines and curves
import java.awt.Shape;             //general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
/**
   
   A tank with a flag

   @author Phillip Fry
   @version for CS56, W16, UCSB
*/
public class flagTank extends Tank implements Shape
{
    /**
     * Constructor for objects of class flagTank
     
       @param x x coor of top left corner
       @param y y coor of top left corner 
       @param length of barrel
       @param height of body
     */

    public flagTank(double x, double y, double blength, double height)
    {
	super(x,y,blength,height);
	GeneralPath gp = this.get();

	double flagheight = height/4;
	double flagx = x + 2*height;
	double flagy = y + .3*height;
	double flagwidth = height/2;
	double insidesheight = height/8;
	double insideslength = height/4;
	

	//draw flag
	Rectangle2D.Double flagoutline =
	    new Rectangle2D.Double(flagx, flagy, flagwidth, flagheight);
	Rectangle2D.Double flaginside =
	    new Rectangle2D.Double(flagx, flagy, insideslength, insidesheight);

	GeneralPath Tank = this.get();
	Tank.append(flagoutline,false);
	Tank.append(flaginside,false);
    }
}

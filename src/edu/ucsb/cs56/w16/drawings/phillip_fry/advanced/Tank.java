package edu.ucsb.cs56.w16.drawings.phillip_fry.advanced;
import java.awt.geom.GeneralPath;  //combinations of lines and curves
import java.awt.Shape;             //general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
/**
   A vector drawing of a tank that implements the Shape interface,
   and can be drawn

   @author Phillip Fry
   @version for CS56, W16, UCSB
*/
public class Tank extends GeneralPathWrapper implements Shape
{
/**
Constructor
@param x x coord of upper left corner of tank facing left always
@param y y coord of upper left corner of tank facing left always
@param length of barrel
@param height of body
*/
    public Tank(double x, double y, double blength, double height)
    {
	//for upper body
	double bodylength = 3*height;
	double barrelheight = height/3;
	double wheelheight = height/2;
	double locateybarrel = y + (height/3);
	double xtop = x + (bodylength*.4);
	double toph = height/3;
	double toplength = bodylength/3;
	double wheelr = bodylength/4;
	double wheel2x = x + (bodylength/4);
	double wheel3x = x + (bodylength/2);
	double wheel4x = x + (bodylength*.75);

	// make the body
	Rectangle2D.Double body =
	    new Rectangle2D.Double(x, y, bodylength, height);

	//make topstack
	Rectangle2D.Double top =
	    new Rectangle2D.Double(xtop, y-toph, toplength, toph);

	//make the barrel
	Rectangle2D.Double barrel =
	    new Rectangle2D.Double(x-blength, locateybarrel, blength, barrelheight);

	//make wheels
	Ellipse2D.Double wheelone =
	    new Ellipse2D.Double(x, y+height, wheelr, wheelheight);

	Ellipse2D.Double wheeltwo =
	    new Ellipse2D.Double(wheel2x, y+height, wheelr, wheelheight);

	Ellipse2D.Double wheelthree =
	    new Ellipse2D.Double(wheel3x, y+height, wheelr, wheelheight);

	Ellipse2D.Double wheelfour =
	    new Ellipse2D.Double(wheel4x, y+height, wheelr, wheelheight);


	//put tank together
	GeneralPath Tank=this.get();
	Tank.append(body,false);
	Tank.append(barrel,false);
	Tank.append(top,false);
	Tank.append(wheelone,false);
	Tank.append(wheeltwo,false);
	Tank.append(wheelthree,false);
	Tank.append(wheelfour,false);
    }
}

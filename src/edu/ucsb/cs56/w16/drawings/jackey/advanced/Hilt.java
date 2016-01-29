package edu.ucsb.cs56.w16.drawings.jackey.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jackey Lau 
   @version for CS56, W16, UCSB
   
*/
public class Hilt extends GeneralPathWrapper implements Shape
{
         
    /**
       Constructor
       
       @param x x coord of upper left corner of hilt
      
    */
         
    public Hilt(Double x)
    {
	Line2D.Double top1 = new Line2D.Double(x,-20,x+60,0);
	Line2D.Double top2 = new Line2D.Double(x+60,0,x+60,010);
	Line2D.Double top3 = new Line2D.Double(x,-20,x,010);
	Line2D.Double top4 = new Line2D.Double(x,010,x+60,010);

	Rectangle2D.Double box1 = new Rectangle2D.Double(x-4,010,68,21);

	Rectangle2D.Double box2 = new Rectangle2D.Double(x,29,60,31);

	Rectangle2D.Double box3 = new Rectangle2D.Double(x,36,18,18);

	Rectangle2D.Double box4 = new Rectangle2D.Double(x-4,60,68,30);

	Rectangle2D.Double box5 = new Rectangle2D.Double(x,90,60,100);

	Rectangle2D.Double box6 = new Rectangle2D.Double(x,190,60,5);
	
	GeneralPath wholeHilt = this.get();
	wholeHilt.append(top1,false);
	wholeHilt.append(top2,false);
	wholeHilt.append(top3,false);
	wholeHilt.append(top4,false);
	wholeHilt.append(box1,false);
	wholeHilt.append(box2,false);
	wholeHilt.append(box3,false);
	wholeHilt.append(box4,false);
	wholeHilt.append(box5,false);
	wholeHilt.append(box6,false);

	//Shape s = ShapeTransforms.scaledCopyOf(wholeHilt,.2,.2);
	Shape s = ShapeTransforms.translatedCopyOf(wholeHilt,0,500);
	this.set(new GeneralPath(s));
    }

    
     
}

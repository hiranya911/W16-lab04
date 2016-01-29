package edu.ucsb.cs56.w16.drawings.matthewcheung.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Line2D;


/**                                                                                                                                         
   A vector drawing of a diamond ring that implements                                                                                       
   the Shape interface                                                                                                                     
   @author Matthew Cheung                                                                                                                   
   @version for CS56, W16, UCSB                                                                                                           
*/


public class DiamondRing extends Ring implements Shape{

    /**                                                                                                                                     
       Constructor                                                                                                                         
       @param x x coord of top left of outer ring                                                                                          
       @param y y coord of top left of outer ring                                                                                         
       @param width width of outer ring                                                                                                   
       @param height height of outer ring                                                                                                  
*/

    public DiamondRing(double x, double y, double width, double height)
    {

	super(x,y,width,height);
	GeneralPath gp = this.get();

        Line2D.Double topLine = new Line2D.Double (x+width*0.42, y - height/4, x+width*0.58, y - height/4);
        Line2D.Double midLine = new Line2D.Double (x+width*0.35, y - height/6, x+width*0.65, y - height/6);
        Line2D.Double left = new Line2D.Double( x + width*0.5, y, x+width*.35, y - height/6);
        Line2D.Double right = new Line2D.Double( x + width*0.5, y, x + width*.65, y - height/6);
        Line2D.Double leftTop = new Line2D.Double( x + width*0.35, y - height/6, x+width*.42, y - height/4);
        Line2D.Double rightTop = new Line2D.Double( x + width*0.65, y - height/6, x + width*.58, y - height/4);
        Line2D.Double middleLeftTop = new Line2D.Double( x + width*0.44, y - height/6, x+width*.48, y - height/4);
        Line2D.Double middleRightTop = new Line2D.Double( x + width*0.56, y - height/6, x + width*.52, y - height/4);
        Line2D.Double middleLeft = new Line2D.Double( x + width*0.5, y, x+width*.45, y - height/6);
        Line2D.Double middleRight = new Line2D.Double( x + width*0.5, y, x + width*.55, y - height/6);

	GeneralPath wholeDiamondRing = this.get();
	wholeDiamondRing.append(topLine, false);
	wholeDiamondRing.append(midLine, false);
	wholeDiamondRing.append(left, false);
	wholeDiamondRing.append(right, false);
	wholeDiamondRing.append(leftTop, false);
	wholeDiamondRing.append(rightTop, false);
	wholeDiamondRing.append(middleLeftTop, false);
	wholeDiamondRing.append(middleRightTop, false);
	wholeDiamondRing.append(middleLeft, false);
	wholeDiamondRing.append(middleRight, false);
    }
}

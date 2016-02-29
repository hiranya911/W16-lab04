package edu.ucsb.cs56.w16.drawings.jmangel.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

/**
   A GoKart with a RollCage
      
   @author John Mangel
   @version for CS56, W16, UCSB
   
*/
public class GoKartWithRollCage extends GoKart implements Shape
{
    /**
     * Constructor for objects of class GoKart
     */
    public GoKartWithRollCage(double x, double y, double width, double height)
    {
			// construct the basic house shell
			super(x,y,width,height);
	
			// get the GeneralPath that we are going to append stuff to
			GeneralPath gp = this.get();

			double radius=width/10;	
			Line2D.Double rollBar1=new Line2D.Double(x+radius,y-(radius*2),x+radius+((width-(radius*4))/3),y-height);
			Line2D.Double rollBar2=new Line2D.Double(x+radius+((width-(radius*4))/3),y-height,x+(width*3/4),y-height);
			Line2D.Double rollBar3=new Line2D.Double(x+(width*3/4),y-height,x+width-radius,y-(radius*2));

      GeneralPath wholeGoKart = this.get();
      wholeGoKart.append(rollBar1, false);
      wholeGoKart.append(rollBar2, false);
    	wholeGoKart.append(rollBar3, false);
    }    
}

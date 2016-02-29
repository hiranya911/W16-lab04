package edu.ucsb.cs56.w16.drawings.jackey.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
/**
   A LightSaber
      
   @author Jackey Lau
   @version for CS56, W16, UCSB
   
*/
public class LightSaber extends Hilt implements Shape
{
    public LightSaber(double x)
    {
	super(x);

	Rectangle2D.Double beam = new Rectangle2D.Double(x+2,100,56,429);
	
	
	GeneralPath wholeHouse = this.get();

	wholeHouse.append(beam,false);
    }

}

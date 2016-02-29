package edu.ucsb.cs56.w16.drawings.tang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   StarShield
      
   @author Franklin Tang
   @version for CS56, W16, UCSB
   
*/
public class StarShield extends Star implements Shape
{
    /**
     * Constructor for objects of class StarShield
     */
    public StarShield(double x, double y, double edge)
    {
	// construct the basic star 
	super(x,y,edge); // the edge will also be shield radius
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	

	
	double r1 = 0.5*edge;
	double r2 = 0.75*edge;
	double r3 = edge;
	double r4 = 1.25*edge;

	Circles x1 = new Circles(x,y,r1);
	Circles x2 = new Circles(x,y,r2);
	Circles x3 = new Circles(x,y,r3);
	Circles x4 = new Circles(x,y,r4);

	
        GeneralPath wholeShield = this.get();
        wholeShield.append(x1, false);
        wholeShield.append(x2, false);
        wholeShield.append(x3, false);
	wholeShield.append(x4, false); 
    }    
}

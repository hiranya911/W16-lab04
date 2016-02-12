package edu.ucsb.cs56.w16.drawings.metomario.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
   Dota2 Logo
      
   @author Ben Zhu
   @version for CS56, W16, UCSB
   
*/
public class Dota2Logo extends Logo implements Shape
{
    /**
     * Constructor for objects of class Dota2Logo
     * @param length side length
     */
    public Dota2Logo(int length)
    {
	// construct a generic Logo
	super(length);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	//start points for three shapes
	double llc_x_start = 0.11 * length ;
	double llc_y_start = 0.75 * length ;
	double mid_x_start = 0.11 * length ;
	double mid_y_start = 0.18 * length;
	double urc_x_start = 0.6 * length;
	double urc_y_start = .2 * length;
	
	//Draw lower left-hand corner shape 
	Line2D.Double llc_1 = 
	    new Line2D.Double(llc_x_start, llc_y_start, llc_x_start + 0.08 * length, llc_y_start - 0.16 * length);
		
	Line2D.Double llc_2 = 
		new Line2D.Double( llc_x_start + 0.08 * length, llc_y_start - 0.16 * length, llc_x_start + 0.28 * length, llc_y_start + 0.04 * length);
		
	Line2D.Double llc_3 = 
	    new Line2D.Double(llc_x_start + 0.28 * length, llc_y_start + 0.04 * length, llc_x_start + 0.11 * length, llc_y_start + 0.11 * length);
		
	Line2D.Double llc_4 = 
	    new Line2D.Double(llc_x_start + 0.11 * length, llc_y_start + 0.11 * length, llc_x_start, llc_y_start);		
		
	//Draw middle shape
	Line2D.Double mid_1 = 
		 new Line2D.Double(mid_x_start, mid_y_start, mid_x_start + 0.08 * length, mid_y_start - 0.04 * length);

	Line2D.Double mid_2 = 
		 new Line2D.Double(mid_x_start + 0.08 * length, mid_y_start - 0.04 * length, mid_x_start + 0.84 * length, mid_y_start + 0.46 * length);
		 
	Line2D.Double mid_3 =
		 new Line2D.Double(mid_x_start + 0.84 * length, mid_y_start + 0.46 * length, mid_x_start + 0.77 * length, mid_y_start + 0.66 * length);
		
	Line2D.Double mid_4 =
		 new Line2D.Double(mid_x_start + 0.77 * length, mid_y_start + 0.66 * length, mid_x_start + 0.64 * length, mid_y_start + 0.66 * length);
		 
	Line2D.Double mid_5 =
		 new Line2D.Double(mid_x_start + 0.64 * length, mid_y_start + 0.66 * length, mid_x_start, mid_y_start);

	//Draw upper right-hand corner shape 
	Line2D.Double urc_1 = 
		new Line2D.Double(urc_x_start, urc_y_start, urc_x_start + 0.16 * length, urc_y_start - 0.05 * length);
	Line2D.Double urc_2 = 
		new Line2D.Double(urc_x_start + 0.16 * length, urc_y_start - 0.05 * length, urc_x_start + 0.23 * length, urc_y_start);
	Line2D.Double urc_3 = 
		new Line2D.Double(urc_x_start + 0.23 * length, urc_y_start, urc_x_start + 0.21, urc_y_start + 0.16 * length);
	Line2D.Double urc_4 = 
		 new Line2D.Double(urc_x_start + 0.21, urc_y_start + 0.16 * length,urc_x_start, urc_y_start);
		 
	// add the Dota2 Logo details to the basic logo

	
        GeneralPath Dota2 = this.get();
        Dota2.append(llc_1, false);
        Dota2.append(llc_2, false);
        Dota2.append(llc_3, false); 
		Dota2.append(llc_4, false);
		
        Dota2.append(mid_1, false);
        Dota2.append(mid_2, false);
		Dota2.append(mid_3, false); 
		Dota2.append(mid_4, false);
        Dota2.append(mid_5, false);
		
		Dota2.append(urc_1, false);
        Dota2.append(urc_2, false);
        Dota2.append(urc_3, false); 
        Dota2.append(urc_4, false); 
    }    
}

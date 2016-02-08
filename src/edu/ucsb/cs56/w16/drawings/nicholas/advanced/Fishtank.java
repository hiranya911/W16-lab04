package edu.ucsb.cs56.w16.drawings.nicholas.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Fishtank
      
   @author Nicholas Frey 
   @version for CS56, W16, UCSB
   
*/
public class Fishtank extends Cube implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Fishtank(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

  GeneralPath water = new GeneralPath();
  water.moveTo(x,y - 0.75*height);
  water.lineTo(x+width, y - 0.75*height);
  water.lineTo(x + 1.3*width, y - 1.1*height);
  water.lineTo(x + .3*width, y - 1.1*height);
  water.lineTo(x, y - 0.75*height);

  GeneralPath fish = new GeneralPath();
	
  double fx = 0.60 * width + x;
  double fy = -0.60 * height + y;

  fish.moveTo(fx, fy);
  fish.lineTo(fx + 0.05 * width, fy - 0.05 * height);
  fish.lineTo(fx + 0.15 * width, fy + 0.05 * height);
  fish.lineTo(fx + 0.15 * width, fy - 0.05 * height);
  fish.lineTo(fx + 0.05 * width, fy + 0.05 * height);
  fish.lineTo(fx, fy);

        GeneralPath wholeTank = this.get();
        //wholeHouse.append(win1, false);
        //wholeHouse.append(win2, false);
        wholeTank.append(water, false);
        wholeTank.append(fish, false); 
    }    
}

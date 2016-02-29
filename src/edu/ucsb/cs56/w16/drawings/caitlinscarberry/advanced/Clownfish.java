package edu.ucsb.cs56.w16.drawings.caitlinscarberry.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
/**
   A vector drawing of a clownfish that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Caitlin Scarberry 
   @version for CS56, W16, UCSB
 */


public class Clownfish extends Fish implements Shape{
    /**
       Constructor
       
       @param x x coord of upper left corner of fish
       @param y y coord of upper left corner of fish
       @param width width of the fish
       @param height of the fish
    */
    public Clownfish(double x, double y, double width, double height){

	//because the base shape uses curves,
	//it's esier to draw on a path with known size
	//and then scale later

	//make the basic fish
	super(0,0,150,100);
	GeneralPath base = this.get();

	//make the front stripe
	GeneralPath frontStripe = new GeneralPath();
	frontStripe.moveTo(120+30,12);
	frontStripe.quadTo(90+30,50,120+30,71);

	frontStripe.moveTo(110+30,5);
	frontStripe.quadTo(80+30,50,110+30,78);

	//make the middle stripe
	GeneralPath midStripe = new GeneralPath();
	midStripe.moveTo(60+30,2);
	midStripe.lineTo(70+30,37);

	midStripe.moveTo(72+30,80);
	midStripe.lineTo(72+30,89);

	midStripe.moveTo(45+30,7);
	midStripe.quadTo(60+30,42,53+30,87);

	//make the tail stripe
	GeneralPath tailStripe = new GeneralPath();
	tailStripe.moveTo(3+30,31);
	tailStripe.lineTo(3+30,66);

	tailStripe.moveTo(-14+30,35);
	tailStripe.lineTo(-14+30,64);

	//add all the stripes to the base path
	base.append(frontStripe,false);
	base.append(midStripe,false);
	base.append(tailStripe,false);

	Shape s = ShapeTransforms.translatedCopyOf(base, x, y);

	// scale to correct height and width
	s =  ShapeTransforms.scaledCopyOf(s,
					  width/150,
					  height/100) ;

	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup

	this.set(new GeneralPath(s));
	
	
    }
}

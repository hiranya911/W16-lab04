package edu.ucsb.cs56.w16.drawings.caitlinscarberry.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a fish that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
     
   @author Caitlin Scarberry
   @version for CS56, W16, UCSB
   
*/
public class Fish extends GeneralPathWrapper implements Shape
{   
    /**
     * Constructor for objects of class Fish
     */
    public Fish(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* fish
        
        final double ORIG_ULX = 70.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 100.0; 
        final double ORIG_WIDTH = 220.0; 

	// body of fish
        GeneralPath body = new GeneralPath();

	body.moveTo(100,100+100/2-10);
	body.quadTo(100+170,50,100+220,100+100/2);
	body.quadTo(100+150,100+100+20,100,100+100/2+10);

	GeneralPath tail = new GeneralPath();

	tail.moveTo(100,100+100/2-10);
	tail.lineTo(70,100+20);
	tail.lineTo(70,100+100-20);
	tail.lineTo(100,100+100/2+10);

	GeneralPath fin = new GeneralPath();

	fin.moveTo(100+220-60,100+70);
	fin.lineTo(100+220-100,100+80);
	fin.lineTo(100+220-105,100+35);
	fin.lineTo(100+220-70,100+45);

	Shape eye = new java.awt.geom.Ellipse2D.Double(100+200-16,100+32,10,10);

	GeneralPath mouth = new GeneralPath();
	mouth.moveTo(100+220,100+100/2);
	mouth.lineTo(100+210,100+100/2);
        
        // now we put the whole thing together ino a single path.
        GeneralPath wholeFish = new GeneralPath ();
        wholeFish.append(body, false);
	wholeFish.append(tail,false);
	wholeFish.append(fin,false);
	wholeFish.append(eye,false);
	wholeFish.append(mouth,false);
        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeFish, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));

    }
}

package edu.ucsb.cs56.w16.drawings.nicholas.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Cube (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.   
      
   @author Nicholas Frey
   @version for CS56, W16, UCSB
   
*/
public class Cube extends GeneralPathWrapper implements Shape
{   
    /**
     * Constructor for objects of class Cube
     */
    public Cube(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* coffee cup
        
        final double ORIG_ULX = 200.0; 
        final double ORIG_ULY = 400.0; 
        final double ORIG_HEIGHT = 100.0; 
        final double ORIG_WIDTH = 100.0; 
        
        GeneralPath frontSide = new GeneralPath();
	
        // front side of cube
	
        frontSide.moveTo(200,400);
        frontSide.lineTo(300,400);
        frontSide.lineTo(300,300);
        frontSide.lineTo(200,300);
        frontSide.lineTo(200,400);
        
        Shape backSide = frontSide;
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 400 pixels
       
        backSide = ShapeTransforms.translatedCopyOf(backSide, 30.0, -35.0);
       
        // now we put the whole thing together ino a single path.
        
        GeneralPath bridgeLines = new GeneralPath();
        bridgeLines.moveTo(200,400);
        bridgeLines.lineTo(230,365);
        bridgeLines.moveTo(300,400);
        bridgeLines.lineTo(330,365);
        bridgeLines.moveTo(300,300);
        bridgeLines.lineTo(330,265);
        bridgeLines.moveTo(200,300);
        bridgeLines.lineTo(230,265);

        GeneralPath wholeCube = new GeneralPath ();
        wholeCube.append(frontSide, false);
        wholeCube.append(backSide, false);
        wholeCube.append(bridgeLines, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeCube, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}

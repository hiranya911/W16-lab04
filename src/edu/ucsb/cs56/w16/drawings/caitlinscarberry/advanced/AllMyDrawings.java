package edu.ucsb.cs56.w16.drawings.caitlinscarberry.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few fish
     */
    
    public static void drawPicture1(Graphics2D g2) {

	// Make one fish
	Shape f1 = new Fish(5,50,150,100);
	g2.setColor(Color.BLACK);
	g2.draw(f1);
	
	// Make two fish
	Shape f2 = new Clownfish(260,25,110,70);
	g2.draw(f2);
	f2 = ShapeTransforms.translatedCopyOf(f2,0,70);
	g2.draw(f2);
	
	// Make a red fish
	f1 = ShapeTransforms.translatedCopyOf(f1,0,250);
	g2.setColor(Color.RED); g2.draw(f1);
	
	// Make a blue fish
	f2 = ShapeTransforms.scaledCopyOfLL(f2, 1.5,1.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,0,250);
	g2.setColor(Color.BLUE); g2.draw(f2);
	
        
	// Sign and label drawing
	g2.setColor(Color.BLACK);
	g2.drawString("A few fish by Caitlin Scarberry", 20,20);
    }
    
    
    /** Draw a school of clownfish
     */
    public static void drawPicture2(Graphics2D g2) {
	// Make the stroke thicker
	g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
	
	// Draw the first fish
	Shape f1 = new Clownfish(5,50,120,80);
	g2.setColor(new Color(230,230,136));g2.draw(f1);

	// Draw the second fish
	f1 = ShapeTransforms.scaledCopyOfLL(f1, 1.1,1.1);
	f1 = ShapeTransforms.translatedCopyOf(f1,10,100);
        g2.setColor(new Color(255,200,140));g2.draw(f1);
	
	// Draw the third fish
	f1 = ShapeTransforms.scaledCopyOfLL(f1, .9,.9);
	f1 = ShapeTransforms.translatedCopyOf(f1,120,50);
        g2.setColor(new Color(200,160,100));g2.draw(f1);
	
	// Draw the fourth fish
	f1 = ShapeTransforms.scaledCopyOfLL(f1, 1.15,1.15);
	f1 = ShapeTransforms.translatedCopyOf(f1,30,-90);
        g2.setColor(new Color(225,105,135));g2.draw(f1);

	g2.setColor(Color.BLACK);
	g2.drawString("A school of clownfish  by Caitlin Scarberry", 20,20);
    }
    
    /** Draw a few fish laughing at a clownfish
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A few fish laughing at a clownfish by Caitlin Scarberry", 20,20);
		
        // Draw the first fish
	Shape f1 = new Fish(5,50,140,80);
	g2.setColor(new Color(100,0,136));g2.draw(f1);

	// Draw the second fish
	f1 = ShapeTransforms.translatedCopyOf(f1,10,100);
        g2.setColor(new Color(20,200,40));g2.draw(f1);

	//Draw the clownfish
	Shape f2 = new Clownfish(350,120,140,80);
	// Make it face the other fish
      	f2 = ShapeTransforms.scaledCopyOfLL(f2, -1,1);

	g2.setColor(Color.ORANGE);g2.draw(f2);

	
			
    }       
}

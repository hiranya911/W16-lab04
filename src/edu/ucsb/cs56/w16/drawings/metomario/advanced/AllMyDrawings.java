package edu.ucsb.cs56.w16.drawings.metomario.advanced;

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
 * @author Ben Zhu
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a couple of blank Logos 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	//Draws default Logo
	
	Logo l1 = new Logo(100);
	g2.setColor(Color.BLACK); g2.draw(l1);
	
	//Draws another logo (150, 150) away with thicker stroke and in green, twice the size
	Logo l2 = new Logo(200);
	Shape l3 = ShapeTransforms.translatedCopyOf(l2,150,150);
	

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.GREEN); g2.draw(l3);
		

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("2 blank Logos, by Ben Zhu", 20,20);
    }
    
    
    /** Draw a picture with a Dota 2 Logo
     */
    public static void drawPicture2(Graphics2D g2) {
       
	Dota2Logo D2L1 = new Dota2Logo(250);

	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	
	Shape D2L2 = ShapeTransforms.translatedCopyOf(D2L1,220,150);
	g2.setStroke(thick);
	g2.setColor(Color.RED); g2.draw(D2L2);

	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A Dota 2 Logo by Ben Zhu", 20,20);
    }
    
    /** Draw a Dota 2 Logo Rotated 90 Degrees 
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
Dota2Logo D2L1 = new Dota2Logo(248);

	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	
	Shape D2L2 = ShapeTransforms.translatedCopyOf(D2L1,123,123);
	Shape D2L3 = ShapeTransforms.rotatedCopyOf(D2L2,Math.PI/2.0);
	g2.setStroke(thick);
	g2.setColor(Color.BLUE); g2.draw(D2L3);

	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A Rotated Dota 2 Logo by Ben Zhu", 20,20);
	
    }       
}

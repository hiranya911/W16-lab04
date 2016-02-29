package edu.ucsb.cs56.w16.drawings.sschwellenbach.advanced;

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
    /** Draw a picture with some backboards  
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
        Backboard b1 = new Backboard(100,250,100,75);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
		
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	// Draw two basketball hoops
	
	BasketballHoop hoop1 = new BasketballHoop(200, 200, 200, 100);
	BasketballHoop hoop2 = new BasketballHoop(100, 50, 80, 50);
	
	g2.draw(hoop1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hoop2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some basketball hoops by Sierra Schwellenbach", 20,20);
    }
    
    
    /** Draw a picture with a few backboards and hoops
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	BasketballHoop large = new BasketballHoop(100,50,225,150);
	BasketballHoop small = new BasketballHoop(20,50,40,30);
	BasketballHoop tall = new BasketballHoop(20,150,20,40);
	BasketballHoop kids = new BasketballHoop(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tall);
	g2.setColor(Color.MAGENTA); g2.draw(kids);
	
	Backboard b1 = new Backboard(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	
	BasketballHoop bh1 = new BasketballHoop(50,350,40,75);
	BasketballHoop bh2 = new BasketballHoop(200,350,200,100);
	
	g2.draw(bh1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second hoop 45 degrees around its center.
	Shape bh3 = ShapeTransforms.rotatedCopyOf(bh2, Math.PI/4.0);
	
	g2.draw(bh3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of basketball hoops by Sierra Schwellenbach", 20,20);
    }
    
    /** Draw a different picture with a few basketball hoops and backboards
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Basketball Hoops by Sierra Schwellenbach", 20,20);
	
	
	// Draw some coffee cups.
	
	BasketballHoop fullSize = new BasketballHoop(100,50,225,150);
	BasketballHoop smaller = new BasketballHoop(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(fullSize);
	g2.setColor(Color.GREEN);   g2.draw(smaller);
	
    }       
}

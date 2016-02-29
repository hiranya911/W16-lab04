package edu.ucsb.cs56.w16.drawings.tang.advanced;

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
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	

	Star s1 = new Star(300,300,100);
	Color f = new Color(123,23,14);
	g2.setColor(f); g2.draw(s1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	g2.setColor(Color.RED); g2.draw(s2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(20,10,230)); 
	g2.draw(s2); 
	

	StarShield ss1 = new StarShield(850,350,100);
	StarShield ss2 = new StarShield(600,600,50);

	g2.draw(ss1);

	g2.setColor(new Color(0,230,12)); g2.draw(ss2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few stars and shields by Franklin Tang", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	StarShield s1 = new StarShield(90,95,30);
	StarShield s2 = new StarShield(170,395, 50);
	StarShield s3 = new StarShield(300, 150, 75);
	
	
	g2.setColor(new Color(1,2,156));     g2.draw(s1);
	g2.setColor(new Color(100,99,88));   g2.draw(s2);
	g2.setColor(new Color(55,55,55));    g2.draw(s3);
		    

	Star Orion = new Star(500, 97, 100);
	g2.setColor(Color.BLUE); g2.draw(Orion);
	
	
	//stretches the orion star vertically
	Shape BStar = ShapeTransforms.scaledCopyOfLL(Orion,0.5,2.5);
	BStar = ShapeTransforms.translatedCopyOf(BStar, 300, 500);
	g2.setColor(Color.RED); g2.draw(BStar);
	
	Shape SStarShield = ShapeTransforms.rotatedCopyOf(s1,Math.PI/4.0);
	SStarShield = ShapeTransforms.translatedCopyOf(SStarShield, 300, 150);
	g2.setColor(Color.GREEN); g2.draw(SStarShield);
	
	Shape Ashape = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(Ashape);
	

	Shape something = ShapeTransforms.translatedCopyOf(s3, 400, 0);
	something = ShapeTransforms.rotatedCopyOf(something, Math.PI);
	g2.setColor(new Color(102,0,25)); g2.draw(something);
	Stroke thick = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
        
	 g2.setColor(new Color(0x002FA7)); 

	

	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of random shields and stars by Franklin Tang", 300,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	

	StarShield t = new StarShield (100,100,50);
	g2.draw(t);
	Shape s = ShapeTransforms.scaledCopyOfLL(t,3, .9);
	s = ShapeTransforms.translatedCopyOf(s, 400, 0);
	g2.setColor(Color.YELLOW); g2.draw(s);

	
	StarShield u = new StarShield (200,250,50);
	g2.draw(u);
	Shape l = ShapeTransforms.scaledCopyOfLL(u,.1, 3);
	l = ShapeTransforms.translatedCopyOf(l, 400, 300);
	g2.setColor(Color.RED); g2.draw(l);

	StarShield v = new StarShield (100,400,50);
	g2.draw(v);
	Shape m = ShapeTransforms.scaledCopyOfLL(v,.5, 2.1);
	m = ShapeTransforms.translatedCopyOf(m, 200, 100);
	g2.setColor(Color.BLUE); g2.draw(m);
	
	g2.setColor(Color.CYAN);
	g2.drawString("The field of stretched shields by Franklin Tang", 20,20);
	


	
    }       
}

package edu.ucsb.cs56.w16.drawings.matthewcheung.advanced;

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
 * @author Phil Conrad, Matthew Cheung 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    public static void drawPicture1(Graphics2D g2) {
	
	//simple ring

	Ring r1 = new Ring(100,100,100,100);
	g2.setColor(Color.BLACK);
	g2.draw(r1);
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.drawString("Rings by Matthew Cheung", 20,20);
    
	
    }

    
    
    public static void drawPicture2(Graphics2D g2) {
	
	//diamond ring

	DiamondRing r2 = new DiamondRing(300,300,100,100);
	g2.draw(r2);	
	g2.setColor(Color.MAGENTA);
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Ring by Matthew Cheung", 20,20);
    }
    
    
    public static void drawPicture3(Graphics2D g2) {
	
	//more diamond rings
	
	g2.setColor(Color.RED);
	DiamondRing r3 = new DiamondRing(200,200,80,80);
	g2.draw(r3);
	DiamondRing r4 = new DiamondRing(100,100,50,50);
	g2.setColor(Color.CYAN);
	g2.draw(r4);
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLUE);
	g2.drawString("More rings by Matthew Cheung", 20,20);
	
    }       
}

package edu.ucsb.cs56.w16.drawings.jackey.advanced;

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
 * @author Jackey Lau 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few hilts and lightsabers
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Hilt h1 = new Hilt(0.0);
	g2.setColor(Color.BLACK); g2.draw(h1);
	
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);

	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);

	Shape h3 = ShapeTransforms.rotatedCopyOf(h2, Math.PI/4.0);
	
	g2.draw(h3);

	LightSaber hw1 = new LightSaber(600);
	g2.setColor(Color.RED);
	g2.draw(hw1);

	Shape hw2 = ShapeTransforms.translatedCopyOf(hw1,-150,50);
	hw2 = ShapeTransforms.scaledCopyOfLL(hw2,1.5,1.5);
	hw2 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/-2.0);
	g2.setColor(Color.BLUE);
	g2.draw(hw2);

      
	g2.setColor(Color.BLACK);
	g2.drawString("A few lightsabers by Jackey Lau", 20,20);

    }

    public static void drawPicture2(Graphics2D g2) {
	
	
	LightSaber hw1 = new LightSaber(100);
	g2.setColor(Color.RED);
	g2.draw(hw1);

	Shape hw2 = ShapeTransforms.translatedCopyOf(hw1,150,100);
	hw2 = ShapeTransforms.scaledCopyOfLL(hw2,1.5,1.5);
	hw2 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI);
	g2.setColor(Color.GREEN);
	g2.draw(hw2);

	LightSaber hw3 = new LightSaber(500);
	Shape hw4 = ShapeTransforms.rotatedCopyOf(hw3, Math.PI/4.0);
	g2.setColor(Color.BLUE);
	g2.draw(hw4);

     

      
	g2.setColor(Color.BLACK);
	g2.drawString("A few lightsabers by Jackey Lau", 20,20);

    }

    public static void drawPicture3(Graphics2D g2){
	LightSaber hw1 = new LightSaber(500);
	g2.setColor(Color.RED);
	g2.draw(hw1);

	Shape hw2 = ShapeTransforms.rotatedCopyOf(hw1, Math.PI/4);
	g2.setColor(Color.BLUE);
	g2.draw(hw2);

	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4);
	g2.setColor(Color.GREEN);
	g2.draw(hw3);

	Shape hw4 = ShapeTransforms.rotatedCopyOf(hw3, Math.PI/4);
	g2.setColor(Color.ORANGE);
	g2.draw(hw4);

	
    }
    
    
    
}


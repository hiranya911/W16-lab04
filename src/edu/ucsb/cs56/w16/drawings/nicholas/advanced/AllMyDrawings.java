package edu.ucsb.cs56.w16.drawings.nicholas.advanced;

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
 * @author Nicholas Frey 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    
    public static void drawPicture1(Graphics2D g2) {
	
	Cube h1 = new Cube(45,350,50,75);
	g2.setColor(Color.YELLOW); g2.draw(h1);

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,1,1.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,120,-50);
	g2.setColor(Color.RED); g2.draw(h2);

	h2 = ShapeTransforms.scaledCopyOfLL(h2,2,1.3);
	h2 = ShapeTransforms.translatedCopyOf(h2,80,-20);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x312BA9)); 
	g2.draw(h2); 
	
	Fishtank hw1 = new Fishtank(105,310,40,75);
	Fishtank hw2 = new Fishtank(250,420,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x7F00FF)); g2.draw(hw2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cubes and fishtanks by Nicholas Frey", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Cube one = new Cube(100,200,25,50);
	Cube two = new Cube(150,250,40,30);
	Cube three = new Cube(175,150,20,40);
	Cube four = new Cube(200,305,40,20);
	Cube five = new Cube(330,300, 40,40);

  Shape c1 = ShapeTransforms.rotatedCopyOf(one, Math.PI/5.0);
  Shape c2 = ShapeTransforms.rotatedCopyOf(two, Math.PI/1.0);
  Shape c3 = ShapeTransforms.rotatedCopyOf(three, Math.PI/2.0);
  Shape c4 = ShapeTransforms.rotatedCopyOf(four, Math.PI/3.0);
  Shape c5 = ShapeTransforms.rotatedCopyOf(five, Math.PI/4.0);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

  g2.setColor(Color.RED); g2.draw(c1);
  g2.setColor(Color.ORANGE); g2.draw(c2);
  g2.setColor(Color.YELLOW); g2.draw(c3);
  g2.setColor(Color.GREEN); g2.draw(c4);
  g2.setColor(Color.CYAN); g2.draw(c5);

	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	
	// Draw two houses with Windows
	
	Fishtank f1 = new Fishtank(300,350,50,40);
	Fishtank f2 = new Fishtank(200,420,200,100);
	
	//g2.draw(f1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	//Shape hw3 = ShapeTransforms.rotatedCopyOf(f1, Math.PI/4.0);
	
	//g2.draw(hw3);
  g2.draw(f2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Items falling into a fishtank by Nicholas Frey", 20,20);
}

    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A fishtank on a table by Nicholas Frey", 20,20);
	
	Cube table = new Cube(100,300,300,200);
	Fishtank tank = new Fishtank(200,250,80,80);
  Cube food = new Cube(170,300,20,20);
	
	g2.setColor(Color.ORANGE);     g2.draw(table);
	g2.setColor(Color.BLUE);   g2.draw(tank);
  g2.setColor(Color.GREEN);   g2.draw(food);
	
    }       
}

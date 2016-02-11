package edu.ucsb.cs56.w16.drawings.henryhyu.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.util.Random;
// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
   A component that draws an animated picture by Henry Yu
   
   @author Henry Yy
   @version CS56, W16
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape computer;
    private Shape computertwo;
    private Shape completecomputer;
    private Shape completecomputertwo;
    private double startingXPos;
    private double startingYPos;
    private double width;
    private double travelDistance = 0;
    private double elevateDistance = 0;


    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a computer moving across the vicinity of the frame, bouncing back to the original point.

	@param startingXPos the starting x position of the computer
	@param startingYPos the starting y position of the computer
	@param travelDistance the number of pixels the computer will move horizontally across the screen before stopping
	@param elevateDistance the number of pixels the computer will move vertically across the screen before stopping
	@param startingLength the starting length of the computer in pixels
	@param width the width of the computer in pixels
    */
    public AnimatedPictureComponent(double startingXPos, double startingYPos, double width) {
	this.startingXPos = startingXPos;
	this.startingYPos = startingYPos;
	this.width = width;

	computer = new Computer(this.startingXPos, this.startingYPos, this.width);
	computertwo = new Computer(this.startingXPos, this.startingYPos, this.width);
	completecomputer = new CompleteComputer(this.startingXPos, this.startingYPos, this.width);
	completecomputertwo = new CompleteComputer(this.startingXPos, this.startingYPos, this.width);
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the computer is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Random rand = new Random();
       float r = rand.nextFloat();
       float gg = rand.nextFloat();
       float b = rand.nextFloat();
       Color randomColor = new Color(r,gg,b);
       Graphics2D g2 = (Graphics2D) g;
       computer = ShapeTransforms.translatedCopyOf(computer,10,0);
       computertwo = ShapeTransforms.translatedCopyOf(computertwo,0,10);
       completecomputer = ShapeTransforms.translatedCopyOf(completecomputer,20,20);
       completecomputertwo = ShapeTransforms.translatedCopyOf(completecomputertwo,10,10);
 
       if(travelDistance > 40){
       	computer = new Computer(startingXPos, startingYPos, width);
	completecomputer = new CompleteComputer(startingXPos, startingYPos, width);
	travelDistance = 0;
	} else{
	  g2.setColor(randomColor);
	  g2.draw(computer);
	  g2.draw(completecomputer);
	  g2.drawString("Computer Dance Party WOOOOOOOOO", 40, 120);
	  travelDistance++;
	}
 	
      if(elevateDistance > 20){
	computertwo = new Computer(startingXPos, startingYPos, width);
	completecomputertwo = new CompleteComputer(startingXPos, startingYPos, width);
	elevateDistance = 0;
	} else{
	  g2.setColor(randomColor);
	  g2.draw(computertwo);
	  g2.draw(completecomputertwo);
          elevateDistance++;
	} 
            
   }    
  
}

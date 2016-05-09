package edu.ucsb.cs56.w16.drawings.hiranya.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.w16.drawings.hiranya.simple.Circle;

/**
   A vector drawing of a car that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Hiranya Jayathilaka 
   @version for CS56, W16, UCSB
   
*/
public class Car extends GeneralPathWrapper implements Shape {

    /**
     * Construct the drawing of the car.
     * @param x x-coordinate of the left edge of the car
     * @param y y-coordinate of the bottom edge of the car (tires excluded)
     * @param width width of the body of the car
     * @param height height of the car (tires excluded)
     * @param tireRadius radius of the tires
     */
    public Car(double x, double y, double width, double height, double tireRadius) {
	// Make the first story
        Rectangle2D.Double firstStory = 
            new Rectangle2D.Double(x, y - height / 2.0, width, height / 2.0);
	Rectangle2D.Double secondStory = 
            new Rectangle2D.Double(x + width / 4.0, y - height, width / 2.0, height / 2.0);
	Circle tire1 = new Circle(x + tireRadius, y + tireRadius, tireRadius);
	Circle tire2 = new Circle(x + width - tireRadius, y + tireRadius, tireRadius);

	// put the whole car together	
        GeneralPath car = this.get();
	car.append(firstStory, false);
	car.append(secondStory, false);
	car.append(tire1, false);
	car.append(tire2, false);
    }

}

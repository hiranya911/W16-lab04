package edu.ucsb.cs56.w16.drawings.sschwellenbach.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

/**
   A Basketball Hoop
      
   @author Sierra Schwellenbach
   @version for CS56, W16, UCSB
   
*/
public class BasketballHoop extends Backboard implements Shape
{
    /**
     * Constructor for objects of class BasketballHoop
     */
    public BasketballHoop(double x, double y, double width, double height)
    {
	// construct the backboard
	super(x,y,width,height);
	

	
	double ovalX = x + width / 3;
	double ovalY = y + height;
	double ovalWidth = width / 3;
	double ovalHeight = height / 6;

	double X1 = ovalX;
	double Y1 = ovalY + ovalHeight / 2;
	double X2 = ovalX + ovalWidth / 4;
	double Y2 = ovalY + ovalHeight * 4;
	double X3 = ovalX + ovalWidth / 2;
	double Y3 = ovalY + ovalHeight;
	double X4 = ovalX + 3*ovalWidth/4;
	double Y4 = Y2;
	double X5 = ovalX + ovalWidth;
	double Y5 = Y1;

	double X6 = (X1 + X2) / 2;
	double Y6 = (Y1 + Y2) / 2;
	double X7 = X2;
	double Y7 = ovalY + ovalHeight * .9;
	double X8 = X3;
	double Y8 = Y2;
	double X9 = X4;
	double Y9 = Y7;
	double X10 =(X4 + X5) / 2;
	double Y10 = Y6;

              
	
	Ellipse2D.Double rim = new Ellipse2D.Double(ovalX, ovalY, ovalWidth, ovalHeight);

	GeneralPath netFront = new GeneralPath();
	netFront.moveTo(X1, Y1);
	netFront.lineTo(X2, Y2);
	netFront.lineTo(X3, Y3);
	netFront.lineTo(X4, Y4);
	netFront.lineTo(X5, Y5);
	netFront.moveTo(X6, Y6);
	netFront.lineTo(X7, Y7);
	netFront.lineTo(X8, Y8);
	netFront.lineTo(X9, Y9);
	netFront.lineTo(X10, Y10);
		
        GeneralPath wholeBasketballHoop = this.get();
        wholeBasketballHoop.append(rim, false);
	wholeBasketballHoop.append(netFront, false);
        
    }    
}

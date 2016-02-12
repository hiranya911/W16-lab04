package edu.ucsb.cs56.w16.drawings.jackey.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Shape;
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Random;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
/**
 * A main class to view an animation
 *
 * @author Jackey Lau
 * @version for CS56, W16
 */

public class AnimatedPictureViewer{
    
    DrawPanel panel = new DrawPanel();
    
    LightSaber saber = new LightSaber(100);
    LightSaber lsaber = new LightSaber(700);
    
    Thread anim;

    int x = 100;
    int x3 = 600;
    int dx = 5;
    int dz = -5;
    int rotate = 1;
    int rotate2 = -1;
    int x2= 700;
    double dy=1;
    double negate = .1;
    int negate2 = -1;

    int R = (int)(Math.random()*256);
    int Gee = (int)(Math.random()*256);
    int B= (int)(Math.random()*256);
    Color randomColor = new Color(R, Gee, B);
    public static void main(String[] args) {
	
	AnimatedPictureViewer thingy = new AnimatedPictureViewer();
	thingy.go();
	

    }
public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(1000,1000);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
	      public void mouseEntered(MouseEvent e){
		  System.out.println("mouse entered");
		  anim = new Animation();
		  anim.start();
	      }

	      public void mouseExited(MouseEvent e){        
		  System.out.println("Mouse exited");
          // Kill the animation thread
		  anim.interrupt();
		  while (anim.isAlive()){}
		  anim = null;         
		  panel.repaint();        
	      }
	  });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the LightSaber
          g2.setColor(randomColor);
	  LightSaber test = new LightSaber(x);
	  Shape test2 = ShapeTransforms.rotatedCopyOf(test,(Math.PI/8)*rotate);
	  if(x<=50){
	      negate2*=-1;
	      R = (int)(Math.random()*256);
	      Gee = (int)(Math.random()*256);
	      B= (int)(Math.random()*256);
	      randomColor = new Color(R, Gee, B);
	      g2.setColor(randomColor);
	  }
	  if(x>799 ){
	      negate2*=-1;
	      R = (int)(Math.random()*256);
	      Gee = (int)(Math.random()*256);
	      B= (int)(Math.random()*256);
	      randomColor = new Color(R, Gee, B);
	      g2.setColor(randomColor);
	  }
	  rotate-=negate2;
	  g2.draw(test2);

	  int R2 = (int)(Math.random()*256);
	  int Gee2 = (int)(Math.random()*256);
	  int B2= (int)(Math.random()*256);
	  Color randomColor2 = new Color(R2, Gee2, B2);
	  g2.setColor(randomColor2);
	  LightSaber test3 = new LightSaber(x2);
	  Shape test4 = ShapeTransforms.rotatedCopyOf(test3,(Math.PI/2));
	  test4 = ShapeTransforms.scaledCopyOfLL(test4,dy,1);
	 
	  System.out.println(dy);
	  g2.draw(test4);
	  if(dy<-1)negate *=-1;
	  if(dy>1)negate*=-1;
	  dy = dy - negate;
	  //lightsaber2

	  g2.setColor(Color.BLACK);
	  LightSaber test5 = new LightSaber(x3);
	  Shape test6 = ShapeTransforms.rotatedCopyOf(test5,(Math.PI/8)*rotate2);
	  
	  rotate2-=1;
	  g2.draw(test6);

       }


    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 800) {
		dx = -5;
		//dz = 5;
	    }
       
            if (x <= 50) {
		dx = 5;
		x3 = 1000;
	    }
            
            x += dx;
	    x3 += dz;
	    
            panel.repaint();
            Thread.sleep(50);
	    
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}

package edu.ucsb.cs56.w16.drawings.matthewcheung.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Shape;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;



/**
 * A main class to view an animation
 *
 * @author Matthew Cheung
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
    
    private DrawPanel panel = new DrawPanel();
    
    private Ring ring = new Ring(200, 200, 50, 50);
    
    Thread anim;   
    private int x = 100;
    private int y = 100;
    private int clicked = 0;
    private int width = 1;
    private int height = 1;
    private int dW = 0;
    private int dH = 0;
    private double rotate = 0.0;
    private int red = 0;
    private int green = 0;
    private int blue = 255;
    private int dG = 5;
    private int dB = 5;
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }
    
    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.getContentPane().add(panel);
	frame.setSize(640,480);
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
		
		public void mouseClicked(MouseEvent e){
		    System.out.println("Mouse clicked");
		    if (dW == 0 && dH == 0 && clicked == 0){
			dW = 5;
			dH = 5;
			clicked = 1;
			System.out.println("Diamond Ring Enlarging");
		    }
		    else if (clicked == 1){
			dW = 0;
			dH = 0;
			clicked = 2;
			System.out.println("Diamond Ring Fixed Size");
		    }
		    else if (clicked == 2){
			dW = -5;
			dH = -5;
			clicked = 3;
			System.out.println("Diamond Ring Shrinking");
		    }
		    else if (clicked == 3){
			dW = 0;
			dH = 0;
			clicked = 0;
			System.out.println("Diamond Ring Fixed Size");
		    }
		}
	    });
	
    } // go()
    
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // Clear the panel first
	    g2.setColor(Color.BLACK);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    // Draw the Ring
	    Color color = new Color(red,green,blue);
	    g2.setColor(color);
	    DiamondRing test = new DiamondRing(320, 240, width, height);
	    DiamondRing test2 = new DiamondRing(320, 240, 50, 50);
	    
	    Shape test1 = ShapeTransforms.rotatedCopyOf(test,rotate);
	    g2.draw(test1);
	    g2.draw(test2);
	    
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    //Changes the color from green to blue and vice versa
		    if (green >= 255) { dG = -5; }
		    if (green <= 0) { dG = 5; }
		    if (blue >= 255) { dB = 5; }
		    if (blue <= 0) { dB = -5; }
		    blue -= dB;
		    green += dG;
		    
		    //Rotate the middle diamondRing
		    rotate += Math.toRadians(10);
		    	
		    //Enlarge and shrink the diamondRing based on clicks
		    width += dW;
		    height += dH;
		    
		    //Repaints panel
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

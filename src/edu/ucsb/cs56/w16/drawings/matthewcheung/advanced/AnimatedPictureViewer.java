package edu.ucsb.cs56.w16.drawings.matthewcheung.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Matthew Cheung
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
    
    private DrawPanel panel = new DrawPanel();
    
    private Ring ring = new Ring(100, 100, 50, 50);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int dx = 5;
    private int dy = 5;
    private int red = 0;
    private int green = 0;
    private int dg = 5;
    private int blue = 255;
    private int db = 5;
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
	    });
	
    } // go()
    
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // Clear the panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    // Draw the Ring
	    Color color = new Color(red,green,blue);
	    g2.setColor(color);
	    DiamondRing test = new DiamondRing(x, y, 100, 100);
	    g2.draw(test);
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls
		    
		    if (x >= 400) { dx = -5; }
		    if (x <= 50) { dx = 5; }

		    if (y >= 400) { dy = -5; }
		    if (y <= 50) { dy = 5; }

		    x += dx;
		    y += dy;
		    
		    if (green >= 255) { dg = -5; }
		    if (green <= 0) { dg = 5; }
		    if (blue >= 255) { db = 5; }
		    if (blue <= 0) { db = -5; }
		    
		    //red += 5;
		    blue -= db;
		    green += dg;
	    
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

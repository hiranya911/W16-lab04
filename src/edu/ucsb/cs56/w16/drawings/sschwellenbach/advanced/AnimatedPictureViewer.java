package edu.ucsb.cs56.w16.drawings.sschwellenbach.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** 
 * A main class to view the animation
 *
 *@author Sierra Schwellenbach
 *@version for CS56, W16
 */

public class AnimatedPictureViewer{
    private DrawPanel panel = new DrawPanel();

    private BasketballHoop hoop = new BasketballHoop(50, 50, 125, 75);

    private Basketball ball = new Basketball(200, 100, 25);
    
    // Thread anim;

    private int x = 100;

    private int y = 100;

    
    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);
    }
 
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g){
	    Graphics2D g2 = (Graphics2D) g;

	    //Clear the panel
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    //Draw basketball
	    g2.setColor(Color.ORANGE);
	    Basketball ball = new Basketball(x,y,25);
	    g2.draw(ball);

  
	}
    }
}

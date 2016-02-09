package edu.ucsb.cs56.w16.drawings.jmangel.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

/**
 * A main class to view an animation
 *
 * @author John Mangel
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

	private DrawPanel panel = new DrawPanel();

	Thread anim;

	private int panelWidth=640;

	private int x = 100;
	private int y = 100;
	private int width = 100;
	private int height = 40;
	private int dx = -30;

	private int x2 = 100;
	private int y2 = 100;
	private int width2 = 75;
	private int height2 = 30;
	private int dx2 = -25;

	private int blueDiff=0;

	private int translation = 0;
	private double xscale = 1.0;
	private double yscale = 1.0;

	public static void main (String[] args) {
		new AnimatedPictureViewer().go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(panel);
		frame.setSize(panelWidth,480);
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

			// Draw the GoKart
			g2.setColor(Color.RED);
			GoKart test = new GoKart(x, y, width, height);
			//scale and orient according to position
			AffineTransform at = new AffineTransform();
			at.scale(xscale,yscale);
			at.translate(translation, 0);
			g2.setTransform(at);
			g2.draw(test);

			//draw another GoKart!
			g2.setColor(Color.BLUE);
			GoKart test2 = new GoKart(x2,y2,width2,height2);
			g2.draw(test2);
		}
	}

	class Animation extends Thread {
		public void run() {
			try {
				while (true) {
					blueDiff=x2-x;
					if (y==100) {//if on upper track
						if (x<=-150){//if red kart is far off screen
							//enlarge and flip gokarts
							xscale=-2.0;
							yscale=2.0;
							//move gokarts down on the panel
							y=150;
							y2=150;
							//move gokarts and translate screen so they appear from the left
							x=panelWidth+150;
							x2=panelWidth+150+blueDiff;
							translation=-panelWidth;
						}
					}
					else {//if on lower track
						if (x<=panelWidth / 2 - 150){//if red kart is far off screen
							//revert gokart size
							xscale=1.0;
							yscale=1.0;
							//return karts to top of track
							y=100;
							y2=100;
							//make gokarts appear from right
							x=panelWidth+150;
							x2=panelWidth+150+blueDiff;
							translation=0;
						}
					}
					//if blue kart is far ahead, slow down
					if (blueDiff<-100) dx2++;
					//if blue kart is far behind, speed up
					if (blueDiff>100) dx2--;
					//move karts
					x += dx;
					x2 += dx2;
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

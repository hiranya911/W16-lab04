


package edu.ucsb.cs56.w16.drawings.sschwellenbach.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
/** 
 * A main class to view the animation
 *
 *@author Sierra Schwellenbach
 *@version for CS56, W16
 */

public class AnimatedPictureViewer{
    private DrawPanel panel = new DrawPanel();

    int x = 100;
    int y = 100;
    int lastX = 100;
    int lastY = 100;
    int dx = 0;
    int dy = 0;
    int a = 0;
    int degreesRotated = 0;
    int basketCount = 0;
    
    int bottomOfWindow = 800;
    int rightOfWindow = 640;
    int ballRadius = 25;
    
    Thread anim;

    
    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	JFrame frame = new JFrame();
	randomizeBallLocation();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.getContentPane().add(panel);
	frame.setSize(rightOfWindow, bottomOfWindow);
	frame.setVisible(true);

	anim = new Animation();
	frame.getContentPane().addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		    if(dx == 0 && dy == 0 && a == 0){
			getVelocities(e.getX(), e.getY());
			anim.start();
		    }else{
			//do nothing
		    }
		}

	    });
    }
 
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g){
	    Graphics2D g2 = (Graphics2D) g;

	    //Clear the panel
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    //Draw basketball
	    g2.setColor(Color.ORANGE);
	    Basketball ball = new Basketball(x,y,ballRadius);
	    Shape rotatedBall = ShapeTransforms.rotatedCopyOf(ball, Math.PI * degreesRotated / 180.0);
	    g2.draw(rotatedBall);

	    //Draw hoop

	    g2.setColor(Color.BLACK);
	    BasketballHoop hoop = new BasketballHoop(200, 100, 240, 150);
	    g2.draw(hoop);

	    //display made baskets text
	    Stroke thick = new BasicStroke(6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	    g2.setStroke(thick);
	    g2.setColor(Color.BLACK);
	    g2.drawString("Score: " + basketCount, 20, 20);

	}
    }

    class Animation extends Thread{
	public void run(){
	    try{
		while(true){
		    boolean made = false;
		    if(y > bottomOfWindow -  ballRadius * 2){ // ball off screen
			randomizeBallLocation();
			
		    } else{
			//sets new vals for x,y,degreesRotated, lastX, and lastY
			lastX = x;
			x += dx;
			lastY = y;
			y += dy;
			dy += a;
			if ((Math.abs(degreesRotated) < 360) && (dx != 0 || dy != 0 || a!=0)){
			    if(dx < 0){
				degreesRotated += 20;
			    }else{
				degreesRotated -= 20;
			    }
			}
			else{
			    degreesRotated = 0;
			}

			//if ball is crossing the horizontal line containing rim
			if (lastY < 225 && y > 225){
			    if((x <= 315 && x >= 275) || (lastX <= 315 && lastX >= 275)){
				//basket made
				made = true;
			    }else if((x < 235) || (x > 355)){
				//shot missed
				made = false;
			    }else{
				//ball hit rim
				y = lastY;
				dy = dy * -1;
				made = false;
			    }
			    if(made == true){
				basketCount ++;
			    }
			}
		    }
		    
		    panel.repaint();
		    Thread.sleep(20);
			
		}
	    } catch(Exception ex){
		if (ex instanceof InterruptedException){
		    //Don't do anything - expected on mouse exit
		} else{
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }

    public void randomizeBallLocation(){
	do{ //sets a new x value so it is not under the rim
	    x = (int) (Math.random() * (rightOfWindow - ballRadius * 2));
	}while (x > 230 && x < 360);

	y = (int)(Math.random() * 500) + 250; //new y value

	lastX = x;
	lastY = y;
	a = 0;
	dx = 0;
	dy = 0;
	degreesRotated = 0;
    }

    public void getVelocities(int xClickLocation, int yClickLocation){
	dx = (int)((xClickLocation - (x + ballRadius)) / 10);
	dy = (int)((yClickLocation - (y + ballRadius)) / 10);
	a = 1;


    }
}

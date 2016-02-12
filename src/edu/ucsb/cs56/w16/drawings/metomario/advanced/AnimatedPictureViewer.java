package edu.ucsb.cs56.w16.drawings.metomario.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
/**
 * A class for viewing an animation
 *
 * @author Ben Zhu
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel surface = new DrawPanel();

    private Ellipse2D.Double dot = new Ellipse2D.Double( 50.0, 50.0, 50.0, 50.0);

    private int counter = 0;
    private int cycle = 0;
    private boolean reverse = false;
    Thread anim;

    private int x = 0;
    private int y = 0;

    private int dx = 0;
    private int dy = 10;
    
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(surface);
	frame.setSize(640,640);
	frame.setVisible(true);


	anim = new Animation();
	anim.start();

    } // go()
    class DrawPanel extends JPanel {
	public void paintComponent (Graphics g) {

	    Graphics2D g2 = (Graphics2D) g;

	    //clear the panel first
	    g2.setColor(Color.WHITE);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    //Draw the dot
	    
	     if ((10*cycle + counter) == 0)
	    	g2.setColor(Color.GRAY);
	     else if ((10*cycle + counter) == 1 )
	    	g2.setColor(Color.MAGENTA);
	     else if ((10*cycle + counter)== 2)
	    	g2.setColor(Color.GREEN);
	     else if ((10*cycle + counter) == 3)
	    	g2.setColor(Color.yellow);
	     else if ((10*cycle + counter) == 10)
	    	g2.setColor(Color.DARK_GRAY);
	     else if ((10*cycle + counter) == 11)
	    	g2.setColor(Color.BLUE);
	     else if ((10*cycle + counter) == 12)
	    	g2.setColor(Color.RED);
	     else if ((10*cycle + counter) == 13)
		 g2.setColor(Color.BLACK);
	     else if ((10*cycle + counter) == 20)
	    	g2.setColor(Color.ORANGE);
	     else if ((10*cycle + counter) == 21)
	    	g2.setColor(Color.PINK);
	     else if ((10*cycle + counter) == 22)
	    	g2.setColor(Color.LIGHT_GRAY);
	     else if ((10*cycle + counter) == 23)
		 g2.setColor(Color.CYAN);
	     else if ((10*cycle + counter) == 30)
	    	g2.setColor(Color.GRAY);
	     else if ((10*cycle + counter) == 31 )
	    	g2.setColor(Color.MAGENTA);
	     else if ((10*cycle + counter) == 32)
	    	g2.setColor(Color.GREEN);
	     else if ((10*cycle + counter) == 33)
	    	g2.setColor(Color.YELLOW);
	     else if ((10*cycle + counter) == 40)
	    	g2.setColor(Color.DARK_GRAY);
	     else if ((10*cycle + counter) == 41)
	    	g2.setColor(Color.BLUE);
	     else if ((10*cycle + counter) == 42)
	    	g2.setColor(Color.RED);
	     else if ((10*cycle + counter) == 43)
		 g2.setColor(Color.BLACK);
	     else if ((10*cycle + counter) == 50)
	    	g2.setColor(Color.ORANGE);
	     else if ((10*cycle + counter) == 51)
	    	g2.setColor(Color.PINK);
	     else if ((10*cycle + counter) == 52)
	    	g2.setColor(Color.LIGHT_GRAY);
	     else if ((10*cycle + counter) == 53)
		 g2.setColor(Color.CYAN);
	     if ((10*cycle + counter) == 60)
	    	g2.setColor(Color.GRAY);
	     else if ((10*cycle + counter) == 61 )
	    	g2.setColor(Color.MAGENTA);

	  Ellipse2D.Double dot = new Ellipse2D.Double( x, y, 50.0, 50.0);
	  g2.fillOval(x,y,50,50);
	  g2.draw(dot);
	}
    } //DrawPanel

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    //Set reverse
                     if (cycle == 0 && counter == 0 && reverse == true) {
                        reverse = false;
                        dx = 0;
                        dy = 10;
                        x = 0;
                        y = 0;
                        counter = 0;
		 
                        }
		     if (cycle == 6 && counter == 1 && reverse == false) {
			reverse = true;
			dx = 0;
			dy = -10;
		    }
		    if (reverse == false) {//Do the swirly-whirly
		    
                        if (y > 544 - (50*cycle) && counter == 0) {
                            y = 554 - (50*cycle);
                            if (y == (554 - (50*cycle)) && dy != 0 && dx !=10) {
				// System.out.println("yo");
                                dy = 0;
				dx = 10;
				counter++;
		    }
		    }
		    else if (x > 576 - (50*cycle) && counter == 1) {
			 x = 586 - (50*cycle);
			 if (x == 586 - (50*cycle) && dx != 0 && dy != -10) {
			     // System.out.println("sup");
				 dx = 0;
				 dy = -10;
				 counter++;
			 }
		    }
		    else if (y < 0 + (50*cycle) && counter == 2) {
			y = 0 + (50*cycle);
			if (y == 0 + (50*cycle) && dy != 0 && dx != -10) {
			    //System.out.println("hey");
				 dy = 0;
				 dx = -10;
				 counter++;
				 cycle++;
		    }
		    }
		    else if (x < 0 + (50*cycle) && counter == 3) {
			x = 0 + (50*cycle);
			if (x == 0 + (50*cycle) && dx != 0 && dy != 10) {
			    // System.out.println("hi");
				dx = 0;
				dy = 10;
				counter = 0;
			    }
			}
		    }
                    else if(reverse == true) {//Do the reverse Swirly
                    
                        if ( y < 0+ (50*cycle) && counter == 1) {
                            y = 0+ (50*cycle);
                            if (y == 0 + (50*(cycle)) && dy !=0 && dx !=10) {
				// System.out.println("yo-again");
                                dy = 0;
                                dx = 10;
                                counter--;
                                }
                            }
                        
                        else if ( x > 576 - (50*(cycle-1)) && counter == 0) {
                            x = 586 - (50*(cycle-1));
                            if (( x == 586 - (50*(cycle-1))) && dx != 0 && dy != -10) { 
				// System.out.println("hi-again");
                                dx = 0;
                                dy = 10;
                                counter = 3;
                                }
                            }
                        
                        else if (y > 544 - (50*(cycle-1)) && counter == 3) {
                            y = 554 - (50*(cycle-1));
                            if (y == 554 - (50*(cycle-1)) && dy != 0 && dx != 10) {
				// System.out.println("hey-again");
                                dy = 0;
                                dx = -10;
				counter--;
				cycle--;
                                }
                        }
                        
                        else if (x < 0 + (50*(cycle)) && counter == 2) {
			 x = 0 + (50*(cycle));
			 if (x == 0 + (50*(cycle)) && dx != 0 && dy != 10) {
			     // System.out.println("sup-again");
				 dx = 0;
				 dy = -10;
				 counter--;			 }
		    }
		    }
		    x+=dx;
		    y+=dy;
		    surface.repaint();
		    Toolkit.getDefaultToolkit().sync();
		    Thread.sleep(15);
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

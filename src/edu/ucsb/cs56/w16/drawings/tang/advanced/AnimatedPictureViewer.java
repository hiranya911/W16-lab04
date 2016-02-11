package edu.ucsb.cs56.w16.drawings.tang.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Shape; // Shape interface
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * @author Franklin Tang
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    
    Thread anim;   
    private int len = 72;
    private int radius = len*3/2;
    private int x = radius;
    private int y = 372;
 
    private int s = 0;


    private double scale = 1.0;
    private int dx = 2;

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

          // Draw the StarShield
          Random rand = new Random();
          Color randColor = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
          g2.setColor(randColor);
          Shape murica;
          // rand = new Random();
          // randColor = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
          // g2.setColor(randColor);
          // Shape something;
          // StarShield test = new StarShield(x, y, len);
          murica = ShapeTransforms.rotatedCopyOf(new StarShield(x, y, len),x*0.785);
          murica = ShapeTransforms.scaledCopyOfLL(murica,1,(scale*(640-x)/640));
          murica = ShapeTransforms.translatedCopyOf(murica,0,(scale*(640-0.75*x*x)/640));
	  // murica = ShapeTransforms.rotatedCopyOf(murica,x/314);
	  
          g2.draw(murica);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            //flatten the shield and makes it change colors
            if(s==0){
              if (x < (640-radius)){ //stop when it touches the wall
                x += dx; 
              }
              else{s=1;x=(640-radius);}
            }
            else{
              if (x > radius){
                x-= dx;
              }
              else{s=0;x=radius;}
            }               
            panel.repaint();
            Thread.sleep(10);
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

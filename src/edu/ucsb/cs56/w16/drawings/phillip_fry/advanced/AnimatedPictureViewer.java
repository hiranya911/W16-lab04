package edu.ucsb.cs56.w16.drawings.phillip_fry.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * A main class to view an animation
 *
 * @author Phillip Fry
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
    private DrawPanel panel = new DrawPanel();
    

    Thread anim;
    private int x = 100;
    private int y = 300;
    private int yR = 300;
    private int xT2 = 700;
    private int dxShot = 5;
    private int xShot = 700;
    private int yShot = 305;
    private int dy = 2;
    private int dx = 5;
    private int blength = 75;
    private int height = 50;
    private int shotRadius = 35;

    private int xBotBomb = 702;
    private int yBotBomb = 32;
    private int xTopBomb = 700;
    private int yTopBomb = 25;
    private int dxBomb = 5;
    private int dyBomb =5;
    

    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JButton labelButton = new JButton("FIRE!");
	labelButton.setBackground(Color.YELLOW);
	labelButton.setContentAreaFilled(false);
	labelButton.setOpaque(true);
	labelButton.addActionListener(new LabelListener());

	JButton AirStrike = new JButton("AirStrike!");
	AirStrike.setBackground(Color.BLUE);
	AirStrike.setContentAreaFilled(false);
	AirStrike.setOpaque(true);
	AirStrike.addActionListener(new AirAttack());
	

	frame.getContentPane().add(BorderLayout.SOUTH, labelButton);
	frame.getContentPane().add(BorderLayout.EAST, AirStrike);
	
	frame.getContentPane().add(panel);
	frame.setSize(900,600);
	frame.setVisible(true);
    }

    public class LabelListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    anim = new Animation();
	    anim.start();	
	    
	}
    }

    public class AirAttack implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    anim = new Animation2();
	    anim.start();
	}
    }

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {

	    Graphics2D g2 = (Graphics2D) g;

	    // Clear the panel first
	    g2.setColor(Color.DARK_GRAY);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    //Ground
	    g2.setColor(Color.GREEN);
	    g2.fillRect(0,375,900,20);
	    
	    // Draw Tank Red
	    g2.setColor(Color.RED);
	    g2.setStroke(new BasicStroke(20));
	    Tank tank = new Tank(x, yR, 75, 50);
	    g2.draw(tank);

	    //projectile
	    g2.setColor(Color.BLACK);
	    g2.fillOval(xShot-blength,yShot,shotRadius,shotRadius);

	    // Draw Blue Tank
	    g2.setColor(Color.BLUE);
	    g2.setStroke(new BasicStroke(20));
	    flagTank tank2 = new flagTank(xT2,y,75,50);
	    g2.draw(tank2);

	    // Text
	    g2.setColor(Color.GREEN);
	    Font f = new Font("Arial",Font.BOLD,20);
	    g2.setFont(f);
	    g2.drawString("MISSION: ATTACK ENEMY TANK",20,40);
	    g2.drawString("TIME 06:30",20,60);

	    //Bottom bomb
	    g2.setColor(Color.BLACK);
	    g2.fillRect(xTopBomb,yTopBomb,35,15);

	    //Top bomb
	    g2.setColor(Color.BLACK);
	    g2.fillOval(xBotBomb,yBotBomb,30,35);
  
	     
	}
    }

    
    class Animation extends Thread {
	public void run() {
	    try {
	    while (true) {
		    // Shoot the Red Tank

		    if (xT2 >= 695) {
			dx = -1;
			xT2 += dx;
			xShot += dx;
		    }

		    if (xT2 <=  695 && xShot >= x+(height*2)) {
			dxShot = -6;
			xShot += dxShot;
		    }

		    if(x+(height*2) < xShot && xShot<= x+(height*3) && yR < 1000) {
			dy = -2;
			yR += dy;
		    }
		    if(xShot <= x+(height*2) && yR < 1000) {
			dy = 3;
			yR += dy;
			yShot += dy;
		    }
		    panel.repaint();
		    Thread.sleep(20);
		}
	    } catch(Exception ex){}
	}
    }
 

    class Animation2 extends Thread {
	public void run() {
	    try {
	    while(true){
	    //drop a bomb;
		if (xBotBomb >= x+(height*2) && (yBotBomb <= y)) {
		    dxBomb = -2;
		    dyBomb = 1;
		    xBotBomb += dxBomb;
		    xTopBomb += dxBomb;
		    yBotBomb += dyBomb;
		    yTopBomb += dyBomb;
		}
		if(x+(height*2) < xBotBomb && xBotBomb<= x+(height*3) && yR < 1000) {
		    dy = -2;
		    yR += dy;
		}
		if(xBotBomb <= x+(height*2) && yR < 1000) {
		    dy = 3;
		    yR += dy;
		    yBotBomb += dy;
		    yTopBomb += dy;
		}
		panel.repaint();
		Thread.sleep(20);
	    }
	    }catch(Exception ex){}
	}
    }
}






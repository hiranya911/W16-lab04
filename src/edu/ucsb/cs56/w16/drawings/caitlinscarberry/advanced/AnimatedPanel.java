package edu.ucsb.cs56.w16.drawings.caitlinscarberry.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

public class AnimatedPanel extends JPanel {
    //approximate coords of fish's mouth
    private double x;
    private double y;

    //target to aim fish at
    private int targetX;
    private int targetY;
    private double direction; //in radians
    private int fishWidth;

    private ArrayList<int[]> foodCoords;
    private Thread animate;
    private static int frameRate = 24;
    private final int baseSpeed = 130; //pixels per second
    private int speed;

    public AnimatedPanel(int x,int y,int width){
	this.x = x;
	this.y = y;
	this.fishWidth = width;
	this.foodCoords = new ArrayList<int[]>();
	animate = new Animation();
	targetX = 500;
	targetY = y;
	this.addMouseListener(
			      new MouseAdapter(){
				  public void mouseClicked(MouseEvent e){
				      foodCoords.add(new int[]{e.getX(),e.getY()});
				      setTarget(e.getX(),e.getY());
				  }
			      }

);
	
    }

    public void run(){
	animate.run();
    }
    
    class Animation extends Thread{
	public void run(){
	    try{
	    long startTime = System.currentTimeMillis();
	    while(true){
		long deltaT = System.currentTimeMillis()-startTime;
		if(deltaT>1000/frameRate){
		    startTime = System.currentTimeMillis();
		    update(deltaT);
		    Thread.sleep(1000/frameRate);
		}
	    }
	    } catch (Exception e){
		System.err.println(e);
	    }
	}
	    
	public void update(long deltaT){
	    //if there is food, target the fish at it
	    if(foodCoords.size()>0)
		setTarget(foodCoords.get(foodCoords.size()-1)[0],
			 foodCoords.get(foodCoords.size()-1)[1]);
	    
	    //if the fish has not reached its target
	    if(!(Math.abs(x-targetX)<4&&Math.abs(y-targetY)<4)){
		 x+=speed*Math.cos(direction)*deltaT/1000.0;
		 y+=speed*Math.sin(direction)*deltaT/1000.0;
		 targetAt();
		 speed = baseSpeed;
	    }
	    //if the fish reached its target and its target is food
	    else if(foodCoords.size()>0&&
		    targetX==foodCoords.get(foodCoords.size()-1)[0]
		    && targetY==foodCoords.get(foodCoords.size()-1)[1]){
		foodCoords.remove(foodCoords.size()-1);
	      
		//grow the fish
		fishWidth+=10;
		
		//start swimming back and forth
		targetX = 500;
		targetY = (int)y;
	    }
	    else if(targetX!=0) {
		targetX = 0;
		targetY = (int)y;
	    }
	    else if(targetX==0) {
		targetX = 500;
		targetY = (int)y;
	    }

	    ArrayList<int[]> toRemove = new ArrayList<int[]>();
	    //make the food fall
	    for(int[] coords : foodCoords){
		coords[1]+=3;
		//destroy it if it falls offscreen
		if(coords[1]>500)
		    toRemove.add(coords);
	    }
	    for(int[] coords : toRemove){
		foodCoords.remove(coords);
		targetY = 200;
		targetX = 0;
	    }
	    
	    repaint();

	    /*necessary to keep animation from
	      lagging when mouse is not moving*/
	    Toolkit.getDefaultToolkit().sync();
	}
    }
    
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;

	//draw fish
	Shape toDraw = new Clownfish(x-fishWidth*1.1,y-fishWidth/3,fishWidth,fishWidth*.75);
	//if the fish is facing left, flip its direction
	if(Math.cos(direction)<0){
	    toDraw = ShapeTransforms.scaledCopyOf(toDraw,-1,1);
	    toDraw = ShapeTransforms.translatedCopyOf(toDraw,fishWidth*2.2,0);
	}
	g2.draw(ShapeTransforms.rotatedCopyOf(toDraw,0));
	//g2.drawRect((int)x,(int)y,5,5);
	
	//draw food
	g2.setStroke(new BasicStroke(1));
	g2.setColor(Color.BLACK);
	for(int[] coords : foodCoords){
	    g2.fillRect(coords[0],coords[1],5,5);
	}

	//draw instructions
	g2.drawString("Click to drop food for the fish",5,20);
    }

    /**
     * Set the target coordinates.
     **/
    public void setTarget(int targetX, int targetY){
	this.targetX = targetX;
	this.targetY = targetY;
	targetAt();
    }

    /**
     * Set the fish's direction to face the point (targetX, targetY)
     **/
    public void targetAt(){
	this.direction = Math.atan2(targetY-y,
	  targetX-x);
    }
}

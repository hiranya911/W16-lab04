package edu.ucsb.cs56.w16.drawings.caitlinscarberry.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Caitlin Scarberry
 * @version for CS56, W16
 */

public class AnimatedPictureViewer extends JFrame{
    public static void main(String[] args){
	AnimatedPictureViewer frame = new AnimatedPictureViewer();
	frame.go();
    }
    public void go(){
	setSize(700,500);
	setTitle("Caitlin Scarberry's Animated Drawing");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	AnimatedPanel panel = new AnimatedPanel(200,200,80);
	add(panel);
       	setVisible(true);
	panel.run();
    }
}

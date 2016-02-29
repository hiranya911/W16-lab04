package edu.ucsb.cs56.w16.drawings.jackey.simple;
import javax.swing.JFrame;

/** A viewer class to see a picture I drew with 
 *  just three simple Java graphics objects, namely
 *  Rectangle, Line2D.Double, Ellipse2D.Double
 *  
 * @author P. Conrad
 * @author Jackey Lau
 * @version CS56, W16, UCSB
 */

public class PictureViewer
{
    public static void main(String[] args)
    {
	JFrame frame = new JFrame();
	
      
	frame.setSize(640,480);

	frame.setTitle("Jackey's Drawing"); 
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	PictureComponent component = new PictureComponent();

	
	frame.add(component);
	frame.setVisible(true);
    }
}

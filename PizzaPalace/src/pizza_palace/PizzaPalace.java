package pizza_palace;
/**
 * PizzaPalace.java		7/20/2003
 */
import javax.swing.JFrame;
import java.awt.Color;

/**
 * Main control frame for the Pizza Palace program. It allows the user 
 * to display the customer order form or the inventory manager interface,
 * or create a new stock inventory
 **/
public class PizzaPalace 
{
	/**
	 * Defines Pizza Palace Yellow
	 */
	public static final Color COLOR_MAIN = new Color (242, 240, 83);  // yellow
	
	/**
	 * Defines Pizza Palace Green
	 */
	public static final Color COLOR_SECONDARY = new Color (27, 117, 78);  // green

	/**
	 * Represents Pizza Palace Red
	 */
	public static final Color COLOR_NAME = new Color (251, 50, 69);  // red
	
	/**
	 * Display option frame
	 */
	public static void main (String[] args)
	{
		
		JFrame frame = new JFrame ("Pizza Palace: Main Control");
		PizzaPalacePanel panel = new PizzaPalacePanel();
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);				

 		frame.setSize (800, 600);
 		frame.setResizable (true);
 		frame.setLocation (200, 200);
		
		frame.getContentPane().add (panel);
				
		frame.pack();
		frame.setVisible(true);
	}
}
		
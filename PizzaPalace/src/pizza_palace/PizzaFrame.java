package pizza_palace;
/**
 * PizzaFrame.java		7/20/2003
 * Author: Patrick Nutt
 */
import javax.swing.JFrame;

/**
 * Frame that contains OrderForm panel
 */
public class PizzaFrame 
{
	/**
	 * Sets up and displays frame
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Pizza Palace: Order Form");
		frame.setSize (800, 600);
		frame.setLocation (100, 100);

		OrderForm myPanel = new OrderForm(true);
		
		frame.getContentPane().add(myPanel);
		frame.pack();
		frame.setVisible (true);
	}
}


package pizza_palace;
/**
 * MainPanel.java	07/12/2003
 * Author: Patrick Nutt
 */
 import javax.swing.*;
 import java.awt.*;
 
 /**
  *	This class represents an introduction panel to the 
  * <@link PizzaManager> interface. It simply provides instructions
  * to the user.
  */
 public class MainPanel extends JPanel
 {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 989262487566140841L;
	private JLabel lineOne;
 	private JLabel lineTwo;
 	private JLabel lineThree;
 	private JLabel lineFour;
 	private JLabel lineFive;

 	
 	public MainPanel()
 	{
 		setBackground (PizzaPalace.COLOR_MAIN);
 		setLayout (new FlowLayout (FlowLayout.CENTER, 200, 0));
		
 		lineOne = new JLabel ("Welcome to the Inventory Manager for the Pizza Palace!");
 		lineTwo = new JLabel ("You may view a copy of the customer order form,");
 		lineThree = new JLabel ("the current inventory of ingredients,");
 		lineFour = new JLabel ("or a shopping list to ensure that you");
 		lineFive = new JLabel ("never run out of needed supplies");
 		lineOne.setFont (new Font ("Helvitica", Font.BOLD, 18));
 		lineTwo.setFont (new Font ("Helvitica", Font.BOLD, 14));
 		lineThree.setFont (new Font ("Helvitica", Font.BOLD, 14));
 		lineFour.setFont (new Font ("Helvitica", Font.BOLD, 14));
 		lineFive.setFont (new Font ("Helvitica", Font.BOLD, 14));
 	
 		add (lineOne);
  		add (lineTwo);
 		add (lineThree);
 		add (lineFour);
 		add (lineFive);
 		
 	}
 }
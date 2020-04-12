package pizza_palace;

/**
 * PizzaPalacePanel.java		7/20/2003
 * Author: Patrick Nutt
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Main control panel for the Pizza Palace program. It allows the user 
 * to display the customer order form or the inventory manager interface,
 * or create a new stock inventory
 **/ 
public class PizzaPalacePanel extends JPanel
{
		/**
	 * 
	 */
	private static final long serialVersionUID = -431961904375497080L;
		private JButton customer, manager, newStock;
		private ButtonListener buttonListener = new ButtonListener();
	
	/**
	 * Displays three buttons. The user has a choice of opening the order form,
	 * displaying the Inventory Manger interface, or creating a new inventory
	 * of ingredients. Creation of a new set of ingredients is performed via 
	 * the <@link newPizza()> method of the <code>CreatePizza</code> class
	 */		
	public PizzaPalacePanel() 
	{		
		customer = new JButton ("Order Form");
		manager = new JButton ("Inventory Manger");
		newStock = new JButton ("New Inventory");
		
		add (customer);
		add (manager);
		add (newStock);

		customer.addActionListener (buttonListener);
		manager.addActionListener (buttonListener);
		newStock.addActionListener (buttonListener);
	}


	/** 
	 * Listener for the option buttons
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * Performs the necessary operation as determined by the selected button
		 */
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();
			
			if (source == customer)
			{				
				PizzaFrame.main(null);
			}
			else if (source == newStock)
			{
				CreatePizza.newPizza();
			}
			else if (source == manager)
			{
				PizzaManager.main (null);
				CreatePizza.newPizza();
			}
		}
	}
}
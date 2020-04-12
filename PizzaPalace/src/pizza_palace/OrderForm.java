package pizza_palace;
/**
* OrderForm.java
* Author: Patrick Nutt
*/
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;

/** 
 * Represents an order form for the Pizza Palace
 */
public class OrderForm extends JPanel
{

 	/**
	 * 
	 */
	private static final long serialVersionUID = 4751218405335989230L;

	/**
 	 * Font for company name
 	 */
	private final int NAME_SIZE = 56;	
	
	/**
	 * Number of topping to display in the check box group
	 */
	private final int MAX_TOPPINGS = 9;
	
	/**
	 * Width and height of OrderForm
	 */
	private final int WIDTH = 600, HEIGHT = 400;
	
	/**
	 * Constant size for submit and reset buttons
	 */
	private final Dimension BUTTON_SIZE = new Dimension (75, 23);
	
	/**
	 * Output file name
	 */
	private String fileName;
	
	/**
	 * All labels for GUI
	 */
	private JLabel name, phone, address, companyName, logoLabel;
	
	/**
	 * Entry fields for customer information
	 */
	private JTextField currentName, currentPhone, currentAddress;
	
	/**
	 * Array to contain toppings' checkboxes
	 */
	private JCheckBox[] toppings;
	
	/**
	 * Array to contain toppings' names
	 */
    private String[] toppingName = {"Pepperoni", "Sausage", "Bacon", "Hamburger",
											"Onion", "Jalepeño", "Pinapple", "Mushroom", 
											"Red Pepper"};
	
	/** 
	 * Radio Buttons for the delivery option group
	 */
	private JRadioButton pickUp, atHome;
	
	/**
	 * Radio Buttons for the size option group
	 */
	private JRadioButton small, medium, large;
	
	/**
	 * Submit and reset buttons
	 */
	private JButton submit, reset;
	
	/**
	 * Panels for each BorderLayout display area
	 */
	private JPanel northPanel, southPanel, centerPanel,westSpacer, eastSpacer;
	
	/** 
	 * Box panels for graphically arranging elements
	 */
	private Box westPanel, checkPanel, eastPanel, deliveryPanel, sizePanel,
			 	   namePanel, phonePanel, addressPanel;
	
	/**
	 * Pizza images. Three different sizes are represented
	 */
	private ImageIcon smallPizza, mediumPizza, largePizza;
	
	/**
	 * Customer selections to be saved to file
	 */
	private String delivery, size, Name, Phone, Address ;
	
	/**
	 * Customer selections to be saved to file
	 */
	private String[] toppingList;
	
	/**
	 * Price totals
	 */
	private double sizePrice, toppingPrice, totalPrice;
	
	/**
	 * Number of toppings selected
	 */
	private int toppingCounter;	
	
	/**
	 * Currency format for prices
	 */
	private NumberFormat format = NumberFormat.getCurrencyInstance();	
	
	/**
	 * Calendar object for dynamically naming output files
	 */
	private Calendar rightNow = Calendar.getInstance();
	
	/**
	 * Creates an OrderForm. 
	 *
	 * @param enable determines if the order form shopuld be enabled or not
	 * 				 true is enabled disabled otherwise
	 */
	public OrderForm(boolean enable) 
	{

		// Initial settings to small pizza with no toppings 
		size = "10 inch Pizza";
		delivery = "Pick Up";
		sizePrice = 6.00;
		
		////////////////////////////////////////////////////////////////////////
		//	 Main Panel																			
		////////////////////////////////////////////////////////////////////////
		setLayout (new BorderLayout());
		setPreferredSize (new Dimension (WIDTH, HEIGHT));
		setBackground (PizzaPalace.COLOR_MAIN);
		//////////////////////////Main Panel////////////////////////////////////


		////////////////////////////////////////////////////////////////////////
		//	 North Panel																			 **
		////////////////////////////////////////////////////////////////////////
		northPanel = new JPanel();
		northPanel.setBackground (PizzaPalace.COLOR_SECONDARY);

		companyName = new JLabel ("Pizza Palace");
		companyName.setForeground (PizzaPalace.COLOR_NAME);
		companyName.setFont (new Font ("Jokewood", Font.PLAIN, NAME_SIZE));
		northPanel.add (companyName);
		///////////////////////////North Panel//////////////////////////////////


		////////////////////////////////////////////////////////////////////////
		//	 West Panel																			 **
		////////////////////////////////////////////////////////////////////////
		westPanel = new Box (BoxLayout.Y_AXIS);  
		westPanel.setBackground (PizzaPalace.COLOR_MAIN);

		namePanel = new Box (BoxLayout.X_AXIS); 
		phonePanel = new Box (BoxLayout.X_AXIS);
		addressPanel = new Box (BoxLayout.X_AXIS);
		name = new JLabel ("Name:");
		currentName = new JTextField (10);	// name entry field
		currentName.setEnabled (enable);
		phone = new JLabel ("Phone #:");
		currentPhone = new JTextField (10);	// phone number entry field
		currentPhone.setEnabled (enable);
		address = new JLabel ("Street Address");
		currentAddress = new JTextField (10);	// address entry field
		currentAddress.setEnabled (enable);
		westSpacer = new JPanel();	// space buffer

		// Name 
		namePanel.add (Box.createRigidArea (new Dimension (5, 0)));
		namePanel.add (name);
		namePanel.add (Box.createRigidArea (new Dimension (17, 0)));
		namePanel.add (currentName);

		// Phone
		phonePanel.add (Box.createRigidArea (new Dimension (5, 0)));
		phonePanel.add (phone);
		phonePanel.add (Box.createRigidArea (new Dimension (5, 0)));
		phonePanel.add (currentPhone);

		// Address
		addressPanel.add (Box.createRigidArea (new Dimension (5, 0)));
		addressPanel.add (address);
		addressPanel.add (Box.createRigidArea (new Dimension (5, 0)));
		addressPanel.add (currentAddress);

		// Spacer
		westSpacer.setPreferredSize (new Dimension (100,200));
		westSpacer.setBackground (PizzaPalace.COLOR_MAIN);

		// fill west panel
		westPanel.add (Box.createRigidArea (new Dimension (10, 10)));
		westPanel.add (namePanel);
		westPanel.add (Box.createRigidArea (new Dimension (10, 10)));
		westPanel.add (phonePanel);
		westPanel.add (Box.createRigidArea (new Dimension (10, 10)));
		westPanel.add (addressPanel);
		westPanel.add (westSpacer);
		///////////////////////////West Panel///////////////////////////////////

		
		////////////////////////////////////////////////////////////////////////
		//	 Center Panel																			 **
		////////////////////////////////////////////////////////////////////////
		centerPanel = new JPanel();
   		centerPanel.setBackground (PizzaPalace.COLOR_MAIN);
			
		toppings = new JCheckBox[MAX_TOPPINGS];	// array of check boxes
		checkPanel = new Box(BoxLayout.Y_AXIS);	// container for check boxes

		ToppingListener toppingListener = new ToppingListener();

		// loop to create check boxes
		for (int topCount = 0; topCount < MAX_TOPPINGS; topCount++)
		{
			toppings[topCount] = new JCheckBox(toppingName[topCount]);
			toppings[topCount].setBackground (PizzaPalace.COLOR_MAIN);
			toppings[topCount].addItemListener (toppingListener);
			checkPanel.add (toppings[topCount]);
			toppings[topCount].setEnabled (enable);
		}
		checkPanel.setBorder (BorderFactory.createTitledBorder("Select Toppings"));
		checkPanel.setPreferredSize (new Dimension (150, 250));
		checkPanel.setBackground (PizzaPalace.COLOR_MAIN);

		// fill center panel	
		centerPanel.add (checkPanel);
		///////////////////////////Center Panel/////////////////////////////////


		////////////////////////////////////////////////////////////////////////
		//	 East Panel																			 **
		////////////////////////////////////////////////////////////////////////
		eastPanel = new Box(BoxLayout.Y_AXIS);	
		eastPanel.setPreferredSize (new Dimension (200, 210));
		eastPanel.setBackground (PizzaPalace.COLOR_MAIN);

		deliveryPanel = new Box (BoxLayout.X_AXIS);
		sizePanel = new Box (BoxLayout.X_AXIS);
		ButtonGroup deliveryGroup = new ButtonGroup ();
		ButtonGroup sizeGroup = new ButtonGroup ();
		eastSpacer = new JPanel();	// space buffer
		pickUp = new JRadioButton ("Pick-up", enable);
		pickUp.setEnabled (enable);
		atHome = new JRadioButton ("Deliver");
		atHome.setEnabled (enable);
		small = new JRadioButton ("10\"", enable);
		small.setEnabled (enable);
		medium = new JRadioButton ("12\"");
		medium.setEnabled (enable);
		large = new JRadioButton ("16\"");
		large.setEnabled (enable);
		smallPizza = new ImageIcon ("./src/res/Images/pizza10.gif");
		mediumPizza = new ImageIcon ("./src/res/Images/pizza12.gif");
		largePizza = new ImageIcon ("./src/res/Images/pizza16.gif");
		logoLabel = new JLabel (smallPizza);

		// set up spacers
		eastSpacer.setBackground (PizzaPalace.COLOR_MAIN);
		eastSpacer.setPreferredSize (new Dimension (100, 70));
		eastSpacer.add (logoLabel);

		// set up delivery panel
		DeliveryListener deliveryListener = new DeliveryListener();
		deliveryPanel.setBackground (PizzaPalace.COLOR_MAIN);		
		pickUp.setBackground (PizzaPalace.COLOR_MAIN);
		pickUp.addActionListener (deliveryListener);
		atHome.setBackground (PizzaPalace.COLOR_MAIN);
		atHome.addActionListener (deliveryListener);

		// group radio buttons
		deliveryGroup.add (pickUp);
		deliveryGroup.add (atHome);

		// fill delivery panel
		deliveryPanel.add (pickUp);
		deliveryPanel.add (atHome);
		deliveryPanel.setPreferredSize (new Dimension (100, 40));
		deliveryPanel.setBorder (BorderFactory.createTitledBorder ("Delivery Method"));		

		// set up size panel
		SizeListener sizeListener = new SizeListener ();
		sizePanel.setBackground (PizzaPalace.COLOR_MAIN);
		small.setBackground (PizzaPalace.COLOR_MAIN);
		small.addActionListener (sizeListener);
		medium.setBackground (PizzaPalace.COLOR_MAIN);
		medium.addActionListener (sizeListener);
		large.setBackground (PizzaPalace.COLOR_MAIN);
		large.addActionListener (sizeListener);
		sizePanel.setBorder (BorderFactory.createTitledBorder ("Select Size"));
		sizePanel.setPreferredSize (new Dimension (100, 40));

		// group radio buttons
		sizeGroup.add (small);
		sizeGroup.add (medium);
		sizeGroup.add (large);

		// fill size panel
		sizePanel.add (small);
		sizePanel.add (medium);
		sizePanel.add (large);

		// fill east panel
		eastPanel.add (deliveryPanel);
		eastPanel.add (Box.createRigidArea (new Dimension (10 ,10)));
		eastPanel.add (sizePanel);
		eastPanel.add (eastSpacer);
		////////////////////////////East Panel//////////////////////////////////


		////////////////////////////////////////////////////////////////////////
		//	 South Panel																			 **
		////////////////////////////////////////////////////////////////////////
		southPanel = new JPanel();
		southPanel.setBackground (PizzaPalace.COLOR_SECONDARY);
		submit = new JButton ("Submit");
		reset = new JButton ("Reset");

		// set up buttons	
		ButtonListener buttonListener = new ButtonListener ();
		submit.setPreferredSize (BUTTON_SIZE);
		submit.setMnemonic ('S');
		submit.createToolTip();
		submit.setToolTipText ("Press to submit order");
		submit.addActionListener (buttonListener);
		submit.setEnabled (enable);
		reset.setPreferredSize (BUTTON_SIZE);
		reset.setMnemonic ('R');
		reset.createToolTip();
		reset.addActionListener (buttonListener);
		reset.setEnabled (enable);
		reset.setToolTipText ("Press to clear all entries");
        
		// fill south panel
		southPanel.add (Box.createHorizontalStrut (WIDTH - 168));
		southPanel.add (submit);
		southPanel.add (reset);
		southPanel.add (Box.createVerticalStrut (34));

		// fill main panel
		add (eastPanel, BorderLayout.EAST);
		add (southPanel, BorderLayout.SOUTH);
		add (westPanel, BorderLayout.WEST);
	    add (centerPanel, BorderLayout.CENTER);
		add (northPanel, BorderLayout.NORTH);
		/////////////////////////South Panel////////////////////////////////////
	}
	
	///////////////
	// Listeners
	///////////////
	
	/**
	 * Listener for delivery option group
	 */
	private class DeliveryListener implements ActionListener
	{
		/**
		* Sets the delivery type
		*/
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if (source == pickUp)
				delivery = "Pick Up";
			else 
				delivery = "Home Delivery";
		}
	}
	
	/**
	 * Listener for size option group
	 */
	private class SizeListener implements ActionListener
	{
		/**
		* Sets pizza size and changes icon appropriately
		*/
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if (source == small)
			{
				size = "10 inch Pizza";
				logoLabel.setIcon (smallPizza);
				sizePrice = 6.00;
			}
			else if (source == medium)
			{
				size = "12 inch Pizza";
				logoLabel.setIcon (mediumPizza);
				sizePrice = 8.00;
			}
			else
			{
				size = "16 inch Pizza";
				logoLabel.setIcon (largePizza);
				sizePrice = 10.00;
			}
		}
	}
	
	/**
	 * Listener for topping checkbox option group
	 */
	private class ToppingListener implements ItemListener
	{
		/**
		* Sets the customer's choice of toppings
		*/
		public void itemStateChanged (ItemEvent event)
		{
			toppingCounter = 0;
			toppingPrice = 0;
			toppingList = new String[MAX_TOPPINGS];

			for (int count = 0; count < MAX_TOPPINGS; count++)
			{
				if (toppings[count].isSelected())
				{
					toppingList[toppingCounter] = toppings[count].getText();
					toppingCounter++;
				}
			}
			toppingPrice = toppingCounter * .75;	// each topping is .75 cents
		}
	}
	
	/**
	 * Listener for the submit and reset buttons
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		* Submits the order when submit button is pressed. Clears all input
		* values if reset is pressed. Tests to ensure customer information
		* has been entered before proceeding with submit operation.
		*/
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if (source == submit)
			{
				int confirm;
				totalPrice = sizePrice + toppingPrice;
				
				Name = currentName.getText();
				Phone = currentPhone.getText();
				Address = currentAddress.getText();
				if (Name.equals ("") || Phone.equals("") || Address.equals(""))
				{
					JOptionPane.showMessageDialog (null, 
												"Please enter all customer" + 
												"information ",
												"Incomplete Form",
												JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					// Set name of file dynamically
					fileName = "./src/res/Orders/"; 
					fileName += rightNow.get (Calendar.MONTH) + 1;
					fileName += rightNow.get (Calendar.DAY_OF_MONTH);					
					fileName += rightNow.get (Calendar.YEAR);	
					fileName += ".dat";	
					
					// Sets text for confirmation dialog			
					String message = Name + " \n" + Phone + "\n"; 
					message += Address + "\n";
					message += "\n" + size + "..... "; 
					message += format.format (sizePrice);
					for (int count = 0; count < toppingCounter; count++)
					{
						message += "\n" + toppingList[count] + "..... $.75";
					}
					message += "\n" + "Total " + delivery + " Price" + "..... ";
				 	message += format.format (totalPrice) + "\n\n"; 
				 	message += "Is this correct?";
	
					confirm = JOptionPane.showConfirmDialog (null, message,
															 "Order Confirmation",
															 JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION)
					{
						// prepare output file	
						try
						{
							FileWriter fWriter = new FileWriter (fileName, true);
							BufferedWriter buffWriter = new BufferedWriter (fWriter);
							PrintWriter outFile = new PrintWriter (buffWriter);
						    outFile.print (Name + ", ");
							outFile.print (Address + ", ");
							outFile.print (size);
							for (int count = 0 ; count < toppingCounter; count++)
								outFile.print (", " + toppingList[count]);
							outFile.println();
							outFile.close();
						}
						catch (IOException exception)
						{
							System.out.println (exception);
						}
						
						// text for final information dialog 
						String orderMessage = Name + "\n" + "Your order has ";
						orderMessage +=	"been placed.\n";
						if (delivery.equals ("Pick Up"))
						{
							orderMessage += "Your order will be ready for "; 
							orderMessage += "pick up in 30 minutes!";
						}
						else
						{
							orderMessage += "Your order will be delivered ";
							orderMessage += "in 30 minutes or less!";
						}

						JOptionPane.showMessageDialog (null, orderMessage, 
													   "Order Confirmation",
													   JOptionPane.WARNING_MESSAGE);
					}

				}
			}
			else if (source == reset)
			{
					for (int count = 0; count < MAX_TOPPINGS; count++)
					{
						toppings[count].setSelected (false);
					}
					pickUp.setSelected (true);
					delivery = "Pick Up";
					small.setSelected (true);
					size = "10 inch Pizza";
					logoLabel.setIcon (smallPizza);
					currentName.setText ("");
					currentPhone.setText ("");
					currentAddress.setText ("");
			}
		}
	}	
}
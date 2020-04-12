package pizza_palace;
/**
 * ShoppingListPanel.java
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

/**
 * Creates and displays a shopping list based on values obtained through the 
 * <@link StockLevles> class
 */
public class ShoppingListPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9177251175186817464L;

	/**
	 * Array of <@link Consumable> objects
	 */
	private Consumable[] itemList;
	
	/**
	 * <@link StockLevels> objects
	 */
	private StockLevels stocker;
	
	/**
	 * String representation of amount values
	 */
	private String itemText, amountText;
	
	/**
	 * Output file name
	 */
	private String fileName;
	
	/**
	 * Amount values
	 */
	private double amount, maxAmount, minAmount, neededAmount;
	
	/**
	 * <@link DecimalFormat> object
	 */
	private DecimalFormat fmt;
	
	/**
	 * Text area to contain reports
	 */
	private JTextArea listItem, listAmt;
	
	/** 
	 * True if shipping is needed.
	 * False otherwise
	 */
	private boolean shoppingNeeded;
	
	/**
	 * <@link Box> object to contain report
	 */
	private Box listBox;
	
	/**
	 * Creates and displays the shopping list.
	 * Also outputs results to a file.
	 */
	public ShoppingListPanel() 
	{
		setBackground (Color.white);
		setSize (800, 600);		
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
	
		listBox = new Box (BoxLayout.X_AXIS);
		
		listItem = new JTextArea();
		listAmt = new JTextArea();
		fmt = new DecimalFormat ("0.00");
		fileName = new String ("./src/res/Orders/shoplist.dat");
		itemList = new Consumable [StockLevels.INGREDIENTS];
		stocker = new StockLevels();		
		
		listBox.setLocation (100, 0);
		listBox.setPreferredSize (new Dimension (300, 400));
		
		// Fill array
		itemList = stocker.getList();
			
		listItem.setEditable (false);
		listAmt.setEditable (false);
		listItem.setBackground (Color.white);
		listAmt.setBackground (Color.white);
		listItem.setText ("Name\n");
		listAmt.setText ("(g)\n");

		try
		{
			FileWriter writer = new FileWriter (fileName);
			BufferedWriter bw = new BufferedWriter (writer);
			PrintWriter outFile = new PrintWriter (bw);
			
			shoppingNeeded = false;
			for (int count = 0; count < StockLevels.INGREDIENTS; count++)
			{
				amount = itemList[count].getAmount();
				maxAmount = itemList[count].getMaxAmount();
				minAmount = itemList[count].getMinAmount();
				
				// build list if amount is within 50 grams of the minimum
				if ((amount - minAmount) < 50.0)
				{
					neededAmount = maxAmount - amount;
					itemText = new String (itemList[count].toString() + "\n");
					amountText = new String ("" + fmt.format (neededAmount) + "\n");
					
					outFile.print (itemText + "     ");
					outFile.println (amountText);
					
					listItem.append (itemText);
					listAmt.append (amountText);
					
					shoppingNeeded = true;
				}
				else
				{
					neededAmount = 0;
				}
			}
			outFile.close();
		}
		catch (IOException exception) {}
		
		listBox.add (listItem);
		listBox.add (listAmt);
		
		add (listBox);

		// Display message box if no items need to be ordered
		if (!shoppingNeeded)
		{
			JOptionPane.showMessageDialog (null, "No shopping is needed" 
											   + " today!");		
		}
	}
}
				
		
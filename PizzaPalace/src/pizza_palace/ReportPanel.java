package pizza_palace;
/**
 * ReportPanel.java		7/20/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;

/**
 * Creates and displays an inventory report
 */
public class ReportPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 996990337542583355L;

	/**
	 * Column headings
	 */
	private String currUsageLabel, prevStockLabel, currStockLabel;
	
	/**
	 * Item name, usage, yesterday's stock, and today's stock values
	 */
	private String[][] item;
	
	/**
	 * Array of <@link Consumable> objects
	 */
	private Consumable[] itemList;
	
	/**
	 * StockLevels object
	 */
	private StockLevels stocker;
	
	/**
	 * Text area to contain report information
	 */ 
	private JTextArea display;
	
	/*
	 * Sets up and displays report based on values obtained from the 
	 * <@link StockLevels> class.
	 */
	public ReportPanel()
	{		
		setSize (800, 600);
		setBackground (Color.white);
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		
		display = new JTextArea ();
		stocker = new StockLevels ();

		currUsageLabel = new String ("\tToday's\t");
		prevStockLabel = new String ("Yesterday's\t");
		currStockLabel = new String ("Today's\n");

		display.setEditable (false);
		display.setText (currUsageLabel + prevStockLabel + currStockLabel);
		display.append ("Item\tUsage\tStock\tStock\n\n");

		itemList = new Consumable [StockLevels.INGREDIENTS];
		itemList = stocker.getList();

		item = new String [StockLevels.INGREDIENTS][4];
		
		// Fill report
		for (int count = 0; count < StockLevels.INGREDIENTS; count++)
		{
			display.append (itemList[count].toString() + "\t");
			for (int inner = 1; inner < 4; inner++)
			{
				item[count][inner] = itemList[count].getStockLevels();
				display.append (item[count][inner] + "\t");
			}
			display.append ("\n");		
		}

		add (display);
	}
}
		   
package pizza_palace;
/**
 * ChartPanel.java		7/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
/**
 * This class creates a bar chart representing the maximum, current, and 
 * minimum level of each product of an array of <@link Consumable> objects.
 * The array is obtained through a <@link StockLevels> class. Three loops are 
 * used, one for each level indicator. A legend is also created and each bar is
 * labeled with the name of a <Code>Combustable</code> object.
 */
public class ChartPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2433505358149383420L;

	/**
	 * Constant width of each bar
	 */
	private final int WIDTH = 30;
	
	/**
	 * Constant used to specify the height boundary for the graphical 
	 * representation of the bar chart
	 */
	private final int MAX_HEIGHT = 400; 
	
	/**
	 * Constant gap between bars
	 */
	private final int GAP = 9;
	
	/** 
	 * Constants defining the x, y, bullet size, and blank space
	 * values for the chart legend
	 */
	private final int LEG_X = 457, LEG_Y = 10, BULLET = 10;
	
	/**
	 * Constants defining the size of this ChartPanel
	 */
	private final int PANEL_WIDTH = 642, PANEL_HEIGHT = 500;
	
	/**
	 * The x and y coordinates for each bar. Values are determined dynamically
	 * from each item of the Consumable array
	 */
	private int xVal, yVal;
	
	/**
	 * The height value for each bar. Determined dynamically from each
	 * item of the Consumable array
	 */
	private int height;
	
	/**
	 * Used to dynamically determine the height of each item. The min 
	 * variable is assigned a value from a Consumable object. This value is 
	 * then manipulated to achieve the right visual effect
	 */
	private double min;
	
	/** 
	 * Array of Consumable objects
	 */
	private Consumable[] itemList;
	
	/**
	 * StockLevel object to retrieve the array of Consumable objects
	 */
	private StockLevels stocker;
	
	/**
	 * Sets up this ChartPanel size and background color. Also instantiates
	 * an array of <@Consumable> objects and a <@link StockLevels> object. 
	 * The array of <@link Consumable> objects is assigned the values obtained 
	 * by calling the <@link getList> method of the <@link StockLevels> class.
	 */
	public ChartPanel()
	{		
		setBackground (Color.black);
		setPreferredSize (new Dimension (PANEL_WIDTH, PANEL_HEIGHT));
		
		itemList = new Consumable [StockLevels.INGREDIENTS];
		stocker = new StockLevels();
		itemList = stocker.getList();				
	}
	
	/**
	 * Paints this ChartPanel to the screen. Location and size values are 
	 * determined dynamically. A separate iteration is used to create each of 
	 * three bar levels, minimum, maximum, and current. Also creates legend for
	 * the chart. The values obtained from the <@link Consumable> objects are 
	 * manipulated in order to provide a graphically pleasing representation 
	 * of the bar chart. It ensures that the objects with large amounts and
	 * small amount can be seen at the same time on the screen
	 */
	public void paintComponent (Graphics page) 
	{
		super.paintComponent (page);
		
		// Legend		
		page.setColor (Color.cyan);		
		page.drawRect (LEG_X, LEG_Y, 175, 50);		
		page.fillRect (LEG_X + 5, LEG_Y + 5, BULLET, BULLET);
		page.setColor (Color.yellow);		
		page.fillRect (LEG_X + 5, LEG_Y + 20, BULLET, BULLET);
		page.setColor (Color.blue);
		page.fillRect (LEG_X + 5, LEG_Y + 35, BULLET, BULLET);	
		page.setColor (Color.cyan);
		page.drawString ("Full Amount in grams", LEG_X + 20, LEG_Y + 15);	
		page.drawString ("Current Amount in grams", LEG_X + 20, LEG_Y + 30);	
		page.drawString ("Minimum amount in grams", LEG_X + 20, LEG_Y + 45);	
	
		// Maximum level bar	
		page.setColor (Color.cyan);	
		xVal = GAP;		
		for (int count = 0; count < StockLevels.INGREDIENTS; count++)
		{
			min = itemList[count].getMaxAmount();
			if (min > 1500)
			{
				min = min / 175;
			}
			else
			{
				min = min / 10;
			}
			height = (int) min;
			yVal = MAX_HEIGHT - height - 50;
			page.fillRect (xVal, yVal, WIDTH, height);
			String text = new String (itemList[count].toString());
			int len = text.length();
			for (int inner = 0; inner < len; inner ++)
			{
				page.drawString (text.substring (inner, inner + 1), 
								 xVal + (WIDTH / 2), MAX_HEIGHT - (40 - (inner * 15)));
			}
			
			xVal = xVal + WIDTH + GAP;
		}
		
		// Current level bar
		page.setColor (Color.yellow);
		xVal = GAP;
		for (int count = 0; count < StockLevels.INGREDIENTS; count++)
		{
			min = itemList[count].getAmount();
			if (min > 1500)
			{
				min = min / 175;
			}
			else
			{
				min = min / 10;
			}
			height = (int) min;
			yVal = MAX_HEIGHT - height - 50;
			page.fillRect (xVal, yVal, WIDTH, height);
			xVal = xVal + WIDTH + GAP;
		}
		
		// Minimum level bar
		page.setColor (Color.blue);
		xVal = GAP;		
		for (int count = 0; count < StockLevels.INGREDIENTS; count++)
		{
			min = itemList[count].getMinAmount();
			if (min > 1500)
			{
				min = min / 175;
			}
			else
			{
				min = min / 10;
			}
			height = (int) min;
			yVal = MAX_HEIGHT - height - 50;
			page.fillRect (xVal, yVal, WIDTH, height);

			xVal = xVal + WIDTH + GAP;
		}
	}
}
package pizza_palace;
/**
 * StockLevels.java		7/20/2003
 * Author: Patrick Nutt
 */
import java.io.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.accessibility.*;
import java.util.StringTokenizer;

/**
 * Adjusts the ingredient amounts for each item of an array of 
 * <@link Consumable> objects. This is accomplished by first de-serializing
 * the Consumable objects. The current days usage file is opened and the size
 * and toppings are determined. This is then used to determine which Consumable
 * needs to have its current amount adjusted. Each object is adjusted by calling
 * the <@link makePizza> method of the Consumable class.
 */ 
public class StockLevels 
{
	/**
	 * Constant for the maximum number of ingredients to be processed
	 */
	public final static int INGREDIENTS = 16;
	
	/**
	 * Array of ingredients
	 */
	private String[] mainIngredients = {"Flour", "Cheese", "Oil", "Salt",
											   "Sauce", "Sugar", "Yeast"};
											   
	/**
	 * File names
	 */											   
	private String serialFileName, inFileName;
	
	/**
	 * Variables to contain information from usage file
	 */
	private String line, name, address, strSize;
	
	/**
	 * Array of toppings filled from usage file
	 */
	private String[] toppings;
	
	/**
	 * Integer representation of the size from the usage file
	 */
	private int size;
	
	/**
	 * Integer representing the number of toppings from the usage file
	 */
	private int toppingCount;
		
	/**
	 * Array of Consumable objects
	 */
	private Consumable[] ingredients;
	
	/**
	 * Today's date used to access the correct file
	 */
	private Calendar rightNow = Calendar.getInstance();

	/**
	 * Processes usage file and adjusts levels appropriately
	 */ 
	private void updateUsedStock () 
	{
					
			serialFileName = "./src/res/Orders/ingredients.dat";
			inFileName = "./src/res/Orders/"; 
			inFileName += rightNow.get (Calendar.MONTH) + 1;
			inFileName += rightNow.get (Calendar.DAY_OF_MONTH);					
			inFileName += rightNow.get (Calendar.YEAR);	
			inFileName += ".dat";
			
		try
		{
			FileReader reader = new FileReader (inFileName);
			BufferedReader inFile = new BufferedReader (reader);
			
			FileInputStream stream = new FileInputStream (serialFileName);
			ObjectInputStream inStream = new ObjectInputStream (stream);
			
			ingredients = new Consumable [INGREDIENTS];
			for (int scan = 0; scan < INGREDIENTS; scan++)
			{
				ingredients[scan] = (Consumable) inStream.readObject();
			}
			
			// Get first line from usage file
			line = inFile.readLine();
			
			// process each line of the usage file
			while (line != null)
			{		
				StringTokenizer token = new StringTokenizer (line, ",");
				toppingCount = (token.countTokens()) - 3;
				toppings = new String[toppingCount];
				
			
				name = token.nextToken();
				address = token.nextToken();
				strSize = token.nextToken();
			
				// Translate size string into an integer						
				if (strSize.trim().equals ("10 inch Pizza"))
					size = Consumable.SMALL;
				else if (strSize.trim().equals ("12 inch Pizza"))
					size = Consumable.MEDIUM;
				else if (strSize.trim().equals ("16 inch Pizza"))
					size = Consumable.LARGE;
				
				// Resets previous amount used to 0	using the open method of 
				// the Consumable class
				boolean openClass;
				for (int scan = 0; scan < INGREDIENTS; scan++)
					openClass = ingredients[scan].open();
					
				// Count the number of toppings
				int count = 0;
				while (token.hasMoreTokens())
				{
					toppings[count] = token.nextToken();
					count ++;
				}
				
				// Adjust the levels of each of the basic ingredients of a pizza
				for (int scan = 0; scan < INGREDIENTS; scan++)
				{
					String innerName = new String (ingredients[scan].toString());
					
					for (int inner = 0; inner < mainIngredients.length; inner++)
					{	
						
						if (innerName.equals (mainIngredients[inner]))
						{
							ingredients[scan].makePizza(size);
						}
					}
				}
				
				
				// Adjust the levels of each of the toppings 
				for (int scan = 0; scan < INGREDIENTS; scan++)
				{
					String innerName = new String (ingredients[scan].toString());
					for (int inner = 0; inner < toppingCount; inner++)
					{
						if (innerName.equals (toppings[inner].trim()))
						{
							ingredients[scan].makePizza(size);
						}
					}
				}
				
				line = inFile.readLine ();
				
			}//while (line != null);
			inFile.close();
			inStream.close();			

			// Erase usage file contents
			FileWriter writer = new FileWriter (inFileName);
			BufferedWriter bw = new BufferedWriter (writer);
			PrintWriter outFile = new PrintWriter (bw);			
			outFile.print ("");
			outFile.close();
			
			// Serialize Consumable object array
			FileOutputStream file = new FileOutputStream (serialFileName);
			ObjectOutputStream outStream = new ObjectOutputStream (file);
			
			for (int scan = 0; scan < ingredients.length; scan++)
			{
				outStream.writeObject (ingredients[scan]);
			}
			outStream.close();
		}
		catch (IOException exception) {}	
		catch (ClassNotFoundException exception) {}
	}
	
	public Consumable[] getList ()
	{
		updateUsedStock();
		return ingredients;
	}

}


		

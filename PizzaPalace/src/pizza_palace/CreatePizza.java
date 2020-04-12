package pizza_palace;
/**
 * CreatePizza.java 7/20/2003
 * Author: Patrick Nutt
 */
import java.io.*;

/**
 * This class is used to create and instantiate an array of {@link Consumable}
 * objects.
 */
public class CreatePizza 
{
	/**
	 * Creates, instatiates, and serializes an array of {@link Consuambable} 
	 * objects.
	 */
	public static void newPizza()
	{
		Consumable[] ingredients = new Consumable [16];
		
		ingredients[0] = new Flour();
		ingredients[1] = new Yeast();
		ingredients[2] = new Sugar();
		ingredients[3] = new Salt();
		ingredients[4] = new Cheese();
		ingredients[5] = new Sauce();
		ingredients[6] = new Oil();
		ingredients[7] = new Pepperoni();
		ingredients[8] = new Sausage();
		ingredients[9] = new Bacon();
		ingredients[10] = new Hamburger();
		ingredients[11] = new Onion();
		ingredients[12] = new Jalepeno();
		ingredients[13] = new Mushroom();
		ingredients[14] = new RedPepper();
		ingredients[15] = new Pinapple();
		
		try
		{	
			FileOutputStream file = new FileOutputStream ("Orders\\ingredients.dat");
			ObjectOutputStream outStream = new ObjectOutputStream (file);
			
			for (int scan = 0; scan < ingredients.length; scan++)
			{
				outStream.writeObject (ingredients[scan]);
			}
		}
		catch (IOException exception) {}		
	}
}
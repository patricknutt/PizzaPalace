package pizza_palace;
/**
 * Cheese.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents cheese
 */
 public class Cheese extends Consumable implements Serializable
 {
 	/**
 	 * Creates a new <code>Cheese</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Consumable>
 	 */ 	
 	public Cheese ()
 	{
 		super ("Cheese", 22700, 11350, 14.2);
 	}
 	
 	/**
 	 * Creates a new <code>Cheese</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Consumable>
 	 * @param currentAmount the current amount of this object
 	 */ 	
 	public Cheese (double currentAmount)
 	{
 		super ("Cheese", 22700, 11350, 14.2, currentAmount);
 	}
 }
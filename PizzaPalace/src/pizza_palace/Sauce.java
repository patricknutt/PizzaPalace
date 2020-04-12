package pizza_palace;
/**
 * Sauce.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents sauce
 */
 public class Sauce extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>Sauce</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */  
 	public Sauce ()
 	{
 		super ("Sauce", 56700, 28350, 35.4);
 	}
  	
 	/**
 	 * Creates a new <code>Sauce</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Sauce (double currentAmount)
 	{
 		super ("Sauce", 56700, 28350, 35.4, currentAmount);
 	}
 }
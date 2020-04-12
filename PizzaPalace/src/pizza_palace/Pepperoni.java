package pizza_palace;
/**
 * Pepperoni.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents pepperoni
 */
 public class Pepperoni extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>Pepperoni</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */  
 	public Pepperoni ()
 	{
 		super ("Pepperoni", 22700, 11350, 14.2);
 	}
  	
 	/**
 	 * Creates a new <code>Pepperoni</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Pepperoni (double currentAmount)
 	{
 		super ("Pepperoni", 22700, 11350, 14.2, currentAmount);
 	}
 }
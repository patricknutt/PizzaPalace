package pizza_palace;
/**
 * RedPepper.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents red pepper
 */
 public class RedPepper extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>RedPepper</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */  	
 	public RedPepper ()
 	{
 		super ("Red pepper", 22700, 11350, 14.2);
 	}
  	
 	/**
 	 * Creates a new <code>RedPepper</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public RedPepper (double currentAmount)
 	{
 		super ("Red pepper", 22700, 11350, 14.2, currentAmount);
 	}
 }
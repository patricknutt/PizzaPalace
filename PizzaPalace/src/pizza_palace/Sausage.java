package pizza_palace;
/**
 * Sausage.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents sausage
 */
 public class Sausage extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>Sausage</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */  	
 	public Sausage ()
 	{
 		super ("Sausage", 22700, 11350, 14.2);
 	}
  	
 	/**
 	 * Creates a new <code>Sausage</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Sausage (double currentAmount)
 	{
 		super ("Sausage", 22700, 11350, 14.2, currentAmount);
 	}
 }
package pizza_palace;
/**
 * Flour.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents flour
 */
 public class Flour extends Consumable implements Serializable
 {
  	/**
 	 * Creates a new <code>Flour</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */ 	
 	public Flour ()
 	{
 		super ("Flour", 25000, 12500, 15.6);
 	}
 	
 	/**
 	 * Creates a new <code>Flour</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */ 	
 	public Flour (double currentAmount)
 	{
 		super ("Flour", 25000, 12500, 15.6, currentAmount);
 	}
 }
 
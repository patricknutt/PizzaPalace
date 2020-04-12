package pizza_palace;
/**
 * Pinapple.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents pinapple
 */
 public class Pinapple extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>Pinapple</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  
 	public Pinapple ()
 	{
 		super ("Pinapple", 22700, 11350, 14.2);
 	}
 	
 	/**
 	 * Creates a new <code>Pinapple</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */   	
 	public Pinapple (double currentAmount)
 	{
 		super ("Pinapple", 22700, 11350, 14.2, currentAmount);
 	}
 }
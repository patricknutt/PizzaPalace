package pizza_palace;
/**
 * Mushroom.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents mushroom
 */
 public class Mushroom extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>Mushroom</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */   	
 	public Mushroom ()
 	{
 		super ("Mushroom", 22700, 11350, 14.2);
 	}
 	
 	/**
 	 * Creates a new <code>Mushroom</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */   	
 	public Mushroom (double currentAmount)
 	{
 		super ("Mushroom", 22700, 11350, 14.2, currentAmount);
 	}
 }
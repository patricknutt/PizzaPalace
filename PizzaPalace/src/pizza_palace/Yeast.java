package pizza_palace;
/**
 * Yeast.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents yeast
 */
 public class Yeast extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>Yeast</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */  	
 	public Yeast ()
 	{
 		super ("Yeast", 800, 400, .5);
 	}
  	
 	/**
 	 * Creates a new <code>Yeast</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Yeast (double currentAmount)
 	{
 		super ("Yeast", 800, 400, .5, currentAmount);
 	}
 }
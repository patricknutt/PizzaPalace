package pizza_palace;
/**
 * Oil.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
 
/**
 * This class represents oil
 */
 public class Oil extends Consumable implements Serializable
 { 	
 	/**
 	 * Creates a new <code>Oil</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */   
 	public Oil ()
 	{
 		super ("Oil", 11300, 5650, 7.1);
 	}
 	
 	/**
 	 * Creates a new <code>Oil</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */   	
 	public Oil (double currentAmount)
 	{
 		super ("Oil", 11300, 5650, 7.1, currentAmount);
 	}
 }
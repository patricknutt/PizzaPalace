package pizza_palace;
/**
 * Sauce.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents sauce
 */
 public class Sauce extends Consumable implements Serializable
 { 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -4198954183732492936L;

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
package pizza_palace;
/**
 * Hamburger.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents hamburger
 */
 public class Hamburger extends Consumable implements Serializable
 {
  	/**
	 * 
	 */
	private static final long serialVersionUID = 5793017835773440912L;

	/**
 	 * Creates a new <code>Hamburger</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */ 	
 	public Hamburger ()
 	{
 		super ("Hamburger", 22700, 11350, 14.2);
 	}
 	
 	/**
 	 * Creates a new <code>Hamburger</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Hamburger (double currentAmount)
 	{
 		super ("Hamburger", 22700, 11350, 14.2, currentAmount);
 	}
 }
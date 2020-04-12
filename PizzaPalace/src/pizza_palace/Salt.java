package pizza_palace;
/**
 * Salt.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents salt
 */
 public class Salt extends Consumable implements Serializable
 { 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = 5029676092040144379L;

	/**
 	 * Creates a new <code>Salt</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */  	
 	public Salt ()
 	{
 		super ("Salt", 500, 250, .3);
 	}
  	
 	/**
 	 * Creates a new <code>Salt</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Salt (double currentAmount)
 	{
 		super ("Salt", 500, 250, .3, currentAmount);
 	}
 }
package pizza_palace;
/**
 * RedPepper.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents red pepper
 */
 public class RedPepper extends Consumable implements Serializable
 { 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -616990647352471546L;

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
package pizza_palace;
/**
 * Onion.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents an onion
 */
 public class Onion extends Consumable implements Serializable
 { 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -33498037019479299L;

	/**
 	 * Creates a new <code>Onion</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */   	
 	public Onion ()
 	{
 		super ("Onion", 22700, 11350, 14.2);
 	}
  	
 	/**
 	 * Creates a new <code>Onion</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Onion (double currentAmount)
 	{
 		super ("Onion", 22700, 11350, 14.2, currentAmount);
 	}
 }
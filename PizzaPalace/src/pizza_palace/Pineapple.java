package pizza_palace;
/**
 * Pinapple.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents pinapple
 */
 public class Pineapple extends Consumable implements Serializable
 { 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -2319528990306528735L;

	/**
 	 * Creates a new <code>Pineapple</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  
 	public Pineapple ()
 	{
 		super ("Pineapple", 22700, 11350, 14.2);
 	}
 	
 	/**
 	 * Creates a new <code>Pineapple</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */   	
 	public Pineapple (double currentAmount)
 	{
 		super ("Pineapple", 22700, 11350, 14.2, currentAmount);
 	}
 }
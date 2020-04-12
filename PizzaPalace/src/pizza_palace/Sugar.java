package pizza_palace;
/**
 * Sugar.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents sugar
 */
 public class Sugar extends Consumable implements Serializable
 { 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -4783760812991542556L;

	/**
 	 * Creates a new <code>Sugar</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */  	
 	public Sugar ()
 	{
 		super ("Sugar", 1400, 700, .875);
 	}
  	
 	/**
 	 * Creates a new <code>Sugar</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */  	
 	public Sugar (double currentAmount)
 	{
 		super ("Sugar", 1400, 70, .875, currentAmount);
 	}
 }
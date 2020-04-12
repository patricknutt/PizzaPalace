package pizza_palace;
/**
 * Jalepeno.java		07/12/2003
 * Author: Patrick Nutt
 */
import java.io.Serializable;
 
/**
 * This class represents jalepeno
 */
 public class Jalepeno extends Consumable implements Serializable
 {
 	/**
	 * 
	 */
	private static final long serialVersionUID = -2164403017808751576L;

	/**
 	 * Creates a new <code>Jalepeno</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 */   	
 	public Jalepeno ()
 	{
 		super ("Jalepeno", 22700, 11350, 14.2);
 	}
 	
 	/**
 	 * Creates a new <code>Jalepeno</code> object and sets its constant
 	 * values
 	 *
 	 * @see <@link Combustable>
 	 * @param currentAmount the current amount of this object
 	 */   	
 	public Jalepeno (double currentAmount)
 	{
 		super ("Jalepeno", 22700, 11350, 14.2, currentAmount);
 	}
 }
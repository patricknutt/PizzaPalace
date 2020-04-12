package pizza_palace;
/**
 * Bacon.java		07/12/2003
 * Author: Patrick Nutt
 */

import java.io.Serializable;

/**
 * This class represents bacon
 */
    public class Bacon extends Consumable implements Serializable
   {
/**
	 * 
	 */
	private static final long serialVersionUID = 4687312998728079469L;

/**
    * Creates a new <code>Bacon</code> object and sets its constant
    * values
    *
    * @see {@link Consumable}
    * @param currentAmount the current amount of this object
    */ 
       public Bacon ()
      {
         super ("Bacon", 22700, 11350, 14.2);
      }
   
   /**
    * Creates a new <code>Bacon</code> object and sets its constant
    * values
    *
    * @see {@link Consumable}
    * @param currentAmount the current amount of this object
    */ 
       public Bacon (double currentAmount)
      {
         super ("Bacon", 22700, 11350, 14.2, currentAmount);
      }
   }
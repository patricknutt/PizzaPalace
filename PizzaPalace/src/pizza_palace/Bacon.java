package pizza_palace;
/**
 * Bacon.java		07/12/2003
 * Author: Patrick Nutt
 */
import javax.swing.*;

import java.awt.*;
   import java.io.Serializable;

/**
 * This class represents bacon
 */
    public class Bacon extends Consumable implements Serializable
   {
   /**
    * Creates a new <code>Bacon</code> object and sets its constant
    * values
    *
    * @see {@link Combustable}
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
    * @see {@link Combustable}
    * @param currentAmount the current amount of this object
    */ 
       public Bacon (double currentAmount)
      {
         super ("Bacon", 22700, 11350, 14.2, currentAmount);
      }
   }
package pizza_palace;
/*
 *Consumable.java		07/09/2003
 *Author: Patrick Nutt
 */
import java.io.Serializable;
import java.text.DecimalFormat;
 
/**
* The <code>Consumable</code> class is used to represent a 
* pizza ingredient. A {@link String} object is used to
* represent the ingredient name. A double value is associated
* with the amount in grams of the item. Two other values
* are included to represent the desired maximum and minimum 
* levels of this item. The best method of use it to create an
* array of <code>Consumable</code> objects.
*/
public class Consumable implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6679516861214075887L;

	private transient static int counter = 1;
	
	/**
	 * Represents size of small pizza in inches
	 */
	public final static int SMALL = 10;
	/**
	 * Represents size of medium pizza in inches
	 */
	public final static int MEDIUM = 12;
	/**
	 * Represents size of large pizza in inches
	 */
	public final static int LARGE = 16;
	/**
	 * The maximum allowable amount of an ingredient. 
	 * Value in grams.
	 */
	private double maxAmount;
	 
	/**
	 * The minimum allowable amount of an ingredient.
	 * Value in grams.
	 */
	private double minAmount;
	
	/**
	 * The current amount of this item.
	 * Value in grams.
	 */
	private double amount;

	/**
	 * Amount per inch (pizza size) that is used of this product
	 */
	private double perInch;
	
	/**
	 * The amount of this item in stock yesterday
	 */
	private double amountYesterday;
	
	/**
	 * The amount of this item that was used today
	 */
	private double amountUsed;
	
	/**
	 * The ingredient name.
	 */
	private String name;
	
	/**
	 * Tests whether or not specified amount is between the maximum
	 * and mimimum allowable amounts. Returns true if value is in
	 * range, false otherwise.
	 * @param testAmount amount to test 
	 */
	private boolean isInRange (double testAmount)
	{
		boolean result = true;
		if (minAmount > testAmount)
			result = false;
		if (testAmount > maxAmount)
			result = false;
		return result;
	}
	
	/**
	 * Tests minimum and maximum values to determine if 
	 * {@link maxAmount} is more than {@link minAmount}.
	 * Throws an {@link IllegalArgumentException} the test fails.
	 * @param higher amount that should be greatest
	 * @param lower amount that should be least 
	 */
	private static void testMinMax (double higher, double lower)
	{
		if (lower > higher)
			throw new IllegalArgumentException ("Maximum value must be greater "
												+ "than minimum.");
	}
	
	/**
	 * Creates an ingredient instance and gives it the specified 
	 * name, maximum, and minimum amount. Defaults current amount
	 * to maximum amount.
	 * @param name the ingredient name
	 * @param maxAmount the maximum allowabele amount
	 * @param minAmount the minimum allowable amount
	 */
	public Consumable (String name, double maxAmount, 
					   double minAmount, double perInch)
	{
		// set current amount to max amount
		this(name, maxAmount, minAmount, perInch, maxAmount);
	}
	
	/**
	 * Creates an ingredient instance and gives it the specified 
	 * name, maximum, minimum, and current amount. If the amount 
	 * is not between the minimum and maximum amount, the amount
	 * is defaulted to the maximum amount.  
	 * @param name the ingredient name
	 * @param maxAmount the maximum allowable amount
	 * @param amount the current amount
	 */
	public Consumable (String name, double maxAmount, 
					   double minAmount, double perInch, double amount)
	{
		this.name = name;
		this.maxAmount = maxAmount;
		this.minAmount = minAmount;
		this.perInch = perInch;
		if (isInRange (amount))
			this.amount = amount;  		
		else 
			this.amount = maxAmount;
		testMinMax (maxAmount, minAmount);
		this.amountYesterday = maxAmount;
		this.amountUsed = 0.0;
	}
	
	/**
	 * Sets the maximum allowable amount for this ingredient
	 * @param maxAmount maximum allowable amount
	 * @param minAmount minimum allowable amount
	 */
	public void setMinMax (double maxAmount, double minAmount)
	{ 
		this.maxAmount = maxAmount;
		this.minAmount = minAmount;
		testMinMax (maxAmount, minAmount);
	}
	
	/**
	 * Determines how much of this ingredient is used in the
	 * making of a pizza. The determination is made by testing
	 * the size of the pizza and the toppings that were used
	 */
	public void makePizza (int size)
	{
		amountUsed += perInch * size;
		amountYesterday = amount;
		amount -= perInch * size;
	}
	
	/**
	 * Resets the amount used variable to zero
	 *
	 * @return  <code>true</code>
	 */
	public boolean open()
	{
		amountUsed = 0.0;
		return true;
	}
	
	/**
	 * Returns String representation of amountUsed, amountYesterday,
	 * and amount in that order upon each successive.call.
	 */
	public String getStockLevels()
	{
		String result = new String();
		DecimalFormat fmt = new DecimalFormat ("0.00");
		if (counter == 1)
		{
			result = fmt.format (amountUsed);
			counter++;
		}
		else if (counter == 2)
		{
			result = fmt.format (amountYesterday);
			counter++;
		}
		else if (counter == 3)
		{
			result = fmt.format (amount);
			counter = 1;
		}
		return result;
	}
			
	/**
	 * Returns the minimum allowable amount for this item
	 */
	public double getMinAmount()
	{
		return minAmount;
	}

	/**
	 * Returns the maximum allowable amount for this item
	 */
	public double getMaxAmount()
	{
		return maxAmount;
	}	
	/**
	 * Returns the current stock level for this item
	 */
	public double getAmount()
	{
		return amount;
	}
	
	/**
	 * Returns this object's name
	 */
	public String toString()
	{
		String text = new String(name);
		return text;
	}
}
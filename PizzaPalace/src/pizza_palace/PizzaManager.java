package pizza_palace;
/**
 * PizzaManager.java	07/11/2003
 * Author: Patrick Nutt
 */
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
 
/**
* This class creates a tabbed pane with three panes. The first
* pane contains an introduction page with instructions. The 
* second page contains a disabled order form for reference.
* The third pane contains a GUI that with three buttons. Each 
* button corresponds to a different inventory report. The first 
* of which is an inventory report. The second is a comparison
* chart. And the third is a shopping list. For further details
* on each of these reports, see the appropriate source file for
* each.
*/ 
public class PizzaManager
{
	/**
	 * Display Frame
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Pizza Palace: Inventory Manager");

		frame.setSize (800, 600);
		frame.setLocation (0, 100);
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.addTab ("Main", new MainPanel());
		tabPane.addTab ("OrderForm", new OrderForm (false));
		tabPane.addTab ("Inventory Manager", new InventoryPanel());
		
		frame.getContentPane().add (tabPane);
		frame.pack();
		frame.setVisible(true);
	}
}
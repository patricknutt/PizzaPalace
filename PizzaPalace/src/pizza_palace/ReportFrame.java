package pizza_palace;
/**
 * ReportFrame.java
 */
import javax.swing.*;
import java.awt.event.*;

/**
 * This class creates a <@link JFrame> object for displaying a panel. 
 * A <@link MenuBar> is created with print and re-stock options
 */ 
public class ReportFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6526502343005056018L;
	private JMenuItem printItem, stockItem;
	private JMenu menu;
	private JMenuBar menuBar;
	private MenuListener listener;
	private JPanel myPanel;
	
	/**
	 * Adds the specified panel to the frame and displays the frame.
	 * Also creates a <@link MenuBar> with two options.
	 *
	 * @param myPanel The panel to be displayed in this frame
	 */
	public ReportFrame (JPanel myPanel)
	{
		this.myPanel = myPanel;
		
		// menu
		listener = new MenuListener ();
		menuBar = new JMenuBar();
		menu = new JMenu ("Actions");
		printItem = new JMenuItem ("Print");		
		stockItem = new JMenuItem ("Stock");

		menu.setMnemonic ('A');					
		menuBar.add (menu);				
		setJMenuBar(menuBar);		

		printItem.addActionListener (listener);
		stockItem.addActionListener (listener);
		
		menu.add (printItem);
		menu.addSeparator();
		menu.add (stockItem);
		
		getContentPane().add (this.myPanel);			
	}

	/**
	 * Listener for the menu
	 */
	private class MenuListener implements ActionListener
	{
		/**
		 * Displays a message dialog simulating a printing function or
		 * resets current stock levels to their default values using the 
		 * <@link newPizza> method of the <code>CreatePizza</code> class.
		 */
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();
			
			if (source == printItem)
			{
				JOptionPane.showMessageDialog (null, "Printing");
			}
			else 
			{			
				CreatePizza.newPizza();			
			}
		}
	}
}
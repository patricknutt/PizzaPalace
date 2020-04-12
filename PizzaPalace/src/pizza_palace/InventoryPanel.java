package pizza_palace;
 /*
 * InventoryPanel.java		07/11/2003
 * Author: Patrick Nutt
 */
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
 /**
  * This class represents an inventory report selection GUI
  * Three choices are available:
  * 	Inventory Report
  * 	Stock Comparison Chart
  * 	Shopping List
  * @see <code>ReportPanel</code>
  * @see <code>ChartPanel</code>
  * @see <code>ShoppingListPanel</code>
  */
  
 public class InventoryPanel extends JPanel
 {
 	/**
	 * 
	 */
	private static final long serialVersionUID = -4895098287191528434L;

	/**
 	 * Three buttons for selecting the desired report
 	 */
 	private JButton invReportButton, stockChartButton, 
 					shoppingListButton;
 					
 	/**
 	 * Text for each button 
 	 */
 	private String invReport, stockChart, shoppingList;
 	
 	/**
 	 * Lable for heading
 	 */
 	private JLabel header;
 	
 	/**
 	 * Frame that will contain one of three reports as selected by the
 	 * user.
 	 */
 	private ReportFrame frame;
 	
 	/**
 	 * Creates a new <code>InventoryPanel</code> with three buttons
 	 */
 	public InventoryPanel()
 	{
 		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
 		setBackground (PizzaPalace.COLOR_MAIN);
 		
		invReportButton = new JButton ();
 		stockChartButton = new JButton (); 
 		shoppingListButton = new JButton ();
 		
		header = new JLabel ("Please select an option....");
 		invReport = "Inventory Report";
 		stockChart = "Stock Chart";
 		shoppingList = "Shopping List";
 		
 		invReportButton.setText (invReport);
 		stockChartButton.setText (stockChart);
 		shoppingListButton.setText (shoppingList);
 		
 		ButtonListener listener = new ButtonListener();
 		invReportButton.addActionListener (listener);
 		stockChartButton.addActionListener (listener);
 		shoppingListButton.addActionListener (listener);
 		 		
 		add (header); 
 		add (invReportButton);
 		add (Box.createRigidArea (new Dimension (0,10)));
 		add (stockChartButton);
 		add (Box.createRigidArea (new Dimension (0,10)));
 		add (shoppingListButton);		
 	}
 
 //////////////
 // Event Handling
 //////////////
 
	 /**
	 *	Creates a listener for the three buttons
	 */		
	 private class ButtonListener implements ActionListener
	 {
	 	JPanel myPanel;
	 	Object source;
	 	String title;
	 	
	 	/**
	 	* Creates a new <code>JPanel</code> and adds the appropriate panel
	 	* to it. Also creates a new <code>JFrame</code> and add the 
	 	* <code>JPanel</code> to it.
	 	*/		
	 	public void actionPerformed (ActionEvent event) 
	 	{
	 		source = event.getSource();
	 		myPanel = new JPanel ();
			title = "Pizza Palace: ";
	 		if (source == invReportButton)
	 		{	
	 			myPanel.add (new ReportPanel());
				title += "Inventory Report";
	 		}
	 		else if (source == stockChartButton)
	 		{	
	 			myPanel.add (new ChartPanel());
	 			title += "Stock Levels Chart";
	 		}
	 			
	 		else if (source == shoppingListButton)
	 		{
	 			myPanel.add (new ShoppingListPanel());
	 			title += "Shopping List";	 			
	 		}
	 		frame = new ReportFrame (myPanel);	
		
			// Set up report frame 		
	 		frame.setSize (800, 600);
	 		frame.setResizable(true);
	 		frame.setLocation (100, 100);
	 		frame.setTitle (title);					
			frame.pack();
			frame.setVisible(true);		
	 	}
	 }
}
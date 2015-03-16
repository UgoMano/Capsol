/*
* Ugochukwu Umeano
* umu23@drexel.edu
* CS338:GUI, Project 2
* 
*/


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class ReviewOrder extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JList list; // list
	private JTable table; // table
	private JTextField[] fields; // list of fields
	private JButton listToTable; // >> button
	private JButton tableToList; // << button
	private final JButton continueShopping; // add button
	private final JButton change; // change button
	private final JButton remove; // remove button
	private DefaultListModel listModel; // model of lists
	private DefaultTableModel tableModel; // model of table
	
	// name of columns
	private String[] columnNames = {"ITEM", 
			"PRICE"
			};
	private Object[][] data; // data in the table


	// class constructor
	public ReviewOrder()
	{
		// Name of Program
		super("Review Order");
		
		// Set outer layout 
		getContentPane().setLayout(new BorderLayout());
		
		// Instantiate components
		listModel = new DefaultListModel();
		tableModel = new DefaultTableModel(data, columnNames);
		listToTable = new JButton (">>>");
		tableToList = new JButton ("<<<");
		
		// Deactivate buttons
		listToTable.setEnabled(false);
		tableToList.setEnabled(false);
		
		// Instantiate top pane
		JPanel topPane = new JPanel ();
		
		
		
		// Instantiate list
		list = new JList(listModel);
		list.setVisibleRowCount(26);
		list.addListSelectionListener(
			new ListSelectionListener()
			{
				public void valueChanged(ListSelectionEvent event) 
				{
					showListInField();
					tableToList.setEnabled(false);
					listToTable.setEnabled(true);
					remove.setEnabled(true);
					change.setEnabled(true);
				}
				
			}
		);
		
		// add scroll pane to table
		//topPane.add ( new JScrollPane( list), BorderLayout.WEST );
		
		// instantiate pane that holds << and >> buttons
		JPanel topCenterPane = new JPanel ();
		topCenterPane.setLayout(new BoxLayout(topCenterPane, BoxLayout.Y_AXIS));
		
		// Initialize JTable
		table = new JTable(tableModel);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		listToTable.setAlignmentY(Component.CENTER_ALIGNMENT);
		//topCenterPane.add(listToTable);
		
		String[] row1 = {"Advil (2)", "$60.00"};
		String[] row2 = {"Methylphenidate ER", "$100.00"};
		String[] row3 = {"Tax", "$19.26"};
		String[] row4 = {"TOTAL", "$179.26"};
		tableModel.addRow(row1);
		tableModel.addRow(row2);
		tableModel.addRow(row3);
		tableModel.addRow(row4);
		
		// add action listener
		listToTable.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event) 
					{
						String[] restaurantArray = completeList().split("\\s*,\\s*");
						tableModel.insertRow(tableModel.getRowCount(), restaurantArray);
						listModel.remove(list.getSelectedIndex());
						clearFields();
						listToTable.setEnabled(false);
						tableToList.setEnabled(false);
						remove.setEnabled(false);
					}
				}
			);
        
		
		tableToList.setAlignmentY(Component.CENTER_ALIGNMENT);
		//topCenterPane.add(tableToList);
		tableToList.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event) 
					{
						listModel.addElement(completeList());
						tableModel.removeRow(table.getSelectedRow());
						clearFields();
						tableToList.setEnabled(false);
						listToTable.setEnabled(false);
						remove.setEnabled(false);
					}
				}
			);

		getContentPane().add(topCenterPane, BorderLayout.CENTER);
		
		// add listener to table
		table.addMouseListener(
				new MouseListener()
				{
					public void mouseClicked(MouseEvent event) 
					{
						remove.setEnabled(true);
						change.setEnabled(true);
						listToTable.setEnabled(false);
						tableToList.setEnabled(true);
						
						// enter data to fields
						for (int i=0; i<table.getColumnCount(); i++)
							fields[i].setText((String) tableModel.getValueAt(table.getSelectedRow(), i));
					}
					
					public void mouseEntered(MouseEvent event) 
					{
			
					}

					public void mouseExited(MouseEvent event) 
					{
						
					}

					public void mousePressed(MouseEvent event) 
					{
						
					}

					public void mouseReleased(MouseEvent event) 
					{
						
					}	
				}
			);
		
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		JScrollPane tableSP = new JScrollPane(table);
       
		topPane.add ( tableSP, BorderLayout.NORTH );
		
		

		getContentPane().add(topPane, BorderLayout.NORTH);
		
		// initialize panel for fields
		// JPanel centralCenterPane = new JPanel ();
		
		// initialize central panel of container
		JPanel centerPane = new JPanel ();
		
		centerPane.setLayout(new BorderLayout());
	    
		// initialize labelPanel and fieldPanel
		JPanel labelPanel = new JPanel(new GridLayout(columnNames.length, 1));
	    JPanel fieldPanel = new JPanel(new GridLayout(columnNames.length, 1));
	    
	    // add labelPanel and fieldPanel to center pane
	    centerPane.add(labelPanel, BorderLayout.WEST);
	    centerPane.add(fieldPanel, BorderLayout.CENTER);
	    
	    // initialize fields
	    fields = new JTextField[columnNames.length];

	    for (int i = 0; i<columnNames.length; i++) 
	    {
	      fields[i] = new JTextField();
	      
	      // set width of fields
	      fields[i].setColumns(30);
	      
	      // instantiate labels for fields
	      JLabel labels = new JLabel(columnNames[i], JLabel.RIGHT);
	      labels.setLabelFor(fields[i]);
	      labelPanel.add(labels);
	      JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	      flowPanel.add(fields[i]);
	      //fieldPanel.add(flowPanel);
	      
	      if (i != 3)
	      {
	    	  fields[i].setEditable(false);
	      }
	    }
	  
		// add fields panel to the center panel
		//centralCenterPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setBackground(Color.BLUE);
		
		// add center panel to container
		//getContentPane().add(centralCenterPane, BorderLayout.CENTER);
		
		// instantiate bottom pane housing add, change and remove buttons
		JPanel bottomPane = new JPanel ();
		
		// instantiating the add, change and remove buttons
		continueShopping = new JButton("Continue Shopping");
		remove = new JButton("Edit Cart");
		change = new JButton("Change");
		
		bottomPane.add (continueShopping, BorderLayout.WEST);
		
		//bottomPane.add (change, BorderLayout.CENTER);
		
		bottomPane.add(remove);
	
		continueShopping.addActionListener(
				
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event) 
				{
					dispose();
					DrugsSearch frame = new DrugsSearch();
					frame.setVisible(true);
				}
				
			}
		);

		
		change.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					int count = 0;
					
					for (int i=0; i<columnNames.length; i++)
					{
						if (fields[i].getText().equals(""))
							count++;
					}
					
					// Display error if any of the fields is empty
					if (count > 0)
						JOptionPane.showMessageDialog( null, "Please fill in all the fields", 
								"Error Message", JOptionPane.ERROR_MESSAGE);
					
					else
					{
						if (table.isRowSelected(table.getSelectedRow()))
						{
							String[] restaurantArray = completeList().split("\\s*,\\s*");
							for (int i=0; i<table.getColumnCount(); i++)
								tableModel.setValueAt(restaurantArray[i], table.getSelectedRow(), i);
						}
					
					}
				}	
			}
		);
		
		
		JButton done = new JButton("Place Order");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThankYou frame = new ThankYou();
				frame.setVisible(true);
				dispose();
			}
		});
		bottomPane.add(done);
		
		remove.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					dispose();
					ShoppingCart frame = new ShoppingCart();
					frame.setVisible(true);
					frame.setSize(600,320);
				}	
			
			}
		);
		
//		JPanel topMostPane = new JPanel();
//		JButton done = new JButton("Done");
//		topMostPane.add(done);
//		topPane.add(topMostPane, BorderLayout.NORTH);
//		
		getContentPane().add(bottomPane, BorderLayout.SOUTH);
	}
	
	// output text at given index
	public String getText(int i) 
	{
	    return (fields[i].getText());
	}
	
	// output field data in list format
	public String completeList()
	{
		String text = "";
		
		for (int i=0; i<columnNames.length; i++)
		{
			if (i<columnNames.length-1)
				text += getText(i) + ", ";
			else
				text += getText(i);
		}
		return text;
	}
	
	// method to clear the data in fields
	public void clearFields()
	{
		for (int i=0; i<columnNames.length; i++)
			fields[i].setText("");
	}
	
	// Shows list contents in fields
	public void showListInField() 
	{
		if (list.getSelectedIndex() >= 0)
		{
			String text = (String) listModel.get(list.getSelectedIndex());

			String[] restaurantArray = text.split("\\s*,\\s*");
			for (int i=0; i<columnNames.length; i++)
				fields[i].setText(restaurantArray[i]);
		}
	}
	
	// display table data in fields
	public void showTableInField() 
	{
		if (list.getSelectedIndex() >= 0)
		{
			String text = (String) listModel.get(list.getSelectedIndex());

			String[] restaurantArray = text.split("\\s*,\\s*");
			for (int i=0; i<columnNames.length; i++)
				fields[i].setText(restaurantArray[i]);
		}
				
	}
	
}

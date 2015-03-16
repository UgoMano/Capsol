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



public class DrugsList extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JList list; // list
	private JTable table; // table
	private JTextField[] fields; // list of fields
	private JCheckBox check;
	private final JButton add; // add button
	private final JButton change; // change button
	private final JButton remove; // remove button
	private DefaultListModel listModel; // model of lists
	private DefaultTableModel tableModel; // model of table
	
	// name of columns
	private String[] columnNames = {"Drug Name", 
			"Qty", 
			"Expiration", 
			"Price", 
			"OTC (Y/N)"
			};
	private Object[][] data; // data in the table


	// class constructor
	public DrugsList()
	{
		// Name of Program
		super("Drugs List");
		
		// Set outer layout 
		getContentPane().setLayout(new BorderLayout());
		
		// Instantiate components
		listModel = new DefaultListModel();
		tableModel = new DefaultTableModel(data, columnNames);
		
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
		
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		//topCenterPane.add(listToTable);
		
		
		getContentPane().add(topCenterPane, BorderLayout.CENTER);
		
		// add listener to table
		table.addMouseListener(
				new MouseListener()
				{
					public void mouseClicked(MouseEvent event) 
					{
						remove.setEnabled(true);
						change.setEnabled(true);
						
						// enter data to fields
						for (int i=0; i<table.getColumnCount(); i++)
							fields[i].setText((String) tableModel.getValueAt(table.getSelectedRow(), i));
						
						if (tableModel.getValueAt(table.getSelectedRow(), 4).equals("Y"))
							check.setSelected(true);
						else
							check.setSelected(false);

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
       
		topPane.add ( new JScrollPane(table), BorderLayout.NORTH );
		
		JPanel radioButtons = new JPanel();
		JRadioButton delivery = new JRadioButton("Delivery");
		ButtonGroup group = new ButtonGroup();
		JRadioButton pickup = new JRadioButton("Pickup");
		//topPane.add(pickup);
		group.add(pickup);
		group.add(delivery);
		radioButtons.add(pickup);
		radioButtons.add(delivery);
		radioButtons.setLayout(new BoxLayout(radioButtons, BoxLayout.Y_AXIS));
		
		topPane.add(radioButtons, BorderLayout.EAST);

		getContentPane().add(topPane, BorderLayout.NORTH);
		
		// initialize panel for fields
		JPanel centralCenterPane = new JPanel ();
		
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
	    check = new JCheckBox();

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
	      
	      if (i<columnNames.length-1)
	    	  flowPanel.add(fields[i]);
	      else
	    	  flowPanel.add(check);
	      
	      fieldPanel.add(flowPanel);
	    }
	  
		// add fields panel to the center panel
		centralCenterPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setBackground(Color.BLUE);
		
		// add center panel to container
		getContentPane().add(centralCenterPane, BorderLayout.CENTER);
		
		// instantiate bottom pane housing add, change and remove buttons
		JPanel bottomPane = new JPanel ();
		
		// instantiating the add, change and remove buttons
		add = new JButton("Add");
		remove = new JButton("Remove");
		change = new JButton("Change");
		
		change.setEnabled(false);
		remove.setEnabled(false);
		
		bottomPane.add (add, BorderLayout.WEST);
	
		add.addActionListener(
				
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event) 
				{
					int count = 0;
					
					for (int i=0; i<columnNames.length-1; i++)
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
					
						// add line to list
						listModel.addElement(completeList());
						String[] restaurantArray = completeList().split("\\s*,\\s*");
						tableModel.insertRow(tableModel.getRowCount(), restaurantArray);
						//listModel.remove(list.getSelectedIndex());
						clearFields();
						remove.setEnabled(false);
						
						System.out.println(tableModel.getRowCount());
						if (check.isSelected())
							tableModel.setValueAt("Y", tableModel.getRowCount()-1, 4);
						else
							tableModel.setValueAt("N", tableModel.getRowCount()-1, 4);
						
						check.setSelected(false);
						
					
					}
				}
				
			}
		);
		
		bottomPane.add (change, BorderLayout.CENTER);
		
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
						// Change list
						if (!list.isSelectionEmpty())
							listModel.set(list.getSelectedIndex(), completeList());
						
						// Change table
						else if (table.isRowSelected(table.getSelectedRow()))
						{
							String[] restaurantArray = completeList().split("\\s*,\\s*");
							for (int i=0; i<table.getColumnCount(); i++)
								tableModel.setValueAt(restaurantArray[i], table.getSelectedRow(), i);
							if (check.isSelected())
								tableModel.setValueAt("Y", tableModel.getRowCount()-1, 4);
							else
								tableModel.setValueAt("N", tableModel.getRowCount()-1, 4);
						}
					
					}
				}	
			}
		);
		
		bottomPane.add (remove, BorderLayout.EAST);
		
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bottomPane.add(done);
		
		remove.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					if (!list.isSelectionEmpty())
					{
						int index = list.getSelectedIndex();
						System.out.println(index);
						listModel.remove(index);
		
						int size = listModel.getSize();
		
						if (size == 0) 
						{ 
							// nothing left to remove
							remove.setEnabled(false);
		
						} 
						else 
						{ 
							// select an index from the DefaultListModel
							if (index == listModel.getSize()) 
							{
								// removed item in last position
								index--;
							}
		
				        list.setSelectedIndex(index);
				        list.ensureIndexIsVisible(index);
						}
					}
					
					else if (table.isRowSelected(table.getSelectedRow()))
					{
						tableModel.removeRow(table.getSelectedRow());
						int index = table.getSelectedRow();
						int size = listModel.getSize();
						
						if (size == 0) 
						{ 
							// Nothing left to remove
							remove.setEnabled(false);
						} 
						else 
						{ 
							//Select an index from the DefaultListModel
							if (index == listModel.getSize()) 
							{
								//removed item in last position
								index--;
							}
						}
					}
					
					clearFields();
					check.setSelected(false);
				}	
			
			}
		);
		

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

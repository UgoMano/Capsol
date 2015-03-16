/*
* Ugochukwu Umeano
* umu23@drexel.edu
* CS338:GUI, Project 2
* 
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Capsol {

	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Capsol window = new Capsol();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Capsol() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 492, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username: ");
		lblNewLabel.setBounds(73, 51, 72, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setBounds(73, 85, 72, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(157, 45, 190, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 79, 190, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		final JRadioButton customer = new JRadioButton("Customer");
		final JRadioButton pharmacy = new JRadioButton("Pharmacy");
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (pharmacy.isSelected())
				{
					frame.dispose();
					DrugsList frame = new DrugsList();
					frame.setSize(600, 700);
					frame.setVisible(true);
				}
				
				else if (customer.isSelected())
				{
					frame.dispose();
					DrugsSearch frame = new DrugsSearch();
					frame.setVisible(true);
				}
				
				else
					JOptionPane.showMessageDialog( null, "Please select either " +
							"Customer or Pharmacy", 
							"Error Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnNewButton.setBounds(186, 131, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (pharmacy.isSelected())
				{
					frame.dispose();
					CreatePharmacyAccount frame = new CreatePharmacyAccount();
					frame.setVisible(true);
				}
				
				else if (customer.isSelected())
				{
					frame.dispose();
					CreateCustomerAccount frame = new CreateCustomerAccount();
					frame.setVisible(true);
				}
				
				else
					JOptionPane.showMessageDialog( null, "Please select either " +
							"Customer or Pharmacy", 
							"Error Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(179, 168, 134, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		customer.setBounds(73, 209, 141, 23);
		frame.getContentPane().add(customer);
		
		pharmacy.setBounds(312, 209, 141, 23);
		frame.getContentPane().add(pharmacy);
		
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(customer);
		buttongroup.add(pharmacy);
		
	}
}

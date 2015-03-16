/*
* Ugochukwu Umeano
* umu23@drexel.edu
* CS338:GUI, Project 2
* 
*/

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class PaymentMethod extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentMethod frame = new PaymentMethod();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaymentMethod() {
		super("Payment Method");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("Cardholder's Name");
		final JLabel lblNewLabel_1 = new JLabel("Card Number");
		final JLabel lblNewLabel_2 = new JLabel("Expiration Date");
		final JLabel lblNewLabel_3 = new JLabel("Security Code");
		final JLabel lblNewLabel_4 = new JLabel("Zipcode");
		
		lblNewLabel.setBounds(26, 47, 136, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1.setBounds(61, 81, 87, 16);
		contentPane.add(lblNewLabel_1);
					
		lblNewLabel_2.setBounds(50, 115, 112, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3.setBounds(61, 148, 87, 16);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(160, 41, 213, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 75, 213, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 109, 96, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 144, 47, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 176, 70, 23);
		contentPane.add(textField_4);
		
		lblNewLabel_4.setBounds(98, 180, 50, 16);
		contentPane.add(lblNewLabel_4);
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						dispose();
						ShippingAddress frame = new ShippingAddress();
						frame.setVisible(true);
						
					}
				}
			);
		btnNewButton.setBounds(6, 6, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Review Order");
		btnNewButton_1.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						dispose();
						ReviewOrder frame = new ReviewOrder();
						frame.setSize(400,170);
						frame.setVisible(true);
						
					}
				}
			);
		btnNewButton_1.setBounds(294, 6, 150, 29);
		contentPane.add(btnNewButton_1);
		
	}

}

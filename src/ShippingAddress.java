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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ShippingAddress extends JFrame {

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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShippingAddress frame = new ShippingAddress();
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
	public ShippingAddress() {
		
		super("Set Shipping Address");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(143, 47, 230, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 87, 230, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 127, 169, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(143, 167, 49, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 207, 82, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						dispose();
						ViewCart frame = new ViewCart();
						frame.setSize(600, 180);
						frame.setVisible(true);
					}
				}
			);
		btnNewButton.setBounds(6, 6, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(
				new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						dispose();
						PaymentMethod frame = new PaymentMethod();
						frame.setVisible(true);
						
					}
				}
			);
		btnNewButton_1.setBounds(327, 6, 117, 29);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Address 1");
		lblNewLabel.setBounds(55, 53, 76, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Address 2");
		lblNewLabel_1.setBounds(55, 93, 76, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setBounds(55, 133, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("State");
		lblNewLabel_3.setBounds(55, 173, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Zipcode");
		lblNewLabel_4.setBounds(55, 213, 61, 16);
		contentPane.add(lblNewLabel_4);
	}

}

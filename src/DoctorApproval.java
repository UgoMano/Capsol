/*
* Ugochukwu Umeano
* umu23@drexel.edu
* CS338:GUI, Project 2
* 
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DoctorApproval extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorApproval frame = new DoctorApproval();
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
	public DoctorApproval() {
		super("Doctor's Approval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Methylphenidate ER requires a doctor's approval");
		label.setBounds(60, 20, 390, 27);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("How do you wish to send the required information?");
		lblNewLabel.setBounds(54, 45, 342, 16);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Attach image");
		rdbtnNewRadioButton.setBounds(6, 98, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Take a picture");
		rdbtnNewRadioButton_1.setBounds(6, 133, 141, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Fax");
		rdbtnNewRadioButton_2.setBounds(6, 168, 141, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Browse My Computer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(212, 132, 169, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(60, 223, 117, 29);
		btnNewButton_1.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					dispose();
					ShoppingCart frame = new ShoppingCart();
					frame.setVisible(true);
					frame.setSize(600,320);
				}
			});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Checkout");
		btnNewButton_2.setBounds(262, 223, 117, 29);
		btnNewButton_2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
						ViewCart frame = new ViewCart();
						frame.setVisible(true);
						frame.setSize(600, 180);
					}
				});
		contentPane.add(btnNewButton_2);
	}
}

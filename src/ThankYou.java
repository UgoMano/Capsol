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
import javax.swing.JLabel;
import javax.swing.JButton;


public class ThankYou extends JFrame {

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
					ThankYou frame = new ThankYou();
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
	public ThankYou() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thank you for your order:");
		lblNewLabel.setBounds(94, 67, 270, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Advil (2)");
		lblNewLabel_1.setBounds(94, 105, 137, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Methylphenidate ER");
		lblNewLabel_2.setBounds(94, 133, 149, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Your order will arrive in 2-3 Business days");
		lblNewLabel_3.setBounds(94, 175, 270, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnDone = new JButton("Finish");
		btnDone.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						
					}
				}
			);
		btnDone.setBounds(327, 243, 117, 29);
		contentPane.add(btnDone);
	}
}

/*
* Ugochukwu Umeano
* umu23@drexel.edu
* CS338:GUI, Project 2
* 
*/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrugsSearch extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrugsSearch frame = new DrugsSearch();
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
	public DrugsSearch() {
		super("Drug Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 210);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel topPane = new JPanel();
		topPane.setLayout(new BoxLayout(topPane, BoxLayout.X_AXIS));
		JLabel name = new JLabel("Drug Name: ");
		topPane.add(name);
		JTextField field = new JTextField();
		topPane.add(field);
		topPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); 
		add(topPane, BorderLayout.NORTH);
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
		JRadioButton delivery = new JRadioButton("Delivery");
		delivery.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerPane.add(delivery);
		JRadioButton pickup = new JRadioButton("Pickup");
		pickup.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerPane.add(pickup);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(delivery);
		buttonGroup.add(pickup);
		add(centerPane, BorderLayout.CENTER);
		
		JPanel bottomPane = new JPanel();
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ListView frame = new ListView();
				frame.setVisible(true);
				frame.setSize(500, 170);
			}	
		});
		
		bottomPane.add(search);
		bottomPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		add(bottomPane, BorderLayout.SOUTH);
	}

}

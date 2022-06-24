package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controller.ManagerServices;
import controller.StoreServices;

import javax.swing.JButton;

public class EditStore implements ActionListener {

	private JFrame frame;
	private JTextField sTField;
	private JTextField cTField;
	private JButton btnUpdateST,btnUpdateET,btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStore window = new EditStore();
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
	public EditStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Store Timings:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 225, 31);
		panel.add(lblNewLabel);
		
		JLabel lblStartingTime = new JLabel("Starting Time:");
		lblStartingTime.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblStartingTime.setBounds(10, 80, 124, 24);
		panel.add(lblStartingTime);
		
		JLabel lblClosingTime = new JLabel("Closing Time:");
		lblClosingTime.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblClosingTime.setBounds(10, 131, 124, 24);
		panel.add(lblClosingTime);
		
		sTField = new JTextField();
		sTField.setBounds(144, 79, 112, 20);
		panel.add(sTField);
		sTField.setColumns(10);
		
		cTField = new JTextField();
		cTField.setColumns(10);
		cTField.setBounds(144, 130, 112, 20);
		panel.add(cTField);
		
		btnUpdateST = new JButton("Update");
		btnUpdateST.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateST.setForeground(Color.BLACK);
		btnUpdateST.setBackground(Color.WHITE);
		btnUpdateST.setBounds(290, 78, 89, 23);
		btnUpdateST.addActionListener(this);
		panel.add(btnUpdateST);
		
		btnUpdateET = new JButton("Update");
		btnUpdateET.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateET.setBackground(Color.WHITE);
		btnUpdateET.setBounds(290, 129, 89, 23);
		btnUpdateET.addActionListener(this);
		panel.add(btnUpdateET);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 215, 89, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean flag = false;
		StoreServices ss = new StoreServices();
		ManagerServices n = new ManagerServices();
		if (e.getSource() == btnUpdateST) {
			ss.setStartTime(n.getStoreId(), sTField.getText());
			JOptionPane.showMessageDialog(null, "Opening time successfully updated!", "Status", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if (e.getSource() == btnUpdateET) {
			ss.setEndTime(n.getStoreId(), cTField.getText());
			JOptionPane.showMessageDialog(null, "Closing time successfully updated!", "Status", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if (e.getSource() == btnBack) {
			ManagerPage m = new ManagerPage();
			frame.setVisible(false);
			m.main(null);
		}
		
	}

}

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

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.AdministratorServices;
import controller.ManagerServices;

public class EditManagers implements ActionListener{

	private JFrame frame;
	private JTextField managerID;
	private JTextField nameField;
	private JTextField textEmail;
	private JTextField passwordField;
	private JButton btnDeleteManager, btnBack, btnAM;
	private JLabel lblStoreID;
	private JTextField storeIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditManagers window = new EditManagers();
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
	public EditManagers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 443, 349);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All Managers:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 25, 127, 37);
		panel.add(lblNewLabel);
		
		JLabel lblListManagerIDs = new JLabel("New label");
		lblListManagerIDs.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblListManagerIDs.setBounds(10, 60, 610, 37);
		panel.add(lblListManagerIDs);
		ManagerServices s = new ManagerServices();
		lblListManagerIDs.setText(s.getAllManagerIDs().toString());
		
		btnAM = new JButton("Add Manager");
		btnAM.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAM.setBackground(Color.WHITE);
		btnAM.setBounds(266, 298, 127, 23);
		btnAM.addActionListener(this);
		panel.add(btnAM);
		
		managerID = new JTextField();
		managerID.setBounds(182, 120, 74, 20);
		panel.add(managerID);
		managerID.setColumns(10);
		
		JLabel lblManagerID = new JLabel("Manager ID (to delete):");
		lblManagerID.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblManagerID.setBounds(10, 123, 162, 20);
		panel.add(lblManagerID);
		
		btnDeleteManager = new JButton("Delete Manager");
		btnDeleteManager.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteManager.setBackground(Color.WHITE);
		btnDeleteManager.setBounds(266, 119, 127, 23);
		btnDeleteManager.addActionListener(this);
		panel.add(btnDeleteManager);
		
		JLabel lblManagerName = new JLabel("Name:");
		lblManagerName.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblManagerName.setBounds(10, 154, 89, 20);
		panel.add(lblManagerName);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(182, 151, 211, 20);
		panel.add(nameField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblEmail.setBounds(10, 185, 89, 20);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(182, 185, 211, 20);
		panel.add(textEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblPassword.setBounds(10, 216, 89, 20);
		panel.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(182, 216, 211, 20);
		panel.add(passwordField);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 298, 97, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		lblStoreID = new JLabel("StoreID:");
		lblStoreID.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblStoreID.setBounds(10, 247, 89, 20);
		panel.add(lblStoreID);
		
		storeIDField = new JTextField();
		storeIDField.setColumns(10);
		storeIDField.setBounds(182, 247, 211, 20);
		panel.add(storeIDField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ManagerServices s = new ManagerServices();
		if (e.getSource() == btnDeleteManager) {
			String mID = managerID.getText();
			if(mID.length() == 2) {;
				s.deleteManager(mID);
				JOptionPane.showMessageDialog(null, "Manager Deleted!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() == btnAM) {
			if (storeIDField.getText().length() == 2){
				s.addNewManager(nameField.getText(), textEmail.getText(), passwordField.getText(), storeIDField.getText());
				JOptionPane.showMessageDialog(null, "Manager Added!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() == btnBack) {
			AdministratorPage m = new AdministratorPage();
			frame.setVisible(false);
			m.main(null);
		}
		
	}

}

package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AdministratorServices;
import controller.ManagerServices;

public class EditProfileManager implements ActionListener{

	private JFrame frame;
	private JTextField newUsernameVal;
	private JTextField newPasswordVal;
	private JTextField retypePasswordVal;
	private JButton btnSave;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfileManager window = new EditProfileManager();
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
	public EditProfileManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 569, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 553, 249);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		ManagerServices service = new ManagerServices();
		
		JLabel lblUserInformation = new JLabel("User Information:");
		lblUserInformation.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblUserInformation.setBounds(10, 13, 201, 45);
		panel.add(lblUserInformation);
		
		JLabel lblUsernameValue = new JLabel(service.viewProfile());
		lblUsernameValue.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblUsernameValue.setBounds(10, 69, 533, 150);
		panel.add(lblUsernameValue);
		
		JLabel lblEditHere = new JLabel("Edit Here:");
		lblEditHere.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblEditHere.setBounds(10, 253, 201, 45);
		frame.getContentPane().add(lblEditHere);
		
		JLabel lblNewUsername = new JLabel("New Username:");
		lblNewUsername.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNewUsername.setBounds(10, 309, 121, 45);
		frame.getContentPane().add(lblNewUsername);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNewPassword.setBounds(10, 369, 121, 45);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password:");
		lblRetypePassword.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblRetypePassword.setBounds(10, 425, 121, 45);
		frame.getContentPane().add(lblRetypePassword);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(455, 490, 88, 32);
		btnSave.addActionListener(this);
		frame.getContentPane().add(btnSave);
		
		newUsernameVal = new JTextField();
		newUsernameVal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		newUsernameVal.setBounds(141, 319, 191, 20);
		frame.getContentPane().add(newUsernameVal);
		newUsernameVal.setColumns(10);
		
		newPasswordVal = new JTextField();
		newPasswordVal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		newPasswordVal.setColumns(10);
		newPasswordVal.setBounds(141, 377, 191, 20);
		frame.getContentPane().add(newPasswordVal);
		
		retypePasswordVal = new JTextField();
		retypePasswordVal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		retypePasswordVal.setColumns(10);
		retypePasswordVal.setBounds(141, 433, 191, 20);
		frame.getContentPane().add(retypePasswordVal);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 490, 88, 34);
		btnBack.addActionListener(this);
		frame.getContentPane().add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ManagerServices service = new ManagerServices();
		if (e.getSource() == btnSave) {
			//String x = service.getId();
			if (newPasswordVal.getText().equals(retypePasswordVal.getText())) {
				if (!(newPasswordVal.getText().equals("")) && !(newUsernameVal.getText().equals(""))) {
					
					
					service.editProfile(newUsernameVal.getText(), newPasswordVal.getText());
					JOptionPane.showMessageDialog(null, "Information has been successfully updated! For security reasons, please log in again!", "Status", JOptionPane.INFORMATION_MESSAGE);
					LoginPage home = new LoginPage();
					frame.setVisible(false);
					home.main(null);
				}
				else if (!(newPasswordVal.getText().equals("")) && (newUsernameVal.getText().equals(""))) {
					service.editProfile(LoginPage.getUserName(), newPasswordVal.getText());
					JOptionPane.showMessageDialog(null, "Information has been successfully updated! For security reasons, please log in again!", "Status", JOptionPane.INFORMATION_MESSAGE);
					LoginPage home = new LoginPage();
					frame.setVisible(false);
					home.main(null);
				}
				else if (!(newUsernameVal.getText().equals("")) && (newPasswordVal.getText().equals(""))) {
					service.editProfile(newUsernameVal.getText(), LoginPage.getUserPassword());
					JOptionPane.showMessageDialog(null, "Information has been successfully updated! For security reasons, please log in again!", "Status", JOptionPane.INFORMATION_MESSAGE);
					LoginPage home = new LoginPage();
//					AdministratorPage a = new AdministratorPage();
//					a.closeFrame();
					frame.setVisible(false);
					home.main(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username/ Password fields are empty!", "Status", JOptionPane.WARNING_MESSAGE);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Passwords didn't match! Try again!", "Status", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
		else if (e.getSource() == btnBack) {
			frame.setVisible(false);
			ManagerPage m = new ManagerPage();
			frame.setVisible(false);
			m.main(null);
		}
		
	}
	
	

}

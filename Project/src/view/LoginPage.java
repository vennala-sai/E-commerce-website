package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.AdministratorServices;
import controller.CustomerServices;
import controller.ManagerServices;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginPage implements ActionListener{

	private JFrame frame;
	public static JTextField textFieldUsername;
	public static JTextField textFieldPassword;
	private JButton btnHome;
	private JButton btnRegister;
	private JButton loginButton;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		
		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		loginButton.setForeground(Color.BLACK);
		loginButton.setBackground(Color.WHITE);
		
		btnHome = new JButton("Back");
		btnHome.setForeground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(this);
		
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnRegister.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(205)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
								.addComponent(textFieldUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
							.addGap(46))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(173)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(183))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(46)
					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHome)
						.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		btnRegister.addActionListener(this);
		loginButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = textFieldUsername.getText();
		String password = textFieldPassword.getText();
		CustomerServices services = new CustomerServices();

		if (e.getSource() == loginButton) {
			CustomerServices service = new CustomerServices();
			AdministratorServices aService = new AdministratorServices();
			ManagerServices mService = new ManagerServices();
			
			if (service.customerExists(username, password)) {
				
				JOptionPane.showMessageDialog(null, "Login Successful!", "Status", JOptionPane.INFORMATION_MESSAGE);
				CustomerPage home = new CustomerPage();
				frame.setVisible(false);
				home.main(null);
			}
			else if (mService.managerExists(username, password)) {
				JOptionPane.showMessageDialog(null, "Login Successful!", "Status", JOptionPane.INFORMATION_MESSAGE);
				ManagerPage home = new ManagerPage();
				frame.setVisible(false);
				home.main(null);
			}
			else if (aService.adminExists(username, password)) {
				
				JOptionPane.showMessageDialog(null, "Login Successful!", "Status", JOptionPane.INFORMATION_MESSAGE);
				AdministratorPage home = new AdministratorPage();
				frame.setVisible(false);
				home.main(null);
			}
			else {
				JOptionPane.showMessageDialog(null, "Login Failed! Try again!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() == btnHome) {
			WelcomePage home = new WelcomePage();
			frame.setVisible(false);
			home.main(null);
			
			
		}
		else if (e.getSource() == btnRegister) {
			RegisterPage register = new RegisterPage();
			frame.setVisible(false);
			register.main(null);
			
		}
		
	}
	public static String getUserPassword() {
		return textFieldPassword.getText();
	}
	public static String getUserName() {
		return textFieldUsername.getText();
	}
}

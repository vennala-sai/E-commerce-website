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
import javax.swing.JTextField;

import controller.CustomerServices;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RegisterPage implements ActionListener{

	private JFrame frame;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnHome;
	private JButton registerButton;
	private JTextField textFieldEmail;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
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
	public RegisterPage() {
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
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		registerButton.setForeground(Color.BLACK);
		registerButton.setBackground(Color.WHITE);
		registerButton.addActionListener(this);
		
		btnHome = new JButton("Back");
		btnHome.setForeground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(this);
		btnHome.setFocusable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(78)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(6)
											.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGap(36))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(104)
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(18)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(textFieldPassword, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(270)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(registerButton, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(43))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(registerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = textFieldUsername.getText();
		String password = textFieldPassword.getText();
		String email = textFieldEmail.getText();
		if (e.getSource() == registerButton) {
			CustomerServices service = new CustomerServices();
			if (service.customerExists(username, password)) {
				JOptionPane.showMessageDialog(null, "Account already Exists! Log in!", "Status", JOptionPane.INFORMATION_MESSAGE);
				
			}
			else {
				if (username.equals("") || password.equals("") ||email.equals("")) {
					JOptionPane.showMessageDialog(null, "One of the fields is empty! Try again!", "Status", JOptionPane.WARNING_MESSAGE);
				}
				else {
					service.addNewUser(username, email, password);
					JOptionPane.showMessageDialog(null, "Account has been created!", "Status", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		}
		else if (e.getSource() == btnHome) {
			WelcomePage home = new WelcomePage();
			frame.setVisible(false);
			home.main(null);
			
			
		}
		
	}
}

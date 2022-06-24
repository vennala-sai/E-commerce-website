package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WelcomePage implements ActionListener {

	private JFrame frame;
	private JButton loginButton;
	private JButton registerButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
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
	public WelcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.getContentPane().setBackground(new Color(255,255,255));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
		);
		
		
		
		JLabel lblNewLabel = new JLabel("Welcome to ShoppersLand!");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		registerButton = new JButton("Register");
		registerButton.setBackground(Color.WHITE);
		registerButton.addActionListener(this);
		registerButton.setFocusable(false);
		
		loginButton = new JButton("Login");
		loginButton.setBackground(Color.WHITE);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(77)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
					.addGap(91))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(registerButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(loginButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
					.addGap(124))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(registerButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(76))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == loginButton) {
			LoginPage login = new LoginPage();
			frame.setVisible(false);
			login.main(null);
			
		}
		else if (e.getSource() == registerButton) {
			RegisterPage register = new RegisterPage();
			frame.setVisible(false);
			register.main(null);
			
		}
		
	}
}

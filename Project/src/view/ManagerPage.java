package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class ManagerPage implements ActionListener{

	private JFrame frame;
	private JButton btnEditItems;
	private JButton btnEditProfile;
	private JLabel lblTitle;
	private JButton btnEditTimings;
	private JButton btnLogOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPage window = new ManagerPage();
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
	public ManagerPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 619, 487);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnEditItems = new JButton("Edit Items");
		btnEditItems.setBackground(Color.WHITE);
		btnEditItems.setBounds(239, 115, 126, 38);
		btnEditItems.setFocusable(false);
		btnEditItems.addActionListener(this);
		panel.add(btnEditItems);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBackground(Color.WHITE);
		btnEditProfile.setBounds(239, 255, 126, 38);
		btnEditProfile.setFocusable(false);
		btnEditProfile.addActionListener(this);
		panel.add(btnEditProfile);
		
		lblTitle = new JLabel("Hello Manager,");
		lblTitle.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 18));
		lblTitle.setBounds(10, 22, 183, 28);
		panel.add(lblTitle);
		
		btnEditTimings = new JButton("Edit Timings");
		btnEditTimings.setBackground(Color.WHITE);
		btnEditTimings.setBounds(239, 185, 126, 38);
		btnEditTimings.setFocusable(false);
		btnEditTimings.addActionListener(this);
		panel.add(btnEditTimings);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(239, 325, 126, 35);
		btnLogOut.setFocusable(false);
		btnLogOut.addActionListener(this);
		panel.add(btnLogOut);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnEditItems) {
			frame.setVisible(false);
			EditItems ei = new EditItems();
			EditItems.setManagerCall();
			ei.main(null);
		}
		else if (e.getSource() == btnEditTimings) {
			frame.setVisible(false);
			EditStore ei = new EditStore();
			ei.main(null);
		}
		else if (e.getSource() == btnEditProfile) {
			frame.setVisible(false);
			EditProfileManager ei = new EditProfileManager();
			ei.main(null);
		}
		else if (e.getSource() == btnLogOut) {
			//frame.setVisible(false);
			WelcomePage welcomePage = new WelcomePage();
			frame.setVisible(false);
			welcomePage.main(null);
		}
	}
}

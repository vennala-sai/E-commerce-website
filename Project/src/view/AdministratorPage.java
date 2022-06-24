package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class AdministratorPage implements ActionListener{

	public JFrame frame;
	
	private JButton btnEditItems;
	private JButton btnEditProfile;
	private JLabel lblTitle;
	private JButton btnEditStores;
	private JButton btnEditManagers;
	private JButton btnLogOut;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorPage window = new AdministratorPage();
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
	public AdministratorPage() {
		initialize();
	}
	public void closeFrame() {
		frame.setVisible(false);
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
		btnEditItems.setForeground(Color.BLACK);
		btnEditItems.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditItems.setBackground(Color.WHITE);
		btnEditItems.setBounds(239, 115, 126, 38);
		btnEditItems.setFocusable(false);
		btnEditItems.addActionListener(this);
		panel.add(btnEditItems);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditProfile.setForeground(Color.BLACK);
		btnEditProfile.setBackground(Color.WHITE);
		btnEditProfile.setBounds(239, 325, 126, 38);
		btnEditProfile.setFocusable(false);
		btnEditProfile.addActionListener(this);
		panel.add(btnEditProfile);
		
		lblTitle = new JLabel("Hello Admin,");
		lblTitle.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 18));
		lblTitle.setBounds(10, 11, 107, 30);
		panel.add(lblTitle);
		
		btnEditStores = new JButton("Edit Stores");
		btnEditStores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditStores.setForeground(Color.BLACK);
		btnEditStores.setBackground(Color.WHITE);
		btnEditStores.setBounds(239, 185, 126, 38);
		btnEditStores.setFocusable(false);
		btnEditStores.addActionListener(this);
		panel.add(btnEditStores);
		
		btnEditManagers = new JButton("Edit Managers");
		btnEditManagers.setForeground(Color.BLACK);
		btnEditManagers.setBackground(Color.WHITE);
		btnEditManagers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditManagers.setBounds(239, 255, 126, 38);
		btnEditManagers.setFocusable(false);
		btnEditManagers.addActionListener(this);
		panel.add(btnEditManagers);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(239, 395, 126, 38);
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
			EditItems.setAdminCall();
			ei.main(null);
		}
		else if (e.getSource() == btnEditStores) {
			frame.setVisible(false);
			EditStores es = new EditStores();
			es.main(null);
		}
		else if (e.getSource() == btnEditManagers) {
			frame.setVisible(false);
			EditManagers em = new EditManagers();
			em.main(null);
		}
		else if (e.getSource() == btnEditProfile) {
			frame.setVisible(false);
			EditProfileAdmin em = new EditProfileAdmin();
			em.main(null);
		}
		else if (e.getSource() == btnLogOut) {
			//frame.setVisible(false);
			WelcomePage welcomePage = new WelcomePage();
			frame.setVisible(false);
			welcomePage.main(null);
		}
	}
}

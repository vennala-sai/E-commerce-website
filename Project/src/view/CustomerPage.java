package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JToggleButton;

import controller.CustomerServices;
import controller.StoreServices;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class CustomerPage implements ActionListener {

	private JFrame frame;
	JPanel panel;
	private JToggleButton tglbtnToggleButton;
	private JButton btnLogOut;
	private JButton btnEditProfile;
	private JButton btnViewCart;
	private JButton btnCustomerAccountDelete;
	private JComboBox locationBox;
	private JLabel lblCurrentLocationValue;
	int allStoreLocationsLength;
	private JPanel panel_1,  panel_2;
	private JTextField searchField;
	private JButton btnSearch;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JTable table_2;
	private JScrollPane scrollPane_1;
	private JTextField iNF;
	private JButton btnAddToCart, btnRemoveFromCart;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPage window = new CustomerPage();
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
	public CustomerPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.  
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBounds(100, 100, 1231, 892);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(999, 0, 216, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 999, 853);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		tglbtnToggleButton = new JToggleButton("...");
		tglbtnToggleButton.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		tglbtnToggleButton.setBackground(Color.WHITE);
		tglbtnToggleButton.setBounds(10, 11, 34, 41);
		panel.add(tglbtnToggleButton);
		tglbtnToggleButton.setFocusable(false);
		tglbtnToggleButton.addActionListener(this);
		
		
		StoreServices ss = new StoreServices();
		String[] allLocations = ss.getAllStoreNames();
		allStoreLocationsLength = allLocations.length;
		locationBox = new JComboBox(allLocations);
		locationBox.setBackground(new Color(255, 255, 255));
		locationBox.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		locationBox.setBounds(636, 13, 353, 31);
		panel_1.add(locationBox);					
		locationBox.addActionListener(this);
		

		JLabel lblCurrentLocation = new JLabel("Nearest Selected Location:");
		lblCurrentLocation.setFont(new Font("Yu Gothic Light", Font.PLAIN, 15));
		lblCurrentLocation.setBounds(10, 11, 182, 39);
		panel_1.add(lblCurrentLocation);
		
		JLabel lblChangeLocation = new JLabel("Change Location:");
		lblChangeLocation.setFont(new Font("Yu Gothic Light", Font.PLAIN, 15));
		lblChangeLocation.setBounds(494, 8, 132, 39);
		panel_1.add(lblChangeLocation);

		searchField = new JTextField();
		searchField.setBounds(636, 89, 235, 31);
		panel_1.add(searchField);
		searchField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(881, 90, 89, 31);
		btnSearch.addActionListener(this);
		panel_1.add(btnSearch);
		
		JLabel lblSearchItem = new JLabel("Search Item:");
		lblSearchItem.setFont(new Font("Yu Gothic Light", Font.PLAIN, 15));
		lblSearchItem.setBounds(530, 87, 96, 39);
		panel_1.add(lblSearchItem);
		
		panel_2 = new JPanel();
		panel_2.setBounds(22, 277, 948, 551);
		panel_2.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 928, 529);
		panel_2.add(scrollPane_1);		

		CustomerServices c = new CustomerServices();
		String[] y = {"Name", "Price", "Description", "Sale Status","Item Location","Quantity"};
		String[][] d = ss.getAllItems(c.getStoreName());
		
		table_2 = new JTable(d,y);
		table_2.setEnabled(false);
		panel_1.add(panel_2);
		scrollPane_1.setViewportView(table_2);
		
		btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnRemoveFromCart.setFocusable(false);
		btnRemoveFromCart.setBackground(Color.WHITE);
		btnRemoveFromCart.setBounds(206, 164, 152, 31);
		btnRemoveFromCart.addActionListener(this);
		panel_1.add(btnRemoveFromCart);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnAddToCart.setFocusable(false);
		btnAddToCart.setBackground(Color.WHITE);
		btnAddToCart.setBounds(10, 164, 132, 31);
		btnAddToCart.addActionListener(this);
		panel_1.add(btnAddToCart);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setFont(new Font("Yu Gothic Light", Font.PLAIN, 15));
		lblItemName.setBounds(10, 87, 96, 39);
		panel_1.add(lblItemName);
		
		iNF = new JTextField();
		iNF.setColumns(10);
		iNF.setBounds(104, 89, 254, 31);
		panel_1.add(iNF);
		
		Random r = new Random();
		int randomIndex = r.nextInt(allStoreLocationsLength);
		if (!(c.getStoreName().equals("No Store Selected"))) {
			lblCurrentLocationValue = new JLabel(c.getStoreName());
			lblCurrentLocationValue.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			lblCurrentLocationValue.setBounds(250, 11, 359, 39);
			panel_1.add(lblCurrentLocationValue);
		}
		else {
			lblCurrentLocationValue = new JLabel(allLocations[randomIndex]);
			c.setStoreLocation(lblCurrentLocationValue.getText());
			lblCurrentLocationValue.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			lblCurrentLocationValue.setBounds(250, 11, 359, 39);
			panel_1.add(lblCurrentLocationValue);
		}
		
		btnViewCart = new JButton("View Cart");
		btnViewCart.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnViewCart.setBackground(new Color(255, 255, 255));
		btnViewCart.setBounds(41, 619, 120, 47);
		btnViewCart.setFocusable(false);
		panel.add(btnViewCart);
		btnViewCart.addActionListener(this);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnEditProfile.setBackground(new Color(255, 255, 255));
		btnEditProfile.setBounds(41, 679, 120, 47);
		btnEditProfile.setFocusable(false);
		panel.add(btnEditProfile);
		btnEditProfile.addActionListener(this);
		
		btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnLogOut.setBackground(new Color(255, 255, 255));
		btnLogOut.setBounds(41, 737, 120, 47);
		btnLogOut.setFocusable(false);
		panel.add(btnLogOut);
		btnLogOut.addActionListener(this);
		
		btnCustomerAccountDelete = new JButton("Delete Account");
		btnCustomerAccountDelete.setForeground(new Color(255, 0, 0));
		btnCustomerAccountDelete.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnCustomerAccountDelete.setBackground(new Color(255, 255, 255));
		btnCustomerAccountDelete.setBounds(41, 795, 120, 47);
		btnCustomerAccountDelete.setFocusable(false);
		panel.add(btnCustomerAccountDelete);
		btnCustomerAccountDelete.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CustomerServices service = new CustomerServices();
		if (e.getSource() == btnLogOut) {
			WelcomePage welcomePage = new WelcomePage();
			frame.setVisible(false);
			welcomePage.main(null);
		}
		else if (e.getSource() == btnEditProfile) {
			EditProfile welcomePage = new EditProfile();
			frame.setVisible(false);
			EditProfile.main(null);
			
		}
		else if(e.getSource() == btnSearch) {
			StoreServices ss = new StoreServices();
			String r = searchField.getText().trim();
			String[] y = {"Name", "Price", "Description", "Sale Status","Item Location","Quantity"};
			String[][] d = ss.getAllItems(service.getStoreName());
			String[][] newD = new String[d.length][6];
			if (r.equals("")) {
				newD = d;
			}
			else {
				int count = 0;
				for (int i = 0; i < d.length; i++) {
					for (int j = 0; j < 6; j++) {
						if (!(d[i][j] == null ) && (d[i][j].equals(r) || d[i][j].contains(r) || r.contains(d[i][j]))) {
							if (count < d.length) {
								newD[count] = d[i];
								count++;
							}
						}
					}
				}
			}
			
			table_2 = new JTable(newD,y);
			scrollPane_1.setViewportView(table_2);
			
		}
		else if(e.getSource() == btnAddToCart) {
			String itemName = iNF.getText().trim();
			CustomerServices cd = new CustomerServices();
			String message = cd.addItemToCart(itemName);			
			JOptionPane.showMessageDialog(null, message, "Status", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == btnRemoveFromCart) {
			String itemName = iNF.getText().trim();
			CustomerServices cd = new CustomerServices();
			String message = cd.removeItemInCart(itemName);			
			JOptionPane.showMessageDialog(null, message, "Status", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource() == btnViewCart) {
			ViewCart c = new ViewCart();
			frame.setVisible(false);
			c.main(null);	
		}
		else if (e.getSource() == btnCustomerAccountDelete) {
			//JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete Account?", "Status", JOptionPane.YES_NO_OPTION);
			service.deleteUser();
			WelcomePage welcomePage = new WelcomePage();
			frame.setVisible(false);
			welcomePage.main(null);
			JOptionPane.showMessageDialog(null, "Account has been successfully deleted!", "Status", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource() == locationBox) {
			StoreServices ss = new StoreServices();
			service.setStoreLocation((String) locationBox.getSelectedItem());
			lblCurrentLocationValue.setText(service.getStoreName());
			lblCurrentLocationValue.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			lblCurrentLocationValue.setBounds(250, 11, 359, 39);
			panel_1.add(lblCurrentLocationValue);
			String[] y = {"Name", "Price", "Description", "Sale Status","Item Location","Quantity"};
			String[][] d = ss.getAllItems(service.getStoreName());
			
			table_2 = new JTable(d,y);
			table_2.setEnabled(false);
		
			scrollPane_1.setViewportView(table_2);
			
		}
		
		
		if (tglbtnToggleButton.isSelected()) {
			panel.setBounds(1147, 0, 68, 853);
			btnViewCart.setVisible(false);
			btnEditProfile.setVisible(false);
			btnLogOut.setVisible(false);
			btnCustomerAccountDelete.setVisible(false);
		}
		else {
			panel.setBounds(999, 0, 216, 853);
			btnViewCart.setVisible(true);
			btnEditProfile.setVisible(true);
			btnLogOut.setVisible(true);
			btnCustomerAccountDelete.setVisible(true);
		}
		
	}
}

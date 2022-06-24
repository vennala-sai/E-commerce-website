package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AdministratorServices;
import controller.ManagerServices;
import controller.StoreServices;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EditStores implements ActionListener{

	private JFrame frame;
	private JTextField storeID;
	private JTextField sTF;
	private JTextField cTF;
	private JButton btnRS;
	private JButton btnAddStore, btnCTUpdate;
	private JButton btnSTUpdate;
    private JLabel lblST, lblCT;
    private JLabel lblNewStoreName;
    private JTextField nSL;
    private JLabel lblmID;
    private JTextField textFMID;
    private JButton btnMIDUpdate;
    private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStores window = new EditStores();
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
	public EditStores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 574, 403);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStoreIDs = new JLabel("All Store IDs:");
		lblStoreIDs.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		lblStoreIDs.setBounds(10, 50, 105, 38);
		panel.add(lblStoreIDs);
		
		JLabel lblListIDs = new JLabel("New label");
		lblListIDs.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblListIDs.setBounds(10, 99, 377, 27);
		panel.add(lblListIDs);
		
		AdministratorServices s = new AdministratorServices();
		lblListIDs.setText(s.getAllStoreIDs().toString());
		
		storeID = new JTextField();
		storeID.setBounds(81, 137, 86, 20);
		panel.add(storeID);
		storeID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Store ID:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 140, 61, 20);
		panel.add(lblNewLabel);
		
		btnRS = new JButton("Remove Store");
		btnRS.setBackground(Color.WHITE);
		btnRS.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRS.setBounds(10, 317, 129, 23);
		btnRS.addActionListener(this);
		panel.add(btnRS);
		
		btnAddStore = new JButton("Add Store");
		btnAddStore.setBackground(Color.WHITE);
		btnAddStore.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddStore.setBounds(166, 317, 129, 23);
		btnAddStore.addActionListener(this);
		panel.add(btnAddStore);
		
		btnCTUpdate = new JButton("Update");
		btnCTUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCTUpdate.setForeground(Color.BLACK);
		btnCTUpdate.setBackground(Color.WHITE);
		btnCTUpdate.setBounds(207, 233, 89, 23);
		btnCTUpdate.addActionListener(this);
		panel.add(btnCTUpdate);
		
		lblST = new JLabel("Starting Time:");
		lblST.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblST.setBounds(10, 206, 115, 20);
		panel.add(lblST);
		
		lblCT = new JLabel("Closing Time:");
		lblCT.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblCT.setBounds(10, 237, 105, 20);
		panel.add(lblCT);
		
		sTF = new JTextField();
		sTF.setColumns(10);
		sTF.setBounds(113, 203, 86, 20);
		panel.add(sTF);
		
		cTF = new JTextField();
		cTF.setColumns(10);
		cTF.setBounds(113, 234, 86, 20);
		panel.add(cTF);
		
		btnSTUpdate = new JButton("Update");
		btnSTUpdate.setForeground(Color.BLACK);
		btnSTUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSTUpdate.setBackground(Color.WHITE);
		btnSTUpdate.setBounds(206, 199, 89, 23);
		btnSTUpdate.addActionListener(this);
		panel.add(btnSTUpdate);
		
		lblNewStoreName = new JLabel("New Store Location:");
		lblNewStoreName.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNewStoreName.setBounds(207, 140, 149, 20);
		panel.add(lblNewStoreName);
		
		nSL = new JTextField();
		nSL.setColumns(10);
		nSL.setBounds(348, 137, 216, 20);
		panel.add(nSL);
		
		lblmID = new JLabel("Manager ID:");
		lblmID.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblmID.setBounds(10, 268, 105, 20);
		panel.add(lblmID);
		
		textFMID = new JTextField();
		textFMID.setColumns(10);
		textFMID.setBounds(113, 268, 86, 20);
		panel.add(textFMID);
		
		btnMIDUpdate = new JButton("Update");
		btnMIDUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMIDUpdate.setForeground(Color.BLACK);
		btnMIDUpdate.setBackground(Color.WHITE);
		btnMIDUpdate.setBounds(207, 268, 89, 23);
		btnMIDUpdate.addActionListener(this);
		panel.add(btnMIDUpdate);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(10, 369, 86, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean flag = false;
		StoreServices ss = new StoreServices();
		ManagerServices n = new ManagerServices();
		if (e.getSource() == btnAddStore) {
			
			if (!(nSL.getText().equals("")) && cTF.getText().equals("") && sTF.getText().equals("")) {
				for (String s: ss.getAllStoreNames()) {
					if (s.equals(nSL.getText())) {
						flag = true;
						break;
					}
				}
				if (flag == false) {
					ss.addStore(nSL.getText());
					JOptionPane.showMessageDialog(null, "Store Added!", "Status", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			else if (!(nSL.getText().equals("") && cTF.getText().equals("") && sTF.getText().equals(""))) {
				for (String s: ss.getAllStoreNames()) {
					if (s.equals(nSL.getText())) {
						flag = true;
						break;
					}
				}
				if (flag == false) {
					ss.addStore(nSL.getText(),sTF.getText(),cTF.getText());
					JOptionPane.showMessageDialog(null, "Store Added!", "Status", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			else if ((!nSL.getText().equals("") && !cTF.getText().equals("") && !sTF.getText().equals("") && !textFMID.getText().equals("")) && storeID.getText().equals("")) {
				for (String s: ss.getAllStoreNames()) {
					if (s.equals(nSL.getText())) {
						flag = true;
						break;
					}
				}
				if (flag == false) {
					ss.addStore(nSL.getText(),sTF.getText(),cTF.getText(),textFMID.getText());
					JOptionPane.showMessageDialog(null, "Store Added!", "Status", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		}
		else if (e.getSource() == btnRS) {
			for (String u : ss.getAllStoreIDs()) {
				if (u.equals(storeID.getText())) {
					ss.removeStore(u);
					JOptionPane.showMessageDialog(null, "Store Deleted!", "Status", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if (e.getSource() == btnCTUpdate) {
			flag = false;
			for (String s: ss.getAllStoreIDs()) {
				if (s.equals(storeID.getText())) {
					flag = true;
					break;
				}
			}

			if (flag) {
				ss.setEndTime(storeID.getText(), cTF.getText());
				JOptionPane.showMessageDialog(null, "Closing time successfully updated!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Store ID!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() == btnSTUpdate) {
			flag = false;
			for (String s: ss.getAllStoreIDs()) {
				if (s.equals(storeID.getText())) {
					flag = true;
					break;
				}
			}
			if (flag) {
				ss.setStartTime(storeID.getText(), sTF.getText());
				JOptionPane.showMessageDialog(null, "Opening time successfully updated!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Store ID!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() == btnMIDUpdate) {
			flag = false;
			for (String s: ss.getAllStoreIDs()) {
				if (s.equals(storeID.getText())) {
					flag = true;
					break;
				}
			}
			if (flag) {
				n.setStoreID(storeID.getText(), textFMID.getText());
				ss.setManagerID(storeID.getText(), textFMID.getText());
				JOptionPane.showMessageDialog(null, "Manager ID successfully updated!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Manager ID!", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() == btnBack) {
			AdministratorPage m = new AdministratorPage();
			frame.setVisible(false);
			m.main(null);
		}
		
	}
}

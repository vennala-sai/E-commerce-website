package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.AdministratorServices;
import controller.ManagerServices;
import controller.StoreServices;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditItems implements ActionListener{

	private JFrame frame;
	private JTextField textStoreID;
	private JTextField textFieldItemName;
	private JTextField textFieldItemQuant;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnBack;
	private JLabel lblAllStoreIDs;
	private JLabel lblListIDs;
	private static boolean managerCall = false;
	private JButton btnRemoveFromSale;
	private JButton btnAddToSale;
	private JLabel lblAisleNo;
	private JLabel lblRowNo;
	private JTextField aisleField;
	private JTextField rowField;
	private JButton btnAUpdate;
	private JButton btnRUpdate;
	private JButton btnUpdateAisleRow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditItems window = new EditItems();
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
	public EditItems() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 607, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 591, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStoreid = new JLabel("Store ID:");
		lblStoreid.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblStoreid.setBounds(10, 59, 103, 37);
		panel.add(lblStoreid);
		
		textStoreID = new JTextField();
		textStoreID.setBounds(115, 65, 100, 20);
		panel.add(textStoreID);
		textStoreID.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblItemName.setBounds(10, 190, 89, 31);
		panel.add(lblItemName);
		
		JLabel lblItemQuantity = new JLabel("Item Quantity:");
		lblItemQuantity.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblItemQuantity.setBounds(10, 253, 100, 31);
		panel.add(lblItemQuantity);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setColumns(10);
		textFieldItemName.setBounds(140, 193, 172, 20);
		panel.add(textFieldItemName);
		
		textFieldItemQuant = new JTextField();
		textFieldItemQuant.setColumns(10);
		textFieldItemQuant.setBounds(140, 256, 172, 20);
		panel.add(textFieldItemQuant);
		
		btnAdd = new JButton("Add to Inventory");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(10, 307, 137, 23);
		panel.add(btnAdd);
		
		btnRemove = new JButton("Remove from Inventory");
		btnRemove.setBackground(Color.WHITE);
		btnRemove.addActionListener(this);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove.setBounds(10, 341, 182, 23);
		panel.add(btnRemove);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(10, 405, 70, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Edit Stock:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 114, 20);
		panel.add(lblNewLabel);
		
		lblAllStoreIDs = new JLabel("Existing StoreIDs:");
		lblAllStoreIDs.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblAllStoreIDs.setBounds(10, 118, 137, 37);
		panel.add(lblAllStoreIDs);
		
		lblListIDs = new JLabel("New label");
		lblListIDs.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblListIDs.setBounds(156, 121, 425, 22);
		panel.add(lblListIDs);
		
		if (managerCall) {
			textStoreID.setEnabled(false);
			lblAllStoreIDs.setVisible(false);
			lblListIDs.setVisible(false);
		}
		else {
			textStoreID.setEnabled(true);
			lblAllStoreIDs.setVisible(true);
			lblListIDs.setVisible(true);
		}
		AdministratorServices s = new AdministratorServices();
		lblListIDs.setText(s.getAllStoreIDs().toString());
		
		btnRemoveFromSale = new JButton("Remove from Sale Inventory");
		btnRemoveFromSale.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveFromSale.setBackground(Color.WHITE);
		btnRemoveFromSale.setBounds(202, 341, 197, 23);
		btnRemoveFromSale.addActionListener(this);
		panel.add(btnRemoveFromSale);
		
		btnAddToSale = new JButton("Add to Sale Inventory");
		btnAddToSale.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddToSale.setBackground(Color.WHITE);
		btnAddToSale.setBounds(202, 307, 168, 23);
		btnAddToSale.addActionListener(this);
		panel.add(btnAddToSale);
		
		lblAisleNo = new JLabel("Aisle No:");
		lblAisleNo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblAisleNo.setBounds(342, 190, 89, 31);
		panel.add(lblAisleNo);
		
		lblRowNo = new JLabel("Row No:");
		lblRowNo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblRowNo.setBounds(342, 253, 89, 31);
		panel.add(lblRowNo);
		
		aisleField = new JTextField();
		aisleField.setColumns(10);
		aisleField.setBounds(425, 193, 65, 20);
		panel.add(aisleField);
		
		rowField = new JTextField();
		rowField.setColumns(10);
		rowField.setBounds(425, 256, 65, 20);
		panel.add(rowField);
		
		btnAUpdate = new JButton("Update");
		btnAUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAUpdate.setBackground(new Color(255, 255, 255));
		btnAUpdate.setBounds(500, 192, 81, 23);
		btnAUpdate.addActionListener(this);
		panel.add(btnAUpdate);
		
		btnRUpdate = new JButton("Update");
		btnRUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRUpdate.setBackground(Color.WHITE);
		btnRUpdate.setBounds(500, 255, 81, 23);
		btnRUpdate.addActionListener(this);
		panel.add(btnRUpdate);
		
		btnUpdateAisleRow = new JButton("Update Aisle and Row");
		btnUpdateAisleRow.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateAisleRow.setBackground(Color.WHITE);
		btnUpdateAisleRow.setBounds(425, 307, 156, 23);
		btnUpdateAisleRow.addActionListener(this);
		panel.add(btnUpdateAisleRow);
	}
	public static void setManagerCall() {
		managerCall = true;	
	}
	public static void setAdminCall() {
		managerCall = false;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String itemName = textFieldItemName.getText();
		String q = textFieldItemQuant.getText();
		String storeID = "";
		storeID = textStoreID.getText();
		int quan;
		if (managerCall) {
			textStoreID.setEnabled(false);
			lblAllStoreIDs.setVisible(false);
			lblListIDs.setVisible(false);
			ManagerServices s = new ManagerServices();
			if (e.getSource() == btnAdd) {
				try {
					quan = Integer.parseInt(q);
					s.addItemToStore(itemName, quan);
					
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnAUpdate) {
				String a = aisleField.getText().trim();
				ManagerServices ms = new ManagerServices();
				ms.updateItemAisle(itemName, a);
				
			}
			else if (e.getSource() == btnRUpdate) {
				String r = rowField.getText().trim();
				ManagerServices ms = new ManagerServices();
				ms.updateItemRow(itemName, r);
			}
			else if (e.getSource() == btnUpdateAisleRow) {
				String a = aisleField.getText().trim();
				String r = rowField.getText().trim();
				ManagerServices ms = new ManagerServices();
				ms.updateItemAisleRow(itemName, a, r);
			}
			else if (e.getSource() == btnAddToSale) {
				try {
					quan = Integer.parseInt(q);
					s.addSaleItemToStore(itemName, quan);
					
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnRemove) {
				try {
					quan = Integer.parseInt(q);
					s.removeItemFromStore(itemName, quan);
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnRemoveFromSale) {
				try {
					quan = Integer.parseInt(q);
					s.removeSaleItemFromStore(itemName, quan);
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnBack) {
				ManagerPage m = new ManagerPage();
				frame.setVisible(false);
				m.main(null);
			}
			
		}
		else {
			AdministratorServices s = new AdministratorServices();
			textStoreID.setEnabled(true);
			lblAllStoreIDs.setVisible(true);
			lblListIDs.setVisible(true);
			lblListIDs.setText(s.getAllStoreIDs().toString());
			if (e.getSource() == btnAdd) {
				try {
					quan = Integer.parseInt(q);
					if (s.isValidStoreID(storeID) == false) {
						JOptionPane.showMessageDialog(null, "StoreID Doesn't Exist!", "Status", JOptionPane.WARNING_MESSAGE);
					}
					else {
						s.addItemToStore(itemName, quan, storeID);
						JOptionPane.showMessageDialog(null, "Item Successfully Added!", "Status", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity or Wrong StoreID!", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnAUpdate) {
				String a = aisleField.getText().trim();
				s.updateItemAisle(itemName, a,storeID);
				
			}
			else if (e.getSource() == btnRUpdate) {
				String r = rowField.getText().trim();
				s.updateItemRow(itemName, r,storeID);
			}
			else if (e.getSource() == btnUpdateAisleRow) {
				String a = aisleField.getText().trim();
				String r = rowField.getText().trim();
				s.updateItemAisleRow(itemName, a, r,storeID);
			}
			else if (e.getSource() == btnRemove) {
				try {
					quan = Integer.parseInt(q);
					if (s.isValidStoreID(storeID) == false) {
						JOptionPane.showMessageDialog(null, "StoreID Doesn't Exist!", "Status", JOptionPane.WARNING_MESSAGE);
					}
					else {
						s.removeItemFromStore(itemName, quan, storeID);
						JOptionPane.showMessageDialog(null, "Item Successfully Removed!", "Status", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity or Wrong StoreID!", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnAddToSale) {
				try {
					quan = Integer.parseInt(q);
					s.addSaleItemToStore(itemName, quan, storeID);
					
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnRemoveFromSale) {
				try {
					quan = Integer.parseInt(q);
					s.removeSaleItemFromStore(itemName, quan, storeID);
				}
				catch (Exception x){				
					JOptionPane.showMessageDialog(null, "Not a Valid Quantity", "Status", JOptionPane.WARNING_MESSAGE);
					x.printStackTrace();
				}	
			}
			else if (e.getSource() == btnBack) {
				AdministratorPage m = new AdministratorPage();
				frame.setVisible(false);
				m.main(null);
			}
		}
		
		
	}
}

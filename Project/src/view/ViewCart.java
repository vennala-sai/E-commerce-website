package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

import controller.CustomerServices;

public class ViewCart implements ActionListener {

	private JFrame frame;
	private JLabel lblItemsList;
	private JLabel lblViewCart;
	private JButton btnBack;
	private JPanel panel_1;
	private JLabel lblEditItemsIn;
	private JLabel lblNewLabel;
	private JTextField textItemRemove;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCart window = new ViewCart();
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
	public ViewCart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 609, 414);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblViewCart = new JLabel("Items in the Cart:");
		lblViewCart.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblViewCart.setBounds(10, 11, 181, 48);
		panel.add(lblViewCart);
		
		CustomerServices s = new CustomerServices();	
		
		lblItemsList = new JLabel(s.getItemsInCart() + "");
		lblItemsList.setBackground(Color.LIGHT_GRAY);
		lblItemsList.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblItemsList.setBounds(10, 70, 557, 168);
		panel.add(lblItemsList);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(10, 384, 89, 23);
		btnBack.setFocusable(false);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 249, 557, 168);
		//panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblEditItemsIn = new JLabel("Edit Items in the Cart:");
		lblEditItemsIn.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblEditItemsIn.setBounds(10, 11, 181, 48);
		panel_1.add(lblEditItemsIn);
		
		lblNewLabel = new JLabel("Name the item to remove:");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 82, 186, 48);
		panel_1.add(lblNewLabel);
		
		textItemRemove = new JTextField();
		textItemRemove.setBounds(206, 90, 186, 29);
		panel_1.add(textItemRemove);
		textItemRemove.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CustomerServices c = new CustomerServices();
		if (e.getSource() == btnBack) {
			CustomerPage p = new CustomerPage();
			frame.setVisible(false);
			p.main(null);
		
		}
		
	}
}

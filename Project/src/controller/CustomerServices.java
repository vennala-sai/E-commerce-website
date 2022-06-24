package controller;
import model.*;
import view.*;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.*;

public class CustomerServices {
	
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	public String path;
	
	public void load(String path) throws Exception{
		try {
			CsvReader reader = new CsvReader(path); 
			reader.readHeaders();
			customers = new ArrayList<Customer>();
			while(reader.readRecord()){ 
				Customer c = new Customer();
				//name,id,email,password
				c.setId(reader.get("ID"));
				c.setName(reader.get("Name"));
				c.setEmail(reader.get("Email"));
				c.setPassword(reader.get("Password"));
				c.setStoreName(reader.get("StoreName"));
				c.setCart(reader.get("Cart"));
				customers.add(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				String s = "";
				String newS = "";
				//name,id,email,password
				csvOutput.write("ID");
				csvOutput.write("Name");
		    	csvOutput.write("Email");
				csvOutput.write("Password");
				csvOutput.write("StoreName");
				csvOutput.write("Cart");
				csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(Customer u: customers){
					csvOutput.write(u.getId());
					csvOutput.write(u.getName());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getStoreName());
					s = u.getItemsInCartS();
					s = s.trim();
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) == '[' || s.charAt(i) == ']' || s.charAt(i) == ' ') {
							newS += "";
						}
						else {
							newS += s.charAt(i);
						}
					}
					csvOutput.write(newS);
					newS = "";
					csvOutput.endRecord();
				}
				csvOutput.close();
				customers = new ArrayList<Customer>();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public boolean customerExists(String name, String password) {
		String path = "customers.csv";

		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public void editProfile(String newUsername, String newPassword) {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				if (!(newUsername.equals(""))) {
					u.setName(newUsername);
				}
				if (!(newPassword.equals(""))) {
					u.setPassword(newPassword);
				}
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getId() {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u.getId();
			}
		}
		return "No ID!";
	}
	public ArrayList<String> getItemsInCart() {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u.getItemsInCart();
			}
		}
		return new ArrayList<String>();
		
	}
	public String addItemToCart(String itemName) {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		String s = itemName +" doesn't Exist!";
		boolean b = false;
		StoreServices ss = new StoreServices();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		int  i = 0;
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				String sn = u.getStoreName();
				if (ss.getAllItemsInStore(sn).containsKey(itemName)) {
					String z = ss.getStoreID(sn);
					b = u.addItemToCart(itemName);
					ss.removeItemFromStore(itemName, 1, z);
					
				}
				
				if (b) {
					s = itemName + " successfully added!";
				}
				
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public String removeItemInCart(String itemName) {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		String s = itemName +" doesn't Exist!";
		boolean b = false;
		StoreServices ss = new StoreServices();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				String sn = u.getStoreName();
				if (ss.getAllItemsInStore(sn).containsKey(itemName)) {
					int cq = ss.getAllItemsInStore(sn).get(itemName);
					String z = ss.getStoreID(sn);
					b = u.removeItemInCart(itemName);		
					ss.addItemToStore(itemName, 1, z);
				}
				
				if (b) {
					s = itemName + " successfully removed!";
				}
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public String viewProfile() {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u.toString();
			}
		}
		return "No Profile Exists!";
		
	}
	public void setStoreLocation(String location) {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				u.setStoreName(location);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getStoreName() {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				if (u.getStoreName().equals("")) {
					return "No Store Selected";
				}
				else {
					return u.getStoreName();
				}
				
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "No Store Selected";
	}
	public boolean addNewUser(String name, String email, String password) {
		String path = "customers.csv";
		try {
			this.load(path);
			Customer newCustomer = new Customer("C" + (customers.size() + "") ,name, email, password);
			this.customers.add(newCustomer);
			this.update(path);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	public void deleteUser() {
		String path = "customers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		Customer c = null;
		boolean flag = false;
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Customer u: customers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				c = u;
				flag = true;
//				u.setName("");
//				u.setEmail("");
//				u.setId("");
//				u.setPassword("");
//				u.setStoreName("");		
				
			}
		}
		if (flag) {
			this.customers.remove(c);
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	public static void main(String [] args) throws Exception{
//		String path = "customers.csv";
//		CustomerServices service = new CustomerServices();
//	
//		service.load(path);
//		for(Customer u: service.customers){
//			System.out.println(u.toString());
//		}
//		
//		service.update(path);
//	}
}

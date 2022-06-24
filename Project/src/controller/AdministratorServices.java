package controller;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import model.Administrator;
import model.Customer;
import model.Manager;
import view.LoginPage;

public class AdministratorServices {
	public ArrayList<Administrator> admins = new ArrayList<Administrator>();
	public String path;
	
	public void load(String path) throws Exception{
		try {
			CsvReader reader = new CsvReader(path); 
			reader.readHeaders();
			admins = new ArrayList<Administrator>();
			while(reader.readRecord()){ 
				Administrator m = new Administrator();
				//name,id,email,password
				m.setId(reader.get("ID"));
				m.setName(reader.get("Name"));
				m.setEmail(reader.get("Email"));
				m.setPassword(reader.get("Password"));
				admins.add(m);
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
				//name,id,email,password
				csvOutput.write("ID");
				csvOutput.write("Name");
		    	csvOutput.write("Email");
				csvOutput.write("Password");
				//csvOutput.write("StoreID");
				csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(Administrator u: admins){
					csvOutput.write(u.getId());
					csvOutput.write(u.getName());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
				//	csvOutput.write(u.getStoreId());
					csvOutput.endRecord();
				}
				csvOutput.close();
				admins = new ArrayList<Administrator>();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	

	public void addItemToStore(String itemName, int quan, String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				ss.addItemToStore(itemName, quan, storeID);
			}
		}
		
	}
	public void addSaleItemToStore(String itemName, int quan, String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				ss.addSaleItemToStore(itemName, quan, storeID);
			}
		}
		
	}
	public void editProfile(String newUsername, String newPassword) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Administrator u: admins) {
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
	public boolean isValidStoreID(String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				return ss.isValidStoreID(storeID);
			}
		}
		return false;
	}
	public ArrayList<String> getAllStoreIDs(){
		StoreServices ss = new StoreServices();
		return ss.getAllStoreIDs();
		
	}

	public void removeItemFromStore(String itemName, int quan, String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				ss.removeItemFromStore(itemName, quan, storeID);
			}
		}
		
	}
	public void removeSaleItemFromStore(String itemName, int quan, String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		String s = "";
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				ss.removeSaleItemFromStore(itemName, quan, storeID);
			}
		}
		
	}

	public boolean adminExists(String username, String password) {
		String path = "administrators.csv";
		
		//CustomerServices service = new CustomerServices();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(username) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}


	public String viewProfile() {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u.toString();
			}
		}
		return "No Profile Exists!";
	}


	public void updateItemAisleRow(String itemName, String a, String r, String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				ss.updateItemAisleRow(itemName, a, r, storeID);
			}
		}
		
	}


	public void updateItemRow(String itemName, String r, String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				ss.updateItemRow(itemName, r, storeID);
			}
		}
		
	}


	public void updateItemAisle(String itemName, String a, String storeID) {
		String path = "administrators.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Administrator u: admins) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				StoreServices ss = new StoreServices();
				ss.updateItemAisle(itemName, a, storeID);
			}
		}
		
	}

}

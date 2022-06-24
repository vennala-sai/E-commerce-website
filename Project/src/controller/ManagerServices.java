package controller;
import model.*;
import view.LoginPage;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.*;

public class ManagerServices {
	
	public ArrayList<Manager> managers = new ArrayList<Manager>();
	public String path;
	
	public void load(String path) throws Exception{
		try {
			CsvReader reader = new CsvReader(path); 
			reader.readHeaders();
			managers = new ArrayList<Manager>();
			while(reader.readRecord()){ 
				Manager m = new Manager();
				//name,id,email,password
				m.setId(reader.get("ID"));
				m.setName(reader.get("Name"));
				m.setEmail(reader.get("Email"));
				m.setPassword(reader.get("Password"));
				m.setStoreId(reader.get("StoreID"));
				managers.add(m);
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
				csvOutput.write("StoreID");
				csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(Manager u: managers){
					csvOutput.write(u.getId());
					csvOutput.write(u.getName());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getStoreId());
					csvOutput.endRecord();
				}
				csvOutput.close();
				managers = new ArrayList<Manager>();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public String storeId() {
		String path = "managers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u.getStoreId();
			}
		}
		return "";
	}
	public void editProfile(String newUsername, String newPassword) {
		String path = "managers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Manager u: managers) {
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
	public void updateItemAisle(String itemName, String a) {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
				StoreServices ss = new StoreServices();
				ss.updateItemAisle(itemName, a, s);
			}
		}
	}
	public void updateItemRow(String itemName, String r) {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
				StoreServices ss = new StoreServices();
				ss.updateItemRow(itemName, r, s);
			}
		}
	}
	public void updateItemAisleRow(String itemName, String a, String r) {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
				StoreServices ss = new StoreServices();
				ss.updateItemAisleRow(itemName, a, r, s);
			}
		}
	}
	public void addItemToStore(String itemName, int quantity) {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
				StoreServices ss = new StoreServices();
				ss.addItemToStore(itemName, quantity, s);
			}
		}
		
	}
	public void addSaleItemToStore(String itemName, int quantity) {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
				StoreServices ss = new StoreServices();
				ss.addSaleItemToStore(itemName, quantity, s);
			}
		}
		
	}
	public void removeItemFromStore(String itemName, int quantity) {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
				StoreServices ss = new StoreServices();
				ss.removeItemFromStore(itemName, quantity, s);
			}
		}
		
	}
	public void removeSaleItemFromStore(String itemName, int quan) {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
				StoreServices ss = new StoreServices();
				ss.removeSaleItemFromStore(itemName, quan, s);
			}
		}
		
	}
	public boolean containsManagerID(String managerID) {
		String path = "managers.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Manager u: managers) {
			if (u.getId().equals(managerID)) {
				return true;
			}
		}
		return false;
	}
	public void setStoreID (String sID, String mID) {
		String path = "managers.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Manager u: managers) {
			if (u.getId().equals(mID)) {
				u.setStoreId(sID);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getAllManagerIDs(){
		String path = "managers.csv";
		ArrayList<String> l = new ArrayList<>();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Manager u: managers) {
			l.add(u.getId());
		}
		return l;
	}
	public String getStoreId() {
		String path = "managers.csv";
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
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				s = u.getStoreId();
			}
		}
		return s;
	}
	public boolean managerExists(String name, String password) {
		String path = "managers.csv";
		//CustomerServices service = new CustomerServices();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public boolean addNewManager(String name, String email, String password, String storeid) {
		String path = "managers.csv";
		StoreServices ss = new StoreServices();
		try {
			this.load(path);
			Manager newManager = new Manager("M" + (managers.size() + ""), name, email, password, storeid);
			ss.setManagerID(storeid, "M" + (managers.size() + ""));
			this.managers.add(newManager);
			this.update(path);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	public void deleteManager(String mID) {
		String path = "managers.csv";
		boolean flag = false;
		Manager m = null;
		StoreServices ss = new StoreServices();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Manager u: managers) {
			if (u.getId().equals(mID)) {
				m = u;
				ss.removeManagerID(mID);
				flag = true;
			}
		}
		if (flag) {
			this.managers.remove(m);
			
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public String viewProfile() {
		String path = "managers.csv";
		String name = LoginPage.getUserName();
		String password = LoginPage.getUserPassword();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		for (Manager u: managers) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u.toString();
			}
		}
		return "No Profile Exists!";
	}


	


	


	

}

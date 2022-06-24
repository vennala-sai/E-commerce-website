package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
	public String name;
	public String id;
	public String email;
	public String password;
	public String storeID;
	public Store s;
	
	
	
	public Manager(String id, String name, String email, String password, Store s) {
		this.name = name;
		this.email = email;
		this.id = id;
		this.password = password;
		this.s = s;
	}
	public Manager(String id, String name, String email, String password, String storeID) {
		this.name = name;
		this.email = email;
		this.id = id;
		this.password = password;
		this.storeID = storeID;
	}
	public Manager() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void addItem(String itemName, int quantity) {
		this.s.addItem(itemName, quantity);
	}
	public void removeItem(String itemName, int quantity) {
		this.s.removeItem(itemName, quantity);
	}
	public String setItemAvailability(String itemName) {
		return this.s.getItemAvailability(itemName);	
				
	}
	public void setId(String id) {
			this.id = id;
	}
	public String getStoreId() {
		return this.storeID;
	}

	public void setStoreId(String storeID) {
		this.storeID = storeID;
	}
	public Store getManagerStore() {
		return this.s;
	}

	public void setManagerStore(Store otherStore) {
		this.s = otherStore;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Username=" + name + ", Id=" + id + ", Email=" + email + ", Password=" + password + ", storeID=" + storeID;
	}
}

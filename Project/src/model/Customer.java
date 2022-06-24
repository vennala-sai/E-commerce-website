package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

	public String name;
	public String id;
	public String email;
	public String password;
	public String storeName;
	public ArrayList<String> itemsInCart = new ArrayList<>();
	
	public Customer(String id, String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.id = id;
		this.password = password;
	}
	public Customer(String id, String name, String email, String password, String storeName) {
		this.name = name;
		this.email = email;
		this.id = id;
		this.password = password;
		this.storeName = storeName;
	}
	
	public Customer() {
		
	}
	public boolean addItemToCart(String name) {
		boolean s = false;
		name.trim();
		String newS = "";
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ' ') {
				newS += "";
			}
			else {
				newS += name.charAt(i);
			}
		}
		itemsInCart.add(newS);
		s=true;
		return s;
	}
	public boolean removeItemInCart(String name) {
		name.trim();
		String newS = "";
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ' ') {
				newS += "";
			}
			else {
				newS += name.charAt(i);
			}
		}
		if (itemsInCart.contains(name)) {
			itemsInCart.remove(name);
			return true;
		}
		else if (itemsInCart.contains(newS)) {
			itemsInCart.remove(newS);
			return true;
		}
		return false;
	}
	public ArrayList<String> getItemsInCart(){
		return this.itemsInCart;
	}
	public String getItemsInCartS(){
		return this.itemsInCart+"";
	}
	public void setCart(String Cart) {
		Cart.trim();
		String newS = "";
		for (int i = 0; i < Cart.length(); i++) {
			if (Cart.charAt(i) == ' ') {
				newS += "";
			}
			else {
				newS += Cart.charAt(i);
			}
		}
		String[] s = newS.split(",");
	
		for (int i = 0; i < s.length; i++) {
			itemsInCart.add(s[i]);
		}
	}
	public String getName() {
		return name;
	}

	public void setStoreName(String name) {
		this.storeName = name;
	}
	public String getStoreName() {
		return this.storeName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "Username:  " + name + "   Email:  " + email + "   Password:  " + password;
	}
	
}



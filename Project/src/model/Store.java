package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
	
	public String name;
	public String id;
	public String startTime;
	public String endTime;
	public String managerID = "no manager assigned";
	public HashMap<String, Integer> itemsInStore = new HashMap<>();
	public HashMap<String, Integer> saleItemsInStore = new HashMap<>();
	public HashMap<String, String> location = new HashMap<>();
	

	public Store(String id, String name, String startTime, String endTime, String managerID){
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.managerID = managerID;
		
	}
	public Store(String id, String name, String startTime, String endTime){
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		
	}
	public Store(String id, String name, String managerID){
		this.id = id;
		this.name = name;
		this.managerID = managerID;
		
	}
	public Store(String id, String name){
		this.id = id;
		this.name = name;
		
	}
	public Store(){
		
	}
	public void addItem(String itemName, int quantity) {
		int currQuan = 0;
		if (this.itemsInStore.containsKey(itemName)) {
			currQuan = this.itemsInStore.get(itemName);
			if (this.itemsInStore.get(itemName) > 0) {
				this.itemsInStore.put(itemName, currQuan + quantity);
			}
		}
		else {
			itemsInStore.put(itemName, quantity);
		}
		
	}
	public HashMap<String, String> getItemsLocationMap(){
		return this.location;
	}
	public void setItemsLocation(String locationList){
		String s = "";
		if (!(locationList.equals(""))) {
			if (locationList.equals("{}")) {
				locationList = s;
			}
			else {
				for (int i = 0; i < locationList.length(); i++) {
					if (locationList.charAt(i) == '{' || locationList.charAt(i) == '}') {
						s += "";
					}
					else {
						s += locationList.charAt(i);
					}
				}
				String[] d = s.split(",");
				for (String x : d) {
				    String[] kv = x.split("=");
				    this.location.put(kv[0], kv[1]);
				}
			}
		}
	}
	public void updateItemLocation(String itemName, String aisle, String row){
		if (this.itemsInStore.containsKey(itemName)) {
			if (!aisle.equals("") && row.equals("")) {
				this.location.put(itemName, "(" + aisle + ": )");
				
			}
			else if (!row.equals("") && aisle.equals("")) {
				this.location.put(itemName, "( :" + row + ")");
			}
			else {
				this.location.put(itemName, "(" + aisle + ":" + row + ")");
			}
		}
		
	}
	
	public void removeItem(String itemName, int quantity) {
		int currQuan = 0;
		int total = 0;
		if (this.itemsInStore.containsKey(itemName)) {
			currQuan = this.itemsInStore.get(itemName);
			if (currQuan > 0) {
				if (quantity <= currQuan) {
					total = currQuan - quantity;
				}
				else {
					total = 0;
				}	
			}
		}
		if (total > 0) {
			this.itemsInStore.put(itemName, total);
		}
		else {
			this.itemsInStore.remove(itemName);
		}
	}
	public String getItemAvailability(String item) {
		String res = item + " not available!";
		if (this.itemsInStore.get(item) > 0) {
			res = "There are " + this.itemsInStore.get(item) + " " + item + "'s left in the stock";
		}
		return res;
	}

	public void setItemsInStore(String itemsList) {
		String s = "";
		if (!(itemsList.equals(""))) {
			if (itemsList.equals("{}")) {
				itemsList = s;
			}
			else {
				for (int i = 0; i < itemsList.length(); i++) {
					if (itemsList.charAt(i) == '{' || itemsList.charAt(i) == '}') {
						s += "";
					}
					else {
						s += itemsList.charAt(i);
					}
				}
				
				String[] d = s.split(",");
				for (String x : d) {
				    String[] kv = x.split("=");
				    itemsInStore.put(kv[0], Integer.parseInt(kv[1]));
				}
			}
		}
		
	}
	public void setSaleItemsInStore(String itemsList) {
		String s = "";
		if (!(itemsList.equals(""))) {
			if (itemsList.equals("{}")) {
				itemsList = s;
			}
			else {
				for (int i = 0; i < itemsList.length(); i++) {
					if (itemsList.charAt(i) == '{' || itemsList.charAt(i) == '}') {
						s += "";
					}
					else {
						s += itemsList.charAt(i);
					}
				}
				
				String[] d = s.split(",");
				for (String x : d) {
				    String[] kv = x.split("=");
				    saleItemsInStore.put(kv[0], Integer.parseInt(kv[1]));
				}
			}
		}
		
	}
	public String getItemsInStore() {
		return this.itemsInStore.toString();
	}
	public String getItemsLocation() {
		return this.location.toString();
	}
	
	public HashMap<String, Integer> getItemsInStoreMap(){
		return this.itemsInStore;
	}
	public HashMap<String, Integer> getSaleItemsInStoreMap(){
		return this.saleItemsInStore;
	}
	public String getSaleItemsInStore() {
		return this.saleItemsInStore.toString();
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
	public void setId(String id) {
		this.id = id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	
	public void setStoreID(String id) {
		this.id = id;
	}
	public String getStoreID() {
		return this.id;
	}
	public void addSaleItem(String itemName, int quantity) {
		int currQuan = 0;
		int x = this.itemsInStore.get(itemName);
		if (this.saleItemsInStore.containsKey(itemName)) {
			currQuan = this.saleItemsInStore.get(itemName);
			if (this.saleItemsInStore.get(itemName) > 0 && quantity <= x) {
				this.saleItemsInStore.put(itemName, currQuan + quantity);
			}
			else {		
				this.saleItemsInStore.put(itemName, quantity);		
			}
		}else {	
			if (x >= quantity) {
				this.saleItemsInStore.put(itemName, quantity);	
			}
			else {
				this.saleItemsInStore.put(itemName, x);	
			}
		}
		
		
	}
	public void removeSaleItem(String itemName, int quan) {
		// TODO Auto-generated method stub
		int currQuan = 0;
		int total = 0;
		if (this.saleItemsInStore.containsKey(itemName)) {
			currQuan = this.saleItemsInStore.get(itemName);
			if (currQuan > 0) {
				if (quan <= currQuan) {
					total = currQuan - quan;
				}
				else {
					total = 0;
				}	
			}
		}
		if (total > 0) {
			this.saleItemsInStore.put(itemName, total);
		}
		else {
			this.saleItemsInStore.remove(itemName);
		}
		
	}
	
	
}

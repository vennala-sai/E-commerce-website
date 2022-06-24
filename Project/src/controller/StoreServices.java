package controller;
import model.*;
import view.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.*;

public class StoreServices {
	
	public ArrayList<Store> stores = new ArrayList<Store>();
	public String path;
	
	public void load(String path) throws Exception{
		try {
			CsvReader reader = new CsvReader(path); 
			reader.readHeaders();
			stores = new ArrayList<Store>();
			while(reader.readRecord()){ 
				Store c = new Store();
				//name,id,email,password
				c.setId(reader.get("ID"));
				c.setName(reader.get("Name"));
				c.setManagerID(reader.get("ManagerID"));
				c.setStartTime(reader.get("StartTime"));
				c.setEndTime(reader.get("EndTime"));
				c.setItemsInStore(reader.get("Items"));
				c.setSaleItemsInStore(reader.get("SaleItems"));
				c.setItemsLocation(reader.get("ItemLocation"));
				
				stores.add(c);
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
				String s = "";
				String newS = "";
				String saleItems = "";
				String newSaleItems = "";
				String newL = "";
				String l = "";
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("ID");
				csvOutput.write("Name");
		    	csvOutput.write("ManagerID");
				csvOutput.write("StartTime");
				csvOutput.write("EndTime");
				csvOutput.write("Items");
				csvOutput.write("SaleItems");
				csvOutput.write("ItemLocation");
				csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(Store u: stores){
					csvOutput.write(u.getId());
					csvOutput.write(u.getName());
					csvOutput.write(u.getManagerID());
					csvOutput.write(u.getStartTime());
					csvOutput.write(u.getEndTime());
					s = u.getItemsInStore();
					s = s.trim();
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) == ' ') {
							newS += "";
						}
						else {
							newS += s.charAt(i);
						}
					}
					csvOutput.write(newS);
					newS = "";
					
					newSaleItems = "";
					saleItems = u.getSaleItemsInStore();
					for (int i = 0; i < saleItems.length(); i++) {
						if (saleItems.charAt(i) == ' ') {
							newSaleItems += "";
						}
						else {
							newSaleItems += saleItems.charAt(i);
						}
					}
					csvOutput.write(newSaleItems);
					newL = "";
					l = u.getItemsLocation();
					l = l.trim();
					for (int i = 0; i < l.length(); i++) {
						if (l.charAt(i) == ' ') {
							newL += "";
						}
						else {
							newL += l.charAt(i);
						}
					}
					csvOutput.write(newL);
					newL = "";			
					csvOutput.endRecord();
				}
				csvOutput.close();
				stores = new ArrayList<Store>();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public boolean storeExists(String name) {
		String path = "stores.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Path!");
		}
		
		for (Store u: stores) {
			if (u.getName().equals(name)) {
				
				return true;
			}
		}
		return false;
	}
	public void addSaleItemToStore(String itemName, int quantity, String s) {
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(s)) {
				if (u.getItemsInStoreMap().containsKey(itemName)) {
					if (quantity <= u.getItemsInStoreMap().get(itemName)) {
						u.addSaleItem(itemName, quantity);
					}
					else {
						u.addSaleItem(itemName, u.getItemsInStoreMap().get(itemName));
					}
					
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
	public HashMap<String,Integer> getAllItemsInStore(String storeName) {
		String path = "stores.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Store u: stores) {
			if (u.getName().equals(storeName)) {
				return u.getItemsInStoreMap();
			}
		}
		return new HashMap<>();
	}
	public boolean addNewStore(String name, String managerID) {
		String path = "stores.csv";
		try {
			this.load(path);
			Store newStore = new Store("S" + stores.size() ,name, managerID);
			this.stores.add(newStore);
			this.update(path);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	public String[] getAllStoreNames() {
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] storeLocations = new String[stores.size()];
		for (int i = 0; i < stores.size(); i++) {
			storeLocations[i] = stores.get(i).getName();			
		}
		return storeLocations;
		
	}

	public void addItemToStore(String itemName, int q, String storeID) {
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				u.addItem(itemName, q);
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
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<String> getAllStoreIDs(){
		String path = "stores.csv";
		ArrayList<String> l = new ArrayList<>();
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			l.add(u.getId());
		}
		return l;
	}
	public String getStoreID(String storeName){
		String path = "stores.csv";
		String l = "";
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if(u.getName().equals(storeName)) {
				l = u.getStoreID();
			}
		}
		return l;
	}


	public void removeItemFromStore(String itemName, int q, String storeID) {
		// TODO Auto-generated method stub
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				u.removeItem(itemName, q);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void removeSaleItemFromStore(String itemName, int q, String storeID) {
		// TODO Auto-generated method stub
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				u.removeSaleItem(itemName, q);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public boolean addStore(String storeName) {
		// TODO Auto-generated method stub
		String path = "stores.csv";
		try {
			this.load(path);
			Store s = new Store("S" + (stores.size() + ""),storeName);
			this.stores.add(s);
			this.update(path);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return false;	
		
	}
	public boolean addStore(String storeName, String sT, String eT) {
		// TODO Auto-generated method stub
		String path = "stores.csv";
		try {
			this.load(path);
			Store s = new Store("S" + (stores.size() + ""),storeName,sT,eT);
			this.stores.add(s);
			this.update(path);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return false;	
		
	}


	public boolean addStore(String storeName, String sT, String eT, String mID) {
		// TODO Auto-generated method stub
		String path = "stores.csv";
		try {
			this.load(path);
			ManagerServices ms = new ManagerServices();
			if (ms.containsManagerID(mID)) {
				for (Store u: stores) {
					if (u.getManagerID().equals(mID)) {
						u.setManagerID("");
						ms.setStoreID("S" + (stores.size() + ""), mID);
					}
				}
				Store s = new Store("S" + (stores.size() + ""),storeName,sT,eT,mID);
				this.stores.add(s);
			}
			else {
				Store s = new Store("S" + (stores.size() + ""),storeName,sT,eT,mID);
				this.stores.add(s);
			}
			
			this.update(path);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return false;	
		
	}


	public void removeStore(String storeID) {
		// TODO Auto-generated method stub
		String path = "stores.csv";
		boolean s = false;
		Store z = null;
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				s = true;
				z = u;
				break;
			}
		}
		if (s) {
			this.stores.remove(z);
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setEndTime(String storeID, String eT) {
		String path = "stores.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				
				u.setEndTime(eT);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setStartTime(String storeID, String sT) {
		String path = "stores.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				
				u.setStartTime(sT);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setManagerID(String storeID, String managerID) {
		// TODO Auto-generated method stub
		String path = "stores.csv";
		ManagerServices m = new ManagerServices();
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getManagerID().equals(managerID)) {
				u.setManagerID("no manager assigned");
			}
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				u.setManagerID(managerID);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void removeManagerID(String mID) {
		String path = "stores.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getManagerID().equals(mID)) {
				u.setManagerID("no manager assigned");
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public String[][] getAllItems(String storeName) {
		ItemServices is = new ItemServices();
		String path = "stores.csv";
		String[][] res = {{"Empty Inventory","Empty Inventory","Empty Inventory","Empty Inventory","Empty Inventory","Empty Inventory"}};
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getName().equals(storeName)) {
				res = new String[u.getItemsInStoreMap().size()][6];
				int i = 0;
				
				for (String k:u.getItemsInStoreMap().keySet()) {
					res[i][0] = k;
					res[i][1] = is.getPrice(k);
					res[i][2] = is.getDescription(k);
					if (u.getSaleItemsInStoreMap().containsKey(k)) {
						res[i][3] = "ITEM ON SALE!!!";
					}
					else {
						int k1 = 0;
						String[] status = {"Item Recommended!", "Not on Sale!", "Most Searched Item!"};
						Random r = new Random();
						k1 = r.nextInt(3);
						res[i][3] = status[k1];
					}
					res[i][4] = u.getItemsLocationMap().get(k);
					res[i][5] = u.getItemsInStoreMap().get(k) + "";
					
					i++;
				}
				return res;				
			}
		}

		return res;
	}


	public void updateItemAisle(String itemName, String a, String storeID) {
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				u.updateItemLocation(itemName, a, "");
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void updateItemRow(String itemName, String r, String storeID) {
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				u.updateItemLocation(itemName, "", r);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateItemAisleRow(String itemName, String a, String r, String storeID) {
		String path = "stores.csv";
		
		try {
			this.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Store u: stores) {
			if (u.getId().equals(storeID)) {
				u.updateItemLocation(itemName, a, r);
			}
		}
		try {
			this.update(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

package controller;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import model.Item;
import model.Manager;
import model.Store;

public class ItemServices {
	public ArrayList<Item> items = new ArrayList<Item>();
	public String path;
	
	public void load(String path) throws Exception{
		try {
			CsvReader reader = new CsvReader(path); 
			reader.readHeaders();
			items = new ArrayList<Item>();
			while(reader.readRecord()){ 
				Item m = new Item();
				//name,id,email,password
				m.setId(reader.get("ID"));
				m.setName(reader.get("Name"));
				m.setPrice(reader.get("Price"));
				m.setDescription(reader.get("Description"));
				
				items.add(m);
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
		    	csvOutput.write("Price");
				csvOutput.write("Description");
				csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(Item u: items){
					csvOutput.write(u.getId());
					csvOutput.write(u.getName());
					csvOutput.write(u.getPrice());
					csvOutput.write(u.getDescription());
					csvOutput.endRecord();
				}
				csvOutput.close();
				items = new ArrayList<Item>();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public String getDescription(String itemName) {
		String path = "items.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Item u: items) {
			if (u.getName().equals(itemName)) {
				return u.getDescription();	
			}
		}
		return "No Description";
	}
	public String getPrice(String itemName) {
		String path = "items.csv";
		try {
			this.load(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Item u: items) {
			if (u.getName().equals(itemName)) {
				return u.getPrice();
			
			}
		}
		return "No Price";
	}
}

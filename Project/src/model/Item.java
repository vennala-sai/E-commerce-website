package model;

public class Item {
	
	String name;
	String price;
	String id;
	String description;
	public Item() {
		
	}
	
	public Item(String id, String name, String price, String description) {
		this.name = name;
		this.price  = price;
		this.id = id;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

package model;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
	public String name;
	//public static int CountID = 0;
	public String id;
	public String email;
	public String password;
    static ArrayList<Manager> managers = new ArrayList<>();
    static ArrayList<Store> stores = new ArrayList<>();
	
	
	public Administrator(String id, String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.id = id;
		this.password = password;
		
	}
	public Administrator() {
		
	}
	public void addManager(Manager m, Store s) {
		if (managers.contains(m)) {
			m.setManagerStore(s);
		}
		
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
		return "Username=" + name + ", Id=" + id + ", Email=" + email + ", Password=" + password;
	}
}

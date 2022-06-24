package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import controller.AdministratorServices;
import controller.CustomerServices;
import controller.ItemServices;
import controller.ManagerServices;
import controller.StoreServices;
import model.Administrator;
import view.LoginPage;

public class ControllerTest {
	//All classes in View Package are GUI Classes (only non GUI Classes are to be tested)
	//Tests for Controller Package (some of the functions in the
	//controller classes are connected with GUI Classes, so they are not tested)
	@Test
	public void testAdminServices1() {
		AdministratorServices a = new AdministratorServices();
		
		try {
			a.load("administrators.csv");
			a.update("administrators.csv");
//			LoginPage.textFieldUsername.setText("Alexy");
//			LoginPage.textFieldPassword.setText("stranger12");
			assertEquals(a.adminExists("Alexy", "stranger12"), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testAdminServices2() {
		AdministratorServices a = new AdministratorServices();
		
		try {
			a.load("administrators.csv");
			a.update("administrators.csv");
//			LoginPage.textFieldUsername.setText("Alexy");
//			LoginPage.textFieldPassword.setText("stranger12");
			assertEquals(a.adminExists("Alxy", "stranger12"),false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testCustomerServices1() {
		CustomerServices a = new CustomerServices();
		
		try {
			a.load("customers.csv");
			a.update("customers.csv");
//			LoginPage.textFieldUsername.setText("Alexy");
//			LoginPage.textFieldPassword.setText("stranger12");
			assertEquals(a.customerExists("phineas", "prince"), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testCustomerServices2() {
		CustomerServices a = new CustomerServices();
		
		try {
			a.load("customers.csv");
			a.update("customers.csv");
//			LoginPage.textFieldUsername.setText("Alexy");
//			LoginPage.textFieldPassword.setText("stranger12");
			assertEquals(a.customerExists("Alxy", "stranger12"),false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testItemServices1() {
		ItemServices a = new ItemServices();
		
		try {
			a.load("items.csv");
			a.update("items.csv");

			assertEquals(a.getDescription("Yogurt"), "Plain");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testItemServices2() {
		ItemServices a = new ItemServices();
		
		try {
			a.load("items.csv");
			a.update("items.csv");

			assertEquals(a.getDescription("y"), "No Description");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testItemServices3() {
		ItemServices a = new ItemServices();
		
		try {
			a.load("items.csv");
			a.update("items.csv");

			assertEquals(a.getPrice("Yogurt"), "3.42");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testItemServices4() {
		ItemServices a = new ItemServices();
		
		try {
			a.load("items.csv");
			a.update("items.csv");

			assertEquals(a.getPrice("lettuce"), "No Price");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testManagerServices1() {
		ManagerServices a = new ManagerServices();
		
		try {
			a.load("managers.csv");
			a.update("managers.csv");

			assertEquals(a.containsManagerID("M0"), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testManagerServices2() {
		ManagerServices a = new ManagerServices();
		
		try {
			a.load("managers.csv");
			a.update("managers.csv");

			assertEquals(a.containsManagerID("M7"), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testManagerServices3() {
		ManagerServices a = new ManagerServices();
		
		try {
			a.load("managers.csv");
			a.update("managers.csv");
			ArrayList<String> x = new ArrayList<>();
			x.add("M0");
			x.add("M1");
			x.add("M2");
			x.add("M3");
			assertEquals(a.getAllManagerIDs(), x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testStoreServices1() {
		StoreServices a = new StoreServices();
		
		try {
			a.load("stores.csv");
			a.update("stores.csv");
			assertEquals(a.storeExists("14 Chevy St"), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testStoreServices2() {
		StoreServices a = new StoreServices();
		
		try {
			a.load("stores.csv");
			a.update("stores.csv");
			assertEquals(a.storeExists("14 Chasdevy St"), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testStoreServices3() {
		StoreServices a = new StoreServices();
		
		try {
			a.load("stores.csv");
			a.update("stores.csv");
			ArrayList<String> x = new ArrayList<>();
			x.add("S0");
			x.add("S1");
			x.add("S2");
			x.add("S3");
			x.add("S4");
			x.add("S5");
			assertEquals(a.getAllStoreIDs(), x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testStoreServices4() {
		StoreServices a = new StoreServices();
		HashMap<String,Integer> z = new HashMap<>();
		try {
			a.load("stores.csv");
			a.update("stores.csv");
			z.put("Chicken", 12);
			z.put("Eggs", 100);
			assertEquals(a.getAllItemsInStore("11 Alham Rd"), z);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testStoreServices5() {
		StoreServices a = new StoreServices();
		try {
			a.load("stores.csv");
			a.update("stores.csv");
			assertEquals(a.isValidStoreID("S6"), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void testStoreServices6() {
		StoreServices a = new StoreServices();
		try {
			a.load("stores.csv");
			a.update("stores.csv");
			assertEquals(a.isValidStoreID("S0"), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
//	@Test
//	public void testStoreServices7() {
//		StoreServices a = new StoreServices();
//		String[] z = {"22 Jon Street", "11 Ron Blvd", "25 Song Rd", "101 Benz Blvd", "11 Alham Rd", "14 Chevy St"};
//		try {
//			a.load("stores.csv");
//			a.update("stores.csv");
//			assertEquals(a.getAllStoreNames(), z);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}
}

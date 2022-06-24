package testing;
import model.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import controller.*;
public class ModelTest {
	//All classes in View Package are GUI Classes (only non GUI Classes are to be tested)
	//Tests for Model Package
	@Test
	public void testAdminGettersSetters1() {
		Administrator a = new Administrator();
		a.setName("jon");
		a.setEmail("xyz@gmail.com");
		a.setPassword("fruits");
		a.setId("A0");
		String r = a.toString();
		
		assertEquals(a.getName(), "jon");
		assertEquals(a.getPassword(), "fruits");
		assertEquals(a.getEmail(), "xyz@gmail.com");
		assertEquals(a.getId(), "A0");
		assertEquals(r,"Username=jon, Id=A0, Email=xyz@gmail.com, Password=fruits");
	}
	
	@Test
	public void testAdminGettersSetters2() {
		Administrator a = new Administrator("A0", "kon", "k@gmail.com", "sds");
		a.setName("ron");
		a.setEmail("yz@gmail.com");
		a.setPassword("ftsl");
		a.setId("A1");
		String r = a.toString();
		
		assertEquals(a.getName(), "ron");
		assertEquals(a.getPassword(), "ftsl");
		assertEquals(a.getEmail(), "yz@gmail.com");
		assertEquals(a.getId(), "A1");
		assertEquals(r,"Username=ron, Id=A1, Email=yz@gmail.com, Password=ftsl");
	}
	
	@Test
	public void testAdminGettersSetters3() {
		Administrator a = new Administrator("A0", "kon", "k@gmail.com", "sds");
		String r = a.toString();
		
		assertEquals(a.getName(), "kon");
		assertEquals(a.getPassword(), "sds");
		assertEquals(a.getEmail(), "k@gmail.com");
		assertEquals(a.getId(), "A0");
		assertEquals(r,"Username=kon, Id=A0, Email=k@gmail.com, Password=sds");
	}
	
	@Test
	public void testCustomerGettersSetters1() {
		Customer a = new Customer();
		a.setName("jon");
		a.setEmail("xyz@gmail.com");
		a.setPassword("fruits");
		a.setId("A0");
		a.setStoreName("22 St");
		String r = a.toString();
		
		assertEquals(a.getName(), "jon");
		assertEquals(a.getPassword(), "fruits");
		assertEquals(a.getEmail(), "xyz@gmail.com");
		assertEquals(a.getId(), "A0");
		assertEquals(a.getStoreName(), "22 St");
		assertEquals(r,"Username:  jon   Email:  xyz@gmail.com   Password:  fruits");
	}
	
	@Test
	public void testCustomerGettersSetters2() {
		Customer a = new Customer("A0", "kon", "k@gmail.com", "sds");
		a.setName("ron");
		a.setEmail("yz@gmail.com");
		a.setPassword("ftsl");
		a.setId("A1");
		a.setStoreName("23 Rd");
		String r = a.toString();
		a.addItemToCart("chocolate");
		assertEquals(a.getItemsInCartS(), "[chocolate]");
		ArrayList<String> x = new ArrayList<>();
		x.add("chocolate");
		assertEquals(a.getItemsInCart(), x);
		
		a.removeItemInCart("chocolate");
		assertEquals(a.getItemsInCartS(), "[]");
		a.setCart("banana");
		assertEquals(a.getItemsInCartS(), "[banana]");
		assertEquals(a.getName(), "ron");
		assertEquals(a.getPassword(), "ftsl");
		assertEquals(a.getEmail(), "yz@gmail.com");
		assertEquals(a.getId(), "A1");
		
		assertEquals(a.getStoreName(), "23 Rd");
		assertEquals(r,"Username:  ron   Email:  yz@gmail.com   Password:  ftsl");
	}
	
	@Test
	public void testCustomerGettersSetters3() {
		Customer a = new Customer("A0", "kon", "k@gmail.com", "sds", "11 Jon Rd");
		String r = a.toString();
		a.addItemToCart("prawn");
		assertEquals(a.getItemsInCartS(), "[prawn]");
		a.removeItemInCart("chocolate");
		assertEquals(a.getItemsInCartS(), "[prawn]");
		a.addItemToCart("chicken");
		ArrayList<String> x = new ArrayList<>();
		x.add("prawn");
		x.add("chicken");
		assertEquals(a.getItemsInCart(), x);
		a.removeItemInCart("chicken");
		a.removeItemInCart("prawn");
		a.setCart("goat");
		assertEquals(a.getItemsInCartS(), "[goat]");
		assertEquals(a.getName(), "kon");
		assertEquals(a.getPassword(), "sds");
		assertEquals(a.getEmail(), "k@gmail.com");
		assertEquals(a.getId(), "A0");
		assertEquals(r,"Username:  kon   Email:  k@gmail.com   Password:  sds");
	}
	
	@Test
	public void testItemGettersSetters1() {
		Item a = new Item();
		a.setName("prawn");
		a.setDescription("yummy");
		a.setPrice("2.00");
		a.setId("I0");
		
		assertEquals(a.getName(), "prawn");
		assertEquals(a.getDescription(), "yummy");
		assertEquals(a.getPrice(), "2.00");
		assertEquals(a.getId(), "I0");
		
	}
	
	@Test
	public void testItemGettersSetters2() {
		Item a = new Item("I0", "chocolate", "5.00", "Milky");
		assertEquals(a.getName(), "chocolate");
		assertEquals(a.getDescription(), "Milky");
		assertEquals(a.getPrice(), "5.00");
		assertEquals(a.getId(), "I0");
		a.setName("coke");
		a.setDescription("zero sugar");
		a.setPrice("2.00");
		a.setId("I1");
		
		assertEquals(a.getName(), "coke");
		assertEquals(a.getDescription(), "zero sugar");
		assertEquals(a.getPrice(), "2.00");
		assertEquals(a.getId(), "I1");
	}
	@Test
	public void testManagerGettersSetters1() {
		Manager a = new Manager();
		a.setName("jon");
		a.setEmail("xyz@gmail.com");
		a.setPassword("fruits");
		a.setId("M0");
		a.setStoreId("S0");
		Store s = new Store();
		a.setManagerStore(s);
		
		a.addItem("prawn", 10);
		a.removeItem("prawn", 10);
		assertFalse(a.getManagerStore() == null);
		
		String r = a.toString();
		assertEquals(a.getName(), "jon");
		assertEquals(a.getPassword(), "fruits");
		assertEquals(a.getEmail(), "xyz@gmail.com");
		assertEquals(a.getId(), "M0");
		assertEquals(a.getStoreId(), "S0");
		assertEquals(r,"Username=jon, Id=M0, Email=xyz@gmail.com, Password=fruits, storeID=S0");
	}
	
	@Test
	public void testManagerGettersSetters2() {
		Store s = new Store();
		Manager a = new Manager("M0", "kon", "k@gmail.com", "sds", s);
		a.setId("M1");
		s.setId("S0");
		a.setStoreId("S0");
		String r = a.toString();
		
		assertEquals(a.getName(), "kon");
		assertEquals(a.getPassword(), "sds");
		assertEquals(a.getEmail(), "k@gmail.com");
		assertEquals(a.getId(), "M1");
		assertEquals(r,"Username=kon, Id=M1, Email=k@gmail.com, Password=sds, storeID=S0");
	}
	
	@Test
	public void testManagerGettersSetters3() {
		Store s = new Store();
		Manager a = new Manager("M0", "kon", "k@gmail.com", "sds", "S0");
		a.setName("ron");
		a.setEmail("yz@gmail.com");
		a.setPassword("ftsl");
		a.setId("M1");
		s.setId("S0");
		a.setStoreId("S0");
		String r = a.toString();
		
		assertEquals(a.getName(), "ron");
		assertEquals(a.getPassword(), "ftsl");
		assertEquals(a.getEmail(), "yz@gmail.com");
		assertEquals(a.getId(), "M1");
		assertEquals(r,"Username=ron, Id=M1, Email=yz@gmail.com, Password=ftsl, storeID=S0");
	}
	
	@Test
	public void testStoreGettersSetters1() {
		Store a = new Store("S0", "11 king rd", "9am", "10pm","M0");
		String r = a.toString();
		
		assertEquals(a.getName(), "11 king rd");
		assertEquals(a.getEndTime(), "10pm");
		assertEquals(a.getStartTime(), "9am");
		assertEquals(a.getId(), "S0");
		assertEquals(a.getManagerID(), "M0");
		
	}
	@Test
	public void testStoreGettersSetters2() {
		Store a = new Store("S1", "11 king rd", "9am", "10pm");
		a.setStoreID("S0");
		a.setManagerID("M0");
		String r = a.toString();
		
		assertEquals(a.getName(), "11 king rd");
		assertEquals(a.getEndTime(), "10pm");
		assertEquals(a.getStartTime(), "9am");
		assertEquals(a.getId(), "S0");
		assertEquals(a.getManagerID(), "M0");
		
	}
	@Test
	public void testStoreGettersSetters3() {
		Store a = new Store("S1", "11 king rd", "M0");
		Store b = new Store("S2", "22 Jon Street");
		a.setStoreID("S0");
		a.setManagerID("M0");
		a.setStartTime("9am");
		a.setEndTime("10pm");
		a.setName("12 abcd Rd");
		a.addItem("prawns", 100);
		a.addItem("prawns", 100);
		String r = a.getItemsInStore();
		String sr = a.getSaleItemsInStore();
		HashMap<String, Integer> srMap = new HashMap<>();
		HashMap<String, Integer> rMap = new HashMap<>();
		HashMap<String, String> ilMap = new HashMap<>();
		assertEquals(a.getItemsLocationMap(), ilMap);
		rMap.put("prawns", 200);
		srMap.put("prawns", 199);
		a.addSaleItem("prawns", 199);
		assertEquals(a.getSaleItemsInStoreMap(), srMap);
		a.removeSaleItem("prawns", 200);
		srMap.remove("prawns", 100);
		srMap.remove("prawns");
		assertEquals(a.getSaleItemsInStoreMap(), srMap);
		assertEquals(a.getItemsInStoreMap(), rMap);
		
		assertEquals(r, "{prawns=200}");
		assertEquals(a.getItemAvailability("prawns"),"There are 200 prawns's left in the stock");
		a.addSaleItem("prawns", 1);
		srMap.put("prawns", 1);
		assertEquals(a.getSaleItemsInStoreMap(), srMap);
		
		a.removeItem("prawns", 100);
		r = a.getItemsInStore();
		assertEquals(r, "{prawns=100}");
		a.addItem("prawns", 50);
		b.setItemsInStore("");
		b.setItemsLocation("");
		b.setItemsInStore("{prawns=100}");
		b.setItemsLocation("{prawns=(5:3)}");
		assertEquals(b.getItemsLocation(), "{prawns=(5:3)}");
		b.setSaleItemsInStore("");
		b.setSaleItemsInStore("{prawns=100}");
		
		assertEquals(a.getItemsLocation(), "{}");
		assertEquals(a.getName(), "12 abcd Rd");
		assertEquals(a.getEndTime(), "10pm");
		assertEquals(a.getStartTime(), "9am");
		assertEquals(a.getId(), "S0");
		assertEquals(a.getStoreID(), "S0");
		assertEquals(a.getManagerID(), "M0");
		
	}

}

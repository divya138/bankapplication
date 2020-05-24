package com.hcl.savingaccount.controller;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hcl.savingaccount.model.Customer;
import com.hcl.savingaccount.service.CustomerServiceImpl;
@RunWith(Silent.class)
public class CustomerControllerTest {
	@InjectMocks
	CustomerController customerController;
	@Mock
	CustomerServiceImpl customerServiceimpl;
	static Customer customer=null;
	@BeforeClass
	public static void setUp() {
		customer = new Customer();

	}
	@Before
	public void beforeMethod(){
		customer.setCustomerId(1l);
		customer.setFirstName("sowjanya");
		customer.setLastName("bana");
		customer.setEmail("sowji@gmail.com");
		customer.setPassword(12344);
		customer.setOccupation("software");
		customer.setAadhar("535657874");
		customer.setPAN("63jgh558hgku");
		customer.setAddress("Anantapur");
		customer.setPinCode("515411");

	}
	@Test
	public void testAccuntById() {
		
		Mockito.when(customerServiceimpl.getAccountByCustomerId(customer.getAccount())).thenReturn(customer);
		ResponseEntity<Long> s1=customerController.getCustomerById(customer.getAccount());
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
	}
	@Test
	public void testAccuntByaadhra() {
		
		Mockito.when(customerServiceimpl.findCustomerByAadhar(customer.getAadhar())).thenReturn(customer);
		ResponseEntity<Customer> s1=customerController.getCustomerById(customer.getAadhar());
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
	}
	@Test
	public void testRegistrtion() {
		Mockito.when(customerServiceimpl.registration(customer)).thenReturn(customer);
		ResponseEntity<String> s1=customerController.registration(customer);
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
		
	}
	@Test
	public void testLogin() {
		Mockito.when(customerServiceimpl.login(customer)).thenReturn(customer);
		ResponseEntity<Object> s1=customerController.login(customer);
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
	}
	@AfterClass
	public static void tearDown() {
		customer= null;
	}
}

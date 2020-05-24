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
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.service.AccountServiceImpl;
@RunWith(Silent.class)
public class AccountControllerTest {
	@InjectMocks
	AccountController accountController;
	@Mock
	AccountServiceImpl accountServicImpl;

	static Account account= null;

	@BeforeClass
	public static void setUp() {
		account = new Account();

	}
	@Before
	public void beforeMethod() {

		account.setAccountHolderName("divya");
		account.setAccountNumber(123336636);
		account.setBalance(23456);
	}
	@Test
	public void testAccuntById() {
		
		Mockito.when(accountServicImpl.findAccountById(account.getAccountNumber())).thenReturn(account);
		ResponseEntity<Account> s1=accountController.getAccountById(account.getAccountNumber());
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
	}
	@Test
	public void testAccuntByName() {
		
		Mockito.when(accountServicImpl.findByAccountHolderName(account.getAccountHolderName())).thenReturn(account);
		ResponseEntity<Account> s1=accountController.getAccountByName(account.getAccountHolderName());
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
	}
	@AfterClass
	public static void tearDown() {
		account= null;
	}
	}




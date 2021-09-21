package com.payment.test.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.payment.model.Account;
import com.payment.model.Response;
import com.payment.services.PaymentService;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ValidateAccountShould {
	Response response;
	@Autowired
	private PaymentService paymentService;
	
	@Test
	public void ReturnCorrectMessageWhenCvvEqualsTo007() {		
		
		Account account = new Account("3916585815127134", "007", "holiii");
		response = paymentService.validateAccount(account);
		assertEquals(response.getStatus(),"cvv not valid");
	}

	@Test
	public void ReturnCorrectMessageWhenNumberStartWith0() {
		
		Account account = new Account("4916585815127134", "237", "holiii");
		response = paymentService.validateAccount(account);
		assertEquals(response.getStatus(),"Credit card number not valid");
	}
		
	@Test
	public void ReturnCorrectMessageWhenTitularNotValid() {
		
		Account account = new Account("3916585815127134", "237", "Eholiii");
		response = paymentService.validateAccount(account);
		assertEquals(response.getStatus(),"Titular not valid");
	}
	
	@Test
	public void ReturnCorrectMessageWhenAccountIsCorrect() {
		
		Account account = new Account("3916585815127134", "237", "holiii");
		response = paymentService.validateAccount(account);
		assertEquals(response.getStatus(),"Valid account");
	}
}

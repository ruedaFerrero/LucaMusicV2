package com.payment.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.payment.model.Account;
import com.payment.model.Response;

@AllArgsConstructor
@Service
class PaymentServiceImp implements PaymentService{
	@Override
	public Response validateAccount(Account account) {

		Response response = new Response();
		if (account.getCreditCard().startsWith("4"))
			response.setStatus("The credit card number cannot start with 4");
		else if (account.getCvv().equals("007")) 
			response.setStatus("The cvv cannot be 007");
		else if (account.getCreditCardOwner().startsWith("E"))
			response.setStatus("Titular name cannot start with E");
		else
			response.setStatus("Valid account");

		return response;
	}
}

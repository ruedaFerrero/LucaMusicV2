package com.payment.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@CreditCardNumber(ignoreNonDigitCharacters = true)
	@NotNull
	private String creditCard;
	@Size(min=3, max=3)
	@NotNull
	private String cvv;
	@Size(min=1)
	@NotNull
	private String creditCardOwner;
	
	
	

	
	
	
	

}

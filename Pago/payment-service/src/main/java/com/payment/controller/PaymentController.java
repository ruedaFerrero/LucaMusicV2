package com.payment.controller;
import com.payment.services.PaymentService;
import com.payment.model.Account;
import com.payment.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    PaymentService service;

    @GetMapping("/")
    public ResponseEntity<Response> validatePayment(@Valid @RequestBody Account account, BindingResult result){
    	log.info("Validating Account: {}", account);
    	Boolean cvvIsValid;
    	try{
    	    Integer.parseInt(account.getCvv());
    	    cvvIsValid = true;
    	} catch(NumberFormatException e){
    	    cvvIsValid = false;
    	}
    	Response response = new Response();
    	if(result.hasErrors() || !cvvIsValid){
    		if (account.getCreditCard().isEmpty())
    			response.setStatus("Credit card must be not null");
    		else if (!cvvIsValid)
    			response.setStatus("The cvv must have a valid format");
    		else if (account.getCreditCardOwner().isEmpty())
    			response.setStatus("Credit card owner must be not null");            
    		else 
    			response.setStatus("Credit card must have a valid format");
        }
        else {
            response = service.validateAccount(account);
        }
        return ResponseEntity.ok(response);
    }
}

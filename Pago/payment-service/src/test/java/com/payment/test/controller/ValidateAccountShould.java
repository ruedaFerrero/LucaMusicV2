package com.payment.test.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.payment.controller.PaymentController;
import com.payment.model.Account;
import com.payment.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ValidateAccountShould {
    ResponseEntity<Response> response;
    @Autowired
    private PaymentController paymentController;

    @Test
    public void ReturnBadRequestWhenValidationHasErrors() {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        Account account = new Account("Holaaaa", "656", "holiii");
        response = paymentController.validatePayment(account, result);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getStatus(), "Bad request");
    }

    @Test
    public void ReturnValidAccountWhenValidationHasNoErrors() {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        Account account = new Account("Holaaaa", "656", "holiii");
        response = paymentController.validatePayment(account, result);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getStatus(), "Valid account");

    }
}


package com.telecom.controller;

import java.util.ArrayList;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.model.TelecomActionResponse;
import com.telecom.model.ServiceInfoLite;
import com.telecom.service.TelecomService;

import io.swagger.annotations.ApiOperation;

/*
 * This is the main controller of application to receive all request from client
 */

@RestController
@RequestMapping(path = "/api/telecom")
public class TelecomController {

	Logger logger = LoggerFactory.getLogger(TelecomController.class);
	
	@Autowired
	private TelecomService telecomService;
	
	
	/**
	 *
	 * URI: /api/telecom/phonenumbers
	 * Objective: Return all stored phone number in application for all customers
	 * Need to add: pagination
	 */
	 
	@GetMapping("/phonenumbers")
	@ApiOperation(value = "Returns all the Mobile and Landline phone numbers for all customers ", notes = "Returns a collection of phonenumber information")
	public ResponseEntity<List<ServiceInfoLite>> getAllphoneNumbers() 
	{
		logger.info("Telecom Conroller: getAllphoneNumbers: Retriving all phoneNumber");		
		List<ServiceInfoLite> phoneNumList = new ArrayList<ServiceInfoLite>();
		
		phoneNumList = telecomService.retrieveAllPhoneNumbers();
		
		
		return new ResponseEntity<List<ServiceInfoLite>>(phoneNumList, HttpStatus.OK);
	}
		
	/**	
	 * URI: /api/telecom/customers/{customerId}/phonenumbers
	 * Objective: Return all stored mobile and landline phone number in application for given customers
	 * Need to add: pagination
	 */
	
	@GetMapping("/customers/{customerId}/phonenumbers")
	@ApiOperation(value = "Return all stored mobile and landline phone number in application for given customers", notes = "Returns a collection of phonenumber information")	
	public ResponseEntity<List<ServiceInfoLite>> retrieveCustomerphoneNumbers(@PathVariable int customerId) 
	{
		logger.info("Telecom Conroller: getAllphoneNumbers: Retriving all phoneNumber for customer "+ customerId);
		
		List<ServiceInfoLite> phoneNumList = new ArrayList<ServiceInfoLite>();
		
		phoneNumList = telecomService.retrieveAllCustomerPhoneNumbers(customerId);
		
		return new ResponseEntity<List<ServiceInfoLite>>(phoneNumList, HttpStatus.OK);
	}
	
	
	/**	 *
	 * URI: /api/telecom//customers/{customerId}/phonenumbers/{phoneNumberId}
	 * Objective: Activate phonenumber for given customer
	 * Need to add: pagination
	 * 	
	 * 1. Verify if customer is legit and exist in database.
	 * 2. Verify if the given phonenumber is associated with customer
	 * 3. Activate the phone number-> update the service info table -> status = 'Active'
	
	 */
	
	@PutMapping("/customers/{customerId}/phonenumbers/{phoneNumberId}")
	@ApiOperation(value = "Activates given phone number for given customer", notes = "Returns activation response")	
	public ResponseEntity<TelecomActionResponse> activatePhoneNumberCustomer(
		@PathVariable int customerId,@PathVariable String phoneNumberId) {

		TelecomActionResponse telecomResponse = telecomService.activatePhoneNumber(customerId, phoneNumberId);
		
		return new ResponseEntity<TelecomActionResponse>(telecomResponse, HttpStatus.OK);
	}

}

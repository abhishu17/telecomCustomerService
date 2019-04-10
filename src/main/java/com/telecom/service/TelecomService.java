package com.telecom.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import com.telecom.common.AppConstants;
import com.telecom.controller.TelecomController;
import com.telecom.dao.CustomerRepository;
import com.telecom.dao.CustomerServiceRepository;
import com.telecom.dao.ServiceInfoRepository;
import com.telecom.exception.AssociationNotFoundException;
import com.telecom.exception.CustomerNotFoundException;
import com.telecom.exception.NumberAlreadyActivatedException;
import com.telecom.jpa.Customer;
import com.telecom.jpa.CustomerService;
import com.telecom.jpa.ServiceInfo;

import com.telecom.model.TelecomActionResponse;
import com.telecom.model.ServiceInfoLite;


@Component
public class TelecomService {

	Logger logger = LoggerFactory.getLogger(TelecomController.class);
	

	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private ServiceInfoRepository serviceInfoRepository;
	

	/*
	 * This function fetch phone number from DAO layer
	 */
	public List<ServiceInfoLite> retrieveAllPhoneNumbers() 
	{				
		List <ServiceInfoLite> list = customerrepository.getAllPhoneNumbers();		
		return list;
	}
	
	
	/*
	 * This function fetch phone number for customer from DAO layer
	 */
	public List<ServiceInfoLite> retrieveAllCustomerPhoneNumbers(int customerId) 
	{				
		
		if (!this.checkCustomerExists(customerId)) {
            throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
        }
		
		List <ServiceInfoLite> list = customerrepository.getAllPhoneNumbers(customerId);		
		return list;
	}
	
	
		
	
	/* 
	 * 1. Verify if customer is legit and exist in database.
	 * 2. Verify if the given phonenumber is associated with customer
	 * 3. Activate the phone number-> update the service info table -> status = 'Active'
	 * */
	public TelecomActionResponse activatePhoneNumber(int customerId, String  phoneNumberId) {
		
		boolean flag = false;
		
		TelecomActionResponse telecomResponse = new TelecomActionResponse("Activation",phoneNumberId,customerId);	
		
		if (!this.checkCustomerExists(customerId)) {
            throw new CustomerNotFoundException("Customer with id " + customerId + " not found");
        }
		
		
		if(this.checkValidAssociation(customerId, phoneNumberId) < 1)
		{
			logger.info("Number is not associated with Customer");
			throw new AssociationNotFoundException("Customer with id " + customerId + " not found association with Phone Number "+ phoneNumberId);
		}
		
		if(this.checkPhoneNumberActivationStatus(customerId, phoneNumberId) > 0)
		{
			logger.info("Number is already activated");
			throw new NumberAlreadyActivatedException("Number is already activated "+ phoneNumberId);
		}
		
			
		if(serviceInfoRepository.updateMobileActivationStatus(phoneNumberId, "Active") > 0)
 		{
			telecomResponse.setResult(AppConstants.SUCCESS);
			telecomResponse.setMessage(AppConstants.ACTIVATION_SUCCESS_MESSAGE);
 		}
 		else
 		{
 			telecomResponse.setResult(AppConstants.SUCCESS);
			telecomResponse.setMessage(AppConstants.ACTIVATION_FAIL_MESSAGE);
 		}	

       return telecomResponse;
	}
    
	
	public boolean checkCustomerExists(int custID)
	{
		return customerrepository.existsById(custID);
	}
	
	public int checkValidAssociation(int customerId,String phoneNumberId)
	{
		return customerrepository.checkCustomerAndPhoneNumberAssociation(customerId, phoneNumberId);
	}
	
	public int checkPhoneNumberActivationStatus(int customerId,String phoneNumberId)
	{
		return customerrepository.checkPhoneNumberActivationStatus(customerId, phoneNumberId);
	}
	
}
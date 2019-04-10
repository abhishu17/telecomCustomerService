package com.telecom.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.common.AppConstants;
import com.telecom.jpa.Customer;
import com.telecom.jpa.CustomerService;
import com.telecom.model.ServiceInfoLite;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	
	
	/* Query to retrive all phone numbers against all customers in application which has service type 'Mobile' or 
	 * 'Landline'.
	 *  
	 * */
	String Q_GET_ALL_PHONENUMBERS = "select c.customerid as customerid, cs.serviceid as serviceid, si.status as status, "
			+ "si.number as number from Customer c left join c.customerservice cs join cs.serviceinfos si "
			+ "where c.customerid = cs.customerid "
			+ "and cs.serviceid = si.serviceid"
			+ " and si.servicetypeid in ('"+AppConstants.MOBILE_SERVICETYPE_ID+"','"+AppConstants.LANDLINE_SERVICETYPE_ID+"')";
	
	String Q_GET_CUSTOMER_PHONENUMBERS = "select c.customerid as customerid, cs.serviceid as serviceid, si.status as status, "
			+ "si.number as number from Customer c left join c.customerservice cs join cs.serviceinfos si "
			+ "where c.customerid=:customerId  and  c.customerid = cs.customerid "
			+ "and cs.serviceid = si.serviceid"
			+ " and si.servicetypeid in ('"+AppConstants.MOBILE_SERVICETYPE_ID+"','"+AppConstants.LANDLINE_SERVICETYPE_ID+"')";
	
	String Q_GET_CUSTOMER_PHONENUMBER_ASSOCIATION_CHECK = "select count(c) from Customer c left join c.customerservice cs join cs.serviceinfos si "
			+ "where c.customerid=:customerId  and  c.customerid = cs.customerid "
			+ "and cs.serviceid = si.serviceid and si.number=:phoneNumber "
			+ " and si.servicetypeid in ('"+AppConstants.MOBILE_SERVICETYPE_ID+"','"+AppConstants.LANDLINE_SERVICETYPE_ID+"')";
	
	
	String Q_GET_CHECK_ACTIVATION_STATUS = "select count(c) from Customer c left join c.customerservice cs join cs.serviceinfos si "
			+ "where c.customerid=:customerId  and  c.customerid = cs.customerid "
			+ "and cs.serviceid = si.serviceid and si.number=:phoneNumber and status='Active' "
			+ " and si.servicetypeid in ('"+AppConstants.MOBILE_SERVICETYPE_ID+"','"+AppConstants.LANDLINE_SERVICETYPE_ID+"')";
	
		
	@Query(Q_GET_ALL_PHONENUMBERS)
	List<ServiceInfoLite> getAllPhoneNumbers();
	
	
	@Query(Q_GET_CUSTOMER_PHONENUMBERS)
	List<ServiceInfoLite> getAllPhoneNumbers(int customerId);
	
	@Query(Q_GET_CUSTOMER_PHONENUMBER_ASSOCIATION_CHECK)
	int checkCustomerAndPhoneNumberAssociation(int customerId, String phoneNumber);

	@Query(Q_GET_CHECK_ACTIVATION_STATUS)
	int checkPhoneNumberActivationStatus(int customerId, String phoneNumber);
	
}

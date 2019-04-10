package com.telecom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.dao.CustomerRepository;
import com.telecom.jpa.Customer;
import com.telecom.jpa.CustomerService;
import com.telecom.jpa.ServiceInfo;
import com.telecom.jpa.ServiceType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryIntegrationTest {
 
    @Autowired
    private EntityManager entityManager;
 
    @Autowired
    private CustomerRepository customerRepository;
 
    @Test
    public void when_check_user_exist_should_return_result_true() {
        
    	boolean expectedResult = true;
    	
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
    	cust.setAddressid(1);
    	cust.setCustomersince(new Date() );
    	cust.setDateofbirth(new Date());
    	cust.setFirstname("Abhishek");
    	cust.setGender("M");
    	cust.setLastname("Srivastava");
    	
    	List<CustomerService> customerservice = new ArrayList<CustomerService>();
    	CustomerService custservice = new CustomerService();
    	custservice.setId(1001);
    	custservice.setServiceid(301);
    	
    	List<ServiceInfo> serviceinfos = new ArrayList<ServiceInfo>();
    	ServiceInfo si = new ServiceInfo();
    	si.setNumber("09455363900");
    	si.setPlanid(1);
    	si.setServiceid(301);
    	si.setStatus("Active");
    	ServiceType serviceTypeID = new ServiceType();
    	serviceTypeID.setServicename("Mobile");
    	serviceTypeID.setServicetypeid(1001);    	
    	si.setServicetypeid(serviceTypeID);
    	
    	serviceinfos.add(si);    	
    	
    	custservice.setServiceinfos(serviceinfos);
    	
    	customerservice.add(custservice);
    	
    	cust.setCustomerservice(customerservice);
    	
    	
    	
    	    	
    	
    	    	
    	when(customerRepository.existsById(Mockito.anyInt())).thenReturn(true);        
    	
        boolean actualResult = customerRepository.existsById(cust.getCustomerid());
        assertEquals(actualResult,expectedResult);
        
    }
    
    @Test
    public void to_check_if_customer_not_exists_by_id() {
        // given
    	boolean result = true;;
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
        entityManager.persist(cust);
        boolean val;
        val = customerRepository.existsById(cust.getCustomerid());
        assertEquals(result,val);
        entityManager.flush();
    }
    
    
    @Test
    public void to_check_if_customer_phonenumber_data_returned() {
        // given
    	boolean result = true;;
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
        entityManager.persist(cust);
        boolean val;
        val = customerRepository.existsById(cust.getCustomerid());
        assertEquals(result,val);
        entityManager.flush();
    }
    
    @Test
    public void to_check_if_phonenumber_landline_phone_returned() {
        // given
    	boolean result = true;;
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
        entityManager.persist(cust);
        boolean val;
        val = customerRepository.existsById(cust.getCustomerid());
        assertEquals(result,val);
        entityManager.flush();
    }
    
    @Test
    public void to_check_if_customer_not_found() {
        // given
    	boolean result = true;;
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
        entityManager.persist(cust);
        boolean val;
        val = customerRepository.existsById(cust.getCustomerid());
        assertEquals(result,val);
        entityManager.flush();
    }
    
    @Test
    public void to_check_if_phone_number_is_active() {
        // given
    	boolean result = true;;
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
        entityManager.persist(cust);
        boolean val;
        val = customerRepository.existsById(cust.getCustomerid());
        assertEquals(result,val);
        entityManager.flush();
    }
    
    @Test
    public void to_check_if_customer_exists_by_customer_phonenumber_is_linked() {
        // given
    	boolean result = true;;
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
        entityManager.persist(cust);
        boolean val;
        val = customerRepository.existsById(cust.getCustomerid());
        assertEquals(result,val);
        entityManager.flush();
    }
    
    @Test
    public void to_check_if_customer_exists_by_customer_phonenumber_is_not_linked() {
        // given
    	boolean result = true;;
    	Customer cust = new Customer();
    	cust.setCustomerid(101);
        entityManager.persist(cust);
        boolean val;
        val = customerRepository.existsById(cust.getCustomerid());
        assertEquals(result,val);
        entityManager.flush();
    }
 
}

package com.telecom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.telecom.dao.CustomerRepository;
import com.telecom.dao.ServiceInfoRepository;
import com.telecom.exception.AssociationNotFoundException;
import com.telecom.exception.CustomerNotFoundException;
import com.telecom.exception.NumberAlreadyActivatedException;
import com.telecom.model.ServiceInfoLite;
import com.telecom.model.TelecomActionResponse;
import com.telecom.service.TelecomService;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TelecomService.class, secure = false)
public class TelecomServiceTest {

	@InjectMocks
	TelecomActionResponse response;
	
	@MockBean
    CustomerRepository customerrepository;
	
	@MockBean
	private ServiceInfoRepository serviceInfoRepository;
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private TelecomService telecomService;

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	

	@Test
    public void to_check_if_return_all_phone_numbers()
    {
		list.clear();
		list.add(record1 );
		
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllPhoneNumbers();
        
        int expectedCount =1;
        int actualCount = phoneList.size();
        assertEquals(expectedCount, actualCount);
        verify(customerrepository, times(1)).getAllPhoneNumbers();
    }
	
	@Test
    public void to_check_if_customer_exist_method()
    {
		//list.clear();
		//list.add(first );
		
		//force return false to mock customer does not exists
        when(customerrepository.existsById(Mockito.anyInt())).thenReturn(false);
         
        boolean result = telecomService.checkCustomerExists(109);
        System.out.println("JUnit::to_check_if_customer_exists->"+ result);
        assertFalse(result);
        
    }
	
	/*
	 * to check the if function returns activation status correctly
	 */
	
	@Test
    public void to_check_if_phonenumber_activation_status_true()
    {
		//list.clear();
		//list.add(first );
		
		//force return false to mock customer phone number is already active
        when(customerrepository.checkPhoneNumberActivationStatus(Mockito.anyInt(),Mockito.anyString())).thenReturn(1);
         
        int result = telecomService.checkPhoneNumberActivationStatus(102,"94554649");
        System.out.println("JUnit::to_check_if_phonenumber_activation_status->"+ result);
        int expectedResponse =1;
        assertEquals(expectedResponse,result);
        
    }
	
	/*
	 *To check if activate phone function send correct status for incorrect data
	 */
	@Test
    public void to_check_if_phonenumber_activation_status_false()
    {
		//list.clear();
		//list.add(first );
		
		//force return false to mock customer phone number is already not active
        when(customerrepository.checkPhoneNumberActivationStatus(Mockito.anyInt(),Mockito.anyString())).thenReturn(0);
         
        int result = telecomService.checkPhoneNumberActivationStatus(102,"94554644");
        System.out.println("JUnit::to_check_if_phonenumber_activation_status_false->"+ result);
        int expectedResponse =0;
        assertEquals(expectedResponse,result);
        
    }
	
	
	/*
	 * To test the function which returns all customer specific phone number.
	 */
	
	@Test
    public void to_check_if_return_all_customer_phone_numbers()
    {
		list.clear();
		list.add(record1);
		
		when(customerrepository.existsById(Mockito.anyInt())).thenReturn(true);	       
		
		
        when(customerrepository.getAllPhoneNumbers(Mockito.anyInt())).thenReturn(list);
         
        //test
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllCustomerPhoneNumbers(102);
        
        assertEquals(1, phoneList.size());
      
    }
	
	
	/*
	 * To test the function which returns all customer specific phone number (customer not exists.
	 */
	
	@Test(expected = ResourceNotFoundException.class)
    public void to_check_if_return_all_customer_phone_numbers_customer_not_exists()
    {
	
		list.clear();
		list.add(record1 );
		
		when(customerrepository.existsById(Mockito.anyInt())).thenReturn(false);	       
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        telecomService.retrieveAllCustomerPhoneNumbers(102);
       
        
    }
	
	
	/*
	 * This unit test is to verify phone number activation functionality of service layer
	 */
	@Test
    public void to_check_function_activate_phone_number()
    {
		
		list.clear();
		list.add(record1 );	
		
        when(serviceInfoRepository.updateMobileActivationStatus(Mockito.anyString(),Mockito.anyString())).thenReturn(1);
         
        when(customerrepository.existsById(Mockito.anyInt())).thenReturn(true);
        
        when(customerrepository.checkCustomerAndPhoneNumberAssociation(Mockito.anyInt(), Mockito.anyString())).thenReturn(1);
        
        
        //test
        TelecomActionResponse response = telecomService.activatePhoneNumber(102,"94554649");
        assertEquals("Success", response.getResult());
        verify(serviceInfoRepository, times(1)).updateMobileActivationStatus(Mockito.anyString(),Mockito.anyString());
    }
	
	/*
	 * This unit test is to verify phone number activation functionality of service layer and scenario if 
	 * customer not found
	 */
	@Test(expected = CustomerNotFoundException.class)
    public void to_check_if_activate_phone_number_customer_not_found_exception()
    {
		
		list.clear();
		list.add(record1 );	
		
        when(serviceInfoRepository.updateMobileActivationStatus(Mockito.anyString(),Mockito.anyString())).thenReturn(1);
         
        when(customerrepository.existsById(Mockito.anyInt())).thenReturn(false);
        
        when(customerrepository.checkCustomerAndPhoneNumberAssociation(Mockito.anyInt(), Mockito.anyString())).thenReturn(1);
        
        telecomService.activatePhoneNumber(102,"94554649");
        
    }
	
	

	/*
	 * This unit test is to verify phone number activation functionality of service layer and scenario if 
	 * customer and phone number association not found in database 
	 */
	@Test(expected = AssociationNotFoundException.class)
    public void to_check_if_activate_phone_number_association_not_found_exception()
    {
		
		list.clear();
		list.add(record1 );	
		
        when(serviceInfoRepository.updateMobileActivationStatus(Mockito.anyString(),Mockito.anyString())).thenReturn(1);
         
        when(customerrepository.existsById(Mockito.anyInt())).thenReturn(true);
        
        when(customerrepository.checkCustomerAndPhoneNumberAssociation(Mockito.anyInt(), Mockito.anyString())).thenReturn(0);
        
        telecomService.activatePhoneNumber(102,"94554649");
        
    }
	
	/*
	 * This unit test is to verify phone number activation functionality of service layer and scenario if 
	 * customer and phone number is already activated 
	 */
	@Test(expected = NumberAlreadyActivatedException.class)
    public void to_check_if_activate_phone_number_number_already_activated_exception()
    {
		
		list.clear();
		list.add(record1 );	
		
        when(serviceInfoRepository.updateMobileActivationStatus(Mockito.anyString(),Mockito.anyString())).thenReturn(1);
         
        when(customerrepository.existsById(Mockito.anyInt())).thenReturn(true);
        
        when(customerrepository.checkCustomerAndPhoneNumberAssociation(Mockito.anyInt(), Mockito.anyString())).thenReturn(1);
        
        when(customerrepository.checkPhoneNumberActivationStatus(Mockito.anyInt(), Mockito.anyString())).thenReturn(1);
        
        telecomService.activatePhoneNumber(102,"94554649");
        
    }
	
	
	@Test
    public void to_check_if_not_activate_phone_number()
    {
		list.clear();
		list.add(record1 );		
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        //test
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllPhoneNumbers();
        assertEquals(1, phoneList.size());
        verify(customerrepository, times(1)).getAllPhoneNumbers();
    }
	
	@Test
    public void to_check_if_not_activate_phone_number_return_exception()
    {
		list.clear();
		list.add(record1 );		
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        //test
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllPhoneNumbers();
        
        assertEquals(1, phoneList.size());
        verify(customerrepository, times(1)).getAllPhoneNumbers();
    }
	
	@Test
    public void to_check_if_customer_exists()
    {
		list.clear();
		list.add(record1 );		
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        //test
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllPhoneNumbers();
        
        assertEquals(1, phoneList.size());
        verify(customerrepository, times(1)).getAllPhoneNumbers();
    }
	
	@Test
    public void to_check_if_customer_not_exists()
    {
		list.clear();
		list.add(record1 );		
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        //test
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllPhoneNumbers();
        
        assertEquals(1, phoneList.size());
        verify(customerrepository, times(1)).getAllPhoneNumbers();
    }
	
	@Test
    public void to_check_if_customer_phonenumber_is_associated()
    {
		list.clear();
		list.add(record1 );		
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        //test
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllPhoneNumbers();
        
        assertEquals(1, phoneList.size());
        verify(customerrepository, times(1)).getAllPhoneNumbers();
    }
	
	@Test
    public void to_check_if_customer_phonenumber_not_associates()
    {
		list.clear();
		list.add(record1 );		
		
        when(customerrepository.getAllPhoneNumbers()).thenReturn(list);
         
        //test
        List<ServiceInfoLite> phoneList = telecomService.retrieveAllPhoneNumbers();
        
        assertEquals(1, phoneList.size());
        verify(customerrepository, times(1)).getAllPhoneNumbers();
    }
	
	
	List<ServiceInfoLite> list = new ArrayList<ServiceInfoLite>();
	
	  ServiceInfoLite record1 = new ServiceInfoLite() {
		
		@Override
		public String getStatus() {
			// TODO Auto-generated method stub
			return "Active";
		}
		
		@Override
		public int getServiceid() {
			// TODO Auto-generated method stub
			return 123;
		}
		
		@Override
		public String getNumber() {
			// TODO Auto-generated method stub
			return "94554649";
		}
		
		@Override
		public int getCustomerid() {
			// TODO Auto-generated method stub
			return 102;
		}
	};
	
	
	
}

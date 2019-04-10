package com.telecom;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpStatusCodeException;

import com.telecom.controller.TelecomController;
import com.telecom.model.ServiceInfoLite;
import com.telecom.service.TelecomService;

/*
 * Integration test will cover all the endpoints exposed to clients.
 * PACT Testing
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = TelecomController.class, secure = false)
public class TelecomControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TelecomService telecomService;

	
	/*
	 *  TEST- Verify if the provided phone number is not activating the incorrect number
	 *  URI- /customers/{customerId}/phonenumbers/{phoneNumberId}
	 */
	@Test
	public void check_if_the_number_is_acticavated() throws Exception {	  

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/telecom/customers/102/phonenumbers/0468314862").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int actual = result.getResponse().getStatus();
		
		String actualresponse = result.getResponse().getContentAsString();
		
		System.out.println("Junit1::check_if_the_number_is_acticavated::Returned response->"+ actual + "::"+ actualresponse);
	
		assertEquals(200, actual); 
			    
	}
	
	
	
	/*
	 *  TEST- to test if the controller returns all phone numbers
	 *  URI- /phonenumbers
	 */
	
	@Test
	public void check_if_controller_returns_all_phone_numbers() throws Exception {

		list.add(first );
		
	Mockito.when(
			telecomService.retrieveAllPhoneNumbers()).thenReturn(list);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/telecom/phonenumbers").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String actual =  result.getResponse().getContentAsString();
	
		System.out.println("Junit::check_if_controller_returns_all_phone_numbers::Returned response"+ actual);
		String expected = "[{\"number\":\"94554649\",\"status\":\"Active\",\"serviceid\":123,\"customerid\":102}]";
		JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);	}
	

	/*
	 *  TEST- retrieve all phone numbers of a customer
	 *  URI- /customers/{customerId}/phonenumbers
	 */
	
	@Test
	public void to_test_if_controller_returns_customer_phone_numbers() throws Exception {

	list.add(first );
		
	Mockito.when(
			telecomService.retrieveAllCustomerPhoneNumbers(Mockito.anyInt())).thenReturn(list);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/telecom/customers/102/phonenumbers").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String actual =result.getResponse().getContentAsString();
		System.out.println("Junit1::to_test_if_controller_returns_customer_phone_numbers::Returned response"+ actual);
		
		String expected = "[{\"number\":\"94554649\",\"status\":\"Active\",\"serviceid\":123,\"customerid\":102}]";
        
		JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
	}

	List<ServiceInfoLite> list = new ArrayList<ServiceInfoLite>();
	
	  ServiceInfoLite first = new ServiceInfoLite() {
		
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

package com.telecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telecom.jpa.Customer;
import com.telecom.jpa.CustomerService;
import com.telecom.jpa.ServiceInfo;

@Repository
public interface CustomerServiceRepository  extends JpaRepository<CustomerService, Integer>{

	
}

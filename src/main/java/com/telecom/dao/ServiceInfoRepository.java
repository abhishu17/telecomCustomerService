package com.telecom.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.jpa.ServiceInfo;

@Repository
public interface ServiceInfoRepository  extends JpaRepository<ServiceInfo, Long>{

	@Modifying(clearAutomatically = true)
	@Query("update ServiceInfo a set a.status =:status where a.number =:phoneNumber ")
	@Transactional
	public int updateMobileActivationStatus(String phoneNumber, String status);
	
	//@Query("select s.number, s.serviceid from ServiceInfo s")
	List<ServiceInfo> findAll();

	
}

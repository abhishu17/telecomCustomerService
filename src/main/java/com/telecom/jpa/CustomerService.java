package com.telecom.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customerservice")
public class CustomerService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id   
    @Column(name="id")
    private int id;
    
    @Column(name="customerid")
    private int customerid;
    
    @Column(name="serviceid")
    private int serviceid;
    
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="serviceid", referencedColumnName = "serviceid")
    private List<ServiceInfo> serviceinfos;

    
    
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCustomerid() {
		return customerid;
	}



	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}



	public int getServiceid() {
		return serviceid;
	}



	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}



	public List<ServiceInfo> getServiceinfos() {
		return serviceinfos;
	}



	public void setServiceinfos(List<ServiceInfo> serviceinfos) {
		this.serviceinfos = serviceinfos;
	}



	@Override
	public String toString() {
		return "CustomerService [id=" + id + ", customerid=" + customerid + ", serviceid=" + serviceid
				+ ", serviceinfos=" + serviceinfos + "]";
	}
    

	
    
    

}

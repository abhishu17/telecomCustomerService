package com.telecom.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
	
    @Id   
    @Column(name="customerid")
    private int customerid;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="lastname")
    private String Lastname;
    
    @Column(name="dateofbirth")
    private Date  dateofbirth;
    
    @Column(name="gender")
    private String gender;
    
    
    @Column(name="customersince")
    private Date  customersince;
    
    @Column(name="addressid")
    private int addressid;
    
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="customerid", referencedColumnName = "customerid")
    private List<CustomerService> customerservice;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCustomersince() {
		return customersince;
	}

	public void setCustomersince(Date customersince) {
		this.customersince = customersince;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public List<CustomerService> getCustomerservice() {
		return customerservice;
	}

	public void setCustomerservice(List<CustomerService> customerservice) {
		this.customerservice = customerservice;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", Lastname=" + Lastname
				+ ", dateofbirth=" + dateofbirth + ", gender=" + gender + ", customersince=" + customersince
				+ ", addressid=" + addressid + ", customerservice=" + customerservice + "]";
	}
    

	
    
    

    
}
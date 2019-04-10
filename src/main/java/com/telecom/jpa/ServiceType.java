package com.telecom.jpa;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "servicetype")
public class ServiceType {
 
	@Id
    @Column(name="servicetypeid")
    private int servicetypeid;
    
	
    @Column(name="servicename")
    private String servicename;


	public int getServicetypeid() {
		return servicetypeid;
	}


	public void setServicetypeid(int servicetypeid) {
		this.servicetypeid = servicetypeid;
	}


	public String getServicename() {
		return servicename;
	}


	public void setServicename(String servicename) {
		this.servicename = servicename;
	}


	@Override
	public String toString() {
		return "ServiceType [servicetypeid=" + servicetypeid + ", servicename=" + servicename + "]";
	}
    
   
    /*@Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = ServiceInfo.class,mappedBy = "servicetype", cascade = CascadeType.ALL)
    private Set<ServiceInfo> serviceInfos;
    
    public Set<ServiceInfo> getServiceInfos() {
        return serviceInfos;
    }

    public void setServiceInfos(Set<ServiceInfo> serviceInfos) {
        this.serviceInfos = serviceInfos;
    }*/
    
	
    
    
    

	
    

}

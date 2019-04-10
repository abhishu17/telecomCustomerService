package com.telecom.jpa;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@IdClass(ServiceInfo.class)
@Table(name = "serviceinfo")
public class ServiceInfo  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="serviceid")
    private int serviceid;
    
	/*@Id
    @Column(name="servicetid")
    private int serviceTypeId;*/
    
	@Column(name="planid")
    private int planid;
    
    /*Assumption: Each service type must have a number assoiated with it */
    @Column(name="number")
    private String number;
    
    @Column(name="status")
    private String status;
    

    

    
    @Access(AccessType.PROPERTY)
    @ManyToOne()
    @JoinColumn(name="servicetypeid", referencedColumnName = "servicetypeid")
    private ServiceType servicetypeid;
    
    	
	public ServiceType getServicetypeid() {
		return servicetypeid;
	}

	public void setServicetypeid(ServiceType servicetypeid) {
		this.servicetypeid = servicetypeid;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	/*public int getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}*/

	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

	@Override
	public String toString() {
		return "ServiceInfo [serviceIds=" + serviceid + ", serviceTypeId=" + ", planId=" + planid
				+ ", number=" + number + ", status=" + status + "]";
	}
    

	
    

}

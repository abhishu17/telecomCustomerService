package com.telecom.model;

/*This interface is lighter version of service information*
 and used to show information to end user */

/*Projection interface declaration*/

public interface ServiceInfoLite {	
	

	int getCustomerid();
	int getServiceid();
	String getStatus();
	String getNumber();
}

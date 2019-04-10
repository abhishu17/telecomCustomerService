package com.telecom.model;

public class TelecomActionResponse {
	private String action;
	private String phonenumber;
	private int customerId;
	private String result;
	private String message;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public TelecomActionResponse(String action, String phonenumber, int customerId) {
		super();
		this.action = action;
		this.phonenumber = phonenumber;
		this.customerId = customerId;
	}
	public TelecomActionResponse(String action, String phonenumber) {
		super();
		this.action = action;
		this.phonenumber = phonenumber;
	}
	
	public TelecomActionResponse(String action, String phonenumber, String result, String message) {
		super();
		this.action = action;
		this.phonenumber = phonenumber;
		this.result = result;
		this.message = message;
	}
	
	
	
	
}
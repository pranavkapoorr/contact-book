package com.pranavkapoorr.contactbook.model;

import java.io.Serializable;

public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String firstName, lastName, cellPhone, homePhone, address, createdTime, updatedTime;
	
	public Contact(){}
	public Contact(String firstName, String lastName, String cellPhone, String homePhone, String address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellPhone = cellPhone;
		this.homePhone = homePhone;
		this.address = address;
		this.createdTime = "";
		this.updatedTime = "";
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getAddress() {
		return address;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}
	
	public void setId(int Id) {
		this.id = Id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	@Override
	public String toString() {
		return "["
				+"id:\""+this.id+"\""
				+"firstName:\""+this.firstName+"\""
				+"lastName:\""+this.lastName+"\""
				+"cellPhone:\""+this.cellPhone+"\""
				+"homePhone:\""+this.homePhone+"\""
				+"address:\""+this.address+"\""
				+"createdTime:\""+this.createdTime+"\""
				+"updatedTime:\""+this.updatedTime+"\""
				+"]";
	}
	
}

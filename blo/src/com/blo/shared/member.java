package com.blo.shared;

import java.io.Serializable;

public class member implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String org;
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConfirmpassword() {
		return Confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}
	public String address;
	 public String phonenumber;
	 public String email;
	 
	public String Password;
	public String Confirmpassword;
	
	}
	
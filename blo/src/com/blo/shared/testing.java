package com.blo.shared;

import java.io.Serializable;

public class testing implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String ph;
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String otp;
	public String res;
	public String epic;
	public String getEpic() {
		return epic;
	}
	public void setEpic(String epic) {
		this.epic = epic;
	}
}

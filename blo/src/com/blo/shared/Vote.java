package com.blo.shared;



import java.io.Serializable;

public class Vote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String epic;
	
	public String getEpic() {
		return epic;
	}

	public void setEpic(String epic) {
		this.epic = epic;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public String Name;
	
	public String address;
	
	public int ph;
	
	public int res;

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}
}


package com.blo.shared;

import java.io.Serializable;

public class verify implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public String epic_no;
 public String addr;
 public String f_name;
 public String res;
public String getRes() {
	return res;
}
public void setRes(String res) {
	this.res = res;
}
public String getEpic_no() {
	return epic_no;
}
public void setEpic_no(String epic_no) {
	this.epic_no = epic_no;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getF_name() {
	return f_name;
}
public void setF_name(String f_name) {
	this.f_name = f_name;
}
 
 
}

package com.blo.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;



public class Myspace {
	static Myspace me=null;
	Blog a1=null;
	Slog a2=null;
	BReg a3=null;
	Sreg a4=null;
	blvo a5=null;
	
	private Myspace() {
		
	}
	static Myspace getInstance()
	{
		if(me==null) {
			me=new Myspace();
		}
		return me;
		
	}
	public void koifucntion()
	{
		if (History.getToken().equals("a1"))
		{
			RootPanel.get("tt2").clear();
			RootPanel.get("tt2").add(getBlog());
		
			
		}
		if (History.getToken().equals("a2"))
		{
			RootPanel.get("tt2").clear();
			RootPanel.get("tt2").add(getSlog());
		
			
		}
		if (History.getToken().equals("a3"))
		{
			RootPanel.get("tt2").clear();
			RootPanel.get("tt2").add(getBReg());
		
			
		}
		if (History.getToken().equals("a4"))
		{
			RootPanel.get("tt2").clear();
			RootPanel.get("tt2").add(getSreg());
		
			
		}
		if (History.getToken().equals("a5"))
		{
			RootPanel.get("tt2").clear();
			RootPanel.get("tt2").add(getblvo());
		
			
		}
	}
		Blog getBlog() {
		if(a1==null)
		{
			a1=new Blog();
		}
		return a1;
	}
	Slog getSlog() {
		if(a2==null)
		{
			a2=new Slog();
		}
		return a2;
	}
	
	BReg getBReg() {
		if(a3==null)
		{
			a3=new BReg();
		}
		return a3;
	}
	
	Sreg getSreg() {
		if(a4==null)
		{
			a4=new Sreg();
		}
		return a4;
	}
	
	blvo getblvo() {
		if(a5==null)
		{
			a5=new blvo();
		}
		return a5;
	}
		


}

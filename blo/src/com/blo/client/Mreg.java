package com.blo.client;

import com.blo.shared.member;
import com.blo.shared.vreg;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Mreg extends Composite {

	private static MregUiBinder uiBinder = GWT.create(MregUiBinder.class);
	
	GreetingServiceAsync aa = GWT.create(GreetingService.class);

	interface MregUiBinder extends UiBinder<Widget, Mreg> {
	}

	public Mreg() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	@UiField
	MaterialTextBox t1;
	

	@UiField
	MaterialTextBox t2;
	

	@UiField
	MaterialTextBox t3;
	
	@UiField
	MaterialTextBox t4;
	
	@UiField
	MaterialTextBox t5;
	
	
	
	@UiField
	MaterialTextBox t6;
	
	

	@UiField
	MaterialButton b1;

	
	
	
	@UiHandler("b1")
	void onClick(ClickEvent e) {
		String s1 = t1.getText();
		String s2 = t2.getText();
		String s3 = t3.getText();
		String s4 = t4.getText();
		String s5 = t5.getText();
		String s6 = t6.getText();
		
		if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty())
		{
		Window.alert("fill the entries");
	
		}
		
		else {
			
		
		
		Window.alert("Registered");

		member u = new member();
		
		
		u.setName(s1);
		u.setOrg(s2);
		u.setAddress(s3);
		u.setPhonenumber(s4);
		u.setEmail(s5);
		u.setPassword(s6);
		
		

		aa.mem(u, new AsyncCallback<member>() {

			public void onSuccess(member result) {
				// TODO Auto-generated method stub
				Window.alert("on success");

			}

			public void onFailure(Throwable caught) {
				Window.alert("on failure");
				// TODO Auto-generated method stub

			}
		});
		}
	}
}


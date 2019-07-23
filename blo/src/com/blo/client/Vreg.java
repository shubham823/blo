package com.blo.client;

import com.blo.shared.user;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Vreg extends Composite {

	private static BRegUiBinder uiBinder = GWT.create(BRegUiBinder.class);
	
	GreetingServiceAsync aa = GWT.create(GreetingService.class);

	interface BRegUiBinder extends UiBinder<Widget, Vreg> {
	}

	public Vreg() {
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
		
		Window.alert("Registered");

		vreg u = new vreg();
		
		
		u.setName(s1);
		u.setArea(s2);
		u.setAddress(s3);
		u.setPhonenumber(s4);
		u.setEmail(s5);
		u.setPassword(s6);
		
		

		aa.vidhan(u, new AsyncCallback<vreg>() {

			public void onSuccess(vreg result) {
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

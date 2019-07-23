package com.blo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.blo.client.GreetingService;
import com.blo.client.GreetingServiceAsync;
import com.blo.shared.testing;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class last extends Composite {
	GreetingServiceAsync aa=GWT.create(GreetingService.class);
	private static lastUiBinder uiBinder = GWT.create(lastUiBinder.class);

	interface lastUiBinder extends UiBinder<Widget, last> {
	}

	public last() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		
		
		
		
b1.addClickHandler(new ClickHandler() {  //generate otp vala ha yeh
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub	
				testing t=new testing();	
				String s1=t2.getText();
				t.setEpic(s1);
				 aa.verification(t,new AsyncCallback<testing>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					Window.alert("nai chala");	
					}

					@Override
					public void onSuccess(testing result) {
						// TODO Auto-generated method stub
						Window.alert("otp is sent");
						
					}
					 
					 
				});
				
				
				
				
				
				
			}
		});
		b2.addClickHandler(new ClickHandler() {  //check vala ha
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				testing t=new testing();
				String st=t1.getText();//otp
				String s1=t2.getText();//phone number
				t.setEpic(s1);//set kia
				//t.setOtp(st);
				aa.checki(t,new AsyncCallback<testing>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(testing result) {
						// TODO Auto-generated method stub
						String l=result.getRes();
						if(st.equals(l))//checking
						{
							Window.alert("otp matched");
						}
						else
						{Window.alert("otp not matched");
						}
					}
					
				});
				
			}
		});
		
	}

	@UiField
	MaterialButton b1;
	
	@UiField
	MaterialTextBox t1;

	@UiField
	MaterialButton b2;
	@UiField
	MaterialTextBox t2;// epic number fetch kia
	

	
	

}

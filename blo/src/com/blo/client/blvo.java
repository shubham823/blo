package com.blo.client;

import com.blo.shared.*;
import com.blo.client.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

import com.blo.shared.Vote;

public class blvo extends Composite {

	private static blvoUiBinder uiBinder = GWT.create(blvoUiBinder.class);

	interface blvoUiBinder extends UiBinder<Widget, blvo> {
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	public blvo() {
		  initWidget(uiBinder.createAndBindUi(this));
		  History.addValueChangeHandler(new ValueChangeHandler<String>() {
				
				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					// TODO Auto-generated method stub
					Myspace.getInstance().koifucntion();
					
				}
			});
		  
		  b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String epic=t1.getText();//epic
				String name=t2.getText();//name
				String add=t3.getText();//address
				int ph=Integer.parseInt(t4.getText()); //phone number
				Vote v=new Vote();
				v.setAddress(add);
				v.setEpic(epic);
				v.setName(name);
				v.setPh(ph);
				a1.log(v, new AsyncCallback<Vote>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
				
						Window.alert("server bhaiya busy hai!! try after sometime");
					}

					@Override
					public void onSuccess(Vote result) {
						// TODO Auto-generated method stub
						int k=result.getRes();
						if(k==1)
							
						{	RootPanel.get("tt2").clear();
							RootPanel.get("tt2").add(new last());
							Window.alert("verified ho tum");
						}
						else {
							Window.alert("verified nai ho");
						}
						
					}
				});
			}
		});
	}
	@UiField MaterialButton b1;
	@UiField MaterialTextBox t1;
	@UiField MaterialTextBox t2;
	@UiField MaterialTextBox t3;
	@UiField MaterialTextBox t4;
	
	
} 
	
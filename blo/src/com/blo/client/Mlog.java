package com.blo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Mlog extends Composite  {

	GreetingServiceAsync aa=GWT.create(GreetingService.class);
	
	private static MlogUiBinder uiBinder = GWT.create(MlogUiBinder.class);

	interface MlogUiBinder extends UiBinder<Widget, Mlog> {
	}

	public Mlog() {
		initWidget(uiBinder.createAndBindUi(this));
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myspace.getInstance().koifucntion();
				
		}
	});

	}
	@UiField
	MaterialTextBox t1;
	
	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialButton b1 ;
	
	@UiField
	Label l;
  
	
	@UiHandler("l")
	void onClick1(ClickEvent e) {
	
		RootPanel.get("tt1").clear();
		RootPanel.get("tt1").add(new Mreg());
		
	//		History.newItem("a9");
	//	Myspace.getInstance().koifucntion();
		
		
	}
	

	@UiHandler("b1")
	void onClick(ClickEvent e) {
		String s1 = t1.getText();//email
		String s2 = t2.getText();//pw
		aa.Mlogin(s1,s2, new AsyncCallback<String>() {

			public void onSuccess(String result) {
				// TODO Auto-generated method stub
			if(result.equals("yes"))
			{
			Window.alert("on success");
			RootPanel.get("tt1").clear();
			RootPanel.get("tt1").add(new home());//votee call
		//	History.newItem("a10");
		//	Myspace.getInstance().koifucntion();
			

		}else {
			Window.alert("no data");
		}
			}
		public void onFailure(Throwable caught) {
			Window.alert("on failure");
			// TODO Auto-generated method stub

		}
	});
	
}
}

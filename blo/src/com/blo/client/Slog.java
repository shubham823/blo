package com.blo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Slog extends Composite {

	private static SlogUiBinder uiBinder = GWT.create(SlogUiBinder.class);
	
	GreetingServiceAsync aa=GWT.create(GreetingService.class);

	interface SlogUiBinder extends UiBinder<Widget, Slog> {
	}

	public Slog() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	

	@UiField
	MaterialTextBox t1;
	
	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialButton b1;
 
	
	
	

	@UiHandler("b1")
	void onClick(ClickEvent e) {
		String s1 = t1.getText();
		String s2 = t2.getText();
	   
		
		
		aa.Slogin(s1,s2, new AsyncCallback<String>() {

			public void onSuccess(String result) {
				// TODO Auto-generated method stub
			if(result.equals("yes"))
			{
			Window.alert("on success");
			RootPanel.get("tt2").clear();
			RootPanel.get("tt2").add(new monitor());
			

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

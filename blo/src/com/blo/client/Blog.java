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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Blog extends Composite {
	GreetingServiceAsync aa=GWT.create(GreetingService.class);
	private static BlogUiBinder uiBinder = GWT.create(BlogUiBinder.class);

	interface BlogUiBinder extends UiBinder<Widget, Blog> {
	}

	public Blog() {
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
  
	
	
	

	@UiHandler("b1")
	void onClick(ClickEvent e) {
		String s1 = t1.getText();//email
		String s2 = t2.getText();//pw
		aa.login(s1,s2, new AsyncCallback<String>() {

			public void onSuccess(String result) {
				// TODO Auto-generated method stub
			if(result.equals("yes"))
			{
			Window.alert("on success");
		//	RootPanel.get("tt2").clear();
		//	RootPanel.get("tt2").add(new blvo());//votee call
			History.newItem("a5");
			Myspace.getInstance().koifucntion();
			

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

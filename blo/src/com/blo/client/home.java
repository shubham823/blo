package com.blo.client;

import com.google.gwt.core.client.GWT;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import com.blo.client.Myspace;
import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialLink;

public class home extends Composite {

	private static homeUiBinder uiBinder = GWT.create(homeUiBinder.class);

	interface homeUiBinder extends UiBinder<Widget, home> {
	}


	public home() {
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
				//RootPanel.get("tt2").clear();
				//RootPanel.get("tt2").add(new Blog());
				History.newItem("a1");
				Myspace.getInstance().koifucntion();
			}
		});
b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				//RootPanel.get("tt2").clear();
				//RootPanel.get("tt2").add(new Slog());
				History.newItem("a2");
				Myspace.getInstance().koifucntion();
				
			}
		});
b3.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		//RootPanel.get("tt2").clear();
		//RootPanel.get("tt2").add(new BReg());
		History.newItem("a3");
		Myspace.getInstance().koifucntion();
		
	}
});

b4.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		//RootPanel.get("tt2").clear();
		//RootPanel.get("tt2").add(new Sreg());
		History.newItem("a4");
		Myspace.getInstance().koifucntion();
		
	}
});

b5.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		RootPanel.get("tt2").clear();
	
		
		
	}
});
b6.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		RootPanel.get("tt2").clear();
		RootPanel.get("tt2").add(new vlog());
		
	}
});

b7.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		RootPanel.get("tt2").clear();
		RootPanel.get("tt2").add(new Vreg());
		
	}
});
	}
	@UiField
	MaterialLink b1;
	
	@UiField
	MaterialLink b2;
	
	@UiField
	MaterialLink b3;

	@UiField
	MaterialLink b4;
	@UiField
	MaterialLink b5;
	
	@UiField
	MaterialLink b6;
	@UiField
	MaterialLink b7;
	
}




package com.blo.client;

import com.blo.shared.verify;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Otp extends Composite {

	private static OtpUiBinder uiBinder = GWT.create(OtpUiBinder.class);

	interface OtpUiBinder extends UiBinder<Widget, Otp> {
	}

	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	public Otp() {
		initWidget(uiBinder.createAndBindUi(this));

		b1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				verify v = new verify();
				a1.hh(v, new AsyncCallback<verify>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("nai chala");

					}

					@Override
					public void onSuccess(verify result) {
						// TODO Auto-generated method stub
						Window.alert(result.getRes());
						t1.setText(result.getF_name());
						t2.setText(result.getAddr());
						//Window.alert("chl- gaya");
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
	MaterialTextBox t2;
}
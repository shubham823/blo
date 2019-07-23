package com.blo.client;

import java.util.Arrays;
import java.util.List;

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
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.blo.client.GreetingService;
import com.blo.client.GreetingServiceAsync;

import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialCollapsibleBody;
import gwt.material.design.client.ui.MaterialCollapsibleHeader;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialLabel;

public class monitor extends Composite  {

	private static monitorUiBinder uiBinder = GWT.create(monitorUiBinder.class);
	
	GreetingServiceAsync aa = GWT.create(GreetingService.class);

	@UiField
	 MaterialCollapsible maco;

	interface monitorUiBinder extends UiBinder<Widget, monitor> {
	}

	public monitor() {
		initWidget(uiBinder.createAndBindUi(this));
	

		MaterialCollapsibleItem mci=new MaterialCollapsibleItem();
		MaterialCollapsibleHeader mch =new MaterialCollapsibleHeader();
		MaterialCollapsibleBody mcb=new MaterialCollapsibleBody();
		
		MaterialLabel h=new MaterialLabel("RAMU");
		mch.add(h);
		
		/*MaterialLabel bodylb=new MaterialLabel("matter");
		bodylb.setFontSize("20px");
		mcb.add(bodylb);*/
		mch.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				mcb.clear();
				aa.mono("ramu", new AsyncCallback<List<String>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(List<String> result) {
						// TODO Auto-generated method stub
						//MaterialLabel l=new MaterialLabel(result.toString());	
						MaterialLabel j=new MaterialLabel("verified list of voter");
						MaterialLabel l=new MaterialLabel(Arrays.toString(result.toArray()));	
					int c=result.size();
							/*for(int i=0;i<c;i++)
							{
								result.toString();
							}
							*/
					String s=Integer.toString(c);
					MaterialLabel t=new MaterialLabel("number of verifeid voter "+s+"");
					MaterialLabel k=new MaterialLabel(" ");
					j.setFontSize("20px");
					t.setFontSize("20px");
					l.setFontSize("20px");
					mcb.add(j);	
					mcb.add(l);
					mcb.add(t);
					//mcb.add(k);
					}
					
				});

				
						
						
						
						
					
					
				
				
				
			}
		});
		
		
		

		
		
		mci.add(mch);
		mci.add(mcb);
		maco.add(mci);

		}
	
	
	
	}

	
	

	
	


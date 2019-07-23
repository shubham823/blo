package com.blo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.blo.shared.testing;
import com.blo.shared.Vote;
import com.blo.shared.secreg;
import com.blo.shared.user;
import com.blo.shared.verify;
import com.blo.shared.member;

import java.util.List;

import com.blo.shared.*;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	 void login(String s1,String s2, AsyncCallback<String> callback)throws IllegalArgumentException;
	 void log(Vote v, AsyncCallback<Vote> callback)throws IllegalArgumentException;
	 void hh(verify v, AsyncCallback<verify> callback) throws IllegalArgumentException;
	 void sector(user u, AsyncCallback<user> callback) throws IllegalArgumentException;
	 void Slogin(String s1,String s2, AsyncCallback<String> callback)throws IllegalArgumentException;
	 void sec(secreg u, AsyncCallback<secreg> callback);

		void verification(testing t, AsyncCallback<testing> callback) throws IllegalArgumentException;
	void checki(testing t, AsyncCallback<testing> callback) throws IllegalArgumentException;
	void mono(String input, AsyncCallback<List<String>> callback) throws IllegalArgumentException;
	void Vlogin(String s1,String s2, AsyncCallback<String> callback)throws IllegalArgumentException;
	 void vidhan(vreg u, AsyncCallback<vreg> callback) throws IllegalArgumentException;
	 void Vmono(String input, AsyncCallback<List<String>> callback) throws IllegalArgumentException;
	 void Mlogin(String s1,String s2, AsyncCallback<String> callback)throws IllegalArgumentException;
	 void mem(member u, AsyncCallback<member> callback) throws IllegalArgumentException;
}

package com.blo.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.blo.shared.testing;

import java.util.List;
import com.blo.shared.member;
import com.blo.shared.Vote;
import com.blo.shared.secreg;
import com.blo.shared.user;
import com.blo.shared.verify;
import com.blo.shared.vreg;
/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String login (String s1,String s2) throws IllegalArgumentException;
Vote log(Vote v) throws IllegalArgumentException;
verify hh(verify v) throws IllegalArgumentException;
user sector(user u) throws IllegalArgumentException;
String Slogin (String s1,String s2) throws IllegalArgumentException;
secreg sec(secreg u) throws IllegalArgumentException;

testing verification(testing t) throws IllegalArgumentException;
testing checki(testing t) throws IllegalArgumentException;

List<String> mono(String blo) throws IllegalArgumentException;
String Vlogin (String s1,String s2) throws IllegalArgumentException;
vreg vidhan(vreg u) throws IllegalArgumentException;
List<String> Vmono(String blo) throws IllegalArgumentException;
String Mlogin (String s1,String s2) throws IllegalArgumentException;
member mem(member u) throws IllegalArgumentException;
}

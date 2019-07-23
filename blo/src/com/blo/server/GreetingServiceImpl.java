package com.blo.server;
import com.blo.shared.Vote;
import com.blo.shared.secreg;
import com.blo.shared.user;
import com.blo.shared.verify;
import com.blo.shared.vreg;
import com.blo.shared.member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.blo.client.GreetingService;
import com.blo.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.blo.shared.testing;


/**
 * The server-side implementation of the RPC service.
 */

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	Connection con=null;
	Statement st=null;
	
	public void init()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vote","root","root"); 
			st=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	 

	

     public String login(String s1,String s2) throws IllegalArgumentException
     {
	    
    	 init(); 
		
		String ss="NO";
	
		ResultSet rs=null;
		
		try {
			
		rs=st.executeQuery("select * from blo where email='"+s1+"' and password='"+s2+"'"); 
	
		if(rs.next())
		{
			ss="yes";		}                              
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		
		
		}
		return ss;
	}
     @Override
 	public Vote log(Vote v) throws IllegalArgumentException {  // yaha par voter ka phone epic aur  kara deta ha otp vala table ma
 		// TODO Auto-generated method stub
 		init();

 		ResultSet rs = null;
 		String addr = v.getAddress();
 		int ph= v.getPh();
 		String epic=v.getEpic();
 		String nam=v.getName();
 		String pho=Integer.toString(ph);// phone nmuber lia
 		String s2="";// otp ka lia
 		try {
 			PreparedStatement pt1=null;
 			pt1=con.prepareStatement("insert into otp values(?,?,?,?,?)");
 			pt1.setString(1,pho);
			pt1.setString(2,nam);
			pt1.setString(3,"0");//ststus
			pt1.setString(4,epic);
			pt1.setString(5,s2);//otp null dia ha
			pt1.executeUpdate();
 			rs = st.executeQuery("select epicno from crawl2 where address='" + addr + "'");
 			if (rs.next()) {
 				v.setRes(1);
 			} else {
 				v.setRes(0);
 			}

 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return v;
 	}
     @Override
 	public verify hh(verify v) throws IllegalArgumentException {
 		// TODO Auto-generated method stub
 		init();
 		ResultSet rs = null;
 		Vote a1=new Vote();
 		
 		String epic = a1.getEpic(); // values come from blo-voter-login 
 		
 		try {
 			rs = st.executeQuery("select fname, address from crawl2 where epicno ='epic'");

 			if (rs.next()) {
 				v.setF_name(rs.getString(1));
 				//System.out.println("Mei aaya");
 				v.setAddr(rs.getString(2));
 			}
 		} catch (SQLException e) {
 		//	System.out.println("Bhut Hua AB");
 		}

 		//v.setRes("ASDASDASD");
 		return v;
 	}
     @Override
 	public user sector(user u) throws IllegalArgumentException {
 		// TODO Auto-generated method stub
     
     init();
		
		String s1 = u.getName();
		String s2 = u.getWardnumber();
		String s3 = u.getAddress();
		String s4 = u.getPhonenumber();
		String s5 = u.getEmail();
		String s6 = u.getPassword();
		
		try
		{   
			PreparedStatement pt1=null;
			pt1=con.prepareStatement("insert into blo values(?,?,?,?,?,?)");
			pt1.setString(1,s1);
			pt1.setString(2,s2);
			pt1.setString(3,s3);
			pt1.setString(4,s4);
			pt1.setString(5,s5);
			pt1.setString(6,s6);
			
			pt1.executeUpdate();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		return u;

	
	}
     
     public String Slogin(String s1,String s2) throws IllegalArgumentException
     {
	    
    	 init(); 
		
		String ss="NO";
	
		ResultSet rs=null;
		
		try {
			
		rs=st.executeQuery("select * from sector where email='"+s1+"' and password='"+s2+"'"); 
	
		if(rs.next())
		{
			ss="yes";		}                              
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		
		
		}
		return ss;
	}
     
     @Override
 	public secreg sec(secreg u) throws IllegalArgumentException {
 		// TODO Auto-generated method stub
     
     init();
		
		String s1 = u.getName();
		String s2 = u.getWardnumber();
		String s3 = u.getAddress();
		String s4 = u.getPhonenumber();
		String s5 = u.getEmail();
		String s6 = u.getPassword();
		
		try
		{   
			PreparedStatement pt1=null;
			pt1=con.prepareStatement("insert into sector values(?,?,?,?,?,?)");
			pt1.setString(1,s1);
			pt1.setString(2,s2);
			pt1.setString(3,s3);
			pt1.setString(4,s4);
			pt1.setString(5,s5);
			pt1.setString(6,s6);
			
			pt1.executeUpdate();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		return u;

	
	}
     @Override
 	public testing verification(testing t) throws IllegalArgumentException { // yaha par changes honga
 		// TODO Auto-generated method stub
 		init();
 		int k=0;
 		 PreparedStatement pt1=null;
 		
 		 Random r=new Random(System.currentTimeMillis());
 		 String a=Integer.toString((1+r.nextInt(2))*1000+r.nextInt(1000));
 		 String s1=t.getEpic();
 		try {
			k=st.executeUpdate("update otp set otp='"+a+"' where epicno= '"+s1+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		// k=st.executeUpdate("insert into otp values('"+ph+"','"+a+"')");
 		 System.out.print(a);
		/*
		 * try { pt1=con.prepareStatement("insert into otp values(?,?)");
		 * pt1.setString(1,ph); pt1.setString(2,a); pt1.executeUpdate(); }
		 * catch(Exception ee){ ee.printStackTrace();
		 * 
		 * }
		 */
 	
 		return t;
 	}


     @Override
 	public testing checki(testing t) throws IllegalArgumentException {
 		// TODO Auto-generated method stub
 		String str=t.getEpic();//get kia
 		//String ph=t.getPh();
 		ResultSet rs=null;
 		ResultSet rt=null;
 		//String ph="123456786";
 		
 		try {
 		rs=st.executeQuery("select otp from otp where epicno='"+str+"'"); 
 		String s="1";
 		if (rs.next())
 		{t.setRes(rs.getString(1));
 		int k=st.executeUpdate("update otp set status='"+s+"' where epicno='"+str+"'");
 	//	int j=st.executeUpdate("update crwal2 set status='"+s+"' where epicno= '"+str+"'");
 		rt=st.executeQuery("select address from crawl2 where epicno='"+str+"'");
 			if(rt.next())
 			{
 				String gh=rt.getString(1);
 				int j=st.executeUpdate("update crawl2 set status='"+s+"' where address='"+gh+"'");
 			}
 		
 		
 		
 		}
 	}
 		catch (SQLException e)  //run karwaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 		{
 			
 		}
 		return t;
 	}
     @Override
 	public List<String> mono(String blo) throws IllegalArgumentException {
 		// TODO Auto-generated method stub
 		//String[][] rt =new String[20][2];
 		List<String> rt=new ArrayList<>();
 		ResultSet rs=null;
 		String s="1";
 		try {
 			rs=st.executeQuery("select name from crawl2 where status='"+s+"' and blo='"+blo+"'");
 			int i=0;
 			while(rs.next())
 			{
 				rt.add(rs.getString(1));
 				i++;
 			}
 			
 			
 			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		return rt;
 		
 	}





	@Override
	public String Vlogin(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		 init(); 
			
			String s="NO";
		
			ResultSet rs=null;
			
			try {
				
			rs=st.executeQuery("select * from vidhan where email='"+s1+"' and password='"+s2+"'"); 
		
			if(rs.next())
			{
				s="yes";		}                              
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			
			
			}
			return s;
	}





	@Override
	public vreg vidhan(vreg u) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		 init();
	 		
	 		String s1 = u.getName();
	 		String s2 = u.getArea();
	 		String s3 = u.getAddress();
	 		String s4 = u.getPhonenumber();
	 		String s5 = u.getEmail();
	 		String s6 = u.getPassword();
	 		
	 		try
	 		{   
	 			PreparedStatement pt1=null;
	 			pt1=con.prepareStatement("insert into vidhan values(?,?,?,?,?,?)");
	 			pt1.setString(1,s1);
	 			pt1.setString(2,s2);
	 			pt1.setString(3,s3);
	 			pt1.setString(4,s4);
	 			pt1.setString(5,s5);
	 			pt1.setString(6,s6);
	 			System.out.print("challa");
	 			pt1.executeUpdate();
	 		}
	 		catch(Exception ee)
	 		{
	 			ee.printStackTrace();
	 		}
	 		
	 		return u;

		
	
	}





	@Override
	public List<String> Vmono(String blo) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		List<String> rt=new ArrayList<>();
 		ResultSet rs=null;
 		String s="1";
 		try {
 			rs=st.executeQuery("select name from crawl2 where status='"+s+"' and blo='"+blo+"'");
 			int i=0;
 			while(rs.next())
 			{
 				rt.add(rs.getString(1));
 				i++;
 			}
 			
 			
 			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		return rt;
	}
	



	@Override
	public String Mlogin(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		 init(); 
			
			String s="NO";
		
			ResultSet rs=null;
			
			try {
				
			rs=st.executeQuery("select * from member where email='"+s1+"' and password='"+s2+"'"); 
		
			if(rs.next())
			{
				s="yes";		}                              
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			
			
			}
			return s;
	}





	@Override
	public member mem(member u) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		 init();
	 		
	 		String s1 = u.getName();
	 		String s2 = u.getOrg();
	 		String s3 = u.getAddress();
	 		String s4 = u.getPhonenumber();
	 		String s5 = u.getEmail();
	 		String s6 = u.getPassword();
	 		
	 		try
	 		{   
	 			PreparedStatement pt1=null;
	 			pt1=con.prepareStatement("insert into member values(?,?,?,?,?,?)");
	 			pt1.setString(1,s1);
	 			pt1.setString(2,s2);
	 			pt1.setString(3,s3);
	 			pt1.setString(4,s4);
	 			pt1.setString(5,s5);
	 			pt1.setString(6,s6);
	 			
	 			pt1.executeUpdate();
	 		}
	 		catch(Exception ee)
	 		{
	 			ee.printStackTrace();
	 		}
	 		
	 		return u;

		
	}

     	

	 }			
		

	


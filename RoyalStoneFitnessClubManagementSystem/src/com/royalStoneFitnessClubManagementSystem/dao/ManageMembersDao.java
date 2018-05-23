package com.royalStoneFitnessClubManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ManageMembersDao {
	public static boolean addMember(String name, String aadharId, String contactNumber, String eMailAddress, String homeAddress, String packageId, String months){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("insert into rsfcms_members values (sequence_members_id.nextval,?,?,?,?,?,?,?)");   
			ps.setString(1,name);
			ps.setString(2,contactNumber);
			ps.setString(3,eMailAddress);  
			ps.setString(4,homeAddress);
			ps.setString(5,packageId);  
			ps.setString(6,aadharId);  	
			ps.setString(7,months);  
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}  
	public static boolean removeMember(String memberId){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("delete from rsfcms_members where id=?");   
			ps.setString(1,memberId);
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}
	public static boolean updateMember(String memberId, String name, String aadharId, String contactNumber, String eMailAddress, String homeAddress, String packageId, String months){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update rsfcms_members set id=?, name=?, aadhar_id=?, contact_number=?, email_address=?, home_address=?, package_id=?,  where id=?");   
			ps.setString(1,memberId);
			ps.setString(2,name);
			ps.setString(3,contactNumber);
			ps.setString(4,eMailAddress);  
			ps.setString(5,homeAddress);
			ps.setString(5,packageId);  
			ps.setString(7,aadharId);  
			ps.setString(8,memberId);
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}
}

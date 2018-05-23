package com.royalStoneFitnessClubManagementSystem.dao;

import java.sql.*;

public class AuthenticationDao {
	public static boolean validate(String loginId,String loginPassword){  
		boolean status=false;  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("select * from rsfcms_managers where manager_id=? and password=?");  
			ps.setString(1,loginId);  
			ps.setString(2,loginPassword);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}  
	public static boolean idExists(String loginId){  
		boolean status=false;  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("select * from rsfcms_managers where manager_id=?");  
			ps.setString(1,loginId);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	} 
}

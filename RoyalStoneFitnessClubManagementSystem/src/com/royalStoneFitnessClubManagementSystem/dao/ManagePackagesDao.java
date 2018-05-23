package com.royalStoneFitnessClubManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ManagePackagesDao {
	public static boolean add(String name, String price){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("insert into rsfcms_packages values (sequence_login_id.nextval,?,?)");   
			ps.setString(1,price);
			ps.setString(2,name);  
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}  
	public static boolean remove(String id){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("delete from rsfcms_packages where id=?");   
			ps.setString(1,id);
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}
	public static boolean update(String id, String name, String price){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update rsfcms_packages set name=?, price=? where id=?");   
			ps.setString(1,name);
			ps.setString(2,price);
			ps.setString(3,id);  
			      
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

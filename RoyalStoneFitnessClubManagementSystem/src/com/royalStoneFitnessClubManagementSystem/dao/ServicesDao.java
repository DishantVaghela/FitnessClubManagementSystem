package com.royalStoneFitnessClubManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicesDao {
	public static boolean validate(String managerId){  
		boolean status=false;  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("select * from rsfcms_managers where id=0 and manager_id=?");  
			ps.setString(1,managerId);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}  
}

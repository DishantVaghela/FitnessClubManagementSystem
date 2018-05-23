package com.royalStoneFitnessClubManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ManageManagersDao {
	public static boolean addManager(String managerId, String password, String recoveryQuestion, String recoveryAnswer){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("insert into rsfcms_managers values (sequence_managers_id.nextval,?,?,?,?)");   
			ps.setString(1,managerId);
			ps.setString(2,password);  
			ps.setString(3,recoveryQuestion);
			ps.setString(4,recoveryAnswer);  
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}  
	public static boolean removeManager(String managerId){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("delete from rsfcms_managers where manager_id=?");   
			ps.setString(1,managerId);
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}
	public static boolean updateManager(String managerId, String password, String recoveryQuestion, String recoveryAnswer){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update rsfcms_managers set manager_id=?, password=?, recovery_question=?, recovery_answer=? where manager_id=?");   
			ps.setString(1,managerId);
			ps.setString(2,password);
			ps.setString(3,recoveryQuestion);
			ps.setString(4,recoveryAnswer);  
			ps.setString(5,managerId);
			      
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

package com.royalStoneFitnessClubManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateInformationDao {
	public static boolean update(String mobileNumber, String emailId, String clubAddress, String mondayTiming, String tuesdayTiming, String wednesdayTiming, String thursdayTiming, String fridayTiming, String saturdayTiming, String sundayTiming, String services, String lastChangesBy){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update rsfcms_club set contact_number=?, email_address=?, club_address=?, monday_timing=?, tuesday_timing=?, wednesday_timing=?, thursday_timing=?, friday_timing=?, saturday_timing=?, sunday_timing=?, services=?, last_changes_by=? where id=?");   
			ps.setString(1,mobileNumber.equalsIgnoreCase("")?"not available":mobileNumber);  
			ps.setString(2,emailId.equalsIgnoreCase("")?"not available":emailId);
			ps.setString(3,clubAddress.equalsIgnoreCase("")?"not available":clubAddress);  
			ps.setString(4,mondayTiming.equalsIgnoreCase("")?"not available":mondayTiming);
			ps.setString(5,tuesdayTiming.equalsIgnoreCase("")?"not available":tuesdayTiming);  
			ps.setString(6,wednesdayTiming.equalsIgnoreCase("")?"not available":wednesdayTiming);
			ps.setString(7,thursdayTiming.equalsIgnoreCase("")?"not available":thursdayTiming);  
			ps.setString(8,fridayTiming.equalsIgnoreCase("")?"not available":fridayTiming);
			ps.setString(9,saturdayTiming.equalsIgnoreCase("")?"not available":saturdayTiming);  
			ps.setString(10,sundayTiming.equalsIgnoreCase("")?"not available":sundayTiming);
			ps.setString(11,services.equalsIgnoreCase("")?"not available":services);  
			ps.setString(12,lastChangesBy);
			ps.setInt(13,0);  
			      
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

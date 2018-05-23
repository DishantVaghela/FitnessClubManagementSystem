<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%	
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Royal Stone fitness club</title>
</head>
<body background="Background.jpg">	
	<%
		try{  
			PreparedStatement ps=con.prepareStatement("select m.*, p.* from rsfcms_members m, rsfcms_packages p where m.package_id=p.id");  
			ResultSet rs = ps.executeQuery(); 
	%>
	<%
			if (rs.next()){
				out.print("<table align=center width=600>");
				out.print("<tr><td valign=bottom><img src=RoyalStoneFitnessClubLogo.png height=200></td>");
				out.print("<td align=center><font color=red>Membership Bill<br>of<br>" + rs.getString(2) + "<br>by<br>" + session.getAttribute("session_id") + "</font></td></tr>");
				out.print("<tr><td colspan=2><br></td></tr>");
				out.print("<tr><td align=right><font color=red>ID: </font></td>");
				out.print("<td align=left>" + rs.getString(1) + "</td></tr>");
				out.print("<tr><td align=right><font color=red>Name: </font></td>");
				out.print("<td align=left>" + rs.getString(2) + "</td></tr>");
				out.print("<tr><td align=right><font color=red>Contact Number: </font></td>");
				out.print("<td align=left>" + rs.getString(3) + "</td></tr>");
				out.print("<tr><td align=right><font color=red>E-Mail Address: </font></td>");
				out.print("<td align=left>" + rs.getString(4) + "</td></tr>");
				out.print("<tr><td align=right><font color=red>Home Address: </font></td>");
				out.print("<td align=left>" + rs.getString(5) + "</td></tr>");
				out.print("<tr><td align=right><font color=red>Aadhar ID: </font></td>");
				out.print("<td align=left>" + rs.getString(7) + "</td></tr>");
				out.print("<tr><td align=right><font color=red>Package: </font></td>");
				out.print("<td align=left>" + rs.getString(11) + "</td></tr>");
				out.print("<tr><td align=right><font color=red>total Amount: </font></td>");
				out.print("<td align=left>Rs." + rs.getString(10) + " x " + rs.getString(8) + " months = Rs." + (rs.getInt(10))*(rs.getInt(8)) + "</td></tr>");
				
			    out.print("</table>");
		    } 
		}
		catch(Exception e){System.out.println(e);}
	%>
</body>
</html>
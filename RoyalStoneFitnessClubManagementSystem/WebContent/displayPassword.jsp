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
<title>Royal Stone fitness club - display password</title>
</head>
<body background="Background.jpg">
	<form action="services.jsp">
		<%
			try{  
				String loginId=(String)session.getAttribute("session_id");
				PreparedStatement ps=con.prepareStatement("select * from rsfcms_managers where manager_id=?");  
				ps.setString(1,loginId);  
				ResultSet rs = ps.executeQuery(); 
				if (rs.next()){
		%>
		<table align="center" width="600">
			<tr>
				<td align="center"><img src="RoyalStoneFitnessClubMiniLogo.png" width="300" height="70"></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td align="center" bgcolor="red">DISPLAY PASSWORD</td>
			</tr>
			<tr>
				<td align="center">your password is <%out.print(rs.getString(3));%></td>
			</tr>
			<% } } catch(Exception e){System.out.println(e);}%>
			<tr>
				<td align="center" >
				<input type="submit" value="go ahead">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
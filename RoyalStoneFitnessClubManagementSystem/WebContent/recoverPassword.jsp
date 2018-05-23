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
<title>Royal Stone fitness club - password</title>
</head>
<body background="Background.jpg">
	<form action="RecoverPasswordService" method="post">
		<%
			try{  
				String loginId=request.getParameter("textFieldId");
				PreparedStatement ps=con.prepareStatement("select * from rsfcms_managers where manager_id=?");  
				ps.setString(1,loginId);  
				ResultSet rs = ps.executeQuery(); 
				if (rs.next()){
		%>
		<table align="center" width="600">
			<tr>
				<td colspan="2" align="center"><img src="RoyalStoneFitnessClubMiniLogo.png" width="300" height="70"></td>
			</tr>
			<tr>
				<td colspan="2"><br></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="red">RECOVER PASSWORD</td>
			</tr>
			<tr>
				<td align="right" valign="top">Manager Id: </td>
				<td><textarea rows="2" cols="60" name="textAreaManagerId"><%=rs.getString(2)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Recovery Question: </td>
				<td><%out.print(rs.getString(4));%></td>
			</tr>
			<tr>
				<td align="right" valign="top">Recovery Answer: </td>
				<td><textarea rows="2" cols="60" name="textAreaRecoveryAnswer"></textarea></td>
			</tr>
			<% } } catch(Exception e){System.out.println(e);}%>
			<tr>
				<td colspan="2" align="center" >
				<input type="submit" value="go ahead">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
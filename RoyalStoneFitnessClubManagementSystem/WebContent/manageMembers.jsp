<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%	 
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stone fitness club - members</title>
</head>
<body>
	<jsp:include page="services.jsp"></jsp:include>
	<form method="post" action="ManageMembersService">
		<table align="center" width="600">
			<tr>
				<td colspan="2" align="center" bgcolor="red">MANAGE MEMBERS</td>
			</tr>
			<tr>
				<td align="right" valign="top">Member Id: </td>
				<td> <input style="width: 425px; " name="textFieldMemberId"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Name: </td>
				<td><input style="width: 425px; " name="textFieldName"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Aadhar Id: </td>
				<td> <input style="width: 425px; " name="textFieldAadharId"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Contact Number: </td>
				<td><input style="width: 425px; " name="textFieldContactNumber"></td>
			</tr>
			<tr>
				<td align="right" valign="top">E-Mail Address: </td>
				<td><input style="width: 425px; " name="textFieldEMailAddress"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Home Address: </td>
				<td> <input style="width: 425px; " name="textFieldHomeAddress"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Package Id: </td>
				<td><input style="width: 425px; " name="textFieldPackageId"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Months: </td>
				<td><input style="width: 425px; " name="textFieldMonths"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
				<input type="submit" value="add" name="buttonAdd">
				<input type="submit" value="update" name="buttonUpdate">
				<input type="submit" value="remove" name="buttonRemove"></td>
			</tr>
		</table>
		<%
				PreparedStatement ps = con.prepareStatement("select * from rsfcms_members");  
				ResultSet rs = ps.executeQuery(); 
				
			    out.print("<table align=center width=600>");
			    out.print("<tr><td><br></td></tr>");
			    out.print("<tr><td align=center bgcolor=red>LIST OF MEMBERS IN SYSTEM</td></tr>");
			    out.println("</table>"); 
			    out.print("<table align=center border=1>");
			    out.print("<th>Member Id</th><th>Name</th><th>Aadhar Id</th><th>Contact Number</th><th>E-Mail Address</th><th>Home Address</th><th>Package Id</th>");
			   	while (rs.next()) {
			   		out.print("<tr><td>" + rs.getString(1) + "</td>");
				    out.print("<td>" + rs.getString(2) + "</td>");
				    out.print("<td>" + rs.getString(3) + "</td>");
				    out.print("<td>" + rs.getString(4) + "</td>");
				    out.print("<td>" + rs.getString(5) + "</td>");
				    out.print("<td>" + rs.getString(6) + "</td>");
				    out.print("<td>" + rs.getString(7) + "</td></tr>");
	   	}
			    out.println("</table>"); 
			}
			catch (Exception e) {
		        System.out.println(e);
		    }
		%>
	</form>
</body>
</html>
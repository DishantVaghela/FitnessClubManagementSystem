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
<title>Royal Stone fitness club - managers</title>
</head>
<body>
	<jsp:include page="services.jsp"></jsp:include>
	<form method="post" action="ManageManagersService">
		<table align="center" width="600">
			<tr>
				<td colspan="2" align="center" bgcolor="red">MANAGE MANAGERS</td>
			</tr>
			<tr>
				<td align="right" valign="top">Manager Id: </td>
				<td> <input style="width: 425px; " name="textFieldManagerId"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Password: </td>
				<td><input type="password" style="width: 425px; " name="textFieldPassword"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Recovery Question: </td>
				<td> <input style="width: 425px; " name="textFieldRecoveryQuestion"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Recovery Answer: </td>
				<td><input style="width: 425px; " name="textFieldRecoveryAnswer"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<input type="submit" value="add" name="buttonAdd">
					<input type="submit" value="update" name="buttonUpdate">
					<input type="submit" value="remove" name="buttonRemove">
				</td>
			</tr>
		</table>
		<%
				PreparedStatement ps = con.prepareStatement("select manager_id from rsfcms_managers");  
				ResultSet rs = ps.executeQuery(); 
				
			    out.print("<table align=center width=600>");
			    out.print("<tr><td><br></td></tr>");
			    out.print("<tr><td align=center bgcolor=red>LIST OF MANAGERS IN SYSTEM</td></tr>");
			    out.println("</table>"); 
			    out.print("<table align=center border=1>");
			    out.print("<th>Manager Id</th>");
			   	while (rs.next()) {
			   		out.print("<tr><td align=center>" + rs.getString(1) + "</td></tr>");
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
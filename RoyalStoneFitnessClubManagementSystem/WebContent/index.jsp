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
	<table align="center" width="600">
		<tr>
			<td valign="top" align="right">
				<%
					try{  
						PreparedStatement ps=con.prepareStatement("select * from rsfcms_club where id=0");  
						ResultSet rs = ps.executeQuery(); 
				%>
				<table>
					<tr>
						<td colspan="2" valign="bottom"><img src="RoyalStoneFitnessClubLogo.png" width="100%" height="200"></td>
					</tr>
						<%
							if (rs.next()){
								out.print("<tr><td colspan=2><br></td></tr>");
							    out.print("<tr><td colspan=2 align=center bgcolor=red>CONTACT</td></tr>");
							    out.print("<tr><td width=110 align=right valign=top> Mobile Number: </td>");
							    out.print("<td align=justify>"+rs.getString(2)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Email Id: </td>");
							    out.print("<td align=justify>"+rs.getString(3)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Club Address: </td>");
							    out.print("<td align=justify>"+rs.getString(4)+"</td></tr>");
							    out.print("<tr><td colspan=2><br></td></tr>");
							    out.print("<tr><td colspan=2 align=center bgcolor=red>WORKING HOURS</td></tr>");
							    out.print("<tr><td align=right valign=top> Monday: </td>");
							    out.print("<td align=justify>"+rs.getString(5)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Tuesday: </td>");
							    out.print("<td align=justify>"+rs.getString(6)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Wednesday: </td>");
							    out.print("<td align=justify>"+rs.getString(7)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Thursday: </td>");
							    out.print("<td align=justify>"+rs.getString(8)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Friday: </td>");
							    out.print("<td align=justify>"+rs.getString(9)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Saturday: </td>");
							    out.print("<td align=justify>"+rs.getString(10)+"</td></tr>");
							    out.print("<tr><td align=right valign=top> Sunday: </td>");
							    out.print("<td align=justify>"+rs.getString(11)+"</td></tr>");
							    out.print("<tr><td colspan=2><br></td></tr>");
							    out.print("<tr><td colspan=2 align=center bgcolor=red>SERVICES</td></tr>");
							    out.print("<tr><td align=justify colspan=2>" + rs.getString(12) + "</td></tr>");
						    } 
						}
						catch(Exception e){System.out.println(e);}%>
					<tr><td colspan=2><br></td></tr>
					<tr>
						<td colspan=2 align=center bgcolor=red>PHOTO GALLERY</td>
					</tr>
					<tr>
						<td colspan="2" valign="bottom"><img src="PhotoGallery1.jpg" width="100%" height="200"></td>
					</tr>
					<tr>
						<td colspan="2" valign="bottom"><img src="PhotoGallery2.jpg" width="100%" height="200"></td>
					</tr>
					<tr>
						<td colspan="2" valign="bottom"><img src="PhotoGallery3.jpg" width="100%" height="200"></td>
					</tr>
				</table>
			</td>
			<td bgcolor=red rowspan="10" valign="top"></td>
			<td valign="top">
				<form action="AuthenticationService" method="post">
					<table>
						<tr>
							<td colspan="2" align="center" bgcolor="red">STAFF LOGIN</td>
						</tr>
						<tr>
							<td align="right">Id:</td>
							<td><input type="text" name="textFieldId"></td>
						</tr>
						<tr>
							<td align="right">Password:</td>
							<td><input type="password" name="textFieldPassword"></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="recover password" name="buttonRecoverPassword">
								<input type="submit" value="login" name="buttonLogin">
							</td>
						</tr>
						<tr>
							<td colspan="2"><hr color="red"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
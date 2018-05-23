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
<title>Royal Stone fitness club - information</title>
</head>
<body>
	<jsp:include page="services.jsp"></jsp:include>
	<form method="post" action="UpdateInformationService">
		<%
			try{  
				PreparedStatement ps=con.prepareStatement("select * from rsfcms_club where id=0");  
				ResultSet rs = ps.executeQuery(); 
				if (rs.next()){
		%>
		<table align="center" width="600">
			<tr>
				<td colspan="2" align="center" bgcolor="red">UPDATE INFORMATION</td>
			</tr>
			<tr>
				<td align="right" valign="top">Mobile Number: </td>
				<td><textarea cols="60" rows="2" name="textAreaMobileNumber"><%=rs.getString(2)%></textarea> </td>
			</tr>
			<tr>
				<td align="right" valign="top">Email Id: </td>
				<td><textarea rows="2" cols="60" name="textAreaEmailId"><%=rs.getString(3)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Club Address: </td>
				<td><textarea cols="60" rows="2" name="textAreaClubAddress"><%=rs.getString(4)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Monday Timing: </td>
				<td><textarea cols="60" rows="2" name="textAreaMondayTiming"><%=rs.getString(5)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Tuesday Timing: </td>
				<td><textarea cols="60" rows="2" name="textAreatuesdayTiming"><%=rs.getString(6)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Wednesday Timing: </td>
				<td><textarea rows="2" cols="60" name="textAreaWednesdayTiming"><%=rs.getString(7)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Thursday Timing: </td>
				<td><textarea cols="60" rows="2" name="textAreaThursdayTiming"><%=rs.getString(8)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Friday Timing: </td>
				<td><textarea rows="2" cols="60" name="textAreaFridayTiming"><%=rs.getString(9)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Saturday Timing: </td>
				<td><textarea rows="2" cols="60" name="textAreaSaturdayTiming"><%=rs.getString(10)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Sunday Timing: </td>
				<td><textarea cols="60" rows="2" name="textAreaSundayTiming"><%=rs.getString(11)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">Services: </td>
				<td><textarea cols="60" rows="2"  name="textAreaServices"><%=rs.getString(12)%></textarea></td>
			</tr>
			<tr>
				<td align="right" valign="top">last changes by: </td>
				<td><textarea cols="60" rows="2" readonly="readonly"><%=rs.getString(13)%></textarea></td>
			</tr>
			<% } } catch(Exception e){System.out.println(e);}%>
			<tr>
				<td colspan="2" align="center" ><input type="submit" value="update"></td>
			</tr>
		</table>
	</form>
</body>
</html>
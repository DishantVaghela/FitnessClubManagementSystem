<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stone fitness club - services</title>
</head>
<body background="Background.jpg">
	<form action="ServicesService" method="post">
		<table align="center" width="600">
			<tr>
				<td align="left"><img src="RoyalStoneFitnessClubMiniLogo.png" width="300" height="70"></td>
				<td align="right">
						Manager Id: <% out.print(session.getAttribute("session_id")); %>
						<input type="submit" value="logout" name="buttonLogout">
				</td>
			</tr>
			<tr>
				<td colspan="2"><br></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
						<input type="submit" value="information" name="buttonInformation">
						<input type="submit" value="managers" name="buttonManagers">
						<input type="submit" value="members" name="buttonMembers">
				</td>
			</tr>
			<tr>
				<td colspan="2"><br></td>
			</tr>
		</table>
	</form>
</body>
</html>
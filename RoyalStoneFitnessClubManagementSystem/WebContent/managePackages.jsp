<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stone fitness club - managers</title>
</head>
<body>
	<jsp:include page="services.jsp"></jsp:include>
	<form method="post" action="ManagePackagesService">
		<table align="center" width="600">
			<tr>
				<td colspan="2" align="center" bgcolor="red">MANAGE PACKAGES</td>
			</tr>
			<tr>
				<td align="right" valign="top">Id: </td>
				<td><input style="width: 425px; " name="textFieldId"></td>
			</tr>
			<tr>
				<td align="right" valign="top">Name: </td>
				<td> <input style="width: 425px; " name="textFieldName"></td>
			</tr>
			<tr>
				<td align="right" valign="top">price: </td>
				<td> <input style="width: 425px; " name="textFieldPrice"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
				<input type="submit" value="add" name="buttonAdd">
				<input type="submit" value="update" name="buttonUpdate">
				<input type="submit" value="remove" name="buttonRemove"></td>
			</tr>
		</table>
	</form>
</body>
</html>
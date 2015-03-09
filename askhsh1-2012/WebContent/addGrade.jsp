<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a student's grade</title>
</head>
<body>

<form method="get" action="register.jsp">

		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="id" value=" <%= request.getParameter("Id") %> " size=2 /></td>
			</tr>
			<tr>
				<td>Grade:</td>
				<td><input type="text" name="grade" size=2 /></td>
			</tr>
			<tr>
				<td><input type=submit /></td>
			</tr>
		</table>
	</form>


</body>
</html>
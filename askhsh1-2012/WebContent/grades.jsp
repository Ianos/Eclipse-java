<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/students";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Grades</title>
</head>
<body>

	<table border="3">
	<%
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection = DriverManager.getConnection(connectionURL, "root", "");
	statement = connection.createStatement();
	rs = statement.executeQuery("SELECT * FROM students");
	
	%>
	
	<%
	while (rs.next()) {
		%>
		<tr>
		<% if (rs.getString("grade") != null) {%>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("grade")%></td>
		<% } else  {%>
			<td><a href="addGrade.jsp?id=
			<%=rs.getString("id")%> ">
			<%=rs.getString("name")%></a></td>
			<td><%=""%></td>
			<%
			}
			%>
		</tr>
		
		<%
	}

	rs.close();
	%>
	
	
	
	</table>

</body>
</html>
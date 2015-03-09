<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/students";
	Connection connection = null;
	Statement statement = null;	
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String grade = request.getParameter("grade");
		String id = request.getParameter("id");
				
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "");
		statement = connection.createStatement();
		String sql = "UPDATE students SET grade = " + grade + " WHERE id = \'" + id + "' ;" ;
		int result = statement.executeUpdate(sql);
	%>

	<p>The student's grade has been added successfully!</p>
	<a href="grades.jsp">Start Page</a>

</body>
</html>
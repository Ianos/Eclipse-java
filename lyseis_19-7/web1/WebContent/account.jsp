<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/bank";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
%>

<html>
<body>

	<%
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "");
		statement = connection.createStatement();
		
		String user = request.getParameter("username");
		rs = statement.executeQuery("SELECT * FROM users WHERE username =\"" +user+"\";");
		%>
		
	<center>
	<h1> Hello <%=user %>. <br/>
	<%  rs.next(); 
		double balance = Double.parseDouble(rs.getString("balance"));%>
	Your account balance is <%=balance%></h1>
	
	<br/>
	<br/>
	<h3> Transfer funds to another account </h3>
	
	<table border="5">
		<tr>
			<th>Id</th>
			<th>Username</th>
		</tr>
		<%
		rs = statement.executeQuery("SELECT * FROM users");
		while (rs.next()) {
			%>

		<tr>
			<td><%=rs.getString("id")%></td>
			<td><a href="transfer.jsp?user=<%=user%>&target=<%=rs.getString("id")%>&balance=<%=balance%>">
				<%=rs.getString("username")%>
			</a></td>
		</tr>
		<%
		}

		rs.close();
	%>
	</table>
	
	</center>

</body>
</html>
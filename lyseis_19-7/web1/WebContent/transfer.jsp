<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.PrintWriter"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/bank";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
%>

<html>
<body>
<%
	String username = request.getParameter("user");
	String target = request.getParameter("target");
	double balance = Double.parseDouble(request.getParameter("balance"));
	double ammount = 0;
	
	if (request.getParameter("ammount") != null)
		ammount = Double.parseDouble(request.getParameter("ammount"));

	if (ammount != 0) {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root","");
		statement = connection.createStatement();

		String sqlSelect = "SELECT * FROM users WHERE id =\"" + target + "\" ;";
		System.out.println(sqlSelect);
		rs = statement.executeQuery(sqlSelect);
		rs.next();

		double reduction = balance - ammount;
		double newbalance = Double.parseDouble(rs.getString("balance"))+ ammount;
		System.out.println(newbalance);

		if (reduction > 0) {
			String sql = "UPDATE users SET BALANCE =" + (newbalance)+ " WHERE id =" + target + ";";
			System.out.println(sql);
			int result = statement.executeUpdate(sql);
			sql = "UPDATE users SET BALANCE =" + reduction + " WHERE username =\"" + username + "\";";
			System.out.println(sql);
			result = statement.executeUpdate(sql);
			
			//print to file
			String file = "C:/Documents and Settings/labuser.PC-A17.001/Desktop/outfile.txt";
			FileWriter outFile = new FileWriter(file, true);	
			PrintWriter pw = new PrintWriter(outFile);
			pw.println("User " + username + " transfered " + ammount + " of money to account with id:" + target);
			pw.close();
			outFile.close();
			
	rs.close();
		%> The ammount was transfered successfully
				<br/><a href="account.jsp"> Go back </a>
		<% }
	} else { %>
		<form method="post" action="transfer.jsp?user=<%=username%>&target=<%=target%>&balance=<%=balance%>">
		Enter ammount for transfer:
			<input type="text" name="ammount" />
			<input type="submit" />
		</form>
		<%
	}
%>

</body>
</html>
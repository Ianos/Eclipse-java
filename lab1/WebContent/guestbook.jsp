<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My jsp</title>
</head>
<body>
<%!
     String connectionURL="jdbc:mysql://localhost:3306/iprogusers";
     Connection connection = null;
     Statement statement = null;
     PreparedStatement ps=null;
     ResultSet rs = null;
     
    %>

Hello <%=session.getAttribute("name")%><br/>
<%
	String cname = request.getParameter("cname");
	String comment = request.getParameter("comment");
	Class.forName("com.mysql.jdbc.Driver").newInstance();
			
	connection = DriverManager.getConnection(connectionURL,"root", "");
	
	
	if ((cname!=null)&&(comment!=null)){
	String sqlUpdate = "INSERT INTO comments(name,comment) VALUES(?,?)";
	ps = connection.prepareStatement(sqlUpdate);
	ps.setString(1,cname);
	ps.setString(2,comment);
	ps.executeUpdate();
	ps.close();
	}

	statement = connection.createStatement();
	String sqlSelect = "SELECT name,comment FROM comments";
	rs = statement.executeQuery(sqlSelect);
	while (rs.next()){
		out.println(rs.getString(1)+"<br/>");
		out.println(rs.getString(2)+"<br/>");
	}
	rs.close();
%>


</body>
</html>
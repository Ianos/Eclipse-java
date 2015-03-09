package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessFormServlet
 */
public class ProcessFormServlet extends HttpServlet {
	 
     String connectionURL="jdbc:mysql://localhost:3306/iprogusers";
     Connection connection = null;
     Statement statement = null;
     ResultSet rs = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();	
		
			
		String username = request.getParameter("username");
		String userpass = request.getParameter("password");
		String name = request.getParameter("name");
		out.println(name+username+userpass);
		if(username != null) {
			out.println(name+username+userpass);
			if (name !=null)
				out.println(name+username+userpass);
				session.setAttribute("name", name);
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				out.println(name+username+userpass);
			
			connection = DriverManager.getConnection(connectionURL,"root", "");
			statement = connection.createStatement();
			String sqlSelect = "SELECT * FROM users;"; //WHERE username = \""+username+"\";";
			rs = statement.executeQuery(sqlSelect);
			
			
			
			
			out.println("<table align=\"center\" border=\"2\" >");
			while (rs.next()) {    
				// Position the cursor                 3 
				            // Retrieve only the first column value
				 out.println("<tr>"+"<td>" +rs.getString(2)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"</tr>");
				                                  // Print the column value
				}
			out.println("</table>");
			
			
			
			
			out.println(name+userpass);
			if (!rs.next()){
				String sql = "INSERT INTO users (username,userpass,name) VALUES (\""+username+"\" , \""+userpass +"\", \""+name+"\");";
				out.println(username+userpass);
				int res = statement.executeUpdate(sql);
			}	
			else out.println("Username taken");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				out.println(userpass);
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
  /*      finally {
            out.close();
        }*/
	
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	
}

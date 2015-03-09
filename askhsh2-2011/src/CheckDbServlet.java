import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CheckDbServlet.
 */
@WebServlet("/CheckDbServlet")
public class CheckDbServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
	/** The text */
	String text;

    /**
     * Instantiates a new check db servlet.
     *

    @see HttpServlet#HttpServlet()
     */
    public CheckDbServlet() {
        super();
    }

	/**
	 * Do get.
	 *
	@param request the request
	 * @param response the response
	 * 
	@throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * 
	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}


	/**
	 * Do post.
	 *
	@param request the request
	 * @param response the response
	 * 
	@throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * 
	@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (request.getParameter("text") != null)
        	text = request.getParameter("text");
        
        // Start
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CheckDatabase</title>");
        out.println("</head>");
        out.println("<body>");
	
        // Insert the words that do not exist in the database in an arraylist
        List<String> notExist = new ArrayList<String>();
        
        // Show the text with the words that do not exist underlined
        // Split to lines
        String[] lines = text.split("\n");
	    for (int i = 0; i < lines.length; i++) {
	    	
	    	// Split to words
	    	String[] words = (lines[i]).split("\\s+");
		    for (int j = 0; j < words.length; j++) {
		    	String temp = words[j];

				// Search in the database if word exists
				Connection con = null;
				Statement stmt = null;
				try {
					// Connection to the database
					Class.forName ("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection( "jdbc:mysql://localhost/dictionary?user=alex&password=localpwd");

					// The query made
					String qry = "SELECT * FROM words WHERE word='"+ temp +"' ;";

					stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery( qry );

					if ( !(rs.first()) ) {				// If word doesn't exist
						out.println("<u><font color=\"red\">" + temp + "</font></u>" + " ");
						if ( !notExist.contains(temp))
							notExist.add(temp);
					}
					else {								// If word exists
						out.println(temp + " ");
					}
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			out.println("<br>");						// Change line
        }
	    out.println("<br><br>");
	    
        // Show the textarea with the text so as the user corrects it
        out.println("<form method=post action=CheckDbServlet>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>Text:</td>");
        out.println("<td><textarea name=\"text\" rows=\"3\" cols=\"60\">" + text + "</textarea></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td colspan=1><input type=submit /></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form> <br>");

        // Convert the arraylist to an array
        String[] notDB = notExist.toArray( new String[notExist.size()] );

        // Ability to select with checkboxes the words to insert into the dictionary
        out.println("<form method=post action=InsertIntoDb>");
		for (int i = 0; i < notDB.length; i++)
	        out.println("<input type=\"checkbox\" name=\"word\" value=\"" + notDB[i] + "\" />" + notDB[i] + "<br>");
        out.println("<input type=submit /> <br>");
        out.println("</form>");

        // End
        out.println("</body>");
        out.println("</html>");
        out.close();
	}

}

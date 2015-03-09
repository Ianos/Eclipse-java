import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InsertIntoDb.
 */
@WebServlet("/InsertIntoDb")
public class InsertIntoDb extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new insert into db.
     *
    @see HttpServlet#HttpServlet()
     */
    public InsertIntoDb() {
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
		String[] word = request.getParameterValues("word");
		for (int i = 0; i < word.length; i++)  {

			// Update the database
			Connection con = null;
			Statement stmt = null;
			try {
				// Connection to the database
				Class.forName ("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection( "jdbc:mysql://localhost/dictionary?user=alex&password=localpwd");
				stmt = con.createStatement();

				// The query made
				String qry = "INSERT INTO words (word) VALUES( \"" + word[i] + "\") ;";
				stmt.executeUpdate( qry );
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }

		// Redirect to the previous page
        response.sendRedirect(response.encodeRedirectURL("CheckDbServlet"));
	}

}

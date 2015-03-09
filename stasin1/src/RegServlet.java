// Setting and Retrieving Cookies
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
public class RegServlet extends HttpServlet {
//private String names[] = { "Europe", "Asia", "America", "Africa" };
//private String cities[] = { "Athens and Rome", "Peking and Amman", "New York", "Cairo" };

public void doPost( HttpServletRequest request, // reaction to the reception of POST
HttpServletResponse response ) throws ServletException, IOException
{
PrintWriter output;
String fname = request.getParameter( "firstName" ); // choice made will be sent back to client
String lname = request.getParameter( "lastName" );
Cookie f = new Cookie("firstName",fname ); // to be stored theree as a cookie
f.setMaxAge( 120 ); // seconds until cookie removed
response.addCookie( f ); // must preceede getWriter
Cookie l = new Cookie("lastName",lname ); // to be stored theree as a cookie
l.setMaxAge( 120 ); // seconds until cookie removed
response.addCookie( l ); // must preceede getWriter

response.setContentType( "text/html" );
output = response.getWriter();
// send HTML page to client
output.println( "<HTML><HEAD><TITLE>" );
output.println( "Finish registration" );
output.println( "</TITLE></HEAD><BODY>" );
output.println( "<P>Thank you we have registered you succesfully<BR>" );
output.println( "<P>" );
output.println( "<P>Click Continue to move to order form<BR>" );
output.println( "<P>" );
output.println( "<FORM METHOD=\"LINK\" ACTION=\"order.html\" > " );
output.println( "<INPUT TYPE=\"submit\" VALUE=\"Continue\">" );
output.println( "</BODY></HTML>" );
output.close (); // close stream
}
public void doGet( HttpServletRequest request, // reaction to the reception of GET
HttpServletResponse response )
throws ServletException, IOException
{
PrintWriter output;
Cookie cookies[];
cookies = request.getCookies(); // get client's cookies
String fna =getCookieValue(cookies,
        "firstName",
        "nobody");
String lna =getCookieValue(cookies,
        "lastName",
        "nobody");
response.setContentType( "text/html" );
output = response.getWriter();
output.println( "<HTML><HEAD><TITLE>" );
output.println( "Already been here !" );
output.println( "</TITLE></HEAD><BODY>" );
if ( cookies.length == 0 ) {
	output.println( "the cookies have expired." );
	}
output.println("Welcome" + "<BR>");

output.println(fna+" "+lna); 
output.println( "<P>Click Continue to move to order form<BR>" );
output.println( "<P>" );
output.println( "<FORM METHOD=\"LINK\" ACTION=\"order.html\" > " );
output.println( "<INPUT TYPE=\"submit\" VALUE=\"Continue\">" );
output.println( "</BODY></HTML>" );
output.close(); // close stream
}

private String getCookieValue(Cookie[] cookies,
        String cookieName,
        String defaultValue) {
for(int i=0; i<cookies.length; i++) {
Cookie cookie = cookies[i];
if (cookieName.equals(cookie.getName()))
return(cookie.getValue());
}
return(defaultValue);
}

}

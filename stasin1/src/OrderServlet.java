// Setting and Retrieving Cookies
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
public class OrderServlet extends HttpServlet {
private String names[] = { "Interamerican", "Spazokokalos", "S.H.I.E.L.D", "SpartanSecurity" };
private String cost[] = { "200", "150", "300", "400" };

public void doPost( HttpServletRequest request, // reaction to the reception of POST
HttpServletResponse response ) throws ServletException, IOException
{
PrintWriter output;
String secur = request.getParameter( "security" );// choice made will be sent back to client
String money = getcost(secur);
Cookie s = new Cookie("security",secur ); // to be stored theree as a cookie
s.setMaxAge( 120 ); // seconds until cookie removed
response.addCookie( s ); // must preceede getWriter
Cookie m = new Cookie("money",money ); // to be stored theree as a cookie
m.setMaxAge( 120 ); // seconds until cookie removed
response.addCookie( m ); // must preceede getWriter
response.setContentType( "text/html" );
output = response.getWriter();
// send HTML page to client
output.println( "<HTML><HEAD><TITLE>" );
output.println( "Total summary" );
output.println( "</TITLE></HEAD><BODY>" );
output.println( "<P>You have chosen security:"+ secur +"<BR>");
output.println( "<P>" );
output.println( "<P>That will cost you:"+ money + "&euro;" + "<BR>" );
output.println( "<P>" );
output.println( "<FORM METHOD=\"GET\" ACTION=\"OrderServlet\" > " );
output.println( "<INPUT TYPE=\"submit\" VALUE=\"ACCEPT\">" );
output.println("</FORM>");
output.println( "<FORM METHOD=\"LINK\" ACTION=\"order.html\" > " );
output.println( "<INPUT TYPE=\"submit\" VALUE=\"DECLINE\">" );
output.println("</FORM>");
output.println( "</BODY></HTML>" );
output.close (); // close stream
}


public void doGet( HttpServletRequest request, // reaction to the reception of GET
HttpServletResponse response )
throws ServletException, IOException
{
PrintWriter output;

Cookie[] cookies = request.getCookies();
String fn =getCookieValue(cookies,
                                  "firstName",
                                  "nobody");
String ln =getCookieValue(cookies,
                                  "lastName",
                                  "nobody");
String se =getCookieValue(cookies,
                                  "security",
                                  "nothing");
String co =getCookieValue(cookies,
        "money",
        "broke");

response.setContentType( "text/html" );
output = response.getWriter();
output.println( "<HTML><HEAD><TITLE>" );
output.println( "Final Form !" );
output.println( "</TITLE></HEAD><BODY>" );
if ( cookies.length == 0 ) { 
output.println( "the cookies have expired." );
}
output.println( "<P>"+ fn +" "+ ln +"<BR>");
output.println( "<P>" );
output.println( "<P>You have chosen security"+ " "+se +" " +"and you will be charged"+ " " + co +"&euro;");
output.println( "<P>" );
output.println( "</BODY></HTML>" );
output.close(); // close stream
}

private String getcost( String conString)
{
for ( int i = 0; i < names.length; ++i )
	if ( conString.equals( names[ i ] ) )
		return cost[ i ];
		return ""; // no matching string found
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
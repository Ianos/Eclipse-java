import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class HTTPGetServlet extends HttpServlet {
public void doGet (HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException
{
PrintWriter output;
response.setContentType ("text/html") ;
output = response.getWriter() ;
StringBuffer buf = new StringBuffer() ;
buf.append( "<HTML><HEAD><TITLE>\n") ; // write here line-by-line the html for the desired page
buf.append( "A simple servlet example\n") ;
buf.append( "</TITLE></HEAD><BODY>\n") ;
buf.append( "<H1>Welcome to servlets !</H1>\n") ;
buf.append( "</BODY></HTML>") ; // end of desired page
output.println (buf.toString()) ;
output.close (); // PrintWriter stream closed->buffer is flashed to client !!!
}
}
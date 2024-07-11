import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ReadCookiesDemo extends HttpServlet 
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
	{
      //Cookie cookie = null;
Cookie[] cookies = null;

      // Get an array of Cookies associated with this domain
cookies = request.getCookies();

      // Set response content type
response.setContentType("text/html");

      PrintWriter out = response.getWriter();

if( cookies != null ) {
out.println("<h2> Found Cookies Name and Value</h2>");

for (int i = 0; i < cookies.length; i++) {
           // cookie = cookies[i];
out.print("Name : " + cookies[i].getName( ) + ",  ");
out.print("Value: " + cookies[i].getValue( ) + " <br/>");
         }
      } else {
out.println("<h2>No cookies founds</h2>");
      }

   }
}


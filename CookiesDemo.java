import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class CookiesDemo extends HttpServlet 
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
	{

      // Create cookies for first and last names.      
      Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
      Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

      // Set expiry date for both the cookies.
firstName.setMaxAge(60);   // 1min-60secs
lastName.setMaxAge(60*60*2); // 2hrs

      // Add both the cookies in the response header.
response.addCookie( firstName );
response.addCookie( lastName );

      // Set response content type
response.setContentType("text/html");

      PrintWriter out = response.getWriter();
out.println("<b> Cookies are created and the cookies are: <b><br>");
out.println("<b>First Name</b>: "
                  + request.getParameter("first_name") + "\n" +
" <b>Last Name</b>: "
                  + request.getParameter("last_name") + "\n" 
                     );
   }
}


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class SessionTrack extends HttpServlet 
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
	 {

      // Create a session object if it is already not  created.
      HttpSession s1 = request.getSession(true);

      // Get session creation time.
      Date createTime = new Date(s1.getCreationTime());

      // Get last access time of this web page.
      Date lastAccessTime = new Date(s1.getLastAccessedTime());
      Integer visitCount = new Integer(0);
      String visitCountKey = new String("visitCount");
      String userIDKey = new String("userID");
      String userID = new String("ABCD");

      // Check if this is new comer on your web page.
if (s1.isNew()) 
	  {
s1.setAttribute(userIDKey, userID);
      }
	else
	  {
visitCount = (Integer)s1.getAttribute(visitCountKey);
visitCount = visitCount + 1;
userID = (String)s1.getAttribute(userIDKey);
      }
s1.setAttribute(visitCountKey,  visitCount);

      // Set response content type
response.setContentType("text/html");
      PrintWriter out = response.getWriter();

out.println("<h1>session id is" + s1.getId() + 
					"<br>Creation Time"+ createTime + 
					"<br>lass access time" + lastAccessTime + 
					"<br>User ID is" +userID + 
					"<br>Number of visits is" + visitCount+"</h1>" );
   }
}


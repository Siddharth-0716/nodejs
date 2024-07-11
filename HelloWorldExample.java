import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorldExample extends HttpServlet {
    
    public void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {
        
        PrintWriter out = response.getWriter();

        out.println("Welcome to Servlet World");
        
    }
}




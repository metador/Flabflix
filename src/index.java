

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class index
 */
@WebServlet("/index.html")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    PrintWriter out = response.getWriter();
 String message = request.getParameter("message");
        out.println("<HTML><HEAD><TITLE>login</TITLE></HEAD>");
        out.println("<BODY><H1>Logged in </H1> <H1 ALIGN=\"CENTER\">Login Form</H1><FORM ACTION=\"/Flabflix/servlet/Login\" METHOD=\"GET\"><center> Username: <INPUT TYPE=\"TEXT\" NAME=\"Username\"><BR> Password: <INPUT TYPE=\"PASSWORD\" NAME=\"password\"><BR></center> <CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"Submit Order\">");
        		if(message !=null)out.println("<br>"+message+"</br>");
        out.println("</CENTER>");
        				out.println("</FORM>");

        						out.println("</BODY>");
        								out.println("</HTML>");
        	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

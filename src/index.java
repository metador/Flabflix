

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
       // super();
        
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
		 String message = request.getParameter("message");
		 out.println("<HTML><HEAD><TITLE>login</TITLE></HEAD>");
		 out.println("<BODY><H1 ALIGN=\"CENTER\">Login Form</H1><FORM ACTION=\"/Flabflix/\" METHOD=\"POST\"><center> Username: <INPUT TYPE=\"TEXT\" NAME=\"Username\"><BR> Password: <INPUT TYPE=\"PASSWORD\" NAME=\"password\"><BR></center> <CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"Submit Order\">");
		 if(message !=null)out.println("<br>"+message+"</br>");
		 out.println("</CENTER>");
		 out.println("</FORM>");
	     out.println("</BODY>");
		 out.println("</HTML>");
		        				String loginUser = "root";
		        			    String loginPasswd = "decodder";
		        				String loginUrl = "jdbc:mysql://localhost:3306/moviedb";
	                            response.setContentType("text/html");    // Response mime type

		        							        // Output stream to STDOUT
		        			   try
		        			   {
		        							              //Class.forName("org.gjt.mm.mysql.Driver");
		        	               Class.forName("com.mysql.jdbc.Driver").newInstance();
		        	               Connection dbcon = DriverManager.getConnection(loginUrl, loginUser, loginPasswd);
		        							              // Declare our statement
		        				  Statement statement = dbcon.createStatement();
		        			      String username=request.getParameter("Username");
		        				  String password=request.getParameter("password");
		        				  if(username !=null && password !=null){
		        					String query = "SELECT * from customers where first_name='"+username+"' AND password='"+ password+"';";

		        					// Perform the query
		        					 ResultSet rs = statement.executeQuery(query);
		        					 out.println("<TABLE border>");

		        							              // Iterate through each row of rs
		        							          //    if(message !=null)
		        					 if (rs.next())
		        					 {
		        					response.sendRedirect("/Flabflix/Main");
		        					String mess = "Succesfully logged in";
		        					 }else{
		        							String mess="Username or password incorrect";
		        							 response.sendRedirect("/Flabflix/index.html?message="+mess);  
		        							 out.println("<tr>" + "<td>" + message+ "</td>" +"</tr>");
		        							              }

		        							              out.println("</TABLE>");

		        							              rs.close();
		        							              statement.close();
		        							              dbcon.close();
		        							            }
		        							              out.println("</TABLE>");
		        			   }
		        							        catch (SQLException ex) {
		        							              while (ex != null) {
		        							                    System.out.println ("SQL Exception:  " + ex.getMessage ());
		        							                    ex = ex.getNextException ();
		        							                }  // end while
		        							            }  // end catch SQLException

		        							        catch(java.lang.Exception ex)
		        							            {
		        							                out.println("<HTML>" +
		        							                            "<HEAD><TITLE>" +
		        							                            "MovieDB: Error" +
		        							                            "</TITLE></HEAD>\n<BODY>" +
		        							                            "<P>SQL error in doGet: " +
		        							                            ex.getMessage() + "</P></BODY></HTML>");
		        							                return;
		        							            }
		        			   
		        							         out.close();

	
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		doPost(request,response);
	} 

}

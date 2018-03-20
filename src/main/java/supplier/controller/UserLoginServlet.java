package supplier.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import aeipa.database.UserLoginDB;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");    
	    String password = request.getParameter("password");
	    PrintWriter writer = response.getWriter();
	    UserLoginDB user = new UserLoginDB(username, password);
	    username = user.UserLogin();
	    if (username == null || password == null)
	    {
	    	//out.println("Invalid password <a href='index.jsp'>try again</a>");
	    	
	    	writer.println("Invalid username/password !");
	    	
	    }
	    else {
		    HttpSession session =request.getSession();
	        session.setAttribute("username", username);
	        response.sendRedirect("success.jsp");
	    }
        user.terminateDBConnection();
	}

}

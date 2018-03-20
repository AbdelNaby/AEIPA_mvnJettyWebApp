package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.db.UserDTO;
import model.db.UserService;

/**
 * Servlet implementation class UserValidationServlet
 */
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidationServlet() {
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
	    UserService userService = new UserService();
	    UserDTO userDTO = new UserDTO();
	    userDTO = userService.userLoginService(username, password);
	    if (userDTO == null)
	    {
	    	//out.println("Invalid password <a href='index.jsp'>try again</a>");
	    	writer.println("Invalid username/password !");
	    }
	    else {
		    HttpSession session =request.getSession();
	        session.setAttribute("username", username);
	        response.sendRedirect("home.jsp");
	    }
	    
	}

}

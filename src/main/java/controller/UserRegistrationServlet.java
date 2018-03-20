package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.db.UserDTO;
import model.db.UserService;

/**
 * Servlet implementation class UserRegistrationServlet
 */
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");   
		String username = request.getParameter("username");    
		String password = request.getParameter("password"); 
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");    
		String organization = request.getParameter("organization"); 
		String job = request.getParameter("job");
		PrintWriter writer = response.getWriter();
		UserService userService = new UserService();
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(firstName);
		userDTO.setLastName(lastName);
		userDTO.setUserName(username);
		userDTO.setPassword(password);
		userDTO.setEmail(email);
		userDTO.setDateOfBirth(dob);
		userDTO.setOrganization(organization);
		userDTO.setJob(job);
		
		
		if(userService.createNew(userDTO))
		{
			System.out.println("User has been registred successfully: " + userDTO.getUserName());
			UserValidationServlet userValid = new UserValidationServlet();
			userValid.doPost(request, response);
			
		}
		else
		{
			System.out.println("User has FAILED to get registred : " + userDTO.getUserName());
		}
		    
	}

}

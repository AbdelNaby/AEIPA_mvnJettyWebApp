/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class UserRegistration extends User {

	/**
	 * 
	 */
	public UserRegistration() {
		// TODO Auto-generated constructor stub
	}
	
	//public void userRegistration(String regUserName, String regUserPassword, String regFirstName , String regLastName, String regEmail , String regDateOfBirth, String regOrganization, String regJob)
	public void userRegistration(User user)
	{
		// create new user in the database
		String userRegQueryStatement = "insert into" + tableName + "(first_name, last_name, username, password, email,DOB, organization, job, regdate) values ('" + user.getUserName() + "','" 
			    + user.getPassword() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getDateOfBirth() + "','" + user.getOrganization() + "','" + user.getJob() + "', CURDATE())";
		//DBConnection code
		DBConnection userRegDBConnection =new DBConnection(); 
		userRegDBConnection.processDataToDB(userRegQueryStatement);		
	}

}

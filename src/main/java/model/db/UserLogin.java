/**
 * 
 */
package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author acil
 *
 */
public class UserLogin extends User {

	/**
	 * 
	 */
	public UserLogin(String chkUserName, String chkPassword)
	{
		//select from database: chkUserName && chkPassword
		
		String validateUserQueryStatement = "select * from" + tableName + "where username='" + chkUserName + "' and password='" + chkPassword + "'";
		 //DBConnection code
		DBConnection userLoginDBConnection =new DBConnection(); 
		ResultSet rs = userLoginDBConnection.getDataFromDB(validateUserQueryStatement);	
		 try {
			if (rs.next()) {
					setFirstName(rs.getString("first_name"));
					setLastName(rs.getString("last_name"));
					setUserName(rs.getString("username"));
			    	setPassword(rs.getString("password"));
			    	setEmail(rs.getString("email"));
			    	setDateOfBirth(rs.getString("DOB"));
			    	setOrganization(rs.getString("organization"));
			    	setJob(rs.getString("job"));
			    	System.out.println("User is logged in successfully "+ getUserName());
			        
			      
			    } else {
			        System.out.println("Invalid UserName\\password");
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//if exists then log the user in:
//		setUserName(chkUserName);
//		setPassword(chkPassword);
		// select from database
		//return returnedLoggedInUserName;
	}

}

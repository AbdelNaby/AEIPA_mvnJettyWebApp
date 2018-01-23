/**
 * 
 */
package model.db;

/**
 * @author  acilA POJO Class
 */
public class UserLoginDTO extends GenericDTO{
	private String userName;
	private String password;
	

	public UserLoginDTO(String userName, String password)
	{
		this.setUserName(userName);
		this.setPassword(password);
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 * @see userName should be unique and not less than 6 characters
	 * only letters, numbers, _ are allowed
	 * 
	 * 
	 * 
	 * 
	 */
	private void setUserName(String userName) {
	
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	private void setPassword(String password) {
		if (password != null)
			this.password = password;
		else
			System.out.println("Password can't be empty");
	}

}

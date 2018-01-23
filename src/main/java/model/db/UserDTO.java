package model.db;

import java.sql.Date;

// Data Object

// A POJO Class


public class UserDTO extends GenericDTO{
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String dateOfBirth;
	private String organization;
	private String job;
	/*
	//private List<String> iPAsList;
	//private List<String> datasets;
	*/

//	public abstract User retrieveUserIfExists(String userName, String password);
//	public abstract void saveUserInDatabase();
	public UserDTO()
	{}
	
	public UserDTO (String userName,String password )
	{
		this.userName = userName;
		this.password = password;
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
	public void setUserName(String userName) {
	
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
	public void setPassword(String password) {
		if (password != null)
			this.password = password;
		else
			System.out.println("Password can't be empty");
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}


}

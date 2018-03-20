/**
 * 
 */
package model.db;

import java.util.ArrayList;


/**
 * @author acil
 *
 */
public class UserService extends GenericService<UserDTO>{

	/**
	 * @return the user info if the login credentials are correct
	 * 
	 */
	public UserDTO userLoginService(String UserName, String Password) {
		if(UserName.isEmpty())
		{
			System.out.println("UserName is a mandatory field, please fill it in.");
			return null;
		}
		if(Password.isEmpty())
		{
			System.out.println("Password is a mandatory field, please fill it in.");
			return null;
		}
		UserDAO userLogin = new UserDAO();
		ArrayList<String> attributeList = new ArrayList<String>();
		attributeList.add("USERNAME");
		attributeList.add("PASSWORD");
		ArrayList<String> conditionOpList = new ArrayList<String>();
		conditionOpList.add("=");
		conditionOpList.add("=");
		ArrayList<String> connectorOpList = new ArrayList<String>();
		connectorOpList.add("AND");
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add(UserName);
		valueList.add(Password);
		ArrayList<UserDTO> userDTO = userLogin.displayManyConditions(attributeList, conditionOpList, 
				connectorOpList, valueList);
		if (userDTO.get(0) == null )
		{
			System.out.println("Username/Password are not valid");
			return null;
		}
		return userDTO.get(0);
	}

	@Override
	public UserDTO dTOMapper(ArrayList<String> dTOvaluesList) {
		UserDTO user = new UserDTO();
		
		user.setDateOfBirth(dTOvaluesList.get(0));
		user.setEmail(dTOvaluesList.get(1));
		user.setFirstName(dTOvaluesList.get(2));
		user.setLastName(dTOvaluesList.get(3));
		user.setJob(dTOvaluesList.get(4));
		user.setOrganization(dTOvaluesList.get(5));
		user.setPassword(dTOvaluesList.get(6));
		user.setUserName(dTOvaluesList.get(7));
		return null;
	}
	@Override
	public ArrayList<String> dTOMapper(UserDTO user) {
		ArrayList<String> tempIPA = new ArrayList<String>();
		tempIPA.add(user.getUserName());
		tempIPA.add(user.getDateOfBirth());
		tempIPA.add(user.getEmail());
		tempIPA.add(user.getFirstName());
		tempIPA.add(user.getFirstName());
		tempIPA.add(user.getJob());
		tempIPA.add(user.getLastName());
		tempIPA.add(user.getOrganization());
		// No need to expose the password field
		tempIPA.add(user.getPassword());
		return tempIPA;
	}
	@Override
	public boolean createNew(UserDTO userToRegDto) {
		UserDAO userRegDao = new UserDAO();
		if(!userRegDao.add(userToRegDto))
		{
			System.out.println("User has NOT been registered successfully");
			return false;
		}
		System.out.println("User has been registered successfully");
		return true;
	}
	@Override
	public boolean updateInfo(UserDTO oldUser, UserDTO newUser) {
		UserDAO userDAO= new UserDAO();
		//Checking if the New IPA's info are valid or not
		UserService iPAtempService = new UserService();
		if (iPAtempService.validateData(newUser))
		{
			String oldUserName = oldUser.getUserName();
			// Updating the IPA using the IPA name attribute
			if( !userDAO.update(newUser, userDAO.getAttributeList().get(2), "=", 
					oldUserName))
			{
				System.out.println("IPA: " + oldUserName 
					+ " failed to get updated. Problem in Database");
				return false;
			}
			System.out.println("New IPA: " + oldUserName + " has been updated "
					+ "succesfully.");
		}
		System.err.println("IPA values are not validated successfully");
		return false;
	}
	@Override
	public boolean delete(UserDTO user) {
		UserDAO userDAO= new UserDAO();
		//Checking if the New username valid or not
		String userName = user.getUserName();
		// Deleting the IPA using the IPA name attribute
		if( !userDAO.delete(userDAO.getAttributeList().get(2), "=", userName))
		{
			System.out.println(userName 
				+ " failed to get deleted. Problem in Database");
			return false;
		}
		System.out.println(userName + " has been deleted succesfully.");
		return true;
	}
	@Override
	public boolean validateData(UserDTO user) {
		if (user.getUserName().isEmpty() 
				|| user.getPassword().isEmpty()
				|| user.getFirstName().isEmpty()
				|| user.getLastName().isEmpty())
		{
			System.out.println("User's mandatory fields are missing. Please enter a value.");
			return false;
		}
		return true;
	}


	@Override
	public ArrayList<UserDTO> retrieveInfobyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserDTO> retrieveInfobyType(String type) {
		// TODO Auto-generated method stub
		return null;
	}


}

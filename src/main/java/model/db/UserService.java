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
	public boolean userRegistrationService(UserDTO userToRegDto)
	{	
		// Repetitive code !
//		if(userToRegDto.getUserName().isEmpty())
//		{
//			System.out.println("UserName is a mandatory field, please fill it in.");
//			return false;
//		}
//		if(userToRegDto.getPassword().isEmpty())
//		{
//			System.out.println("Password is a mandatory field, please fill it in.");
//			return false;
//		}
		UserDAO userRegDao = new UserDAO();
		if(!userRegDao.add(userToRegDto))
		{
			System.out.println("User has NOT been registered successfully");
			return false;
		}
		System.out.println("User has been registered successfully");
		return true;		
	}
//	@Override
//	protected void dTOMapper(ArrayList<String> dTOvaluesList) {
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	protected void dTOMapper(ArrayList<String> dTOvaluesList) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected ArrayList<String> dTOMapper(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


}

/**
 * 
 */
package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


/**
 * @author acil
 *
 */
public class UserDAO extends GenericDAO<UserDTO> {
	
	public UserDAO() {
		super();
	}
	@Override
	protected String tableName() {
		// TODO Auto-generated method stub
		return "USER";
	}
	@Override
	protected ArrayList<String> valueList(UserDTO dto) {
		// Filling in values from database row to the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add(dto.getFirstName());
		valueList.add(dto.getLastName());
		valueList.add(dto.getUserName());
		valueList.add(dto.getPassword());
		valueList.add(dto.getEmail());
		valueList.add(dto.getDateOfBirth());
		valueList.add(dto.getOrganization());
		valueList.add(dto.getJob());
		return valueList;
	}
	@Override
	protected ArrayList<UserDTO> convertToDTO(ResultSet rs) {	
		ArrayList<UserDTO> usersList = new ArrayList<UserDTO>();
		try {
			while (rs.next())
			{
				UserDTO user = new UserDTO(rs.getString(attributeList.get(2)), rs.getString(attributeList.get(3)));
				user.setFirstName(rs.getString(attributeList.get(0)));
				user.setLastName(rs.getString(attributeList.get(1)));
				user.setEmail(rs.getString(attributeList.get(4)));
				user.setDateOfBirth(rs.getString(attributeList.get(5)));
				user.setOrganization(rs.getString(attributeList.get(6)));
		
				usersList.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usersList;
	}
	@Override
	protected void setAttributeList() {
		// Setting the columns names from the database to the DTO object
		attributeList.add("FIRST_NAME");
		attributeList.add("LAST_NAME");
		attributeList.add("USERNAME");
		attributeList.add("PASSWORD");
		attributeList.add("EMAIL");
		attributeList.add("DOB");
		attributeList.add("ORGANIZATION");
		attributeList.add("JOB");
		
	}

}






















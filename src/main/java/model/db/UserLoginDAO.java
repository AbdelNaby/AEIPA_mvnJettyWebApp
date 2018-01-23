/**
 * 
 */
package model.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;

/**
 * @author acil
 *
 */
public class UserLoginDAO extends GenericDAO<UserLoginDTO> {

	@Override
	protected String tableName() {
		// TODO Auto-generated method stub
		return "User";
	}

	@Override
	protected ArrayList<String> valueList(UserLoginDTO dto) {
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add(dto.getUserName());
		valueList.add(dto.getPassword());
		return valueList;
	}

	@Override
	protected ArrayList<UserLoginDTO> convertToDTO(ResultSet rs) {
		// Doing NOTHING
		return null;
	}

	@Override
	protected void setAttributeList() {
		attributeList.add("username");
		attributeList.add("password");
	}
	/**
	 * @return the attributeList
	 */
	public ArrayList<String> getAttributeList()
	{
		return null;
	}
	public boolean add(UserLoginDTO dto)
	{
		return false;
	}
	public  boolean update(UserLoginDTO dto, String attributeValue, String conditionOp, String value)
	{
		return false;
	}
	public  ArrayList<UserLoginDTO> display(String attributeValue, String conditionOp, String value)
	{
		return null;
	}
	public boolean delete(String attributeValue, String conditionOp, String value)
	{
		return false;
	}
	public ArrayList<String> getConditionOpList() {
		return null;
	}
}

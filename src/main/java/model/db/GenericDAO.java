/**
 * 
 */
package model.db;

import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * @author acil
 *
 */
public abstract class GenericDAO <T extends GenericDTO>{
	private DBConnection operationDBCon;
	protected ArrayList<String> attributeList;
	private ArrayList<String> conditionOpList;
	private ArrayList<String> connectorOpList;
	
	GenericDAO()
	{
		setAttributeList();
		createDBConnection();
	}
	/**
	 * @return the tableName
	 */
	protected abstract String tableName();
	protected abstract ArrayList<String> valueList(T dto);
	protected abstract ArrayList<T> convertToDTO(ResultSet rs);
	
	/**
	 * @return the attributeList
	 */
	public ArrayList<String> getAttributeList() {
		return attributeList;
	}
	/**
	 * @param attributeList the attributeList to set
	 */
	protected abstract void setAttributeList();
	
	
	private void createDBConnection() {
		// TODO Auto-generated method stub
		operationDBCon = new DBConnectionMySQL();
	}
	
	
	public boolean add(T dto)
	{
		boolean isSuccess = operationDBCon.insertDataToDB(tableName(),attributeList, 
				valueList(dto));
		if (!isSuccess)
		{
			System.out.println(" Data  in Generic DAO Failed to be inserted ");
			return false;
		}
		System.out.println(" Data  in Generic DAO inserted successfully");
		return true;
	}

	public  boolean update(T dto, String attributeValue, String conditionOp, String value)
	{
		if (!attributeList.contains(attributeValue))
		{
			// The attributeValue doesn't exist in the attributeList
			System.out.println("The attributeValue doesn't exist in the attributeList");
			return false;
		}
		if(conditionOpList.contains(conditionOp))
		{
			// The conditionOp doesn't exist in the conditionOpList
			System.out.println("The conditionOp doesn't exist in the conditionOpList");
			return false;
		}
		boolean isSuccess = operationDBCon.updateDataToDB(tableName(),getAttributeList(),
				valueList(dto), attributeValue, conditionOp, value);
		if (!isSuccess)
		{
			System.out.println(" Data  in Generic DAO Failed to be inserted ");
			return false;
		}
		System.out.println(" Data  in Generic DAO inserted successfully");
		return true;
	}

	public  ArrayList<T> display(String attributeValue, String conditionOp, String value)
	{
		if (!attributeList.contains(attributeValue))
		{
			// The attributeValue doesn't exist in the attributeList
			System.out.println("The attributeValue doesn't exist in the attributeList");
			return null;
		}
		if(conditionOpList.contains(conditionOp))
		{
			// The conditionOp doesn't exist in the conditionOpList
			System.out.println("The conditionOp doesn't exist in the conditionOpList");
			return null;
		}
		ResultSet rs = operationDBCon.selectDataFromDB(tableName(), attributeValue, conditionOp, value);
		if(rs.equals(null))
		{
			System.out.println(" Cannot display data Generic DAO Failed to select ");
			return null;
		}
		ArrayList<T> dtoList= convertToDTO(rs);

		System.out.println(" Display  in Generic DAO  successfully");
		return dtoList;
	}
	
	
	public ArrayList<T> displayManyConditions(ArrayList<String> chkAttributeList, 
			ArrayList<String> chkConditionOpList, 
			ArrayList<String> chkConnectorOpList, 
			ArrayList<String> chkValueList)
	{
		if(chkAttributeList.size() == chkConditionOpList.size() 
				&& chkAttributeList.size() == chkConnectorOpList.size()-1 
				&& chkAttributeList.size() == chkValueList.size() )
		{
			// Check the method has received the correct count of values
			System.out.println("The condition is not correct => check the count of values");
			return null;
		}
		// Checking all the attributes match the attributeList
		for (int i = 0; i < chkAttributeList.size(); i++) {
			if (!attributeList.contains(chkAttributeList.get(i)))
			{
				// The chkAttributeList doesn't exist in the attributeList
				System.out.println("The attributeValue doesn't exist in the attributeList");
				return null;
			}
		}
		//	Set the list of condition operators 
		setConditionOpList();
		// Checking all the conditions match the conditionOpList
		for (int i = 0; i < chkConditionOpList.size(); i++) {
			if (!conditionOpList.contains(chkConditionOpList.get(i)))
			{
				// The chkConditionOpList doesn't exist in the conditionOpList
				System.out.println("The conditionOp doesn't exist in the conditionOpList");
				return null;
			}
		}
		//		Set the list of connector operators 
		setConnectorOpList();
		// Checking all the connectors match the connectorOpList
		for (int i = 0; i < chkConnectorOpList.size(); i++) {
			if (!connectorOpList.contains(chkConnectorOpList.get(i)))
			{
				// The connector doesn't exist in the connectorOpList
				System.out.println("The connector doesn't exist in the connectorOpList");
				return null;
			}
		}
		
		ResultSet rs = operationDBCon.selectDataFromDB_MultiCondition(tableName(),  
				chkAttributeList, chkConditionOpList, chkConnectorOpList, chkValueList);
		if(rs.equals(null))
		{
			System.out.println(" Cannot display data Generic DAO Failed to select ");
			return null;
		}
		ArrayList<T> dtoList= convertToDTO(rs);

		System.out.println(" Display  in Generic DAO  successfully");
		return dtoList;
	}
	

	public boolean delete(String attributeValue, String conditionOp, String value)
	{
		if (!attributeList.contains(attributeValue))
		{
			// The attributeValue doesn't exist in the attributeList
			System.out.println("The attributeValue doesn't exist in the attributeList");
			return false;
		}
		if(conditionOpList.contains(conditionOp))
		{
			// The conditionOp doesn't exist in the conditionOpList
			System.out.println("The conditionOp doesn't exist in the conditionOpList");
			return false;
		}
		boolean isSuccess = operationDBCon.deleteDataFromDB(tableName(), attributeValue,
				conditionOp ,value);
		if (!isSuccess)
		{
			System.out.println(" Data  in Generic DAO Failed to be Deleted ");
			return false;
		}
		System.out.println(" Data  in Generic DAO is deleted successfully");
		return true;
	}
	/**
	 * @return the conditionOpList
	 */
	public ArrayList<String> getConditionOpList() {
		return conditionOpList;
	}
	/**
	 * @param conditionOpList the conditionOpList to set
	 */
	
	private void setConditionOpList() {
		conditionOpList.add(">");
		conditionOpList.add("<");
		conditionOpList.add("=");
		conditionOpList.add("LIKE");
		conditionOpList.add("NOT");
	}
	/**
	 * @return the connectorOpList
	 */
	public ArrayList<String> getConnectorOpList() {
		return connectorOpList;
	}
	/**
	 * @param connectorOpList the connectorOpList to set
	 */
	private void setConnectorOpList() {
		connectorOpList =  new ArrayList<String>(); 
		connectorOpList.add("AND");
		connectorOpList.add("OR");
	}
}	
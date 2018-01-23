/**
 * 
 */
package model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author acil
 *
 */
public abstract class DBConnection {
	protected static Connection dBConn;
	public DBConnection()
	{
		createDBConnection();
	}
	protected final void finalize()
	{
		terminateDBConnection();
	}
	public abstract void createDBConnection();
	public abstract boolean insertDataToDB(String tableName, ArrayList<String> attributeList, ArrayList<String> valueList);
	public abstract boolean updateDataToDB(String tableName, ArrayList<String> attributeList, ArrayList<String> valueList, String attributeValue, String conditionOp, String value); 
	public abstract boolean deleteDataFromDB(String tableName, String attributeValue, String conditionOp, String value);
	public abstract ResultSet selectDataFromDB(String tableName, String attributeValue, String conditionOp, String value);
	public abstract void terminateDBConnection();
	public abstract ResultSet selectDataFromDB_MultiCondition(String tableName, ArrayList<String> chkAttributeList,
			ArrayList<String> chkConditionOpList, ArrayList<String> chkConnectorOpList,
			ArrayList<String> chkValueList);
}

/**
 * 
 */
package model.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;
/**
 * @author acil
 *
 */
public class DBConnectionMySQL extends DBConnection {
	public DBConnectionMySQL() {

		super();
	}

	/* (non-Javadoc)
	 * @see model.db.DBConnectionI#createDBConnection()
	 */
	public void createDBConnection() {
		String jdbcConnectionStr = "jdbc:mysql://localhost:3306/testdb";
		String dbUserName = "root";
		String dbUserPassword = "MySQLroot1$";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.
			dBConn = DriverManager.getConnection(jdbcConnectionStr, dbUserName, dbUserPassword);
			if (dBConn != null) {
				System.out.println("DB Connection Successful! ");
			} else {
				System.out.println(" DB Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("DB MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
	}

	/* (non-Javadoc)
	 * @see model.db.DBConnectionI#terminateDBConnection()
	 */
	public void terminateDBConnection() 
	{

        try {
        	
        	dBConn.close(); // connection is closed
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/* (non-Javadoc)
	 * @see model.db.DBConnectionI#processDataToDB(java.lang.String)
	 */

	public boolean insertDataToDB(String tableName, ArrayList<String> attributeList, ArrayList<String> valueList) 
	{
		String queryStatement = "insert into " + tableName + " (";
		for (int i = 0; i < attributeList.size()-1; i++) {
			queryStatement += attributeList.get(i) +" , ";
		}
		queryStatement += attributeList.get(attributeList.size()-1)  + " ) values ( ";
		for (int i = 0; i < attributeList.size()-1; i++) {
			queryStatement += " ? , ";
		}
		queryStatement += " ?);";
		PreparedStatement prepareStat = null;
		System.out.println("All the valueList: " + valueList);
		try {
			prepareStat = dBConn.prepareStatement(queryStatement);
			System.out.println(queryStatement);
			// set value list in the prepare statement (DB query)
			for (int i = 0; i < valueList.size(); i++) {
				prepareStat.setString(i+1, valueList.get(i));
			}
			System.out.println("==> The final insert Statement is: "+ prepareStat);
			// execute insert/update/delete SQL statement
			prepareStat.executeUpdate();
			prepareStat.close();
		} catch (SQLException e) {
			System.out.println(" Data  NOT inserted successfully");
			e.printStackTrace();
			return false;
		}
		System.out.println(" Data  inserted successfully");
		return true;
	}

	@Override
	public boolean updateDataToDB(String tableName, ArrayList<String> attributeList, ArrayList<String> valueList, String attributeValue, String conditionOp, String value) {
		String queryStatement = "update " + tableName + " set ";
		int size = attributeList.size();
		for (int i = 0; i < size-1; i++) {
			queryStatement += attributeList.get(i) + " = " + valueList.get(i) + " , ";
		}
		queryStatement += attributeList.get(size)+ " = " + valueList.get(size) + " where " + attributeValue + conditionOp + " ?";
		PreparedStatement prepareStat;	
		try {
			prepareStat = dBConn.prepareStatement(queryStatement);
			prepareStat.setString(1, value);
			// execute insert/update/delete SQL statement
			prepareStat.executeUpdate();
		
			prepareStat.close();
		} catch (SQLException e) {
			System.out.println(" Data is NOT  updates successfully");
			e.printStackTrace();
			return false;
		}
		System.out.println(" Data  updates=d successfully");
		return true;
	}

	@Override
	public ArrayList<String> selectDataFromDB(String tableName, String attributeValue, String conditionOp, String value) {
		ArrayList<String> selectedData = new ArrayList<String>();
		String queryStatement = "select * from " + tableName + " where " + attributeValue + conditionOp + " ?";
		System.out.println(queryStatement);
		PreparedStatement prepareStat = null;	
		ResultSet rs = null;
		try {
			dBConn.setAutoCommit(false);
			prepareStat = dBConn.prepareStatement(queryStatement);
			prepareStat.setString(1, value);
			// execute select SQL statement
			System.out.println("The query is: " + prepareStat.toString());
			rs = prepareStat.executeQuery();
			
			System.out.println("Resultset metadata: "+ rs.getMetaData());
			dBConn.commit();
			//System.out.println("The FIRST_NAME ----> " + rs.getString("FIRST_NAME"));
			System.out.println("Data in selectDataFromDB has been selected successfully");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println("Number of selected columns is: " + columnsNumber);
			while (rs.next())
			{
				for(int i=1; i<=columnsNumber; i++)
				{
					selectedData.add(rs.getString(i));
				}
			}
			System.out.println("The resultset data are: " + selectedData.toString());

		} catch (SQLException e) {
			System.out.println(" Data is NOT  selected successfully");
			e.printStackTrace();
			return null;
		}
		finally
		{
			try {
			if (prepareStat != null) {
				
					prepareStat.close();
	        }

				dBConn.setAutoCommit(true);
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(" Data  selected successfully");
//		try {
//			while (rs.next())
//			{
//				System.out.println(rs.getString("FIRST_NAME"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return selectedData;
	}

	@Override
	public boolean deleteDataFromDB(String tableName, String attributeValue, String conditionOp, String value) {
		String queryStatement = "delete from " + tableName + " where " + attributeValue + conditionOp + " ?";

		PreparedStatement prepareStat;	
		try {
			prepareStat = dBConn.prepareStatement(queryStatement);
			prepareStat.setString(1, value);
			// execute insert/update/delete SQL statement
			prepareStat.executeUpdate();
		
			prepareStat.close();
		} catch (SQLException e) {
			System.out.println(" Data is NOT  deleted successfully");
			e.printStackTrace();
			return false;
		}
		System.out.println(" Data  deleted successfully");
		return true;
	
	}

	@Override
	public ArrayList<String> selectDataFromDB_MultiCondition(String tableName, 
			ArrayList<String> chkAttributeList,
			ArrayList<String> chkConditionOpList, ArrayList<String> chkConnectorOpList,
			ArrayList<String> chkValueList) 
	{
		ArrayList<String> selectedData = new ArrayList<String>();
		String queryStatement = "select * from " + tableName + " where ";
		for (int i = 0; i < chkAttributeList.size(); i++) {
			queryStatement += chkAttributeList.get(i) + " " + chkConditionOpList.get(i) + " ? ";
			if(chkConnectorOpList.size()>i)
			{
				queryStatement += chkConnectorOpList.get(i) + " ";
			}
		}
		queryStatement += ";";
		System.out.println(queryStatement);
		PreparedStatement prepareStat = null;	
		ResultSet rs = null;
		try {
			dBConn.setAutoCommit(false);
			prepareStat = dBConn.prepareStatement(queryStatement);
			for (int i = 0; i < chkValueList.size(); i++) 
			{
				prepareStat.setString(i+1, chkValueList.get(i));
			}
			System.out.println("The query is: " + prepareStat.toString());
			
			
			// execute select SQL statement
			rs = prepareStat.executeQuery();
			System.out.println("Resultset metadata: "+ rs.getMetaData());
			dBConn.commit();
			//System.out.println("The FIRST_NAME ----> " + rs.getString("FIRST_NAME"));
			System.out.println("Data multicondition selected successfully");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println("Number of selected columns is: " + columnsNumber);
			while (rs.next())
			{
				for(int i=1; i<=columnsNumber; i++)
				{
					selectedData.add(rs.getString(i));
				}
			}
			System.out.println("The resultset data are: " + selectedData.toString());
			
		} catch (SQLException e) {
			System.out.println(" Data multicondition is NOT  selected successfully");
			e.printStackTrace();
		}
		finally
		{
			try {
			if (prepareStat != null) {
				
					prepareStat.close();
	        }

				dBConn.setAutoCommit(true);
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectedData;
	}

}

package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dBConn = null;
	private static PreparedStatement prepareStat = null;
	private static String jdbcConnectionStr = "jdbc:mysql://localhost:3306/testdb";
	private static String dbUserName = "root";
	private static String dbUserPassword = "MySQLroot1$";
	//private String queryStatement = null ;
	DBConnection()
	{
		createDBConnection();
		
	}
	public ResultSet getDataFromDB(String queryStatement)
	{
		ResultSet rs = null;
		try {
			prepareStat = dBConn.prepareStatement(queryStatement);
			// Execute "Select" Query, and get a java ResultSet
			rs = prepareStat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void processDataToDB(String queryStatement) {
		 
		try {
			prepareStat = dBConn.prepareStatement(queryStatement);
 
			// execute insert/update/delete SQL statement
			prepareStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(" Data  insert/update/delete successfully");
	}
	
	private static void createDBConnection() {	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered! UserLoginDB");
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
	
	public void terminateDBConnection()
	{
        try {
        	prepareStat.close();
        	dBConn.close(); // connection is closed
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

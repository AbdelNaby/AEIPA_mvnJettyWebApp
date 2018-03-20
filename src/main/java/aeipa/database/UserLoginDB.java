package aeipa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import java.sql.*;

public class UserLoginDB {
	
	static Connection aeipaDBConn = null;
	static PreparedStatement aeipaPrepareStat = null;
	
    String username = null;    
    String password = null;
    
    
	public UserLoginDB(String usernamex, String passwordx)
	{
	    username = usernamex;    
	    password = passwordx;
	    makeJDBCConnection();
	}
	
	private static void makeJDBCConnection() {
		 
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
			aeipaDBConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "MySQLroot1$");
			if (aeipaDBConn != null) {
				System.out.println("UserLoginDB Connection Successful! ");
			} else {
				System.out.println(" UserLoginDB Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("UserLoginDB MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
 
	}
 
	public String UserLogin()  {
		
		String returnedUserName = null;

		try {
			System.out.println("-------- AEIPA User login Database ------------");

		   
			// MySQL Select Query 
			String ValidateUserQueryStatement = "select * from USER2 where username='" + username + "' and password='" +password + "'";
 
			aeipaPrepareStat = aeipaDBConn.prepareStatement(ValidateUserQueryStatement);
			
			// Execute the Query, and get a java ResultSet
			ResultSet rs = aeipaPrepareStat.executeQuery();
		    
		    if (rs.next()) {
		       // session.setAttribute("username", username);
		        //response.sendRedirect("success.jsp");
		    	returnedUserName = rs.getString("username");
		    	System.out.println("user is logged in successfully "+ returnedUserName);
		        
		      
		    } else {
		        System.out.println("Invalid password <a href='index.jsp'>try again</a>");
		    }
 
	
 
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
		
	
		return(returnedUserName);
		
	}
	
	public void terminateDBConnection()
	{
        try {
			aeipaPrepareStat.close();
			aeipaDBConn.close(); // connection close
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	 

}